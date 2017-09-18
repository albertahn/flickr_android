package com.albert.flickrrecents;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.albert.flickrrecents.adapters.FlickrImageAdapter;
import com.albert.flickrrecents.models.FlickrImageModel;
import com.albert.flickrrecents.utils.ApiManager;

import java.util.ArrayList;
import java.util.HashMap;

import static com.albert.flickrrecents.utils.Constants.IMAGE_JSON_SHARED_PREF_KEY;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private Context mContext;
    private Gson gson = new Gson();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this.getApplicationContext();

        sharedPreferences = getSharedPreferences(IMAGE_JSON_SHARED_PREF_KEY, Context.MODE_PRIVATE);

        HashMap<String, String> hsm = new HashMap<>();

        //initialize call to server
        new ApiManager().getRecentPhotos(hsm, this);

        //set listener for loose coupling
        sharedPreferences.registerOnSharedPreferenceChangeListener(
                new SharedPreferences.OnSharedPreferenceChangeListener() {
                    public void onSharedPreferenceChanged(
                            SharedPreferences prefs, String key) {

                        //if the image in shared pref change reset recylerview
                        if(key.equals("photo")){

                            String fJsonString = prefs.getString("photo", "empty");

                            FlickrImageModel flickrArray = gson.fromJson(fJsonString, FlickrImageModel.class);

                            RecyclerView rc1 = (RecyclerView) findViewById(R.id.rc3);
                            FlickrImageAdapter fAdapter = new FlickrImageAdapter();
                            rc1.setHasFixedSize(false);

                            LinearLayoutManager llm = new LinearLayoutManager(mContext);
                            llm.setOrientation(LinearLayoutManager.HORIZONTAL);
                            rc1.setLayoutManager(llm);
                            rc1.setAdapter(fAdapter);



                        }//if



                    }//shared
                });




    }
}
