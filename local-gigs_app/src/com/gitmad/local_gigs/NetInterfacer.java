package com.gitmad.local_gigs;

<<<<<<< HEAD
import android.util.Log;

=======
import com.google.gson.Gson;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
>>>>>>> origin/artists-list
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
<<<<<<< HEAD
import java.net.HttpURLConnection;
import java.net.URL;
=======
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
>>>>>>> origin/artists-list

/**
 * Created by thedekel on 10/21/13.
 */
public class NetInterfacer {
<<<<<<< HEAD
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
=======
    public static String getPath(String path) {
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
       } catch (MalformedURLException e) {
           e.printStackTrace();
           return null;
       } catch (IOException e) {
           e.printStackTrace();
           return null;
       }
>>>>>>> origin/artists-list
    }

    public static Boolean setPath(String path, String value) throws IOException {
        try {
            URL url = new URL("http://local-gigs-server.herokuapp.com" + path);
<<<<<<< HEAD
=======

>>>>>>> origin/artists-list
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();

            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.connect();
<<<<<<< HEAD
=======

>>>>>>> origin/artists-list
            DataOutputStream out = new DataOutputStream(conn.getOutputStream());
            out.writeBytes(value);
            out.flush();
            out.close();
            DataInputStream in = new DataInputStream(conn.getInputStream());
            in.close();

            return true;
<<<<<<< HEAD
        } catch (IOException e){
            Log.e("NetworkInterfacer", "Failed to POST data", e);
            return false;
        }
    }
=======
        } catch (IOException e) {
            return false;
        }

    }

    public static ArrayList<String> findArtist(String query){
        try {
           String url_str = "http://ws.audioscrobbler.com/2.0/?method=artist.search&artist="
                   +query+"&api_key=9263072adfc72420902eba3a5e3c938f&format=json";
           URL url = new URL(url_str);
           HttpURLConnection conn = (HttpURLConnection)url.openConnection();
           InputStream in = conn.getInputStream();
           if (conn.getResponseCode() != HttpURLConnection.HTTP_OK){
               return null;
           }
           InputStreamReader isr = new InputStreamReader(in);
           BufferedReader br = new BufferedReader(isr);
           String out = "";
           String outLine;
           while ((outLine = br.readLine()) != null) {
               out += outLine;
           }
           Reader string_reader = new StringReader(out);
           Gson gson = new Gson();
           APIResponse resp = gson.fromJson(string_reader, APIResponse.class);
           ArrayList<String> result = new ArrayList<String>(resp.results.artistmatches.artists.size());
           int i = 0;
           for (Artist ar: resp.results.artistmatches.artists) {
               result.set(i, ar.name);
               i++;
           }
           return result;
        } catch (MalformedURLException e) {
           e.printStackTrace();
           return new ArrayList<String>();
        } catch (IOException e) {
           e.printStackTrace();
           return new ArrayList<String>();
        }
    }
/*
    public static List<Event> findEvent(){

    }*/
>>>>>>> origin/artists-list
}
