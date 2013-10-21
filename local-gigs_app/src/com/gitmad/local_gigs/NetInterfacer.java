package com.gitmad.local_gigs;

import android.util.Log;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by thedekel on 10/21/13.
 */
public class NetInterfacer {
    public static String getPath(String path) throws IOException {
        try {
            URL url = new URL("http://local-gigs-server.herokuapp.com" + path);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            InputStream in = conn.getInputStream();
            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK){
                return null;
            }
            byte[] buffer = new byte[1024];
            in.read(buffer);
            String out = new String(buffer);
            return out;
        } catch (IOException e){
            return null;
        }
    }

    public static Boolean setPath(String path, String value) throws IOException {
        try {
            URL url = new URL("http://local-gigs-server.herokuapp.com" + path);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();

            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.connect();
            DataOutputStream out = new DataOutputStream(conn.getOutputStream());
            out.writeBytes(value);
            out.flush();
            out.close();
            DataInputStream in = new DataInputStream(conn.getInputStream());
            in.close();

            return true;
        } catch (IOException e){
            Log.e("NetworkInterfacer", "Failed to POST data", e);
            return false;
        }
    }
}
