package com.bgstation0.android.sample.devicepolicymanager_;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
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
	DevicePolicyManager mDevicePolicyManager = null;	// mDevicePolicyManager��null�ŏ�����.
	ComponentName mComponentName = null;	// mComponentName��null�ŏ�����.
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // mContext�̏�����.
        mContext = this;	// mContext��this���Z�b�g.
        
        // mDevicePolicyManager�̎擾.
        mDevicePolicyManager = (DevicePolicyManager)getSystemService(DEVICE_POLICY_SERVICE);	// mDevicePolicyManager���擾.
        
        // mComponentName�̏�����.
        mComponentName = new ComponentName(this, Admin.class);	// mComponentName�𐶐�.
        
        // button1�̏�����.
        Button button1 = (Button)findViewById(R.id.button1);	// button1���擾.
        button1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (v.getId() == R.id.button1){
				
					// �Ǘ��Ҍ������ǂ���.
					if (mDevicePolicyManager.isAdminActive(mComponentName)){
						// �[����ʂ����b�N.
						mDevicePolicyManager.lockNow();	// mDevicePolicyManager.lockNow�Ń��b�N.
					}
					else{
						// �Ǘ��Ҍ����擾�C���e���g.
						Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);	// intent�쐬.
						intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, mComponentName);	// mComponentName��n��.
						intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION,  "Lock OK?");	// "Lock OK?".
						((MainActivity)mContext).startActivityForResult(intent, 1);	// intent���N��.
					}
					
				}
			}
			
        });

    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
    	
    	// �����ꂽ���ǂ���.
    	if (requestCode == 1){	// 1�̎�.
    		if (resultCode == RESULT_OK){	// OK
    			Toast.makeText(mContext, "Admin OK", Toast.LENGTH_LONG).show();	// "OK".
    		}
    		else{
    			Toast.makeText(mContext, "Admin NG", Toast.LENGTH_LONG).show();	// "NG".
    		}
    	}
    	
    }
    
}