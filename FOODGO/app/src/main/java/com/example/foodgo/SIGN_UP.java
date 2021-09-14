package com.example.foodgo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
import com.google.firebase.auth.FirebaseUser;

public class SIGN_UP extends AppCompatActivity {
    private FirebaseAuth mAuth;
    EditText edt_password, edt_user, edt_repeat_password;
    Button btn_signup;
    TextView txt_check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_i_g_n__u_p);
        unit();
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CHECK_USER check_user = new CHECK_USER(edt_user.getText().toString().trim(), edt_password.getText().toString());
                String pass1 =edt_password.getText().toString();
                String pass2 =edt_repeat_password.getText().toString();
                if (!pass1.equals(pass2))
                {
                    txt_check.setText("Xác nhận mật khẩu không đúng.");
                    txt_check.setVisibility(View.VISIBLE);
                    txt_check.setTextColor(getResources().getColor(R.color.design_default_color_error));
                }
                else if (!check_user.check_email() || !check_user.check_password())
                {
                    txt_check.setVisibility(View.VISIBLE);
                    txt_check.setText("Emai, mật khẩu không đúng. " + "\n" + "(Không được phép rỗng. Mật khẩu >= 6 kí tự. Email có dạng abc@gmail.com)");
                    txt_check.setTextColor(getResources().getColor(R.color.design_default_color_error));
                }
                else process();
            }
        });

    }
    private void process()
    {
        mAuth = FirebaseAuth.getInstance();
        String email = edt_user.getText().toString().trim();
        String password = edt_password.getText().toString().trim();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                           Intent intent = new Intent(SIGN_UP.this, MainActivity.class);
                           startActivity(intent);
                           finishAffinity();
                        } else {
                            Toast.makeText(SIGN_UP.this, "Email đã tồn tại", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
    private void unit() {
        txt_check = findViewById(R.id.sign_up_txt_check);
        edt_password = findViewById(R.id.sign_up_edtMatkhau);
        edt_user = findViewById(R.id.sign_up_edtTendangnhap);
        edt_repeat_password = findViewById(R.id.signup_edtxacnhanMatkhau);
        btn_signup = findViewById(R.id.sign_up_btn);
    }
}