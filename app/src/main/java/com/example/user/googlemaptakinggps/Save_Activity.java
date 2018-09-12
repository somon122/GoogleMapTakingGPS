package com.example.user.googlemaptakinggps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Save_Activity extends AppCompatActivity {

    Button saveButton;
    private EditText name_editText,latitude_editText,longitude_editText;

    DBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_);

        dbHelper = new DBHelper(getApplicationContext());

        name_editText = findViewById(R.id.placeName_id);
        latitude_editText = findViewById(R.id.placeLatitude_id);
        longitude_editText = findViewById(R.id.placeLongitude_id);
        saveButton = findViewById(R.id.savePlace_id);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = name_editText.getText().toString();
                String latitude = latitude_editText.getText().toString();
                String longitude = longitude_editText.getText().toString();

                double mLatitudeNo = Double.parseDouble(latitude);
                double mlongitudeNo = Double.parseDouble(longitude);

                AddPlaceName placeName = new AddPlaceName(name,mLatitudeNo,mlongitudeNo);

                boolean isInsert = dbHelper.AddToPlace(placeName);
                if (isInsert)
                {
                    Toast.makeText(Save_Activity.this, "Successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Save_Activity.this,PlaceNameShowActivity.class));
                }else {
                    Toast.makeText(Save_Activity.this, "Field", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}
