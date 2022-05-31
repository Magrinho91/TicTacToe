package com.example.mytictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class PlayerSetup extends AppCompatActivity {

    private EditText firstPlayerName;
    private EditText secondPlayerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_setup);

        firstPlayerName = findViewById(R.id.firstPlayerName);
        secondPlayerName = findViewById(R.id.secondPlayerName);

        emptyTextFields(firstPlayerName);
        emptyTextFields(secondPlayerName);
    }

    private void emptyTextFields(EditText editText) {
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().toString().equals("Type your name")) {
                    editText.setText("");
                }
            }
        });
    }

    public void onClickSendNamesToGameDisplay(View view) {
        String playerOneName = firstPlayerName.getText().toString();
        String playerTwoName = secondPlayerName.getText().toString();

        Intent intent = new Intent(this, GameDisplay.class);
        intent.putExtra("NAMES", new String[]{playerOneName, playerTwoName});
        startActivity(intent);
    }
}