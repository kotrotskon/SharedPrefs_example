package com.example.sharedprefs_example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText1 = findViewById(R.id.edTxt_1);
        EditText editText2 = findViewById(R.id.edTxt_2);
        Button button = findViewById(R.id.button);

        SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
        String text1 = preferences.getString("myText1", "no text 1");
        String text2 = preferences.getString("myText2", "no text 2");
        editText1.setText(text1);
        editText2.setText(text2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("myText1", editText1.getText().toString());
                editor.putString("myText2", editText2.getText().toString());
                editor.commit();
            }
        });
    }
}