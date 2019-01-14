package com.bgstation0.android.sample.connectivitymanager_;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	// �����o�t�B�[���h�̒�`.
	Context mContext = null;	// mContext��null�ŏ�����.
		
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // mContext�̏�����.
        mContext = this;	// mContext��this���Z�b�g.
        
        // button1�̏�����.
        Button button1 = (Button)findViewById(R.id.button1);	// button1���擾.
        button1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// ConnectivityManager�̎擾.
				ConnectivityManager connectivityManager = (ConnectivityManager)mContext.getSystemService(CONNECTIVITY_SERVICE);	// connectivityManager�̎擾.
				// NetworkInfo�̎擾.
				NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();	// �A�N�e�B�u��networkInfo���擾.
				if (networkInfo == null){	// null�Ȃ�.
					Toast.makeText(mContext, "networkInfo == null!", Toast.LENGTH_LONG).show();	// "networkInfo == null!"�ƃg�[�X�g�\��.
				}
				else if (networkInfo.isConnected()){	// isConnected��true�Ȃ�.
					Toast.makeText(mContext, "Connected!", Toast.LENGTH_LONG).show();	// "Connected!"�ƃg�[�X�g�\��.
				}
				else{	// isConnected��false�Ȃ�.
					Toast.makeText(mContext, "Not Connected!", Toast.LENGTH_LONG).show();	// "Not Connected!"�ƃg�[�X�g�\��.
				}
			}
			
        });
        
    }
    
}