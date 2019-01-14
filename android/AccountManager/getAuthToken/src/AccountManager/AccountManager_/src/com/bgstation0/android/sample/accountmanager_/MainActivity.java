package com.bgstation0.android.sample.accountmanager_;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{

	// �����o�t�B�[���h�̒�`.
	Context mContext = null;	// mContext��null�ŏ�����.
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
        // mContext�̏�����.
        mContext = this;	// mContext��this���Z�b�g.
        
        // button1�̎擾.
        Button button1 = (Button)findViewById(R.id.button1);	// button1���擾.
        button1.setOnClickListener(this);	// ���X�i�[��this���Z�b�g.
        
    }
    
    // �N���b�N���ꂽ��.
 	@Override
 	public void onClick(View v) {	// onClick�̒�`(�I�[�o�[���C�h)
 		// TODO Auto-generated method stub
 		AccountManager accountManager = AccountManager.get(this);	// accountManager�擾.
 		EditText edittext1 = (EditText)findViewById(R.id.edittext1);	// edittext1���擾.
 		Account target = new Account(edittext1.getText().toString(), "com.google");	// target�𐶐�.
 		accountManager.getAuthToken(target, "mail", null, this, new AccountManagerCallback<Bundle>(){

			@Override
			public void run(AccountManagerFuture<Bundle> future) {
				// TODO Auto-generated method stub
				try{
					Bundle bundle = future.getResult();	// bundle���擾.
					String token = bundle.getString(AccountManager.KEY_AUTHTOKEN);	// token���擾.
					Toast.makeText(mContext, "token = " + token, Toast.LENGTH_LONG).show();	// token��\��.
				}
				catch (Exception ex){
					Toast.makeText(mContext, "ex = " + ex.toString(), Toast.LENGTH_LONG).show();	// ex��\��.
				}
			}
		
 		}, null);	// �g�[�N���̎擾.
 	}
 	
}