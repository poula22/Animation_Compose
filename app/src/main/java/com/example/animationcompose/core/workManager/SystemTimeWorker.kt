package com.example.animationcompose.core.workManager

import android.content.Context
import androidx.work.SystemClock
import androidx.work.Worker
import androidx.work.WorkerParameters

class SystemTimeWorker(appContext: Context, workParams: WorkerParameters) :
    Worker(appContext, workParams) {
    override fun doWork(): Result {

        return Result.success()
    }

}