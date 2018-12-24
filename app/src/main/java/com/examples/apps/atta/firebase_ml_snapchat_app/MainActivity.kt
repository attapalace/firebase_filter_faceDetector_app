package com.examples.apps.atta.firebase_ml_snapchat_app

import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val PERMISION_REQUEST_CODE = 3;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN ,WindowManager.LayoutParams.FLAG_FULLSCREEN )
        checkAndRequestCameraPermission();
    }

    private fun checkAndRequestCameraPermission(){
        if(ActivityCompat.checkSelfPermission(this,android.Manifest.permission.CAMERA) !=
                PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA)
                ,PERMISION_REQUEST_CODE)
        }else{
            startFacePreocessor();
        }
    }

    private fun startFacePreocessor() {
        lifecycle.addObserver(MainActivityLifeCycleObserver(camera_view))

        val faceProcessor = FaceProcessor(camera_view , OverlayView )
        faceProcessor.startProcessing()

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode == PERMISION_REQUEST_CODE){
            if (android.Manifest.permission.CAMERA == permissions[0]
                && grantResults[0] ==PackageManager.PERMISSION_GRANTED ){
                startFacePreocessor()
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}
