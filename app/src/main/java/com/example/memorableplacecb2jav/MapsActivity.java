package com.example.memorableplacecb2jav;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapLongClickListener;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static com.example.memorableplacecb2jav.MainActivity.arrayAdapter;
import static com.example.memorableplacecb2jav.MainActivity.location;
import static com.example.memorableplacecb2jav.MainActivity.places;
import static com.example.memorableplacecb2jav.MainActivity.value;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMapLongClickListener {

    private GoogleMap mMap;
    //static Intent intent;
    // LocationManager locationManager; //untuk mendapatkan lokasi user fungsi location manager;

    public void centerMapOnLocation(Location location, String title){
        if (location != null){
            LatLng userLocation = new LatLng(location.getLatitude(), location.getLongitude());
            mMap.clear(); // untuk menghapus map yang sebelumnya di pilih
            mMap.addMarker(new MarkerOptions().position(userLocation).title(title)); // untuk nambahkan marker atau tanda sesuai dengan  pilihan user.
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(userLocation,15)); // new camera dan jarak zoom kameranya

        }}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
//            //mMap.setMyLocationEnabled(true);
//
//           // Location lastKnownLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
//        } else {
//
//        }
    }



    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
//        mMap = googleMap;
//        Intent intent = getIntent();
//        mMap.setOnMapLongClickListener(this);
//        Integer cobasaja = 0;
////        // Add a marker in Sydney and move the camera
////        LatLng sydney = new LatLng(-34, 151); // lokasi disney
////        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney")); // nama dari tujuannya
////        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
//
//        // set lokasi secara manual
//        if (places.get(intent.getIntExtra("position", 0)) == Integer.toString(Integer.parseInt("0"))){
//
//            LatLng sydney = new LatLng(-5.134562, 119.482900); // lokasi mesjid ali hizaam
//            // mMap.addMarker(new MarkerOptions().position(sydney).title("INI MESJID ALI HIZAAM")); // nama dari tujuannya // dan tanda penunjuknya merah
//            mMap.addMarker(new MarkerOptions().position(sydney).title("INI MESJID ALI HIZAAM").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))); // maka markernya akan hijau
//            //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney)); // jika kita ingin mengatur pengaturan awal kamera di bagian ini
//            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,14)); // maka kamera akan di zoom
//
//
//        } else {
//            Location placeLocation = new Location(LocationManager.GPS_PROVIDER);
//            placeLocation.setLatitude(MainActivity.location.get(intent.getIntExtra("position", 0)).latitude);
//            placeLocation.setLongitude(MainActivity.location.get(intent.getIntExtra("position", 0)).longitude);
////
//        centerMapOnLocation(placeLocation, places.get(intent.getIntExtra("position",0)));
//        }
//        //PERCOBAAN PERTAMA GAGAL, LOGIKA KALAU INTENT = 0 HARUSNYA DI LOCATION AWAL TAPI JIKA TIDAK HARUSNYA SESUAI SAMA LAT AND LONG


        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//        //PERCOBAAN KEDUA /////////////////////////////////
//
//
//        mMap = googleMap;
//        Intent intent = getIntent();
//        mMap.setOnMapLongClickListener(this);
////        // Add a marker in Sydney and move the camera
////        LatLng sydney = new LatLng(-34, 151); // lokasi disney
////        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney")); // nama dari tujuannya
////        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
//
//        // set lokasi secara manual
//
//        Location placeLocation = new Location(LocationManager.GPS_PROVIDER);
//        placeLocation.setLatitude(MainActivity.location.get(intent.getIntExtra("position", 0)).latitude);
//        placeLocation.setLongitude(MainActivity.location.get(intent.getIntExtra("position", 0)).longitude);
//
//        centerMapOnLocation(placeLocation, places.get(intent.getIntExtra("position",0)));
//
//
//        //mMap.setMapType(googleMap.MAP_TYPE_HYBRID); // memilih tipe mapnya
//        LatLng sydney = new LatLng(-5.134562, 119.482900); // lokasi mesjid ali hizaam
//        // mMap.addMarker(new MarkerOptions().position(sydney).title("INI MESJID ALI HIZAAM")); // nama dari tujuannya // dan tanda penunjuknya merah
//        mMap.addMarker(new MarkerOptions().position(sydney).title("INI MESJID ALI HIZAAM").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))); // maka markernya akan hijau
//        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney)); // jika kita ingin mengatur pengaturan awal kamera di bagian ini
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,14)); // maka kamera akan di zoom
//
//        /////PERCOBAAN KEDUA ///////////////////////
//
//        ////// percobaan ketiga //////////////////////
//
//                mMap = googleMap;
//        Intent intent = getIntent();
//        Bundle bundle = getIntent().getExtras();
//        final String positionlist = bundle.getString("position");
//        mMap.setOnMapLongClickListener(this);
//
//
//
//      //  if (intent.getIntExtra("position",0) == 0){}
//
//       if (positionlist == "0") {
//           Toast.makeText(MapsActivity.this, "ini list yang pertma " + location.toString(), Toast.LENGTH_SHORT).show(); // to see list array yang di klik
//           LatLng sydney = new LatLng(-5.134562, 119.482900); // lokasi mesjid ali hizaam
//           // mMap.addMarker(new MarkerOptions().position(sydney).title("INI MESJID ALI HIZAAM")); // nama dari tujuannya // dan tanda penunjuknya merah
//           mMap.addMarker(new MarkerOptions().position(sydney).title("INI MESJID ALI HIZAAM").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))); // maka markernya akan hijau
//           //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney)); // jika kita ingin mengatur pengaturan awal kamera di bagian ini
//           mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,14)); // maka kamera akan di zoom
//       }else {
//           Toast.makeText(MapsActivity.this, positionlist, Toast.LENGTH_SHORT).show(); // to see list array yang di klik
//
//           //mMap.setMapType(googleMap.MAP_TYPE_HYBRID); // memilih tipe mapnya
//
//           //centerMapOnLocation(MainActivity.places.get(intent.getIntExtra("position",0)));
//       }
//
//         akhir percobaan ketiga//////////////

        // percobaan 4 //


//
//                mMap = googleMap;
//        Intent intent = getIntent();
//        Bundle bundle = getIntent().getExtras();
//        final String positionlist = bundle.getString("position");
//        mMap.setOnMapLongClickListener(this);
//
//
//
//        if (intent.getIntExtra("position",0) == 0){
//
//       //if (positionlist == "0") {
//           Toast.makeText(MapsActivity.this, "ini list yang pertma " + location.toString(), Toast.LENGTH_SHORT).show(); // to see list array yang di klik
//           LatLng sydney = new LatLng(-5.134562, 119.482900); // lokasi mesjid ali hizaam
//           // mMap.addMarker(new MarkerOptions().position(sydney).title("INI MESJID ALI HIZAAM")); // nama dari tujuannya // dan tanda penunjuknya merah
//           mMap.addMarker(new MarkerOptions().position(sydney).title("INI MESJID ALI HIZAAM").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))); // maka markernya akan hijau
//           //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney)); // jika kita ingin mengatur pengaturan awal kamera di bagian ini
//           mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,14)); // maka kamera akan di zoom
//       }else {
//           Toast.makeText(MapsActivity.this, positionlist, Toast.LENGTH_SHORT).show(); // to see list array yang di klik
//            LatLng sydney = new LatLng(-5.1555597,119.4826823); // lokasi mesjid ali hizaam
//            // mMap.addMarker(new MarkerOptions().position(sydney).title("INI MESJID ALI HIZAAM")); // nama dari tujuannya // dan tanda penunjuknya merah
//            mMap.addMarker(new MarkerOptions().position(sydney).title("INI bukit baruga").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))); // maka markernya akan hijau
//            //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney)); // jika kita ingin mengatur pengaturan awal kamera di bagian ini
//            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,14)); // maka kamera akan di zoom
//           //mMap.setMapType(googleMap.MAP_TYPE_HYBRID); // memilih tipe mapnya
//           // Location placeLocation = new Location(LocationManager.GPS_PROVIDER);
//            // placeLocation.setLatitude(MainActivity.location.get(intent.getIntExtra("position", 0)).latitude);
//           // placeLocation.setLongitude(MainActivity.location.get(intent.getIntExtra("position", 0)).longitude);
//
//           //centerMapOnLocation(MainActivity.places.get(intent.getIntExtra("position",0)));
//       }
//
//        // akhir percobaan ke4//////////////

        // akhir percobaan ke5 //

        mMap = googleMap;
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int ayo = bundle.getInt("position");
        //Intent intent = getIntent();
        //Bundle bundle=getIntent().getExtras();
        int mealId = bundle.getInt("position");
        String s=bundle.getString("position");
        Bundle N = bundle.getBundle("position");
        Bundle A = intent.getBundleExtra("position");
       int SA =  intent.getIntExtra("position",0);
        mMap.setOnMapLongClickListener(this);
//        if (intent.getIntExtra("pasition",0) == 0) {
//            Toast.makeText(this, "lokasi awal " + intent.getIntExtra("position",0) , Toast.LENGTH_SHORT).show();
//                       LatLng sydney = new LatLng(-5.134562, 119.482900); // lokasi mesjid ali hizaam
//           // mMap.addMarker(new MarkerOptions().position(sydney).title("INI MESJID ALI HIZAAM")); // nama dari tujuannya // dan tanda penunjuknya merah
//           mMap.addMarker(new MarkerOptions().position(sydney).title("INI MESJID ALI HIZAAM").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))); // maka markernya akan hijau
//           //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney)); // jika kita ingin mengatur pengaturan awal kamera di bagian ini
//           mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,14)); // maka kamera akan di zoom
//
//        }else if(intent.getIntExtra("pasition",0) == 1) {
//            Toast.makeText(this, "lokasi kedua " , Toast.LENGTH_SHORT).show();
//        }

        //salah
//        if (mealId == 0){
//            Toast.makeText(this, "nomor " + mealId, Toast.LENGTH_SHORT).show();
//
//        } else {
//            Toast.makeText(this, "nomor" + mealId, Toast.LENGTH_SHORT).show();
//        }
//          SALAH
//        if (intent.getIntExtra("position", 0)== 0){
//            Toast.makeText(this, "nomor " + intent.getIntExtra("position", 1), Toast.LENGTH_SHORT).show();
//        }else {
//            Toast.makeText(this, "nomor2" + intent.getIntExtra("position", 1), Toast.LENGTH_SHORT).show();
//        }
        final String positionlist = bundle.getString("position");
      //  int likecount = intent.getIntExtra("position",0);


        if (positionlist.equals("Add a new place")) {
            Toast.makeText(this, "lokasinya "+ location, Toast.LENGTH_SHORT).show(); // to see list array yang di klik


            //Toast.makeText(this, "benar " + positionlist, Toast.LENGTH_SHORT).show();
            //Toast.makeText(this, "lokasi awal " + intent.getIntExtra("position",0) , Toast.LENGTH_SHORT).show();
                       LatLng sydney = new LatLng(-5.134562, 119.482900); // lokasi mesjid ali hizaam
           // mMap.addMarker(new MarkerOptions().position(sydney).title("INI MESJID ALI HIZAAM")); // nama dari tujuannya // dan tanda penunjuknya merah
           mMap.addMarker(new MarkerOptions().position(sydney).title("INI MESJID ALI HIZAAM").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))); // maka markernya akan hijau
           //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney)); // jika kita ingin mengatur pengaturan awal kamera di bagian ini
           mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,14)); // maka kamera akan di zoom
        }else {
            int devalue = Integer.parseInt(value);
           Toast.makeText(this, "salah " + devalue, Toast.LENGTH_SHORT).show();
                      // Toast.makeText(MapsActivity.this, positionlist, Toast.LENGTH_SHORT).show(); // to see list array yang di klik
//            LatLng sydney = new LatLng(-5.1555597,119.4826823); // lokasi mesjid ali hizaam
//            // mMap.addMarker(new MarkerOptions().position(sydney).title("INI MESJID ALI HIZAAM")); // nama dari tujuannya // dan tanda penunjuknya merah
//            mMap.addMarker(new MarkerOptions().position(sydney).title("INI bukit baruga").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))); // maka markernya akan hijau
//            //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney)); // jika kita ingin mengatur pengaturan awal kamera di bagian ini
//            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,14)); // maka kamera akan di zoom


             //Toast.makeText(this, "lokasinya "+ likecount, Toast.LENGTH_SHORT).show(); // to see list array yang di klik

                        Location placeLocation = new Location(LocationManager.GPS_PROVIDER);
             placeLocation.setLatitude(MainActivity.location.get(intent.getIntExtra("position", devalue)).latitude);
            placeLocation.setLongitude(MainActivity.location.get(intent.getIntExtra("position", devalue)).longitude);

            LatLng userLocation = new LatLng(placeLocation.getLatitude(), placeLocation.getLongitude());
            mMap.clear(); // untuk menghapus map yang sebelumnya di pilih
            mMap.addMarker(new MarkerOptions().position(userLocation).title(positionlist)); // untuk nambahkan marker atau tanda sesuai dengan  pilihan user.
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(userLocation,14)); // new camera dan jarak zoom kameranya


            //centerMapOnLocation(MainActivity.places.get(intent.getIntExtra("position",0)));

        }
       // percobaan akhir 5 //
// SETPOINT AWAL
//        mMap = googleMap;
//        Intent intent = getIntent();
//        mMap.setOnMapLongClickListener(this);
////        // Add a marker in Sydney and move the camera
////        LatLng sydney = new LatLng(-34, 151); // lokasi disney
////        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney")); // nama dari tujuannya
////        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
//
//        // set lokasi secara manual
//
//        //mMap.setMapType(googleMap.MAP_TYPE_HYBRID); // memilih tipe mapnya
//        LatLng sydney = new LatLng(-5.134562, 119.482900); // lokasi mesjid ali hizaam
//        // mMap.addMarker(new MarkerOptions().position(sydney).title("INI MESJID ALI HIZAAM")); // nama dari tujuannya // dan tanda penunjuknya merah
//        mMap.addMarker(new MarkerOptions().position(sydney).title("INI MESJID ALI HIZAAM").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))); // maka markernya akan hijau
//        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney)); // jika kita ingin mengatur pengaturan awal kamera di bagian ini
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,14)); // maka kamera akan di zoom
 // SETPOINT AWAL
    }


    @Override
    public void onMapLongClick(LatLng latLng) {

        Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());
        String address = "";

        try {

            List<Address> listAdddresses = geocoder.getFromLocation(latLng.latitude,latLng.longitude,1);

            if (listAdddresses != null && listAdddresses.size() > 0) {
                if (listAdddresses.get(0).getThoroughfare() != null) {
                    if (listAdddresses.get(0).getSubThoroughfare() != null) {
                        address += listAdddresses.get(0).getSubThoroughfare() + " ";
                    }
                    //address += listAdddresses.get(0).getThoroughfare();
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm yyyy-MM-dd") ;
                    address += sdf.format(new Date()) + " "+ listAdddresses.get(0).getThoroughfare();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // this source for add what we press long in map and save to activity main.
        places.add(address);
        location.add(latLng);
        MainActivity.arrayAdapter.notifyDataSetChanged();


        mMap.addMarker(new MarkerOptions()
                .position(latLng)
                .title(address)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

    }
}