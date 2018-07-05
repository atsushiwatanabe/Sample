package com.bgstation0.android.sample.wv.wvt_;

import android.app.Activity;
import android.app.ActivityGroup;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;

public class MainActivity extends ActivityGroup {

	// �����o�t�B�[���h�̒�`.
	public LocalActivityManager mLAM = null;	// mLAM��null�ŏ�����.
	public Window mWindow1 = null;	// mWindow1��null�ŏ�����.
	public Window mWindow2 = null;	// mWindow2��null�ŏ�����.
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // LocalActivityManager�̎擾.
        mLAM = getLocalActivityManager();	// mLAM�̎擾.
        
        // SubActivity(1)�̍쐬.
        Intent intent1 = new Intent(this, SubActivity.class);	// intent1�̍쐬.
        intent1.putExtra("id", "tab1");	// "id"���L�[, "tab1"��l�Ƃ��ēo�^.
        intent1.putExtra("url", "file:///android_asset/test.html");	// "url"���L�[, "file:///android_asset/test.html"��l�Ƃ��ēo�^.
        mWindow1 = mLAM.startActivity("tab1", intent1);	// mWindow1���擾.
        // MainActivity��mWindow1��}��.
        FrameLayout fl = (FrameLayout)findViewById(R.id.frame_main);	// fl���擾.
        View decorView1 = mWindow1.getDecorView();	// decorView1�̎擾.
        fl.addView(decorView1);	// fl.addView��decorView1��ǉ�.
        
    }
    
    // ���j���[���쐬���ꂽ��.
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
    	
    	// ���j���[�̍쐬
    	getMenuInflater().inflate(R.menu.main, menu);	// getMenuInflater��MenuItem���擾��, ���̂܂�inflate�Ŏw�肳�ꂽR.menu.main������menu���쐬.
    	return true;	// true��Ԃ�.
    	
    }
    
    // ���j���[���I�����ꂽ��.
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
    
    	// �ǂ̃��j���[���I�����ꂽ��.
    	switch (item.getItemId()){	// �A�C�e��ID���ƂɐU�蕪��.
    	
    		// TextView1
    		case R.id.menu_textview1:
    			
    			// TextView1�u���b�N
				{
					
					// tab1��\��.
					FrameLayout mainContentView = (FrameLayout)findViewById(android.R.id.content);	// android.R.id.content���擾.
					mainContentView.removeAllViews();	// android.R.id.content��艺���폜.
					setContentView(R.layout.activity_main);	// �R���e���g�r���[�̃Z�b�g.
					FrameLayout fl = (FrameLayout)findViewById(R.id.frame_main);	// fl���擾.
					View decorView1 = mWindow1.getDecorView();	// decorView1���擾.
					ViewGroup parent = (ViewGroup)decorView1.getParent();	// �e�����邩�m�F.
					if (parent != null){	// parent��null�łȂ�.
						parent.removeAllViews();	// �S�č폜.
					}
					fl.addView(decorView1);	// decorView1��ǉ�.
					
				}
				
				break;
			
			// TextView1
    		case R.id.menu_textview2:
    			
    			// TextView2�u���b�N
				{
	
					// tab2��\��.
					FrameLayout mainContentView = (FrameLayout)findViewById(android.R.id.content);	// android.R.id.content���擾.
					mainContentView.removeAllViews();	// android.R.id.content��艺���폜.
					setContentView(R.layout.activity_main);	// �R���e���g�r���[�̃Z�b�g.
					FrameLayout fl = (FrameLayout)findViewById(R.id.frame_main);	// fl���擾.
					View decorView2 = mWindow2.getDecorView();	// decorView2���擾.
					ViewGroup parent = (ViewGroup)decorView2.getParent();	// �e�����邩�m�F.
					if (parent != null){	// parent��null�łȂ�.
						parent.removeAllViews();	// �S�č폜.
					}
					fl.addView(decorView2);	// decorView2��ǉ�.
			        
				}
				
				break;
				
    	}
    	return super.onOptionsItemSelected(item);	// �e�N���X���菈��
    	
    }
    
}