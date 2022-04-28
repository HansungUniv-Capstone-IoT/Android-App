package com.googlemap;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonParser {

    public  static  void jsonParser(String resultJson) {

        try {
            JSONObject jsonObject = new JSONObject(resultJson);
            JSONArray jsonArray = new JSONArray();
            JSONObject jsonObject2 = new JSONObject(resultJson);

            jsonArray = jsonObject.getJSONArray("items");
            for(int i=0; i<=jsonArray.length(); i++) {
                jsonObject2 = jsonArray.getJSONObject(i);

                String longitude = jsonObject2.getString("longitude");
                Log.d("JsonParsing","longitude :" + longitude);
            }

        }catch (JSONException e) {

        }
    }
}
