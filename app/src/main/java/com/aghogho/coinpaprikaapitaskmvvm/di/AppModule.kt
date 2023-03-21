package com.aghogho.coinpaprikaapitaskmvvm.di

import com.aghogho.coinpaprikaapitaskmvvm.constants.Constants.COIN_PAPRIKA_BASE_URL
import com.aghogho.coinpaprikaapitaskmvvm.model.network.CoinPaprikaApi
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
    fun providePaprikaCoinApi(): CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(COIN_PAPRIKA_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

}
