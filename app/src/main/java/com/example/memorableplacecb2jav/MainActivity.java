package com.example.memorableplacecb2jav;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static ArrayList<String> places = new ArrayList<String>();
    static ArrayList<LatLng> location = new ArrayList<LatLng>();
    static ArrayAdapter arrayAdapter;
    static String value;
   // static Object likecountis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listView = findViewById(R.id.listView);
        location.add(new LatLng(0,0));
        places.add("Add a new place");
       // places.add("Add a new place2");
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, places);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Toast.makeText(MainActivity.this, location.toString(), Toast.LENGTH_SHORT).show(); // to see list array yang di klik
                //likecountis = mExampleAdapter.get(Integer.parseInt("position"));
                //String value = places.get(position); send location ke toast yang diklik
               // Integer value = places.getPosition(position); salah
               // int value = Integer.parseInt(places.get(position)); salah
                //Integer value = (Integer) listView.getItemAtPosition(position);
                //Log.i("nama", (String) listView.getItemAtPosition(position));

                value = Integer.toString(position);
                Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show(); // to see list array yang di klik
                Intent intent = new Intent (getApplicationContext(), MapsActivity.class);
                intent.putExtra("position",places.get(position));
                startActivity(intent);
               // Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show(); // to see list array yang di klik
            }
        });
        }

}
