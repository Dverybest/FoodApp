package com.dverybest.fun;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static com.dverybest.fun.DetailActivity.INTENT_KEY;

public class DashActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView recyclerView;
    TextView popularDishNumber;
    TextView appetizerDishNumber;
    ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listview = findViewById(R.id.appetizerListView);
        recyclerView = findViewById(R.id.popularRecyclerView);
        popularDishNumber = findViewById(R.id.dishNumber);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        final ListViewAdapter listViewAdapter = new ListViewAdapter(this,R.layout.list_view,Load2());
        PopularRecyclerAdapter adapter = new PopularRecyclerAdapter(Load(),this);
        listview.setAdapter(listViewAdapter);

        recyclerView.setAdapter(adapter);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Food food = listViewAdapter.getItem(position);
                Intent i = new Intent(DashActivity.this,DetailActivity.class);
                i.putExtra("name",food.getFoodName());
                i.putExtra("description",food.getDescription());
                i.putExtra("price",food.getPrice());
                i.putExtra("img",food.getFootImageURL());

                startActivity(i);
            }
        });
    }

    private List<Food> Load2() {
        ArrayList<Food> list = new ArrayList<>();
        list.add(new Food(R.drawable.img9,"Chicken Suya","3 sticks of delicious chicken syua",1500));
        list.add(new Food(R.drawable.img10,"Short Bread","5 pieces of short bread",1000));
        list.add(new Food(R.drawable.img11,"Sweet Chinchin","1 bottle of sweet chinchin",300));
        list.add(new Food(R.drawable.img12,"Egg Roll","1 full egg egg roll",150));


        return list;
    }

    ArrayList<Popular> Load(){
        ArrayList<Popular> list = new ArrayList<>();
        list.add(new Popular(R.drawable.img3,"Egusi soup"));
        list.add(new Popular(R.drawable.img2,"Chicken Jellof Rice"));
        list.add(new Popular(R.drawable.img7,"Ora Soup"));
        list.add(new Popular(R.drawable.img8,"White Rice With Stew"));
        list.add(new Popular(R.drawable.img5,"Jellof Rice with Salad"));
        list.add(new Popular(R.drawable.img6,"Okro Soup"));

        popularDishNumber.setText(list.size() + " Dishes");
        return  list;
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dash, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
