package com.bgstation0.android.sample.accountmanager_;

import java.util.ArrayList;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // AccountManager�I�u�W�F�N�g���擾����, �����\��.
        AccountManager accountManager = AccountManager.get(this);	// accountManager�Ɋi�[.
        
        // �A�J�E���g���X�g�̎擾.
        ArrayList<ListItem> list = new ArrayList<ListItem>();	// list�𐶐�.
        Account[] accounts = accountManager.getAccounts();	// accountManager.getAccounts��accounts���擾.
        for (Account account : accounts){	// accounts����account�����o���̂�v�f���J��Ԃ�.
        	ListItem item = new ListItem();	// item�𐶐�.
        	item.name = account.name;	// item.name��account.name���Z�b�g.
        	list.add(item);	// list.add��item��ǉ�.
        }
        
        // listView1�̎擾.
        ListView listView1 = (ListView)findViewById(R.id.listview1);	// listView1���擾.
        
        // ListItemAdapter�̐���.
        ListItem[] array = new ListItem[list.size()];	// array�𐶐�.
        ListItemAdapter listItemAdapter = new ListItemAdapter(this, R.layout.list_item, list.toArray(array));	// arrayAdapter�𐶐�.
        listView1.setAdapter(listItemAdapter);	// listItemAdapter���Z�b�g.
        
    }
    
}