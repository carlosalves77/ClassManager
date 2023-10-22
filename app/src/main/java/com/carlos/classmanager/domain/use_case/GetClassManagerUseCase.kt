package com.carlos.classmanager.domain.use_case

import com.carlos.classmanager.cammon.Resource
import com.carlos.classmanager.data.remote.ClassManagerRepository
import com.carlos.classmanager.domain.model.ClassManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

import javax.inject.Inject

class GetClassManagerUseCase @Inject constructor(
    private val repository: ClassManagerRepository
) {

    operator fun invoke(): Flow<Resource<List<ClassManager>>> = flow {
        try {
            emit(Resource.Loading())
            val homeWorkAndNotice = repository.getNoticesAndHomeWork()
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Um erro aconteceu"))
        } catch (e: HttpException) {
            emit(Resource.Error("Verifique sua conexão"))
        }
    }
}