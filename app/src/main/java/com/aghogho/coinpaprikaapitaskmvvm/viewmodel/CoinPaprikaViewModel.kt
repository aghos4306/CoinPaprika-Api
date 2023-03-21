package com.aghogho.coinpaprikaapitaskmvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aghogho.coinpaprikaapitaskmvvm.model.remote.CoinPaprikaData
import com.aghogho.coinpaprikaapitaskmvvm.model.remote.datail.CoinPaprikaDetailData
import com.aghogho.coinpaprikaapitaskmvvm.model.repository.CoinPaprikaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class CoinPaprikaViewModel @Inject constructor(
    private val coinPaprikaRepository: CoinPaprikaRepository
): ViewModel() {

    private val disposable = CompositeDisposable()
    val getAllCoins = MutableLiveData<List<CoinPaprikaData>>()
    val getCoinDetailById = MutableLiveData<CoinPaprikaDetailData>()

    val isCoinLoading = MutableLiveData<Boolean>()
    val isErrorLoadingCoin = MutableLiveData<Boolean>()

    init {
        getAllCoinPaprika()
    }

    private fun getAllCoinPaprika() {
        isCoinLoading.value = true
        disposable.add(
            coinPaprikaRepository.getAllCoins()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<CoinPaprikaData>>() {
                    override fun onSuccess(value: List<CoinPaprikaData>?) {
                        getAllCoins.value = value
                        isCoinLoading.value = false
                        isErrorLoadingCoin.value = false
                    }

                    override fun onError(e: Throwable?) {
                        isErrorLoadingCoin.value = true
                        isCoinLoading.value = false
                    }

                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}
















