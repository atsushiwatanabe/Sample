package com.bgstation0.android.sample.context_;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SubActivity extends Activity {

	// Activity���������ꂽ�Ƃ�.
	@Override
	protected void onCreate(Bundle savedInstanceState) {	// onCreate�̒�`
		super.onCreate(savedInstanceState);
			
		// "SubActivity!"�̕\��.
		TextView tv = new TextView(this);	// TextView�I�u�W�F�N�gtv�̐���.
		tv.setText("SubActivity!");	// tv.setText��"SubActivity!"�̃Z�b�g.
		setContentView(tv);	// setContentView��tv��\��.
		
		// Toast��this�̓��e�𕶎���ɂ������̂�\��.
		Toast.makeText(this, this.toString(), Toast.LENGTH_LONG).show();
		
	}
		
}