package com.example.gestos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String codena="Cadena que es un cambio";
    }
    public void irG1(View v){
        Intent intent=new Intent(getApplicationContext(),G1.class);
        startActivity(intent);
    }
    public void irG2(View v){
        Intent intent=new Intent(getApplicationContext(),G2.class);
        startActivity(intent);
    }
    public void irG3(View v){
        Intent intent=new Intent(getApplicationContext(),G3.class);
        startActivity(intent);
    }
    public void irG4(View v){
        Intent intent=new Intent(getApplicationContext(),G4.class);
        startActivity(intent);
    }
    public void irG5(View v){
        Intent intent=new Intent(getApplicationContext(),G5.class);
        startActivity(intent);
    }
}