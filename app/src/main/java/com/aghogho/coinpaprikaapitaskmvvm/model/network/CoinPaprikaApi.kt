package com.aghogho.coinpaprikaapitaskmvvm.model.network

import com.aghogho.coinpaprikaapitaskmvvm.model.remote.CoinPaprikaData
import com.aghogho.coinpaprikaapitaskmvvm.model.remote.datail.CoinPaprikaDetailData
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/coins")
    fun getAllCoins(): Single<List<CoinPaprikaData>>

    @GET("/v1/coins/{coinId}")
    fun getCoinById(@Path("coinId") coinId: String) : CoinPaprikaDetailData

}
