package com.carlos.classmanager.presentation.viewModel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carlos.classmanager.domain.model.HomeWork
import com.carlos.classmanager.domain.repository.HomeworkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddNoteViewModel @Inject constructor(
    private val homeworkRepository: HomeworkRepository
): ViewModel() {

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