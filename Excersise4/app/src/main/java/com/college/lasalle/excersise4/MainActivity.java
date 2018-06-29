package com.college.lasalle.excersise4;

import android.support.animation.DynamicAnimation;
import android.support.animation.DynamicAnimation.OnAnimationEndListener;
import android.support.animation.SpringAnimation;
import android.support.animation.SpringForce;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView imageView = findViewById(R.id.imageView);

        final  SpringAnimation anim1 = new SpringAnimation(imageView, DynamicAnimation.TRANSLATION_X, 500);
        final  SpringAnimation anim2 = new SpringAnimation(imageView, DynamicAnimation.TRANSLATION_Y, 500);
        final  SpringAnimation anim3 = new SpringAnimation(imageView, DynamicAnimation.TRANSLATION_X, 0);
        final  SpringAnimation anim4 = new SpringAnimation(imageView, DynamicAnimation.TRANSLATION_Y, 0);

        anim1.getSpring().setStiffness(SpringForce.STIFFNESS_LOW);

        anim1.addEndListener(new OnAnimationEndListener() {
            @Override
            public void onAnimationEnd(DynamicAnimation animation, boolean canceled, float value, float velocity) {

                anim2.start();
            }
        });

        anim2.addEndListener(new OnAnimationEndListener() {
            @Override
            public void onAnimationEnd(DynamicAnimation animation, boolean canceled, float value, float velocity) {

                anim3.start();
            }
        });

        anim3.addEndListener(new OnAnimationEndListener() {
            @Override
            public void onAnimationEnd(DynamicAnimation animation, boolean canceled, float value, float velocity) {

                anim4.start();
            }
        });

        anim4.addEndListener(new OnAnimationEndListener() {
            @Override
            public void onAnimationEnd(DynamicAnimation animation, boolean canceled, float value, float velocity) {

                anim1.start();
            }
        });

       anim1.start();
    }

}//end of class
