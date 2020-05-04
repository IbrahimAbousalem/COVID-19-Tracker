package com.iti.mobile.covid19tracker.model.sync

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.ListenableWorker
import androidx.work.WorkerParameters
import com.iti.mobile.covid19tracker.model.repositories.DataRepository
import com.iti.mobile.covid19tracker.utils.makeStatusNotification
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject


class SyncWork @Inject constructor(
     private val repo: DataRepository,
     appContext: Context,
     workerParams: WorkerParameters) : CoroutineWorker(appContext, workerParams) {

    override suspend fun doWork(): Result = withContext(Dispatchers.IO) {
        var job = repo.updateDataBase()
        Timber.d("#8 You have the data + $job")
        if(job!!.isNotEmpty()) {
            for(data in 0..job.size)
                makeStatusNotification(applicationContext, job)
        }
        Result.success()
    }


    class Factory @Inject constructor(
        private val myRepository: DataRepository
    ): ChildWorkerFactory {

        override fun create(appContext: Context, params: WorkerParameters): CoroutineWorker {
            return SyncWork(myRepository, appContext, params)
        }
    }
}
interface ChildWorkerFactory {
    fun create(appContext: Context, params: WorkerParameters): ListenableWorker
}

