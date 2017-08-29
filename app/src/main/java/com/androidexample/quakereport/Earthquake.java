package com.androidexample.quakereport;

// this is used to return the 3 text view displayed on list item
public class Earthquake {

    /** URL for earthquake data from the USGS dataset */
    //private static final String USGS_REQUEST_URL ="https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&orderby=time&minmag=6&limit=10";

    //private static final String USGS_REQUEST_URL ="https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&orderby=time&minmag=5&limit=10";
// eaach earthquake has these attributes
/// har eek row me kya dikhayi dega
  private double mMagnitude;
    private String mLocation;
    private long mTimeInMilliseconds;
    /// row par click to website par full detail ke liye
    private  String murl;

    //set the values of these
     Earthquake(double magnitude, String location,long timeinMilliseconds,String url) {
         mMagnitude = magnitude;
         mLocation = location;
         mTimeInMilliseconds=timeinMilliseconds;
    murl=url;
     }

    // return to display
    public double getMagnitude() {
        return mMagnitude;
    }
    public String getLocation() {
        return mLocation;
    }
    public long getTimeInMilliseconds() {return  mTimeInMilliseconds;}
    public String getUrl() {
        return murl;
    }
}

