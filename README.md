# Flickr Android Persistent data and swipe demo
Android example for Flicker api getting recent photos. Works with offline mode and using recycler view and ImageLoader.
Must open app on wifi and scroll to get images first, then when offline the cached images persist.

 app
  |MainActivity.java : Activity for showing the layout and images swiping from right to left: uses SharedPref listener for loose-Coupling.
  | adapters/
        | FlickrImageAdapter.java : RecyclerView adaper uses Volley ImageLoader to cache images
  
  | models/
        | FlickrImageModel.Java : Model for gson json data parsing to arraylist after getting api data

  | utils/
        | ApiManager.java : gets the api calls for photos using Volley
        |Constants.Java : stores the constants and URLs, and gets sensitive data from Gradle like api keys.
        |VolleyControl : gets Volley instance for image Loader 
        