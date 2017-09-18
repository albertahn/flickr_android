package com.albert.flickrrecents;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;
import com.albert.flickrrecents.adapters.FlickrImageAdapter;
import com.albert.flickrrecents.models.FlickrImageModel;
import com.albert.flickrrecents.utils.ApiManager;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.albert.flickrrecents.utils.Constants.IMAGE_JSON_SHARED_PREF_KEY;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private Context mContext;
    private Gson gson = new Gson();
    private  String TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = getApplicationContext();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Swipe Right to Left");

        sharedPreferences = getSharedPreferences(IMAGE_JSON_SHARED_PREF_KEY, Context.MODE_PRIVATE);

        String fJsonString = sharedPreferences.getString("photo", "empty");

        Log.d("responsepost: ", "" + fJsonString.toString());


        if(!fJsonString.equals("empty")){
            ArrayList<FlickrImageModel> flickrArray =(ArrayList<FlickrImageModel>) gson.fromJson(fJsonString, new TypeToken<ArrayList<FlickrImageModel>>() {
            }.getType());

            RecyclerView rc1 = (RecyclerView) findViewById(R.id.rc3);
            FlickrImageAdapter fAdapter = new FlickrImageAdapter(flickrArray, getBaseContext());
            rc1.setHasFixedSize(false);

            LinearLayoutManager llm = new LinearLayoutManager(mContext);
            llm.setOrientation(LinearLayoutManager.HORIZONTAL);
            rc1.setLayoutManager(llm);
            rc1.setAdapter(fAdapter);


        }//not empty


        //set listener for loose coupling
        sharedPreferences.registerOnSharedPreferenceChangeListener(
                new SharedPreferences.OnSharedPreferenceChangeListener() {
                    public void onSharedPreferenceChanged(
                            SharedPreferences prefs, String key) {

                        Log.d(TAG, "key:" + key.toString());

                        //if the image in shared pref change reset recylerview
                        if(key.equals("photo")){



                            String fJsonString = prefs.getString("photo", "empty");

                            Log.d(TAG, "listener: " + fJsonString.toString());

                            ArrayList<FlickrImageModel> flickrArray =(ArrayList<FlickrImageModel>) gson.fromJson(fJsonString, new TypeToken<ArrayList<FlickrImageModel>>() {
                            }.getType());

                            RecyclerView rc1 = (RecyclerView) findViewById(R.id.rc3);
                            FlickrImageAdapter fAdapter = new FlickrImageAdapter(flickrArray, getBaseContext());
                            rc1.setHasFixedSize(false);

                            LinearLayoutManager llm = new LinearLayoutManager(mContext);
                            llm.setOrientation(LinearLayoutManager.HORIZONTAL);
                            rc1.setLayoutManager(llm);
                            rc1.setAdapter(fAdapter);

                       }//if

                    }//shared
                });


    }

    @Override
    protected void onStart() {
        super.onStart();
        //initialize call to server
        new ApiManager().getRecentPhotos(mContext);


    }


}
