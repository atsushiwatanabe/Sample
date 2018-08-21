package com.bgstation0.android.sample.view_;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ScrollView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // 10�b��ɉ��ɃX�N���[��.
        final ScrollView scrollView = (ScrollView)findViewById(R.id.scrollview);	// scrollView���擾.
        new Thread(new Runnable(){	// THread�𐶐���, ��������Runnable��n��.
        	public void run(){	// run�̒�`.
        		// 10�b�҂�.
        		try{
        			Thread.sleep(10000);	// Thread.sleep��10�b�x�~.
        			scrollView.post(new Runnable(){	// sclollView.post�Ńn���h����post.
        				public void run(){	// run�̒�`.
        					scrollView.scrollTo(0, scrollView.getBottom());	// scrollView.scrollTo�ŉ��ɃX�N���[��.
        				}
        			});
        		}
        		catch(Exception ex){
        			Log.d("View", "ex = " + ex.toString());
        		}
        	}
        }).start();	// �X���b�h�J�n.
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
    	
    		// Up
    		case R.id.menu_scrollup:
    			
    			// Up�u���b�N
				{
					
					// ��ɃX�N���[��.
					ScrollView scrollView = (ScrollView)findViewById(R.id.scrollview);	// scrollView���擾.
					scrollView.scrollTo(0, scrollView.getTop());	// scrollView.scrollTo�ŏ�ɃX�N���[��.
					
				}
				
				break;
				
    		case R.id.menu_scrolldown:
    			
    			// Down�u���b�N
				{
					
					// ���ɃX�N���[��.
					ScrollView scrollView = (ScrollView)findViewById(R.id.scrollview);	// scrollView���擾.
					scrollView.scrollTo(0, scrollView.getBottom());	// scrollView.scrollTo�ŉ��ɃX�N���[��.
				
				}
			
				break;
    
    	}
    	return super.onOptionsItemSelected(item);	// �e�N���X���菈��
    	
    }
    
}