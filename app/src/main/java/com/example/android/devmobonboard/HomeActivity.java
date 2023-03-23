package com.example.android.devmobonboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;

public class HomeActivity extends AppCompatActivity {
    private ImageButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toggleButton = findViewById(R.id.profile_button);
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v);
            }
        });

        ImageButton profileButton = findViewById(R.id.profile_button);
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Handle profile button click
            }
        });
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