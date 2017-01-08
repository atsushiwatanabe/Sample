package com.bgstation0.android.sample.resources_;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // colors.xml����F���擾����, Button�̔w�i�ɃZ�b�g.
        Resources res = getResources();	// getResources��res���擾.
        int red = res.getColor(R.color.red);	// res.getColor��R.color.red�̐F�����擾.
        Button button1 = (Button)findViewById(R.id.button1);	// button1���擾.
        button1.setBackgroundColor(red);	// setBackgroundColor��red���Z�b�g.
        int green = res.getColor(R.color.green);	// res.getColor��R.color.green�̐F�����擾.
        Button button2 = (Button)findViewById(R.id.button2);	// button2���擾.
        button2.setBackgroundColor(green);	// setBackgroundColor��green���Z�b�g.
        int blue = res.getColor(R.color.blue);	// res.getColor��R.color.blue�̐F�����擾.
        Button button3 = (Button)findViewById(R.id.button3);	// button3���擾.
        button3.setBackgroundColor(blue);	// setBackgroundColor��blue���Z�b�g.       
    }
}