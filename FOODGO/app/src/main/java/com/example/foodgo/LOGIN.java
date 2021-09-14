package com.example.foodgo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LOGIN extends AppCompatActivity {
    TextView txt_dangki, txt_check;
    EditText edt_password, edt_user;
    Button btn_login;

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l_o_g_i_n);
        txt_dangki = findViewById(R.id.login_txt_dangki);
        unit();
        onClick_txt_dangki();
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CHECK_USER check_user = new CHECK_USER(edt_user.getText().toString().trim(), edt_password.getText().toString());
                if (check_user.check_email() && check_user.check_password())
                {
                    process();

                }
                else
                {
                    txt_check.setVisibility(View.VISIBLE);
                    txt_check.setText("Emai, mật khẩu không đúng. " + "\n" + "(Không được phép rỗng. Mật khẩu >= 6 kí tự. Email có dạng abc@gmail.com)");
                    txt_check.setTextColor(getResources().getColor(R.color.design_default_color_error));
                }
            }
        });
    }
    private void onClick_txt_dangki() {
        txt_dangki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LOGIN.this, SIGN_UP.class);
                startActivity(intent);
            }
        });
    }
    private void process()
    {
        mAuth = FirebaseAuth.getInstance();
        String email = edt_user.getText().toString().trim();
        String password = edt_password.getText().toString().trim();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent intent = new Intent(LOGIN.this, MainActivity.class);
                            startActivity(intent);
                            finishAffinity();
                        } else {
                            txt_check.setText("Sai mật khẩu");
                        }
                    }
                });
    }
    //private class
    private void unit() {
        txt_check = findViewById(R.id.login_txt_check);
        edt_password = findViewById(R.id.login_edtMatkhau);
        edt_user = findViewById(R.id.login_edtTendangnhap);
        btn_login = findViewById(R.id.login_btn);
    }

}