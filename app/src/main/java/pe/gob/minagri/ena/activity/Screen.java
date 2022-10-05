package pe.gob.minagri.ena.activity;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.util.Arrays;

import pe.gob.minagri.ena.R;
import pe.gob.minagri.ena.util.Constants;

public class Screen extends AppCompatActivity {
    private boolean hasAllPermission;
    private int PERMISSION_ALL = 1;
    private  String[] PERMISSIONS = {
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen);

        try {
            if (!hasPermissions(this, PERMISSIONS)) {
                ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_ALL);
            } else {
                sincronizarUsuarios();
            }
        } catch (Exception e){
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Error en la aplicacion = " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void sincronizarUsuarios(){
        new LoadAssync().execute();
    }


    private static boolean hasPermissions(Context context, String... permissions) {
        if (context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == PERMISSION_ALL) {
            for (int i = 0; i < permissions.length; i++) {
                String permission = permissions[i];
                int grantResult = grantResults[i];
                if (Arrays.asList(Constants.PERMISSIONS).contains(permission)) {
                    if (grantResult != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_ALL);
                        hasAllPermission = false;
                    } else {
                        hasAllPermission = true;
                    }
                }
            }
            if (hasAllPermission){
                sincronizarUsuarios();
            }
        }
    }

    private class LoadAssync extends AsyncTask<String, Void, Void> {

        ProgressDialog dialog;
        double longitude;
        double latitude;
        protected void onPreExecute() {

            dialog = new ProgressDialog(Screen.this);
            dialog.setMessage("Iniciando ENA...");
            dialog.setCancelable(false);
            dialog.show();
        }

        protected Void doInBackground(final String... args) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        protected void onPostExecute(final Void unused) {
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
            Intent i = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(i);
        }
    }
}