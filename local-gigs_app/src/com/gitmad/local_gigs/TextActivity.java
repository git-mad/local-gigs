package com.gitmad.local_gigs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date: 9/17/13
 * Time: 11:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class TextActivity extends Activity implements View.OnClickListener
{
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_activity);
        Intent intent = getIntent();
        String text = intent.getStringExtra("My Text");
        TextView textBox = (TextView)findViewById(R.id.displayBox);
        textBox.setText(text);

        Button button = (Button)findViewById(R.id.closebutton);
        button.setOnClickListener(this);
        //comment
    }

    @Override
    public void onClick(View v)
    {
        this.finish();
    }
}
