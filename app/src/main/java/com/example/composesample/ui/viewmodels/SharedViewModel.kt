package com.example.composesample.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composesample.data.models.TodoTask
import com.example.composesample.data.repositories.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(private val repository: ToDoRepository) :ViewModel() {

    private val _getAllTasks = MutableStateFlow<List<TodoTask>>(emptyList())
    val getAllTasks: StateFlow<List<TodoTask>> = _getAllTasks

    fun getAllTaskFromDb(){
        viewModelScope.launch {
            repository.getAllTasks.collect {
                _getAllTasks.value = it
            }
        }
    }

}