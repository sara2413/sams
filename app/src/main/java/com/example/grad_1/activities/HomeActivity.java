package com.example.grad_1.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.grad_1.R;
import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;

    NavController navController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);

        ActionBar actionBar= getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);




        navController = Navigation.findNavController(HomeActivity.this, R.id.
                nav_host_fragment);


        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {

                //String title;
                switch(destination.getId()){
                    case R.id.subjectFragment3:
                        actionBar.setTitle("Subjects");
                        break;
                    case R.id.settingsFragment3:
                        actionBar.setTitle("Settings");
                        break;
                    case R.id.helpFragment3:
                        actionBar.setTitle("Help");
                        break;
                    case R.id.logOutFragment3:
                   //     actionBar.setTitle("LogOut");
                        doLogout();
                        break;
                    default:
                        actionBar.setTitle("Attendance");
                }
            }
        });



        NavigationUI.setupWithNavController(navigationView, navController);

    }

    private void doLogout(){
        drawerLayout.closeDrawer(GravityCompat.START);
//        navController.navigate(R.id.action_subjectFragment3_to_std_Login_Fragment2);
        finishAffinity();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == android.R.id.home) {


            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START);
            } else {
                drawerLayout.openDrawer(GravityCompat.START);
            }
            return true;
        } else if(item.getItemId() == R.id.action_notifications){
            //TODO : aro7 li el
        }
        return super.onOptionsItemSelected(item);


    }


}