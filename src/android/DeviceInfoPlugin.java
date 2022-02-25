//package com.cordova.plugin;

package com.an.deviceinfo;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class DeviceInfoPlugin extends CordovaPlugin {
  
  private static final String TAG = "DeviceInfoPlugin";

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
          Log.d(TAG, "HelloWorld");
		  
	  callbackContext.success("HelloWorld");
		  
          } catch (Exception e) {
            callbackContext.error(e.getMessage());
          }
     	}
    	});
  	}
	
	  private void getBatteryPercent(final CallbackContext callbackContext) {      
      cordova.getThreadPool().execute(new Runnable() {
        public void run() {
          try {	
          Log.d(TAG, "getBatteryPercent");
		  
	  callbackContext.success(getBatteryPercent());
		  
          } catch (Exception e) {
            callbackContext.error(e.getMessage());
          }
     	}
    	});
  	}
	
  }
