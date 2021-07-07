package com.example.sharedprefs_example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edTxt_email = findViewById(R.id.edTxt_email);
        EditText edTxt_password = findViewById(R.id.edTxt_password);
        Button btn = findViewById(R.id.btn_login);
        TextView textView = findViewById(R.id.textView);

        SharedPreferences preferences = getSharedPreferences("PREFS", MODE_PRIVATE);
        textView.setText(preferences.getString("email", "")+" "+preferences.getString("password", ""));


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = getSharedPreferences("PREFS", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("email", edTxt_email.getText().toString());
                editor.putString("password", edTxt_password.getText().toString());
                editor.commit();
            }
        });
    }
}