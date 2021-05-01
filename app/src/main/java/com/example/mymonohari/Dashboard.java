package com.example.mymonohari;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.GridLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private RecyclerView recyclerView;
    private StaticRV_Adapter adapter;
    private DynamicRV_Adapter adapter2;
    //Variables for Navigation Bar
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dashboard);

        //<------------------------Hooks------------------------------------->
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        toolbar = findViewById(R.id.my_toolbar);
        //<---------------------Tool Bar as Our Action Bar-------------------->
        setSupportActionBar(toolbar);
        //<-----------------Navigation Menu------------------------------->
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        ArrayList<StaticRV_Model> itemList = new ArrayList<>();
        itemList.add(new StaticRV_Model(R.drawable.groceryimg, "Item1"));
        itemList.add(new StaticRV_Model(R.drawable.groceryimg, "Item2"));
        itemList.add(new StaticRV_Model(R.drawable.groceryimg, "Item3"));
        itemList.add(new StaticRV_Model(R.drawable.groceryimg, "Item4"));
        itemList.add(new StaticRV_Model(R.drawable.groceryimg, "Item5"));
        itemList.add(new StaticRV_Model(R.drawable.groceryimg, "Item6"));

        recyclerView = (RecyclerView) findViewById(R.id.rv_1);
        adapter = new StaticRV_Adapter(itemList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(adapter);

        //Dynamic

        ArrayList<DynamicRV_Model> itemList2 = new ArrayList<>();
        itemList2.add(new DynamicRV_Model(R.drawable.cart, "Item1"));
        itemList2.add(new DynamicRV_Model(R.drawable.cart, "Item2"));
        itemList2.add(new DynamicRV_Model(R.drawable.cart, "Item1"));
        itemList2.add(new DynamicRV_Model(R.drawable.cart, "Item2"));
        itemList2.add(new DynamicRV_Model(R.drawable.cart, "Item1"));
        itemList2.add(new DynamicRV_Model(R.drawable.cart, "Item2"));
        itemList2.add(new DynamicRV_Model(R.drawable.cart, "Item1"));
        itemList2.add(new DynamicRV_Model(R.drawable.cart, "Item2"));
        itemList2.add(new DynamicRV_Model(R.drawable.cart, "Item1"));
        itemList2.add(new DynamicRV_Model(R.drawable.cart, "Item2"));
        itemList2.add(new DynamicRV_Model(R.drawable.cart, "Item1"));
        itemList2.add(new DynamicRV_Model(R.drawable.cart, "Item2"));
        itemList2.add(new DynamicRV_Model(R.drawable.cart, "Item1"));
        itemList2.add(new DynamicRV_Model(R.drawable.cart, "Item2"));
        itemList2.add(new DynamicRV_Model(R.drawable.cart, "Item1"));
        itemList2.add(new DynamicRV_Model(R.drawable.cart, "Item2"));


        recyclerView = (RecyclerView) findViewById(R.id.rv_2);
        adapter2 = new DynamicRV_Adapter(itemList2);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter2);


    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return true;
    }
}