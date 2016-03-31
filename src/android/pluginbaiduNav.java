package org.lhhy;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.LOG;
import org.apache.cordova.PluginResult;

import org.apache.cordova.CordovaActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.net.Uri;
import android.text.Html;

/**
 * This class echoes a string called from JavaScript.
 */
public class pluginbaiduNav extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("coolMethod")) {
           // String message = args.getString(0);
            //this.coolMethod(message, callbackContext);
            //调起百度地图客户端
            try {
                String inputPar = "intent://map/direction?origin=latlng:34.264642646862,108.95108518068|name:我家&destination=大雁塔&mode=driving®ion=西安&referer=Autohome|GasStation#Intent;scheme=bdapp;package=com.baidu.BaiduMap;end";
                 Intent intent = Intent.getIntent(inputPar);
                     cordova.getActivity().startActivity(intent); //启动调用
                     // if(isInstallByread("com.baidu.BaiduMap")){
                     //     this.cordova.startActivity(intent); //启动调用
                     //     Log.e("GasStation", "百度地图客户端已经安装") ;
                     // }else{
                     //     Log.e("GasStation", "没有安装百度地图客户端") ;
                     // }
                 } catch (Exception e) {
                     e.printStackTrace();
            }
            return true;
        }
        return false;
    }

    private void coolMethod(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}
