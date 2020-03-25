package com.example.datastoragelab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.prefs.Preferences;

public class MainActivity extends AppCompatActivity {
    private TextView savedName;
    private EditText newNameInput;
    private Button submitBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPref.edit();
        savedName = findViewById(R.id.savedName);
        savedName.setText(sharedPref.getString("savedName",getString(R.string.defaultName)));
        newNameInput = findViewById(R.id.newNameInput);
        submitBtn = findViewById(R.id.submitBtn);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = newNameInput.getText().toString();
                editor.putString("savedName", input);
                editor.commit();
                savedName.setText(sharedPref.getString("savedName",getString(R.string.defaultName)));

            }
        });


    }
}
