package com.vymo.vymoassignment;
import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class HttpGetRequest extends AsyncTask<String,Void ,String> {
    public static  final String REQUEST_METHOD="GET";
    public static  final int REQUEST_TIMEOUT=1500;
    public static  final int CONNECTION_TIMEOUT=1500;

    @Override
    protected String doInBackground(String... strings) {
        String strUrl=strings[0];
        String result;
        try{
            URL myUrl=new URL(strUrl);
            HttpsURLConnection connection=(HttpsURLConnection) myUrl.openConnection();
            connection.setRequestMethod(REQUEST_METHOD);
            connection.setReadTimeout(REQUEST_TIMEOUT);
            connection.setConnectTimeout(CONNECTION_TIMEOUT);

            connection.connect();
            InputStreamReader reader=new InputStreamReader(connection.getInputStream());
            BufferedReader bufferedReader=new BufferedReader(reader);
            StringBuilder stringBuilder=new StringBuilder();
            String inputline;
            while ((inputline=bufferedReader.readLine())!=null)
            {
                stringBuilder.append(inputline);
            }
            bufferedReader.close();
            reader.close();
            result=stringBuilder.toString();


        } catch (MalformedURLException e) {
            e.printStackTrace();
            result=null;
        } catch (IOException e) {
            e.printStackTrace();
            result=null;
        }
        return result;
    }
}
