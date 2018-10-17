package com.dverybest.fun;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView name;
    TextView description;
    TextView price;
    TextView sub , add, qty;
    ImageView img;
    int count =1;
    public static String INTENT_KEY = "user_detail";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        img = findViewById(R.id.img);
        description = findViewById(R.id.description);
        price = findViewById(R.id.price);
        sub = findViewById(R.id.subBtn);
        add = findViewById(R.id.addBtn);
        qty = findViewById(R.id.qty);
        name = findViewById(R.id.name);

        img.setImageResource(getIntent().getIntExtra("img",0));
        price.setText(getIntent().getDoubleExtra("price",0.0)+"");
        name.setText(getIntent().getStringExtra("name"));
        description.setText(getIntent().
                getStringExtra("description"));
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count==1){
                    return;
                }
                --count;
                qty.setText(""+count);
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ++count;
                qty.setText(""+count);
            }
        });
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

}
