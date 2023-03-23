package com.example.android.devmobonboard;

import static androidx.core.content.PackageManagerCompat.LOG_TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    private ImageButton toggleButton;
    protected ImageButton alerteButton;


    public static final String EXTRA_MESSAGE =
            "com.example.android.twoactivities.extra.MESSAGE";
    private EditText mMessageEditText;
    /**
     * getting reply from the alert data view
     */
    public static final int TEXT_REQUEST = 1;
    private TextView mReplyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //sending request
        mMessageEditText = findViewById(R.id.Alert_content);
        //getting reply
        mReplyTextView = findViewById(R.id.alerte2);

        

        toggleButton = findViewById(R.id.profile_button);
         alerteButton = findViewById(R.id.Alertes);
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v);
            }
        });

        ImageButton profileButton = findViewById(R.id.profile_button);
        alerteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, AlertesData.class);
                String message = mMessageEditText.getText().toString();
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivityForResult(intent, TEXT_REQUEST);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode,
                                 int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply =
                        data.getStringExtra(AlertesData.EXTRA_REPLY);
                mReplyTextView.setText(reply);
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }
    }
    public void launchSecondActivity(View view) {
        Intent intent = new Intent(this, AlertesData.class);
        String message = mMessageEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, TEXT_REQUEST);
    }
    private void showPopupMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.getMenuInflater().inflate(R.menu.main_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_documents:
                        // TODO: Handle option 1 click
                        return true;
                    case R.id.nav_Frais:
                        // TODO: Handle option 2 click
                        return true;
                    case R.id.nav_scolarité:
                        // TODO: Handle option 3 click
                        return true;
                    case R.id.nav_experiences:
                        // TODO: Handle option 4 click
                        return true;
                    case R.id.nav_absences:
                        // TODO: Handle option 4 click
                        return true;
                    default:
                        return false;
                }
            }
        });
        popupMenu.show();
    }

}