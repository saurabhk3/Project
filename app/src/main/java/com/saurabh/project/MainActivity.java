package com.saurabh.project;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    BluetoothAdapter bluetoothAdapter = null;
    final int REQUEST_ENABLE_BT = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter(); // it represents device's own bluetooth adapter(radio)
        if(bluetoothAdapter==null){
            //device doesn't support bluetooth
            Toast.makeText(this, "Bluetooth not supported on this device!", Toast.LENGTH_LONG).show();
        }

        // now check whether bluetooth is enabled in the device,if not ask to enable it
        if(!bluetoothAdapter.isEnabled()){
            Intent enableBt = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);    // this call issues a request to enable BT without stopping the application
            startActivityForResult(enableBt,REQUEST_ENABLE_BT);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_ENABLE_BT && resultCode==RESULT_OK){
            
        }
    }
}
