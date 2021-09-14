package com.example.foodgo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class INTRO extends AppCompatActivity {
    TextView txt_tenquan;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i_n_t_r_o);
        txt_tenquan = findViewById(R.id.intro_tenquan);
        btn = findViewById(R.id.intro_btn);
        //btn.setVisibility(View.INVISIBLE);
        Animation anim_fade_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);
        btn.startAnimation(anim_fade_out);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation anim_fade_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
                txt_tenquan.startAnimation(anim_fade_in);
                txt_tenquan.setVisibility(View.INVISIBLE);
                //btn.startAnimation(anim_fade_in);
                btn.setVisibility(View.GONE);
                btn.setClickable(false);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        nextActivity();
                    }
                }, 1500);
            }
        });

    }

    private void nextActivity() {
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if (firebaseUser == null)
        {
            Intent intent = new Intent(INTRO.this, LOGIN.class);
            startActivity(intent);
            finish();
        }
        else
        {
            Intent intent = new Intent(INTRO.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

}