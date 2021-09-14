package com.example.foodgo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Activity_thongtintaikhoan extends AppCompatActivity {
    TextView  gmail;
    EditText edt_ten;
    Button btn_thaydoi, btn_huy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongtintaikhoan);
        unit();
        process();
    }

    private void unit() {
        gmail = findViewById(R.id.tttk_gmail);
        edt_ten = findViewById(R.id.tttk_ten);
        btn_huy = findViewById(R.id.tttk_btn_huy);
        btn_thaydoi = findViewById(R.id.tttk_btn_thaydoi);
    }

    private void process() {
        String getEmail = FirebaseAuth.getInstance().getCurrentUser().getEmail();
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("MyPref",0);
        if (preferences.contains("TenUser")) edt_ten.setText(preferences.getString("TenUser", "Huu"));
        if (getEmail != null)
        {
            gmail.setText(getEmail+"");
        }

        btn_huy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_thongtintaikhoan.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btn_thaydoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_thongtintaikhoan.this, MainActivity.class);
                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("MyPref", 0);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("TenUser",edt_ten.getText().toString().trim());
                editor.commit();
                startActivity(intent);
                finish();
            }
        });
    }

}