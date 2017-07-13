package com.bgstation0.android.sample.urlutil_;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener{	// View.OnClickListener������.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // checkbutton���擾��, OnClickListener�Ƃ��Ď��g���Z�b�g.
        Button checkButton = (Button)findViewById(R.id.checkbutton);	// checkButton���擾.
        checkButton.setOnClickListener(this);	// checkButton.setOnClickListener��this���Z�b�g.
    }
    
    // View.OnClickListener�C���^�t�F�[�X�̃I�[�o�[���C�h���\�b�h������.
    public void onClick(View v){	// onClick���I�[�o�[���C�h.
    	
    	// �{�^����id�����Ƃɏ�����U�蕪����.
    	switch (v.getId()) {	// v.getId��View(Button)��id���擾.
    		
    		case R.id.checkbutton:	// R.id.checkbutton�̎�.
    			
    			// checkButton�u���b�N
				{
					
					// urlBar��url���擾.
    				EditText urlBar = (EditText)findViewById(R.id.urlbar);	// urlBar���擾.
    				String url = urlBar.getText().toString();	// urlBar.getText().toString()��url���擾.
    				
    				// url���L����URL���ǂ����`�F�b�N.
    				if (URLUtil.isValidUrl(url)){	// �L����URL�Ȃ�.
    					// checkedittext��"true"�Z�b�g.
    					EditText checkedittext = (EditText)findViewById(R.id.checkedittext);	// checkedittext���擾.
    					checkedittext.setText("true");	// checkedittext��"true"���Z�b�g.
    				}
    				else{
    					// checkedittext��"false"�Z�b�g.
    					EditText checkedittext = (EditText)findViewById(R.id.checkedittext);	// checkedittext���擾.
    					checkedittext.setText("false");	// checkedittext��"false"���Z�b�g.
    				}
    				
    				// ������.
    				break;	// break�Ŕ�����.
    				
				}
				
    	}
    	
    }
    
}