package com.example.taskmaster;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.Tasks;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    private static final int RC_SIGN_IN = 321;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//   Navigation Code for the Main page from here down
        dl = (DrawerLayout) findViewById(R.id.activity_main);
        t = new ActionBarDrawerToggle(this, dl, R.string.open, R.string.close);

        dl.addDrawerListener(t);
        t.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nv = (NavigationView) findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.nav_item_1:
                        Intent intent = new Intent(MainActivity.this, Tasks.class);
                        startActivity(intent);
                        break;

                    case R.id.nav_item_2:
                        Toast.makeText(MainActivity.this, "You're already at Home!", Toast.LENGTH_SHORT).show();
                        break;

//                    case R.id.nav_item_3:
//                        Intent intent2 = new Intent(MainActivity.this, ExerciseDiaryActivity.class);
//                        startActivity(intent2);
//                        break;
//
                    default:
                        return true;
                }
                return true;
            }
        });
    }
//  Navigation code for the Main page from here up

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }

    public void onLoginClick(View view) {
        // Choose authentication providers
        List<AuthUI.IdpConfig> providers = Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build());


        // Create and launch sign-in intent
        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .build(),
                RC_SIGN_IN);
    }

    private void setUI() {
        Button login = findViewById(R.id.button_login);
        Button logout = findViewById(R.id.button_logout);
        TextView textView = findViewById(R.id.text_content);
        if (user != null) {
            login.setEnabled(false);
            logout.setEnabled(true);
            textView.setText(user.getDisplayName());
        } else {
            login.setEnabled(true);
            logout.setEnabled(false);
            textView.setText("Welcome!");
        }
    }
}
