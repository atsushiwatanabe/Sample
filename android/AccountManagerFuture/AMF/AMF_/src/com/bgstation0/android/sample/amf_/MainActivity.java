package com.bgstation0.android.sample.amf_;

import java.util.ArrayList;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity implements AccountManagerCallback{

	// メンバフィールドの定義.
	Context mContext = null;	// mContextをnullで初期化.
	ArrayList<ListItem> mList = null;	// mListをnullで初期化.
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // コンテキストのセット.
        mContext = this;	// thisをセット.
        
        // AccountManagerオブジェクトを取得して, それを表示.
        AccountManager accountManager = AccountManager.get(this);	// accountManagerに格納.
        // アカウントリストの取得.
        mList = new ArrayList<ListItem>();	// mListを生成.
        //Account[] accounts = accountManager.getAccounts();	// accountManager.getAccountsでaccountsを取得.
        /*
        Account[] accounts = accountManager.getAccountsByType("com.google");	// accountManager.getAccountsByTypeでtypeが"com.google"なaccountsを取得.
        for (Account account : accounts){	// accountsからaccountを取り出すのを要素分繰り返す.
        	ListItem item = new ListItem();	// itemを生成.
        	item.name = account.name;	// item.nameにaccount.nameをセット.
        	item.type = account.type;	// item.typeにaccount.typeをセット.
        	list.add(item);	// list.addでitemを追加.
        }*/
        accountManager.getAccountsByTypeAndFeatures("com.google", new String[]{"service_mail"}, this, null);	// コールバックにthisをセット.
        
        /*
        // listView1の取得.
        ListView listView1 = (ListView)findViewById(R.id.listview1);	// listView1を取得.
        
        // ListItemAdapterの生成.
        ListItem[] array = new ListItem[list.size()];	// arrayを生成.
        ListItemAdapter listItemAdapter = new ListItemAdapter(this, R.layout.list_item, list.toArray(array));	// arrayAdapterを生成.
        listView1.setAdapter(listItemAdapter);	// listItemAdapterをセット.
        */
        
    }
    
    @Override
	public void run(AccountManagerFuture future) {
		// TODO Auto-generated method stub
		try{
			//Toast.makeText(mContext, "AccountManagerCallback.run", Toast.LENGTH_LONG).show();
			Account[] accounts = (Account[])future.getResult();	// accountsの取得.
			for (Account account : accounts){	// accountsからaccountを取り出すのを要素分繰り返す.
	        	ListItem item = new ListItem();	// itemを生成.
	        	item.name = account.name;	// item.nameにaccount.nameをセット.
	        	item.type = account.type;	// item.typeにaccount.typeをセット.
	        	mList.add(item);	// list.addでitemを追加.
	        }
			// listView1の取得.
	        ListView listView1 = (ListView)findViewById(R.id.listview1);	// listView1を取得.
	        // ListItemAdapterの生成.
	        ListItem[] array = new ListItem[mList.size()];	// arrayを生成.
	        ListItemAdapter listItemAdapter = new ListItemAdapter(this, R.layout.list_item, mList.toArray(array));	// arrayAdapterを生成.
	        listView1.setAdapter(listItemAdapter);	// listItemAdapterをセット.
		}
		catch (Exception ex){
			Toast.makeText(mContext, "ex = " + ex.toString(), Toast.LENGTH_LONG).show();
		}
	}
    
}