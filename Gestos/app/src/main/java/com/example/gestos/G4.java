package com.example.gestos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class G4 extends AppCompatActivity {

    GestureDetectorCompat mDetector;
    View parentView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g4);
        parentView=findViewById(R.id.cl_4);
        mDetector=new GestureDetectorCompat(this,new G4.serGestos());
        parentView.setOnTouchListener(touchListener);
    }

    View.OnTouchListener touchListener=new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return mDetector.onTouchEvent(motionEvent);
        }
    };


    class serGestos extends GestureDetector.SimpleOnGestureListener{

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            float xI=e1.getX(),yI=e1.getY();
            float xF=e2.getX(),yF=e2.getY();
            float difX=xI-xF,difY=yI-yF;
            if(difX<0){
                if(difY>0){
                    if(difX-difY>0){
                        parentView.setBackgroundColor(Color.RED);
//                        derecha
                    }else{
                        parentView.setBackgroundColor(Color.GREEN);
//                        arriba
                    }
                }else{
                    if(difX+difY>0){
                        parentView.setBackgroundColor(Color.RED);
//                        derecha
                    }else{
                        parentView.setBackgroundColor(Color.GRAY);
//                        abajo
                    }
                }
            }else{
                if(difY>0){
                    if(difX+difY>0){
                        parentView.setBackgroundColor(Color.BLUE);
//                        izquierda
                    }else{
                        parentView.setBackgroundColor(Color.GREEN);
//                        arriba
                    }
                }else{
                    if(difX-difY>0){
                        parentView.setBackgroundColor(Color.BLUE);
//                        izquierda
                    }else{
                        parentView.setBackgroundColor(Color.GRAY);
//                        abajo
                    }
                }
            }

            return true;
        }

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }
    }
}