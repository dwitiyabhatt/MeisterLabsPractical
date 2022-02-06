package com.example.darshanpractical.factory_providers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.darshanpractical.models.api_implementors.TaskVMImplementor
import com.oncobuddy.app.view_models.TaskViewModel


class TaskFactoryProvider(private val TaskVMImplementor: TaskVMImplementor) : ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
              return TaskViewModel(TaskVMImplementor) as T
    }

}