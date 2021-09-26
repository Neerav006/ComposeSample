package com.example.composesample

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintLayoutScope
import androidx.constraintlayout.compose.Dimension
import com.example.composesample.ui.theme.ComposeSampleTheme
import com.example.composesample.ui.theme.Purple200
import kotlin.math.log

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    TopAppBarContent()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Box(
        modifier = Modifier.then(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        )
    ) {
        Column(
            modifier = Modifier
                .then(Modifier.fillMaxSize())
                .then(Modifier.padding(16.dp))
        ) {

            ConstraintLayout(modifier = Modifier.fillMaxWidth()) {

                val (logo, title, description) = createRefs()

                Image(
                    painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "",
                    modifier = Modifier
                        .size(70.dp)
                        .constrainAs(logo)
                        { top.linkTo(parent.top)
                          bottom.linkTo(parent.bottom)
                        }
                )

                Text(text = "Espresso", fontSize = 24.sp,
                    modifier = Modifier.constrainAs(title)
                    {
                        top.linkTo(logo.top)
                        bottom.linkTo(description.top)
                        linkTo(
                            start = logo.end, end = parent.end, startMargin = 16.dp,
                            endMargin = 8.dp
                        )
                        width = Dimension.fillToConstraints
                    }
                )
                Text(
                    text = "Espresso is coffee of Italian origin, brewed by forcing a small amount of nearly boiling water under pressure (expressing) through finely-ground coffee beans.",
                    style = TextStyle(textAlign = TextAlign.Justify),
                    modifier = Modifier.constrainAs(description) {
                        top.linkTo(title.bottom)
                        bottom.linkTo(logo.bottom)
                        linkTo(start = title.start, end = title.end)
                        width = Dimension.fillToConstraints
                    }
                )


            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeSampleTheme {
        // A surface container using the 'background' color from the theme
        TopAppBarContent()
    }
}

@Composable
fun TopAppBarContent() {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = { (Text(text = "AppBar")) },
                navigationIcon = {
                    Box(modifier = Modifier.fillMaxWidth()) {
                        IconButton(
                            modifier = Modifier
                                .then(Modifier.size(24.dp))
                                .then(Modifier.align(alignment = Alignment.Center)),
                            onClick = {
                                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
                            },
                        )

                        {
                            Icon(
                                Icons.Default.Home,
                                "contentDescription",
                                tint = Color.White
                            )
                        }
                    }

                }
            )
        },
        content = {
            Greeting(name = "Jetpack Compose")
        }

    )
}




