package com.d3if4202.emaildata

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.d3if4202.emaildata.db.EmailDataRepository
import java.lang.IllegalArgumentException

class EmailDataViewModelFactory(
    private val repository: EmailDataRepository
):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(EmailDataViewModel::class.java)){
            return EmailDataViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown View Model class")
    }

}