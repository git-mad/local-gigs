package com.gitmad.local_gigs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date: 11/3/13
 * Time: 7:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class CameraActivity extends Activity {
    Button intentButton;
    Button captureButton;
    Camera mCamera;
    CameraPreview mPreview;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera_activity);
        intentButton = (Button)findViewById(R.id.intentButton);
        intentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getImage();
            }
        });
        captureButton = (Button)findViewById(R.id.button_capture);
        captureButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                mCamera.takePicture(null,null,mPicture);

            }
        });

        mCamera = getCamera();
      //  mCamera.startFaceDetection();
        if(mCamera!=null)
        {
            mPreview = new CameraPreview(this, mCamera);
            FrameLayout preview = (FrameLayout)findViewById(R.id.camera_preview);
            preview.addView(mPreview);
        }



    }
    private Camera.PictureCallback mPicture = new Camera.PictureCallback() {

        @Override
        public void onPictureTaken(byte[] data, Camera camera) {

            File pictureFile = getOutputMediaFile();
            if (pictureFile == null){
                Log.d("CameraActivity", "Error creating media file, check storage permissions: " );
                return;
            }

            try {
                FileOutputStream fos = new FileOutputStream(pictureFile);
                fos.write(data);
                fos.close();
                Toast t = Toast.makeText(CameraActivity.this,"Image captured", Toast.LENGTH_SHORT);
                t.show();
                mCamera.startPreview();
               // mCamera.startFaceDetection();
            } catch (FileNotFoundException e) {
                Log.d("CameraActivity", "File not found: " + e.getMessage());
            } catch (IOException e) {
                Log.d("CameraActivity", "Error accessing file: " + e.getMessage());
            }
        }
    };

    private static File getOutputMediaFile(){

        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "LocalGigs");

        if (! mediaStorageDir.exists()){
            if (! mediaStorageDir.mkdirs()){
                Log.d("LocalGigs", "failed to create directory");
                return null;
            }
        }

        // Create a media file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File mediaFile;
        mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                "IMG_"+ timeStamp + ".jpg");

        return mediaFile;
    }
    public void onPause()
    {
        super.onPause();
        //mPreview = null;
        if(mCamera!=null)
            mCamera.release();
    }
    public static boolean isIntentAvailable(Context context, String action) {
        final PackageManager packageManager = context.getPackageManager();
        final Intent intent = new Intent(action);
        List<ResolveInfo> list =
                packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        return list.size() > 0;
    }

    private void getImage() {
        //use an existing camera app
            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if(isIntentAvailable(this, MediaStore.ACTION_IMAGE_CAPTURE))
            {



            //If you want a custom name and location, uncomment
            //cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
                startActivityForResult(cameraIntent, 100);
            }



    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
            if(requestCode==100)
            {
                if(resultCode==RESULT_OK)
                {
                    Toast.makeText(this,"Image saved in: "+data.getData(), Toast.LENGTH_SHORT).show();
                }
            }
    }

    private static boolean checkCameraHardware(Context context)
    {
        if(context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA))
        {
            return true;
        }
        return false;
    }
    public Camera getCamera()
    {
        Camera c = null;
        try
        {
            int cameraCount = 0;

            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            cameraCount = Camera.getNumberOfCameras();
            for ( int camIdx = 0; camIdx < cameraCount; camIdx++ ) {
                Camera.getCameraInfo( camIdx, cameraInfo );
                if ( cameraInfo.facing == Camera.CameraInfo.CAMERA_FACING_FRONT  ) {
                   c = Camera.open(camIdx);

                }
            }
        }
        catch(Exception e)
        {
        }
        return c;
    }
}