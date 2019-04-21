package com.jjguitar.platzigram.view;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.jjguitar.platzigram.R;
import com.jjguitar.platzigram.view.fragment.HomeFragment;
import com.jjguitar.platzigram.view.fragment.ProfileFragment;
import com.jjguitar.platzigram.view.fragment.SearchFragment;
import com.jjguitar.platzigram.view.CreateAccountActivity;

public class ContainerActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);


        final Fragment homeFragment = new HomeFragment();
        final Fragment searchFragment = new SearchFragment();
        final Fragment profileFragment = new ProfileFragment();

        if (savedInstanceState == null) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.container_container, homeFragment).commit();
        }

        //botomBar

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.botomBar);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                FragmentManager fragmentManager = getSupportFragmentManager();

                if (menuItem.getItemId() == R.id.home_navigationbar) {
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.container_container, homeFragment).
                            setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).
                            addToBackStack(null).commit();
                } else if (menuItem.getItemId() == R.id.search_navigationbar) {
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.container_container, searchFragment).
                            setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).
                            addToBackStack(null).commit();
                } else if (menuItem.getItemId() == R.id.account_navigationbar) {
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.container_container, profileFragment).
                            setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).
                            addToBackStack(null).commit();
                }

                return true;
            }
        });
    }




}
