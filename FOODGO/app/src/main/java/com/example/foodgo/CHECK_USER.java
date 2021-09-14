package com.example.foodgo;

import android.text.TextUtils;
import android.util.Patterns;

import java.util.regex.Pattern;

public class CHECK_USER {
    String email, password;

    public CHECK_USER(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public boolean check_password()
    {
        return !TextUtils.isEmpty(password) && password.length() >= 6;
    }
    public boolean check_email()
    {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
