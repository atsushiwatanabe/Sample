package com.bgstation0.android.sample.locationmanager_;

import android.app.Activity;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {

	// �����o�t�B�[���h�̒�`.
	LocationManager mLocationManager = null;	// mLocationManager��null�ŏ�����.
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // mLocationManager�̎擾.
        mLocationManager = (LocationManager)getSystemService(LOCATION_SERVICE);	// mLocationManager���擾.
        
        // �ʒu���̍X�V���N�G�X�g.
        mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 50, new LocationListener(){

			@Override
			public void onLocationChanged(Location location) {
				// TODO Auto-generated method stub
				// �ܓx.
				TextView textview1 = (TextView)findViewById(R.id.textview1);	// textview1���擾.
				textview1.setText("lat: " + String.valueOf(location.getLatitude()));	// textview1�ɃZ�b�g.
				// �o�x.
				TextView textview2 = (TextView)findViewById(R.id.textview2);	// textview2���擾.
				textview2.setText("long: " + String.valueOf(location.getLongitude()));	// textview2�ɃZ�b�g.
			}

			@Override
			public void onStatusChanged(String provider, int status,
					Bundle extras) {
				// TODO Auto-generated method stub
				// �X�e�[�^�X.
				TextView textview3 = (TextView)findViewById(R.id.textview3);	// textview3���擾.
				if (status == LocationProvider.AVAILABLE){
					textview3.setText("status: AVAILABLE");
				}
				else if (status == LocationProvider.OUT_OF_SERVICE){
					textview3.setText("status: OUT_OF_SERVICE");
				}
				else if (status == LocationProvider.TEMPORARILY_UNAVAILABLE){
					textview3.setText("status: TEMPORARILY_UNAVAILABLE");
				}
			}

			@Override
			public void onProviderEnabled(String provider) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onProviderDisabled(String provider) {
				// TODO Auto-generated method stub
				
			}
			
        });
        
    }
    
}