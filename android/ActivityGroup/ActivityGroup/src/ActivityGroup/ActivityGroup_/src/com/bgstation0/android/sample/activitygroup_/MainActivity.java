package com.bgstation0.android.sample.activitygroup_;

import android.app.Activity;
import android.app.ActivityGroup;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends ActivityGroup {

	// �����o�t�B�[���h�̒�`.
	LocalActivityManager lam = null;
	FrameLayout fl = null;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // LocalActivityManager�̎擾.
        lam = getLocalActivityManager();	// lam�̎擾.
        
        // FrameLayout�̎擾.
        fl = (FrameLayout)findViewById(R.id.frame_main);	// fl�̎擾.
        
        // SubActivity��Intent�쐬.
        Intent intent1 = new Intent(this, SubActivity.class);	// intent1�쐬.
        // Window�̎擾.
        Window window1 = lam.startActivity("test1", intent1);	// intent1��n����, window1�̎擾.
        // View�̎擾.
        View view1 = window1.getDecorView();	// view1���擾.
        // TextView�Ƀe�L�X�g���Z�b�g.
        TextView tv1 = (TextView)view1.findViewById(R.id.textview1);	// tv1���擾.
        tv1.setText("TV1");	// "TV1"���Z�b�g.
        // View�̒ǉ�.
        fl.addView(view1);	// fl.addView��fl��view1��ǉ�.
        
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
					
					// fl�̃r���[���폜.
					fl.removeAllViews();	// fl.removeAllViews�Ńr���[�̑S�폜.
					// SubActivity��Intent�쐬.
			        Intent intent1 = new Intent(this, SubActivity.class);	// intent1�쐬.
			        // Window�̎擾.
			        Window window1 = lam.startActivity("test1", intent1);	// intent1��n����, window1�̎擾.
			        // View�̎擾.
			        View view1 = window1.getDecorView();	// view1���擾.
			        // TextView�Ƀe�L�X�g���Z�b�g.
			        TextView tv1 = (TextView)view1.findViewById(R.id.textview1);	// tv1���擾.
			        tv1.setText("TV1");	// "TV1"���Z�b�g.
			        // View�̒ǉ�.
			        fl.addView(view1);	// fl.addView��fl��view1��ǉ�.
			        
				}
				
				break;
			
			// TextView1
    		case R.id.menu_textview2:
    			
    			// TextView2�u���b�N
				{
	
					// fl�̃r���[���폜.
					fl.removeAllViews();	// fl.removeAllViews�Ńr���[�̑S�폜.
					// SubActivity��Intent�쐬.
			        Intent intent2 = new Intent(this, SubActivity.class);	// intent2�쐬.
			        // Window�̎擾.
			        Window window2 = lam.startActivity("test2", intent2);	// intent2��n����, window2�̎擾.
			        // View�̎擾.
			        View view2 = window2.getDecorView();	// view2���擾.
			        // TextView�Ƀe�L�X�g���Z�b�g.
			        TextView tv2 = (TextView)view2.findViewById(R.id.textview1);	// tv2���擾.
			        tv2.setText("TV2");	// "TV2"���Z�b�g.
			        // View�̒ǉ�.
			        fl.addView(view2);	// fl.addView��fl��view2��ǉ�.
					
				}
				
				break;
				
    	}
    	return super.onOptionsItemSelected(item);	// �e�N���X���菈��
    	
    }
    
}