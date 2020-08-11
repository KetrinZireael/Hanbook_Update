package com.example.gamer_hanbook;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements  NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawer;
    private ListView listArray;
    private String[] array;
    private ArrayAdapter<String> adapter;
    private Toolbar toolbar;
    private int category_index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listArray = findViewById(R.id.listView);
        array = getResources().getStringArray(R.array.rpg_array);
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, new ArrayList<String>(Arrays.asList(array)));
        listArray.setAdapter(adapter);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        listArray.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent intent = new Intent(MainActivity.this, Text_Content_Activity.class);
                intent.putExtra("category", category_index);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        toolbar.setTitle(R.string.menu_rpg);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.nav_rpg){
            toolbar.setTitle(R.string.menu_rpg);
            Toast.makeText(this, "Привет Владушка ❤️️", Toast.LENGTH_SHORT).show();
            array = getResources().getStringArray(R.array.rpg_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
        }
        else if (id == R.id.nav_shooter){
            toolbar.setTitle(R.string.menu_shooter);
            array = getResources().getStringArray(R.array.shooter_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
        }
        else if (id == R.id.nav_strategy){
            toolbar.setTitle(R.string.menu_strategy);
            array = getResources().getStringArray(R.array.strategy_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}