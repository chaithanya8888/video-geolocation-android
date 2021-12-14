
package com.reactlibrary;

import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.WritableMap;

public class RNVideoGeolocationAndroidModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNVideoGeolocationAndroidModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @ReactMethod
  public void VideoLocation(String filePath, Promise promise){
    try {
      MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
      mediaMetadataRetriever.setDataSource(filePath);
      String location = mediaMetadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_LOCATION);
      LocationCoords locationCoords = getLocationFromISO6709(location);
      WritableMap writableMap = Arguments.createMap();
      writableMap.putDouble("latitude", locationCoords.latitude);
      writableMap.putDouble("longitude", locationCoords.longitude);
      promise.resolve(writableMap);
    }catch (Exception e){
      promise.reject(e);
    }
  }

  class LocationCoords {
    Double latitude = 0d;
    Double longitude = 0d;
  }

  private LocationCoords getLocationFromISO6709(String location) {
    LocationCoords locationCoords = new LocationCoords();
    try {
      if (location != null) {
        String latSign = location.substring(0, 1).equals("+") ? "+" : "-";
        String longSign = location.substring(1).indexOf("+") >= 0 ? "+" : "-";
        String[] locationParts = location.substring(1).split(longSign.equals("+") ? "\\+" : "\\-");

        if (locationParts.length > 1) {
          locationCoords.latitude = Double.parseDouble(latSign + locationParts[0]);
          locationCoords.longitude = Double.parseDouble(longSign + locationParts[1].replace("/", ""));
        }
      }
    }catch (Exception e){
      Log.d("CONV_LOC_ERR", e.toString());
    }
    return locationCoords;
  }

  @Override
  public String getName() {
    return "RNVideoGeolocationAndroid";
  }
}