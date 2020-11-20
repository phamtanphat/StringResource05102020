package com.example.stringresource05102020;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText mEdtTk,mEdtMk;
    Button mBtnDangNhap,mBtnEn,mBtnVn;
    TextView mTvInFo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEdtMk = findViewById(R.id.editTextPassWord);
        mEdtTk = findViewById(R.id.editTextAccount);
        mBtnDangNhap = findViewById(R.id.buttonLogin);
        mTvInFo = findViewById(R.id.textViewInFo);
        mBtnVn = findViewById(R.id.buttonVn);
        mBtnEn = findViewById(R.id.buttonEn);

        mBtnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tk = mEdtTk.getText().toString();
                String mk = mEdtMk.getText().toString();

                String translateTk = getResources().getString(R.string.hint_tai_khoan);
                String translateMk = getResources().getString(R.string.hint_mat_khau);

                mTvInFo.setText(translateTk + " : " + tk + "\n" + translateMk + " : " + mk );
            }
        });
        mBtnEn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLocale(MainActivity.this,"en");
                Intent intent = new Intent(MainActivity.this,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
        mBtnVn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLocale(MainActivity.this,"vi");
                Intent intent = new Intent(MainActivity.this,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

    }
    public static void setLocale(Activity activity, String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        Resources resources = activity.getResources();
        Configuration config = resources.getConfiguration();
        config.setLocale(locale);
        resources.updateConfiguration(config, resources.getDisplayMetrics());
    }
}