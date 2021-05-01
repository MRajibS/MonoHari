package com.example.mymonohari;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static int DELAY_SCREEN=3000;
    //Variable
    Animation fade_anim;
    TextView logoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        //Animation
        fade_anim = AnimationUtils.loadAnimation(this, R.anim.fade_anim);
        //HOOKs
        logoView = findViewById(R.id.logoView);
        logoView.setAnimation(fade_anim);
        //Next Activity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent= new Intent(MainActivity.this,Dashboard.class);
                startActivity(intent);
                finish();
            }
        },DELAY_SCREEN);
    }
}