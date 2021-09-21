package com.d3if4202.emaildata

import android.util.Patterns
import androidx.lifecycle.*
import com.d3if4202.emaildata.db.EmailData
import com.d3if4202.emaildata.db.EmailDataRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class EmailDataViewModel(private val repository: EmailDataRepository) : ViewModel() {
    private var isUpdateOrDelete = false
    private lateinit var emaildataToUpdateOrDelete: EmailData
    val inputName = MutableLiveData<String>()
    val inputEmail = MutableLiveData<String>()
    val saveOrUpdateButtonText = MutableLiveData<String>()
    val clearAllOrDeleteButtonText = MutableLiveData<String>()

    private val statusMessage = MutableLiveData<Event<String>>()
    val message: LiveData<Event<String>>
        get() = statusMessage

    init {
        saveOrUpdateButtonText.value = "Save"
        clearAllOrDeleteButtonText.value = "Clear All"
    }

    fun initUpdateAndDelete(emaildata: EmailData) {
        inputName.value = emaildata.name
        inputEmail.value = emaildata.email
        isUpdateOrDelete = true
        emaildataToUpdateOrDelete = emaildata
        saveOrUpdateButtonText.value = "Update"
        clearAllOrDeleteButtonText.value = "Delete"
    }

    fun saveOrUpdate() {
        if (inputName.value == null) {
            statusMessage.value = Event("Please enter Owner's name")
        } else if (inputEmail.value == null) {
            statusMessage.value = Event("Please enter Owner's email")
        } else if (!Patterns.EMAIL_ADDRESS.matcher(inputEmail.value!!).matches()) {
            statusMessage.value = Event("Please enter a correct email address")
        } else {
            if (isUpdateOrDelete) {
                emaildataToUpdateOrDelete.name = inputName.value!!
                emaildataToUpdateOrDelete.email = inputEmail.value!!
                updateEmailData(emaildataToUpdateOrDelete)
            } else {
                val name = inputName.value!!
                val email = inputEmail.value!!
                insertEmailData(EmailData(0, name, email))
                inputName.value = ""
                inputEmail.value = ""
            }
        }
    }

    private fun insertEmailData(emaildata: EmailData) = viewModelScope.launch {
        val newRowId = repository.insert(emaildata)
        if (newRowId > -1) {
            statusMessage.value = Event("EmailData Inserted Successfully $newRowId")
        } else {
            statusMessage.value = Event("Error Occurred")
        }
    }


    private fun updateEmailData(emaildata: EmailData) = viewModelScope.launch {
        val noOfRows = repository.update(emaildata)
        if (noOfRows > 0) {
            inputName.value = ""
            inputEmail.value = ""
            isUpdateOrDelete = false
            saveOrUpdateButtonText.value = "Save"
            clearAllOrDeleteButtonText.value = "Clear All"
            statusMessage.value = Event("$noOfRows Row Updated Successfully")
        } else {
            statusMessage.value = Event("Error Occurred")
        }
    }

    fun getSavedEmailDatas() = liveData {
        repository.emaildatas.collect {
            emit(it)
        }
    }

    fun clearAllOrDelete() {
        if (isUpdateOrDelete) {
            deleteEmailData(emaildataToUpdateOrDelete)
        } else {
            clearAll()
        }
    }

    private fun deleteEmailData(emaildata: EmailData) = viewModelScope.launch {
        val noOfRowsDeleted = repository.delete(emaildata)
        if (noOfRowsDeleted > 0) {
            inputName.value = ""
            inputEmail.value = ""
            isUpdateOrDelete = false
            saveOrUpdateButtonText.value = "Save"
            clearAllOrDeleteButtonText.value = "Clear All"
            statusMessage.value = Event("$noOfRowsDeleted Row Deleted Successfully")
        } else {
            statusMessage.value = Event("Error Occurred")
        }
    }

    private fun clearAll() = viewModelScope.launch {
        val noOfRowsDeleted = repository.deleteAll()
        if (noOfRowsDeleted > 0) {
            statusMessage.value = Event("$noOfRowsDeleted EmailDatas Deleted Successfully")
        } else {
            statusMessage.value = Event("Error Occurred")
        }
    }
}