package com.cordova.plugin.BatteryInfoPlugin;

import android.os.BatteryManager;
import android.content.IntentFilter;
import android.content.Intent;
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
      	this.getPercentage(callbackContext);
      	return true;   
      
      } else if (action.equals("getStatus")) {
        this.getStatus(callbackContext);	    
        return true;  

      } else {
        callbackContext.error("\"" + action + "\" is not a recognized action.");
        return false;

        }
    }
		    
  private void getPercentage(final CallbackContext callbackContext) {      
      cordova.getThreadPool().execute(new Runnable() {
        public void run() {
          try {	
          Log.d(TAG, "getPercentage");
		  
	  IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
	  Intent batteryStatus = cordova.getActivity().getApplicationContext().registerReceiver(null, ifilter);
	  int level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
	  int scale = batteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
	  float batteryPct = level / (float) scale;
		  
	  callbackContext.success(Math.round(batteryPct * 100));
		  
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
	
	  IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
    	  Intent batteryStatus = cordova.getActivity().getApplicationContext().registerReceiver(null, ifilter);

    	  int status = batteryStatus.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
    	  boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING || status == BatteryManager.BATTERY_STATUS_FULL;

    	  int chargePlug = batteryStatus.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
    	  boolean usbCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_USB;
    	  boolean acCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_AC;
    	  int level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
    	  int scale = batteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
    	  float batteryPct = (level / (float) scale) * 100;
		  
	  callbackContext.success(String.valueOf(batteryPct) + "% charging?: " + isCharging + " AC Charging?: " + acCharge + " USB Charging?: " + usbCharge);
		  
          } catch (Exception e) {
            callbackContext.error(e.getMessage());
          }
     	}
    	});
  	}
	
  }
