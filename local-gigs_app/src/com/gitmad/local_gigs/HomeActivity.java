package com.gitmad.local_gigs;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HomeActivity extends Activity implements View.OnClickListener{


    Button button;
    EditText textBox;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_activity);

        button = (Button)findViewById(R.id.button);
        textBox = (EditText)findViewById(R.id.textBox);
        button.setOnClickListener(this);


        // Cool source control blah
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hello_world, menu);
		return true;
	}

    @Override
    public void onClick(View v)
    {
        //get text from text box, start activity
        String text = textBox.getText().toString();
        Intent i = new Intent(this, TextActivity.class);
        i.putExtra("My Text", text);
        startActivity(i);

    }
}
