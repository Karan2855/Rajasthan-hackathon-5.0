package com.karanverma.womenhelplineapp;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

/**
 * Created by KaranVerma on 30-Apr-18.
 */

public class CustomAdaptor extends BaseAdapter {
    private static MediaPlayer mediaPlayer;
    private Camera camera;
    Camera.Parameters params;
    private boolean isFlashOn;
    String[] result;
    Context context;
    int[] imageId;
    int id = 0;
    private static LayoutInflater inflater = null;

    public CustomAdaptor(HomeActivity homeActivity, String[] itemNameList, int[] itemImages) {
        result = itemNameList;
        context = homeActivity;
        imageId = itemImages;
        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder {
        TextView tv;
        ImageView img;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder = new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.inflating_layout_home, null);
        holder.tv = (TextView) rowView.findViewById(R.id.textitem);
        holder.img = (ImageView) rowView.findViewById(R.id.imageitem);

        holder.tv.setText(result[position]);
        holder.img.setImageResource(imageId[position]);
        mediaPlayer = MediaPlayer.create(context, R.raw.whistlering);
        mediaPlayer.setLooping(true);
        getCamera();
        rowView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(context, "You Clicked " + result[position], Toast.LENGTH_SHORT).show();
                switch (result[position]) {
                    case "Unsafe":
                        unsafe();
                        break;
                    case "Safe":
                        safe();
                        break;
                    case "Doubtful":
                        doubtful();
                        break;
                    case "Police":
                        police();
                        break;
                    case "Fire":
                        fire();
                        break;
                    case "Ambulance":
                        ambulance();
                        break;
                    case "Whistle":
                        whistle();
                        break;
                    case "Light":
                        light();
                        break;
                    case "WHL Call":
                        whlCall();
                        break;

                }

            }
        });

        return rowView;
    }

    private void whlCall() {
        try {
            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            context.startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:1091")));
        } catch (ActivityNotFoundException ex) {
            Toast.makeText(context, "Could not find an activity to place the call", Toast.LENGTH_SHORT).show();

        }

    }

    private void light() {
        if (isFlashOn) {
            turnOffFlash();
        } else {
            turnOnFlash();
        }
    }

    private void getCamera() {

        if (camera == null) {
            try {
                camera = Camera.open();
                params = camera.getParameters();
            } catch (Exception e) {

            }
        }

    }


    private void turnOnFlash() {

        if (!isFlashOn) {
            if (camera == null || params == null) {
                return;
            }

            params = camera.getParameters();
            params.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
            camera.setParameters(params);
            camera.startPreview();
            isFlashOn = true;
        }

    }

    private void turnOffFlash() {

        if (isFlashOn) {
            if (camera == null || params == null) {
                return;
            }

            params = camera.getParameters();
            params.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
            camera.setParameters(params);
            camera.stopPreview();
            isFlashOn = false;
        }
    }

    private void whistle() {

        // If the music is playing
        if (mediaPlayer.isPlaying() == true)
            // Pause the music player
            mediaPlayer.stop();
            // If it's not playing
        else {
            mediaPlayer = MediaPlayer.create(context, R.raw.whistlering);
            mediaPlayer.setLooping(true);
            mediaPlayer.start();
        }
    }

    private void ambulance() {
        try {
            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            context.startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:108")));
        } catch (ActivityNotFoundException ex) {
            Toast.makeText(context, "Could not find an activity to place the call", Toast.LENGTH_SHORT).show();

        }

    }

    private void fire() {
        try {
            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            context.startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:101")));
        } catch (ActivityNotFoundException ex) {
            Toast.makeText(context, "Could not find an activity to place the call", Toast.LENGTH_SHORT).show();

        }
    }

    private void police() {
        try {
            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            context.startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:100")));
        } catch (ActivityNotFoundException ex) {
            Toast.makeText(context, "Could not find an activity to place the call", Toast.LENGTH_SHORT).show();

        }
    }

    private void doubtful() {
    }

    private void safe() {
    }

    private void unsafe() {
    }

}