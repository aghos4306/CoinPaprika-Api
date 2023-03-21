package com.aghogho.coinpaprikaapitaskmvvm.model.repository

import com.aghogho.coinpaprikaapitaskmvvm.model.network.CoinPaprikaApi
import com.aghogho.coinpaprikaapitaskmvvm.model.remote.CoinPaprikaData
import com.aghogho.coinpaprikaapitaskmvvm.model.remote.datail.CoinPaprikaDetailData
import io.reactivex.Single
import javax.inject.Inject

class CoinPaprikaRepositoryImpl @Inject constructor(
    private val coinPaprikaApi: CoinPaprikaApi
): CoinPaprikaRepository {
    override fun getAllCoins(): Single<List<CoinPaprikaData>> {
        return coinPaprikaApi.getAllCoins()
    }

    override fun getCoinById(coinId: String): CoinPaprikaDetailData {
        return coinPaprikaApi.getCoinById(coinId)
    }


}
