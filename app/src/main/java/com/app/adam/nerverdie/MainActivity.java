package com.app.adam.nerverdie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(MainActivity.this, MyJobIntentService.class);
        intent.putExtra("key","value");
        MyJobIntentService.enqueueWork(MainActivity.this, intent);
    }
}
