package com.e.majocardn.di


import com.e.majocardn.data.remote.RecipeApi
import com.e.majocardn.data.repository.RecipeRepository
import com.e.majocardn.data.repository.RecipeRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://hf-android-app.s3-eu-west-1.amazonaws.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideRecipeApi(retrofit: Retrofit): RecipeApi =
        retrofit.create(RecipeApi::class.java)



}

