package com.aghogho.coinpaprikaapitaskmvvm.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.aghogho.coinpaprikaapitaskmvvm.model.remote.CoinPaprikaData
import com.aghogho.coinpaprikaapitaskmvvm.model.repository.CoinPaprikaRepository
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.disposables.Disposable
import io.reactivex.internal.schedulers.ExecutorScheduler
import io.reactivex.plugins.RxJavaPlugins
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import java.util.concurrent.Executor
import java.util.concurrent.TimeUnit

class CoinPaprikaViewModelTest {

    @get:Rule
    var rule = InstantTaskExecutorRule()

    @Mock
    lateinit var coinPaprikaRepository: CoinPaprikaRepository

    @InjectMocks
    var coinPaprikaViewModel = CoinPaprikaViewModel(coinPaprikaRepository)

    private var testSingle: Single<List<CoinPaprikaData>>? = null

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun getAllPaprikaCoinsSuccess() {
        val coinPaprika = listOf(CoinPaprikaData())
        testSingle = Single.just(coinPaprika)

        Mockito.`when`(coinPaprikaRepository.getAllCoins()).thenReturn(testSingle)
        Assert.assertEquals(1, coinPaprikaViewModel.getAllCoins.value?.size)
        Assert.assertEquals(false, coinPaprikaViewModel.isErrorLoadingCoin.value)
        Assert.assertEquals(false, coinPaprikaViewModel.isCoinLoading.value)
    }

    @Test
    fun getAllPaprikaCoinsFail() {
        testSingle = Single.error(Throwable())

        Mockito.`when`(coinPaprikaRepository.getAllCoins()).thenReturn(testSingle)

        Assert.assertEquals(true, coinPaprikaViewModel.isErrorLoadingCoin)
        Assert.assertEquals(false, coinPaprikaViewModel.isCoinLoading)

    }

    @Before
    fun setUpRxSchedulers() {
        val immediate = object : Scheduler() {
            override fun scheduleDirect(run: Runnable?, delay: Long, unit: TimeUnit?): Disposable {
                return super.scheduleDirect(run, 0, unit)
            }

            override fun createWorker(): Worker {
                return ExecutorScheduler.ExecutorWorker(Executor { it.run() })
            }
        }

        RxJavaPlugins.setInitIoSchedulerHandler { scheluler -> immediate}
        RxJavaPlugins.setInitComputationSchedulerHandler { scheduler -> immediate }
        RxJavaPlugins.setInitNewThreadSchedulerHandler { scheduler -> immediate }
        RxJavaPlugins.setInitSingleSchedulerHandler { scheduler -> immediate }
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { scheduler -> immediate }

    }

}
