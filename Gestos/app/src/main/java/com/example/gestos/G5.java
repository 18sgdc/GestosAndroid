package com.example.gestos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class G5 extends AppCompatActivity {

    GestureDetectorCompat mDetector;
    Button b_jugar,b_nuevo;
    TextView tv_objetivo,tv_actual;
    int objetivo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g5);
//        parentView=findViewById(R.id.cl_5);
        b_jugar=(Button)findViewById(R.id.b_jugar);
        b_nuevo=(Button)findViewById(R.id.b_nuevo);
        tv_objetivo=(TextView)findViewById(R.id.tv_segundos);
        tv_actual=(TextView)findViewById(R.id.tv_actual);
        mDetector=new GestureDetectorCompat(this,new G5.serGestos());
        b_jugar.setOnTouchListener(touchListener);
        nuevo();
        b_nuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nuevo();
            }
        });
    }
// Simplemente con eso ya se podria hacer comporbando que hace con el boton
//    event.getAction()==MotionEventent
    View.OnTouchListener touchListener=new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return mDetector.onTouchEvent(motionEvent);
        }
    };
    public void nuevo(){
        objetivo= (int) Math.floor(Math.random()*8500+1500);
        tv_objetivo.setText(Integer.toString(objetivo));
        tv_actual.setVisibility(View.INVISIBLE);
    }


    class serGestos extends GestureDetector.SimpleOnGestureListener{
        long startTime;

        @Override
        public boolean onSingleTapUp(MotionEvent e) {

            long endTime = System.currentTimeMillis();

            int transcurrido = (int) ((int) endTime-startTime);
            tv_actual.setVisibility(View.VISIBLE);
            tv_actual.setText(Integer.toString(transcurrido));
            return true;
        }


        @Override
        public boolean onDown(MotionEvent e) {
            startTime = System.currentTimeMillis();
            return true;
        }

        @Override
        public void onShowPress(MotionEvent e) {
            Toast.makeText(G5.this, "Mantener Pulsado", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onLongPress(MotionEvent e) {
            Toast.makeText(G5.this, "Mantener Pulsado largo", Toast.LENGTH_SHORT).show();
        }

    }
}