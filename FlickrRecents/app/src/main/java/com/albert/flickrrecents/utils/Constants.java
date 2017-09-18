package com.albert.flickrrecents.utils;

import com.albert.flickrrecents.BuildConfig;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Created by albert on 9/17/17.
 */

public class Constants {

    ImageLoader mImageLoader;

    //shared preference for loose coupling and also makes app capable of offline mode
    public static String IMAGE_JSON_SHARED_PREF_KEY = "flickr_jsonkey";
    //api url for json calls : getting the url from BuildConfig for security on compile time
    public static String FLICKR_API_URL = BuildConfig.API_URL ;
    //method separated just in case of wanting a different menthod
    public static String FLICKR_API_METHOD="?method=flickr.photos.getrecent";//&api_key=3f807259749363aaa29c712fa93945&format=json&nojsoncallback=?";
    //api key for flickr is taken from gradle on compiletime for security just in case someone reverse engineer apk file
    public static String FLICKR_API_KEY = "&"+BuildConfig.FLICKR_API_KEY;
    //format of flicker photo: &format=json&nojsoncallback=?
    public static String FLICKR_FORMAT= "&format=json&nojsoncallback=?";
    // photo is constructed with current format : https://farm{farm-id}.staticflickr.com/{server-id}/{id}_{secret}.jpg
    public static String FLICKR_PHOTO_URL = "https://farm%s.staticflickr.com/%s/%s_%s.jpg";
    // constructed url for recent photos :
    public static String FLICKER_RECENT_PHOTOS_URL = FLICKR_API_URL+FLICKR_API_METHOD+FLICKR_API_KEY+FLICKR_FORMAT;

    //header builder
    public static String AUTH_HEADER = "";



}
