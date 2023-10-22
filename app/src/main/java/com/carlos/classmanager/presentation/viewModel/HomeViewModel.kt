package com.carlos.classmanager.presentation.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.carlos.classmanager.cammon.Resource
import com.carlos.classmanager.domain.use_case.GetClassManagerUseCase
import com.carlos.classmanager.presentation.State.HomeworkAndNoticeList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getHomeworkAndNotice: GetClassManagerUseCase
): ViewModel() {

    private val _state = MutableStateFlow(HomeworkAndNoticeList())
    val state: StateFlow<HomeworkAndNoticeList> = _state


    init {
        getHomeworkAndNoticeList()
    }

    private fun getHomeworkAndNoticeList() {
        getHomeworkAndNotice().onEach { result ->
          when (result) {
              is Resource.Success -> {
                  _state.value = HomeworkAndNoticeList(homeworkAndNotice = result.data ?: emptyList())
              }
              is Resource.Error -> {
                  _state.value = HomeworkAndNoticeList(error = result.message ?: "Um error aconteceu")
              }
              is Resource.Loading -> {
                  _state.value = HomeworkAndNoticeList(isLoading = true)
              }
          }
        }
        }
    }
