package com.example.user.googlemaptakinggps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PlaceNameShowActivity extends AppCompatActivity {

    ListView listView;
    DBHelper dbHelper;
    PlaceNameAdapter placeNameAdapter;
    ArrayList<AddPlaceName>placeNameList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_name_show);

        dbHelper = new DBHelper(getApplicationContext());

        listView = findViewById(R.id.listView_id);
        placeNameList = dbHelper.GetAllPlaceName();
        placeNameAdapter = new PlaceNameAdapter(this,placeNameList);

        listView.setAdapter(placeNameAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(PlaceNameShowActivity.this,MapsActivity.class);
                intent.putExtra("id",placeNameList.get(position).getId());
                intent.putExtra("name",placeNameList.get(position).getPlaceName());
                intent.putExtra("latitude",placeNameList.get(position).getLatitudeNo());
                intent.putExtra("longitude",placeNameList.get(position).getLongitudeNo());
                startActivity(intent);
            }
        });


    }
}
