package com.sts.navigationdrawerandroid;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sts.navigationdrawerandroid.fragments.Fragment_Email;
import com.sts.navigationdrawerandroid.fragments.Fragment_Home;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    NavigationView mNavigation;
    TextView mNameTextView,mEmailTextView;
    ImageView mProfileImageView;
    DrawerLayout drawer;
    Toolbar toolbar;
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Window window=getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("First Navigation");
        drawer= (DrawerLayout) findViewById(R.id.drawer_layour);

        manager=getSupportFragmentManager();

        ActionBarDrawerToggle toogle=new ActionBarDrawerToggle(this,drawer,toolbar,R.string.OPEN,R.string.CLOSE);
        drawer.addDrawerListener(toogle);
        toogle.syncState();


        mNavigation= (NavigationView) findViewById(R.id.navigation_view);
        View view=mNavigation.getHeaderView(0);
        mNameTextView= (TextView) view.findViewById(R.id.profile_name);
        mEmailTextView= (TextView) view.findViewById(R.id.profile_email);
        mProfileImageView= (ImageView) view.findViewById(R.id.profile_pic);

        mNameTextView.setText("jaspal");
        mEmailTextView.setText("jaspal@gmail.com");

        mNavigation.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.email)
        {
            manager.beginTransaction().replace(R.id.container,new Fragment_Email()).commit();
            Toast.makeText(this, "Email", Toast.LENGTH_SHORT).show();
            drawer.closeDrawers();
        }
        if(item.getItemId()==R.id.home)
        {
            manager.beginTransaction().replace(R.id.container,new Fragment_Home()).commit();
            Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
            drawer.closeDrawers();
        }

        return false;
    }
}
