package com.example.darshanpractical.injectors

import androidx.lifecycle.ViewModelProvider
import com.example.darshanpractical.factory_providers.TaskFactoryProvider
import com.example.darshanpractical.models.api_implementors.TaskVMImplementor
import com.example.darshanpractical.models.api_repositories.TaskVMRepository

object TaskListInjection {

    private val LOGIN_VM_IMPLEMENTOR: TaskVMImplementor = TaskVMRepository()

    private val loginViewModelFactory = TaskFactoryProvider(LOGIN_VM_IMPLEMENTOR)


    fun provideViewModelFactory(): ViewModelProvider.Factory{
        return loginViewModelFactory
    }

}