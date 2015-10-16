package com.hw.corcow.sampleanimation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView frameAniView, tweenAniView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // Frame Animation
        frameAniView = (ImageView)findViewById(R.id.imageView);
        Button btn = (Button)findViewById(R.id.btn_start);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnimation();
            }
        });

        btn = (Button)findViewById(R.id.btn_stop);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopAnimation();
            }
        });

        // Tween Animation (View Animation)
        tweenAniView = (ImageView)findViewById(R.id.imageView2);
        // translate
        btn = (Button)findViewById(R.id.btn_translate);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.translate);
                tweenAniView.startAnimation(anim);
            }
        });
        // rotate
        btn = (Button)findViewById(R.id.btn_rotate);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotate);
                tweenAniView.startAnimation(anim);
            }
        });
        // scale
        btn = (Button)findViewById(R.id.btn_scale);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scale);
                tweenAniView.startAnimation(anim);
            }
        });
        // alpha
        btn = (Button)findViewById(R.id.btn_alpha);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.alpha);
                tweenAniView.startAnimation(anim);
            }
        });
        // set1
        btn = (Button)findViewById(R.id.btn_set1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.set1);
                tweenAniView.startAnimation(anim);
            }
        });
        // set2 (startOffset)
        btn = (Button)findViewById(R.id.btn_set2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.set2);
                tweenAniView.startAnimation(anim);
            }
        });
        // custom animation (MyAnimation class)
        btn = (Button)findViewById(R.id.btn_custom);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyAnimation anim = new MyAnimation();
                // duration은 여기서!
                anim.setDuration(1000);
                tweenAniView.startAnimation(anim);
            }
        });
        btn = (Button)findViewById(R.id.btn_3d);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                My3DAnimation anim = new My3DAnimation();
                // duration은 여기서!
                anim.setDuration(1000);
                tweenAniView.startAnimation(anim);
            }
        });

    }

    // Frame Animation
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            startAnimation();
        } else {
            stopAnimation();
        }
    }

    private void startAnimation() {
        AnimationDrawable d = (AnimationDrawable) frameAniView.getDrawable();
        d.start();
    }

    private void stopAnimation() {
        AnimationDrawable d = (AnimationDrawable) frameAniView.getDrawable();
        d.stop();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
