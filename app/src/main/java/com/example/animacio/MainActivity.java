package com.example.animacio;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.view.animation.Animation;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button buttonRotate;
    private Button buttonFadeIn;
    private Button buttonFadeOut;
    private Button buttonZoomIn;
    private Button buttonZoomOut;
    private Button buttonBounce;
    private Button buttonStartAnim;
    private ImageView imageViewIcon;
    private ImageView imageViewMonster;
    private Animation bounce;
    private Animation fadeIn;
    private Animation fadeOut;
    private Animation zoomIn;
    private Animation zoomOut;
    private Animation rotate;
    private Boolean animationStarted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
        buttonStartAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!animationStarted) {
                    ((AnimationDrawable) imageViewMonster.getBackground()).start();
                    animationStarted = true;
                    buttonStartAnim.setText("Stop Animation");
                } else {
                    ((AnimationDrawable) imageViewMonster.getBackground()).stop();
                    animationStarted = false;
                    buttonStartAnim.setText("Start Animation");
                }
            }
        });
        buttonFadeIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageViewIcon.startAnimation(fadeIn);
            }
        });
        buttonFadeOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageViewIcon.startAnimation(fadeOut);
            }
        });
        buttonBounce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageViewIcon.startAnimation(bounce);
            }
        });
        buttonZoomIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageViewIcon.startAnimation(zoomIn);
            }
        });
        buttonZoomOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageViewIcon.startAnimation(zoomOut);
            }
        });
        buttonRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageViewIcon.startAnimation(rotate);
            }
        });



    }

    public void init() {
        buttonRotate = findViewById(R.id.buttonRotate);
        buttonFadeIn = findViewById(R.id.buttonFadeIn);
        buttonFadeOut = findViewById(R.id.buttonFadeOut);
        buttonZoomIn = findViewById(R.id.buttonZoomIn);
        buttonZoomOut = findViewById(R.id.buttonZoomOut);
        buttonBounce = findViewById(R.id.buttonBounce);
        buttonStartAnim = findViewById(R.id.buttonStartAnim);
        imageViewIcon = findViewById(R.id.imageViewIcon);
        imageViewMonster = findViewById(R.id.imageViewMonster);
        bounce = AnimationUtils.loadAnimation(this, R.anim.bounce);
        fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        fadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        zoomIn = AnimationUtils.loadAnimation(this, R.anim.zoom_in);
        zoomOut = AnimationUtils.loadAnimation(this, R.anim.zoom_out);
        rotate = AnimationUtils.loadAnimation(this, R.anim.rotate);
        animationStarted = false;
    }
}