package com.example.foodgo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SlidingDrawer;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.firebase.auth.FirebaseAuth;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ViewPager2 viewPager2;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unit();
        setToolbar();
        getfragment();
    }


    @Override
    public void addContentView(View view, ViewGroup.LayoutParams params) {
        super.addContentView(view, params);
    }

    private  void unit()
    {
        drawerLayout = findViewById(R.id.main_layout);
        toolbar = findViewById(R.id.main_toolbar);
        viewPager2 = findViewById(R.id.main_viewPager);
        tabLayout = findViewById(R.id.main_tabLayout);
    }
    private void setToolbar()
    {
        //setSupportActionBar(toolbar);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_Open_drawer, R.string.nav_Close_drawer);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        //
        NavigationView navigationView = findViewById(R.id.main_navigation_view);
        View view_header = navigationView.getHeaderView(0);
        TextView txt_mail = view_header.findViewById(R.id.nav_header_email);
        TextView txt_ten = view_header.findViewById(R.id.nav_header_user);
        ImageView imageView = findViewById(R.id.nav_header_img);
        //
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("MyPref", 0);
        txt_mail.setText(FirebaseAuth.getInstance().getCurrentUser().getEmail());

        if (sharedPreferences.contains("TenUser"))
        {
            txt_ten.setText(sharedPreferences.getString("TenUser", "Huu"));
        }
        navigationView.setNavigationItemSelectedListener(this);
        toolbar.getMenu().findItem(R.id.store_menu).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.store_menu)
                {
                    Intent intent = new Intent(MainActivity.this, Activity_thanhtoan.class);
                    startActivity(intent);
                }
                return false;
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.nav_menu_thanhtoan:
            {
                Intent intent = new Intent(MainActivity.this, Activity_thanhtoan.class);
                startActivity(intent);
                break;
            }

            case R.id.nav_menu_canhan:
            {
                Intent intent = new Intent(MainActivity.this, Activity_thongtintaikhoan.class);
                startActivity(intent);
                finish();
                break;
            }
            case R.id.nav_menu_dangxuat :
            {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(MainActivity.this, LOGIN.class);
                startActivity(intent);
                finishAffinity();
                break;
            }
            case R.id.nav_menu_thoat:
            {
                System.exit(0);
            }
        }
        return true;
    }

    private void getfragment() {
        Adapter_ViewPager adapter_viewPager;
        adapter_viewPager = new Adapter_ViewPager(this);
        viewPager2.setAdapter(adapter_viewPager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position)
                {
//                    case 0:
//                    {
//                        tab.setText("Home");
//                        break;
//                    }
                    case 0:
                    {
                        tab.setText("BBQ");
                        break;
                    }
                    case 1:
                    {
                        tab.setText("Lẩu");
                        break;
                    }
                    case 2:
                    {
                        tab.setText("Món xào");
                        break;
                    }
                    case 3:
                    {
                        tab.setText("Súp");
                        break;
                    }
                    case 4:
                    {
                        tab.setText("Bia");
                        break;
                    }
                    case 5:
                    {
                        tab.setText("Giải khát");
                        break;
                    }
                }
            }
        }).attach();
    }

}