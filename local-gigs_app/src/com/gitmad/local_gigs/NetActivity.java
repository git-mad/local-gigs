package com.gitmad.local_gigs;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
<<<<<<< HEAD
=======
import java.util.ArrayList;
>>>>>>> origin/artists-list

public class NetActivity  extends Activity implements  View.OnClickListener {
    private Button get_button, post_button;
    private TextView result_path, result_value;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.net_activity);

        get_button = (Button)findViewById(R.id.get_button);
        post_button = (Button)findViewById(R.id.post_button);
        get_button.setOnClickListener(this);
        post_button.setOnClickListener(this);
<<<<<<< HEAD
        result_path = (TextView)findViewById(R.id.path);
        result_value = (TextView)findViewById(R.id.value);
=======
        result_path = (TextView)findViewById(R.id.result_path);
        result_value = (TextView)findViewById(R.id.result_value);
>>>>>>> origin/artists-list


    }


    @Override
    public void onClick(View v)
    {
        //decide whether to GET or POST based on button pressed
        String method = (v.getId() == R.id.get_button)?"GET":"POST";
        //get the values from the text fields
<<<<<<< HEAD
        EditText path_field = (EditText)findViewById(R.id.enter_path);
        String path = path_field.getText().toString();
        EditText value_field = (EditText)findViewById(R.id.enter_value);
=======
        EditText path_field = (EditText)findViewById(R.id.path_field);
        String path = path_field.getText().toString();
        EditText value_field = (EditText)findViewById(R.id.value_field);
>>>>>>> origin/artists-list
        String value = value_field.getText().toString();
        //initiate and execute a task
        NetworkTask task = new NetworkTask();
        task.execute(method, path, value);

        //set the result field
        result_path.setText(path);
        result_value.setText("...connecting...");
    }

    private class NetworkTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            try {
<<<<<<< HEAD
                if (params[0].compareTo("GET") == 0){
                    String result = new NetInterfacer().getPath(params[1]);
                    Log.i("Netactivity",result);
                    return result;
                } else {
                    if (new NetInterfacer().setPath(params[1], params[2])){
                        return "Value successfully set. press GET";
                    }
                    return "Error setting value. Try again.";
                }
            } catch (IOException e) {
                Log.e("NetworkActivity", "Failed to GET URL", e);
=======
                if (params[0].compareTo("GET") == 0) {
                    String result = NetInterfacer.getPath(params[1]);
                    return result;
                } else {
                    if (NetInterfacer.setPath(params[1], params[2])) {
                       return "Value successfully set, press GET";
                    }
                    return "Error setting value, Try again.";
                }
            } catch (IOException e) {
>>>>>>> origin/artists-list
                return "ERROR";
            }
        }

        @Override
        protected void onPostExecute(String result){
            result_value.setText(result);
        }
    }
}