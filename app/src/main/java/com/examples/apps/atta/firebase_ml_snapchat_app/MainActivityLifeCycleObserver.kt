package com.examples.apps.atta.firebase_ml_snapchat_app

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import com.otaliastudios.cameraview.CameraView

class MainActivityLifeCycleObserver(private val cameraView: CameraView) : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun startCamera(){
        cameraView.start()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun stopCamera(){
        cameraView.stop()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun destroyCamera(){
        cameraView.destroy()
    }
}