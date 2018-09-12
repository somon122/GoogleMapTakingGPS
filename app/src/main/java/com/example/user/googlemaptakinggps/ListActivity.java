package com.example.user.googlemaptakinggps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    static List<String> address =new ArrayList<>();
    static List<LatLng> latLngs =new ArrayList<>();
    static ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ListView listView = findViewById(R.id.listView_id);
        address.add("Add a new Historical Place");
        latLngs.add(new LatLng(0,0));

        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,address);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListActivity.this, MapsActivity.class);
                intent.putExtra("place", position);
                startActivity(intent);
            }
        });
        listView.setAdapter(arrayAdapter);
    }
}
