package com.cordova.plugin;

import com.an.deviceinfo;

import android.util.Log;

public class MyStuff extends CordovaPlugin {
  
  private static final String TAG = "MyStuff";

  @Override
  public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
      if (action.equals("HelloWorld")) {
      	this.HelloWorld(callbackContext);
      	return true;   
      
      } else if (action.equals("getBatteryPercent")) {
        this.getBatteryPercent(callbackContext);	    
        return true;  

      } else {
        callbackContext.error("\"" + action + "\" is not a recognized action.");
        return false;

        }
    }
		    
  private void HelloWorld(final CallbackContext callbackContext) {      
      cordova.getThreadPool().execute(new Runnable() {
        public void run() {
          try {	
          String TAG = "MyStuff";
          Log.d(TAG, "HelloWorld");
		  
		      callbackContext.success("HelloWorld");
		  
          } catch (Exception e) {
            callbackContext.error(e.getMessage());
          }
     	}
    	});
  	}
  }

  private void getBatteryPercent(final CallbackContext callbackContext) {      
      cordova.getThreadPool().execute(new Runnable() {
        public void run() {
          try {	
          String TAG = "MyStuff";
          Log.d(TAG, "getBatteryPercent");
            
          int batteryPercentage = getBatteryPercent();
		  
		      callbackContext.success(batteryPercentage);
		  
          } catch (Exception e) {
            callbackContext.error(e.getMessage());
          }
     	}
    	});
  	}
  }
