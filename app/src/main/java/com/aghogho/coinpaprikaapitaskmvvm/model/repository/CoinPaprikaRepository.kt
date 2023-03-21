package com.aghogho.coinpaprikaapitaskmvvm.model.repository

import com.aghogho.coinpaprikaapitaskmvvm.model.remote.CoinPaprikaData
import com.aghogho.coinpaprikaapitaskmvvm.model.remote.datail.CoinPaprikaDetailData
import io.reactivex.Single

interface CoinPaprikaRepository {

    fun getAllCoins(): Single<List<CoinPaprikaData>>

    fun getCoinById(coinId: String) : CoinPaprikaDetailData

}
