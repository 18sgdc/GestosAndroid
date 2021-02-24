package com.example.gestos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

public class G1 extends AppCompatActivity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    GestureDetectorCompat detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g1);
        detector=new GestureDetectorCompat(this,this);
        detector.setOnDoubleTapListener(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return detector.onTouchEvent(event);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        Toast.makeText(this, "Solo", Toast.LENGTH_SHORT).show();
        return true;
//        para un tab (no double tab)
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {
        Toast.makeText(this, "Doble", Toast.LENGTH_SHORT).show();
        return true;
//        para un double tab
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return true;
//        para un double tab(Segundo tab especificamente)
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return true;
//        Al pulsar (Con cualquier gesto)
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {
        Toast.makeText(this, "Mantener Pulsado", Toast.LENGTH_SHORT).show();
//        Al mantener pulsado
    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        Toast.makeText(this, "Toast Largo Final", Toast.LENGTH_SHORT).show();
        return true;
//        Al pulsar (Con cualquier gesto, al levantar)
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return true;
//        Movimiento poco a poco
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {
//      Pulsacion larga
    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return true;
//        Movimiento de golpe
    }
}