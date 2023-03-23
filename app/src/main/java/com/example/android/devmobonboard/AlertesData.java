package com.example.android.devmobonboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AlertesData extends AppCompatActivity {
    public static final String EXTRA_REPLY =
            "com.example.android.DEVMOBOnBoard.extra.REPLY";
    private EditText mReply;

    protected Button alerte_btn  ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alertes_data);
        mReply = findViewById(R.id.alert_content);
        Intent intent = getIntent();
        String message = intent.getStringExtra(HomeActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.alert_content);
        textView.setText(message);
        alerte_btn = findViewById(R.id.btn_add_alerte);
        alerte_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String reply = mReply.getText().toString();
                Intent replyIntent = new Intent();
                replyIntent.putExtra(EXTRA_REPLY, reply);
                setResult(RESULT_OK, replyIntent);
                finish();
            }
        });


    }
    /* public void returnReply(View view) {
        String reply = mReply.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, replyIntent);
        finish();
    } */
}