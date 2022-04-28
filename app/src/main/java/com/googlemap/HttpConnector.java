package com.googlemap;

import static java.net.HttpURLConnection.HTTP_OK;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConnector extends Thread{
    @Override
    public void run() {
        try {
            URL url = new URL("https://907epdyfgc.execute-api.ap-northeast-2.amazonaws.com/prod/trash"); //URL 선언
            HttpURLConnection conn = (HttpURLConnection)url.openConnection(); //선언한 URL 연결

            if(conn != null) {
                conn.setConnectTimeout(10000); // 연결이 안되면 접속을 끊음
                conn.setRequestMethod("GET"); // GET방식으로 데이터 호출

                int resCode = conn.getResponseCode();
                int Http_OK = HTTP_OK;

                Log.d("JsonParsing","resCode : " + resCode);
                Log.d("JsonParsing","HTTP_OK : " + HTTP_OK);

                if (resCode == HttpURLConnection.HTTP_OK) {  //버퍼에 데이터 담기
                    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    String line = null;
                    while(true) {
                           line = reader.readLine();

                           Log.d("JsonParsing", "Line : " +line); //Json데이터 출력

                           if (line == null) {
                               break;
                           }
                           JsonParser.jsonParser(line);
                    }
                    reader.close();
                }
                conn.disconnect();
            }
        }catch (Exception e) {
        }
    }
}
