package com.cordova.plugin;

import android.hardware.BatteryState;
import android.content.Context;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class BatteryInfoPlugin extends CordovaPlugin {
  
  private static final String TAG = "DeviceInfoPlugin";

  @Override
  public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
      if (action.equals("getCapacity")) {
      	this.getCapacity(callbackContext);
      	return true;   
      
      } else if (action.equals("getStatus")) {
        this.getStatus(callbackContext);	    
        return true;  

      } else {
        callbackContext.error("\"" + action + "\" is not a recognized action.");
        return false;

        }
    }
		    
  private void getCapacity(final CallbackContext callbackContext) {      
      cordova.getThreadPool().execute(new Runnable() {
        public void run() {
          try {	
          Log.d(TAG, "getCapacity");
		  
	  BatteryState state = (BatteryState) this.cordova.getActivity().getApplicationContext();
		  
	  callbackContext.success(state.getCapacity());
		  
          } catch (Exception e) {
            callbackContext.error(e.getMessage());
          }
     	}
    	});
  	}
	
   private void getStatus(final CallbackContext callbackContext) {      
      cordova.getThreadPool().execute(new Runnable() {
        public void run() {
          try {	
          Log.d(TAG, "getStatus");
	
	  BatteryState state = (BatteryState) this.cordova.getActivity().getApplicationContext();
		  
	  callbackContext.success(state.getStatus());
		  
          } catch (Exception e) {
            callbackContext.error(e.getMessage());
          }
     	}
    	});
  	}
	
  }
