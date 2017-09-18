package com.albert.flickrrecents.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.albert.flickrrecents.utils.Constants.FLICKER_RECENT_PHOTOS_URL;
import static com.albert.flickrrecents.utils.Constants.IMAGE_JSON_SHARED_PREF_KEY;

/**
 * Created by albert on 9/17/17.
 */


public class ApiManager {

    private Context context;

    SharedPreferences sharedpreferences;
    SharedPreferences initsharedpreferences;
    private static String TAG = ApiManager.class.getSimpleName();

    public void getRecentPhotos(final Context context) {
        this.context = context;
        sharedpreferences = context.getSharedPreferences(IMAGE_JSON_SHARED_PREF_KEY, Context.MODE_PRIVATE);
        RequestQueue queue = Volley.newRequestQueue(context);

        Log.d(TAG, "FLICKER_RECENT_PHOTOS_URL: "+FLICKER_RECENT_PHOTOS_URL);

        JsonObjectRequest req = new JsonObjectRequest(FLICKER_RECENT_PHOTOS_URL, new JSONObject(),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                              Log.d("json from url: ", "" + response.toString(7));

                           SharedPreferences.Editor editor = sharedpreferences.edit();

                            JSONObject photos = (JSONObject) response.get("photos");

                            editor.putString("photo", "" + photos.getString("photo").toString());

                            editor.apply();

                        } catch (JSONException e) {
                            e.printStackTrace();

                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e("Error: ", error.getMessage());
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("Authorization", "OAuth oauth_consumer_key=\"0668e00bd0a8fe83bd7d6d67723c770b\",oauth_signature_method=\"HMAC-SHA1\",oauth_timestamp=\"1505606674\",oauth_nonce=\"KHbFQH\",oauth_version=\"1.0\",oauth_signature=\"8zKcHjAPyYfPCtDGu3BLrMaIlU4%3D\"");

                return params;
            }
        };

// add the request object to the queue to be executed
        queue.add(req);


    }




}

