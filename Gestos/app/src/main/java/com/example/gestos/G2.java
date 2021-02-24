package com.example.gestos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class G2 extends AppCompatActivity {

    GestureDetectorCompat mDetector;
    View parentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g2);
        parentView=findViewById(R.id.cl2);
        mDetector=new GestureDetectorCompat(this,new serGestos());
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
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public void onLongPress(MotionEvent e) {
            Toast.makeText(G2.this, "Mantener pulsado", Toast.LENGTH_SHORT).show();
        }
    }
}