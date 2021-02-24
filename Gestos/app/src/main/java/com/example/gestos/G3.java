package com.example.gestos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class G3 extends AppCompatActivity {

    public View v1,v2,v3;

    GestureDetectorCompat mDetector;
    public View touch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g3);
        v1=(View)findViewById(R.id.v1);
        v2=(View)findViewById(R.id.v2);
        v3=(View)findViewById(R.id.v3);

        mDetector=new GestureDetectorCompat(this,new serGestos());
        v1.setOnTouchListener(touchListener);
        v2.setOnTouchListener(touchListener);
    }
    View.OnTouchListener touchListener=new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            touch=view;
            return mDetector.onTouchEvent(motionEvent);
        }
    };


    class serGestos extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onDown(MotionEvent e) {
            if(touch==v1){
                v3.setBackgroundColor(Color.RED);
            }
            return true;
        }
//        onfling

        @Override
        public void onLongPress(MotionEvent e) {
            if(touch==v2){
                v3.setBackgroundColor(Color.BLUE);
            }
        }
    }
}