package com.Alejandro.The_Strategy;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout mDrawelayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //UI
        mDrawelayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.nav_view);
        toolbar=findViewById(R.id.toolbar);

        //para que empieze por PrincipalFragment
        getSupportFragmentManager().beginTransaction().add(R.id.content,new PrincipalFragment()).commit();
        setTitle("Principal");

        //setup toolbar
        setSupportActionBar(toolbar);

        toggle= setupDrawerToggle();
        mDrawelayout.addDrawerListener(toggle);

        navigationView.setNavigationItemSelectedListener(this);

    }
    private ActionBarDrawerToggle setupDrawerToggle(){
        return new ActionBarDrawerToggle(this,
                mDrawelayout,
                toolbar,
                R.string.drawer_open,
                R.string.drawer_close
        );
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        selectItemNav(item);
        return true;
    }

    private void selectItemNav(MenuItem item) {
        FragmentManager fm= getSupportFragmentManager();
        FragmentTransaction ft= fm.beginTransaction();
        switch (item.getItemId()){
            case R.id.nav_principal:
                ft.replace(R.id.content,new PrincipalFragment()).commit();
                break;
            case R.id.nav_strategy:
                ft.replace(R.id.content,new StrategyFragment()).commit();
                break;
            case R.id.nav_recors:
                ft.replace(R.id.content,new RecorsFragment()).commit();
                break;
            case R.id.nav_settings:
                ft.replace(R.id.content,new SettingsFragment()).commit();
                break;
        }
        //para recoger el titulo del item
        setTitle(item.getTitle());
        //para que al pulsar fuera del DraweLayout se cierre este
        mDrawelayout.closeDrawers();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}