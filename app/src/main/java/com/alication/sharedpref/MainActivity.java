package com.alication.sharedpref;

import android.content.SharedPreferences;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button saveButton;
    private TextView resultView;
    private EditText enterName;
    private SharedPreferences myPref;
    private static final String Prefs_Name = "MyPrefsFile";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveButton = findViewById(R.id.saveButtonID);
        resultView = findViewById(R.id.resultViewID);
        enterName = findViewById(R.id.enterNameID);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myPref = getSharedPreferences(Prefs_Name, 0);
                SharedPreferences.Editor editor = myPref.edit();

                editor.putString("name", enterName.getText().toString());
                editor.commit();

            }
        });

        SharedPreferences prefs = getSharedPreferences(Prefs_Name, 0);

        if (prefs.contains("name")) {
            String message = prefs.getString("name", "Not Found");
            resultView.setText("Message: " + message);
        }

    }
}
