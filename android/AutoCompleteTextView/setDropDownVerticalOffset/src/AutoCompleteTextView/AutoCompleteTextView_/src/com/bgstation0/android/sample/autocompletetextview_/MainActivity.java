package com.bgstation0.android.sample.autocompletetextview_;

import android.app.Activity;
import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.Context;
import android.os.Bundle;
import android.provider.SearchRecentSuggestions;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	// �����o�t�B�[���h�̒�`.
	Context mContext = null;	// mContext��null���Z�b�g.
	CustomCursorAdapter mAdapter = null;	// mAdapter��null���Z�b�g.
	SearchRecentSuggestions mSuggestions = null;	// mSuggestions��null���Z�b�g.
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // �R���e�L�X�g�̃Z�b�g.
        mContext = this;	// mContext��this���Z�b�g.
        
        // �G�f�B�b�g�e�L�X�g�̎擾.
        final EditText editText = (EditText)findViewById(R.id.edittext);	// editText�̎擾.
        
        // �I�[�g�R���v���[�g�e�L�X�g�r���[�̎擾.
        final AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView)findViewById(R.id.autocompletetextview);	// autoCompleteTextView�̎擾.

        // �{�^���̎擾.
        final Button button = (Button)findViewById(R.id.button);	// button�̎擾.
        
        // SearchManager�̎擾.
        SearchManager searchManager = (SearchManager)getSystemService(Context.SEARCH_SERVICE);	// searchManager�̎擾.
        
        // SearchableInfo�̎擾.
        SearchableInfo searchableInfo = (SearchableInfo)searchManager.getSearchableInfo(getComponentName());	// searchableInfo�̎擾.

        // SearchableInfo����臒l���擾.
        int threshold = searchableInfo.getSuggestThreshold();	// threshold���擾.
        //Toast.makeText(mContext, "searchableInfo threshold = " + String.valueOf(threshold), Toast.LENGTH_LONG).show();	// threshold��\��.
        
        // �I�[�g�R���v���[�g�̃T�W�F�X�g臒l���擾.
        //int threshold = autoCompleteTextView.getThreshold();	// threshold���擾.
        //Toast.makeText(mContext, "autoCompleteTextView threshold = " + String.valueOf(threshold), Toast.LENGTH_LONG).show();	// threshold��\��.
        
        // �I�[�g�R���v���[�g�̃T�W�F�X�g臒l��ݒ�.
        autoCompleteTextView.setThreshold(threshold);	// 臒l��threshold���Z�b�g.

        // �T�W�F�X�g�̕\���ʒu�𒲐�.
        autoCompleteTextView.setDropDownVerticalOffset(50);	// 50���炢���ɉ�����.(�P�ʂ�dp�Ȃ̂��͕s��.)
        
        // ���͂��Ȃ��Ă�, �T�W�F�X�g��\������悤�ɂ���.
        autoCompleteTextView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
			
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				// TODO Auto-generated method stub
				
				// �t�H�[�J�X����ꂽ��\��.
				if (hasFocus){	// hasFocus��true.
					autoCompleteTextView.showDropDown();	// autoCompleteTextView.showDropDown�ŃT�W�F�X�g�\��.
				}
				
			}
			
		});
        
        // CustomCursorAdapter�̃Z�b�g.
        mAdapter = new CustomCursorAdapter(this, true, searchableInfo);	// mAdapter�̐���.
        autoCompleteTextView.setAdapter(mAdapter);	// autoCompleteTextView�ɃZ�b�g.
    
        // SearchRecentSuggestions�̐���.
        mSuggestions = new SearchRecentSuggestions(mContext, CustomContentProvider.AUTHORITY, CustomContentProvider.MODE);	// SearchRecentSuggestions�I�u�W�F�N�gmSuggestions�̐���.
        
        // ���X�i�[�̃Z�b�g.
        button.setOnClickListener(new View.OnClickListener() {	// setOnClickListener�ŃZ�b�g.
			
			@Override
			public void onClick(View v) {
				
				// TODO Auto-generated method stub
				// �N�G���̕ۑ�.
				String line1 = editText.getText().toString();	// line1�̎擾.
				String line2 = autoCompleteTextView.getText().toString();	// line2�̎擾.
				mSuggestions.saveRecentQuery(line1, line2);	// line1, line2���Ƃ��ɓo�^.
				
			}
			
		});
        
    }
    
    // Activity���j�����ꂽ�Ƃ�.
    protected void onDestroy() {	// onDestroy�̒�`
    	
    	// �e�N���X�̏���
    	super.onDestroy();	// super.onDestroy�Őe�N���X�̊��菈��.
    	
    	// �A�_�v�^�����.
    	mAdapter.close();	// mAdapter.close�ŕ���.
    	
    }
    
}