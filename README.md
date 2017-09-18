# Flickr Android Persistent data and swipe demo
Android example for Flicker api getting recent photos. Works with offline mode and using recycler view and ImageLoader.
Must open app on wifi and scroll to get images first, then when offline the cached images persist.

 app componets:<br />
  - MainActivity.java : Activity for showing the layout and images swiping from right to left: uses SharedPref listener for loose-Coupling.<br /><br />
   adapters/<br />
        -  FlickrImageAdapter.java : RecyclerView adaper uses Volley ImageLoader to cache images<br /><br />
  
   models/<br />
        -  FlickrImageModel.Java : Model for gson json data parsing to arraylist after getting api data<br /><br />

   utils/<br />
        - ApiManager.java : gets the api calls for photos using Volley<br />
        - Constants.Java : stores the constants and URLs, and gets sensitive data from Gradle like api keys.<br />
        - VolleyControl : gets Volley instance for image Loader <br />
        