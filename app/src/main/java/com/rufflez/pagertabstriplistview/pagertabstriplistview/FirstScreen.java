package com.rufflez.pagertabstriplistview.pagertabstriplistview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;



public class FirstScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_screen);
        setupMessageButton();

    }
    private void setupMessageButton() {
        //1. Get reference to button
        ImageButton messageButton = (ImageButton) findViewById(R.id.btn_start);

        //2. Set the click listener to run code.
        messageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("DemoButtonApp", "Clicked Begin");
                startActivity(new Intent(FirstScreen.this, MainActivity.class));
                finish();
            }
        });
    }

}
