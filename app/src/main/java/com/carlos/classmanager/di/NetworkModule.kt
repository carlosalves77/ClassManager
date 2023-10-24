package com.carlos.classmanager.di

import com.carlos.classmanager.domain.repository.ClassManagerApi
import com.carlos.classmanager.data.remote.ClassManagerRepository
import com.carlos.classmanager.data.repository.ClassManagerRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideClassManagerApi() : ClassManagerApi {
        return Retrofit.Builder()
            .baseUrl("https://my-json-server.typicode.com/carlosalves77/mockjson/")
            .build()
            .create(ClassManagerApi::class.java)
    }

    @Provides
    @Singleton
    fun provideClassManagerRepository(api: ClassManagerApi) : ClassManagerRepository {
        return ClassManagerRepositoryImpl(api)
    }


}