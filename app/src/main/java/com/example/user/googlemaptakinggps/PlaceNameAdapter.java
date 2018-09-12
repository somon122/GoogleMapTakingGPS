package com.example.user.googlemaptakinggps;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaceNameAdapter extends ArrayAdapter<AddPlaceName> {

    ArrayList<AddPlaceName> placeNameList = new ArrayList<>();
     Context mContext;


    public PlaceNameAdapter(@NonNull Context context, @NonNull ArrayList<AddPlaceName> placeNameList) {
        super(context, R.layout.view_model, placeNameList);
        mContext = context;
        this.placeNameList = placeNameList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(mContext);

        convertView = inflater.inflate(R.layout.view_model,parent,false);

        TextView placeName = convertView.findViewById(R.id.view_placeName_id);
        TextView placelatitudeNo = convertView.findViewById(R.id.view_placeLatitude_id);
        TextView placelongatitudeNo = convertView.findViewById(R.id.view_placeLongitude_id);


        AddPlaceName addPlaceName = placeNameList.get(position);

        placeName.setText(addPlaceName.getPlaceName());


        String mlatitude = String.valueOf(addPlaceName.getLatitudeNo());
        String mlongitude = String.valueOf(addPlaceName.getLongitudeNo());

        placelatitudeNo.setText(mlatitude);
        placelongatitudeNo.setText(mlongitude);



        return convertView;
    }

}
