package com.example.user.googlemaptakinggps;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "PlaceName_db";
    public static final int VERSION = 1;
    public static final String TABLE_NAME = "GPS_Place_Name";
    public static final String KEY_ID = "Id";
    public static final String KEY_NAME = "PlaceName";
    public static final String KEY_LATITUDE_NO = "LatitudeNo";
    public static final String KEY_LONGITUDES_NO = "LogatudeNo";

    public Context context;
    SQLiteDatabase db;

     private static final String CreateTable = "CREATE TABLE "+TABLE_NAME+" ("+KEY_ID+" INTEGER PRIMARY KEY, "+KEY_NAME+" TEXT, "+KEY_LATITUDE_NO+" TEXT, "+KEY_LONGITUDES_NO+" TEXT);";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            db.execSQL(CreateTable);
            Toast.makeText(context, "onCreate is called", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(context, "onCreate is called"+e, Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    public boolean AddToPlace(AddPlaceName placeName){
        db = this.getWritableDatabase();
        ContentValues values =new ContentValues();
        values.put(KEY_NAME,placeName.getPlaceName());
        values.put(KEY_LATITUDE_NO,placeName.getLatitudeNo());
        values.put(KEY_LONGITUDES_NO,placeName.getLongitudeNo());

        long isInsert = db.insert(TABLE_NAME,null,values);
        db.close();
        if (isInsert>0)
        {
            return true;
        }else {
            return false;
        }

    }

    public ArrayList<AddPlaceName>GetAllPlaceName()
    {
        ArrayList<AddPlaceName>placeNameList = new ArrayList<>();
       db = this.getReadableDatabase();

       String quary = "SELECT * FROM "+TABLE_NAME;
        Cursor cursor = db.rawQuery(quary,null);
        if (cursor.moveToFirst())
        {
            do {

                int id = cursor.getInt(cursor.getColumnIndex(KEY_ID));
                String name = cursor.getString(cursor.getColumnIndex(KEY_NAME));
                double latitudeNo = cursor.getDouble(cursor.getColumnIndex(KEY_LATITUDE_NO));
                double longitudeNo = cursor.getDouble(cursor.getColumnIndex(KEY_LONGITUDES_NO));
                AddPlaceName placeName = new AddPlaceName(id,name,latitudeNo,longitudeNo);
                placeNameList.add(placeName);



            }while (cursor.moveToNext());
            db.close();
        }

        return placeNameList;


    }


}
