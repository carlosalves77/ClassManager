package com.carlos.classmanager.presentation.viewModel


import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carlos.classmanager.data.db.DataBaseModule
import com.carlos.classmanager.domain.model.HomeWork
import com.carlos.classmanager.domain.repository.HomeworkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddNoteViewModel @Inject constructor(
    private val homeworkRepository: HomeworkRepository
): ViewModel() {

//    var getAllHomeWork : Flow<List<HomeWork>>

//
//    private val repository: HomeworkRepository
//    var getAllHomework : Flow<List<HomeWork>>

//
//        repository = HomeworkRepository(studentHomework)
//        getAllHomework = repository.getAllStudentsHomeWork()

    var getAllHomework = homeworkRepository.getAllStudentsHomeWork()

    fun addHomework(homework: HomeWork) {
        viewModelScope.launch(Dispatchers.IO) {
            homeworkRepository.insertHomework(homework)
        }
    }

    fun deleteNote(userHomeworkId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            homeworkRepository.deleteHomeworkById(userHomeworkId)
        }
    }

    fun updateNote(homework: HomeWork) {
        viewModelScope.launch(Dispatchers.IO) {
            homeworkRepository.updateHomeWork(homework)
        }
    }


}