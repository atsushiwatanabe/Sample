package com.bgstation0.android.sample.activity_;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{	// View.OnClickListenerを実装.

	// タグの定義
	private final String TAG = "MainActivity";	// TAGは"MainActivity"
	private final int DIALOG_ID_1 = 1;	// DIALOG_ID_1を1にする.
	private final int DIALOG_ID_2 = 2;	// DIALOG_ID_2を2にする.
    private int count1 = 0;	// button1が押された回数count1を0で初期化.
    private int count2 = 0;	// button2が押された回数count2を0で初期化.
    
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // button1を取得し, OnClickListenerとして自身をセット.
        Button button1 = (Button)findViewById(R.id.button1);	// findViewByIdでR.id.button1を取得.
        button1.setOnClickListener(this);	// button1.setOnClickListenerでthis(自身)をセット.
        
        // button2を利用し, OnClickListenerとして自身をセット.
        Button button2 = (Button)findViewById(R.id.button2);	// findViewByIdでR.id.button2を取得.
        button2.setOnClickListener(this);	// button2.setOnClickListenerでthis(自身)をセット.
        
    }
	
	// View.OnClickListenerインタフェースのオーバーライドメソッドを実装.
    public void onClick(View v){	// onClickをオーバーライド.
    
    	// ボタンのIDごとに分ける.
    	if (v.getId() == R.id.button1){ // button1

    		// DIALOG_ID_1の表示.
    		Bundle args = new Bundle();	// argsの生成.
    		//args.putString("title", "dialog1");	// "title"を"dialog1"にセット.
    		//args.putString("message", "button1 clicked!");	// "message"を"button1 clicked!"にセット.
    		args.putInt("count1", count1);	// count1を登録.
    		count1++;	// count1をインクリメント.
    		showDialog(DIALOG_ID_1, args);	// showDialogでDIALOG_ID_1のダイアログ表示.(argsを渡す.)
    		//showDialog(DIALOG_ID_1);	// showDialogでDIALOG_ID_1のみ渡す.
    		
    	}
    	else if (v.getId() == R.id.button2){ // button2
    		
    		// DIALOG_ID_2の表示.
    		Bundle args = new Bundle();	// argsの生成.
    		//args.putString("title", "dialog2");	// "title"を"dialog2"にセット.
    		//args.putString("message", "button2 clicked!");	// "message"を"button2 clicked!"にセット.
    		args.putInt("count2", count2);	// count2を登録.
    		count2++;	// count2をインクリメント.
    		showDialog(DIALOG_ID_2, args);	// showDialogでDIALOG_ID_2のダイアログ表示.(argsを渡す.)
    		//showDialog(DIALOG_ID_2);	// showDialogでDIALOG_ID_2のみ渡す.
    		
    	}
    	
    }

    // onCreateDialog(int id)でダイアログ作成.
    /*
    @Override
    protected Dialog onCreateDialog(int id){
    	
    	// アラートダイアログビルダーの生成
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);	// AlertDialog.Builerのインスタンスbuilderの生成.
    	
    	// "onCreateDialog(id)"が呼ばれたことを表示.
    	Toast.makeText(this, "onCreateDialog(id)", Toast.LENGTH_LONG).show();	// "onCreateDialog(id)"を表示.
    	
    	// IDごとに変える.
    	if (id == DIALOG_ID_1){	// DIALOG_ID_1
    		
    		// アラートダイアログの設定
	    	builder.setTitle("create title 1");	// setTitleで"create title 1"をセット.	    	
	    	builder.setMessage("create message 1");	// setMessageで"create message 1"セット.
	
	    	// ポジティブボタンの設定
	    	builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {	// builder.setPositiveButtonでポジティブボタン"OK"のDialogInterface.OnClickListenerをセット. 
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					Log.v(TAG, "Activity.showDialog(1) OK onClick!");	// Log.vで"Activity.showDialog(1) OK onClick!"を表示.
				}
				
			});
	    	
    	}
    	else if (id == DIALOG_ID_2){ // DIALOG_ID_2
    	
    		// アラートダイアログの設定
	    	builder.setTitle("create title 2");	// setTitleで"create title 2"をセット.	    	
	    	builder.setMessage("create message 2");	// setMessageで"create message 1"セット.
	
	    	// ポジティブボタンの設定
	    	builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {	// builder.setPositiveButtonでポジティブボタン"OK"のDialogInterface.OnClickListenerをセット. 
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					Log.v(TAG, "Activity.showDialog(2) OK onClick!");	// Log.vで"Activity.showDialog(2) OK onClick!"を表示.
				}
				
			});
	    	
    	}
    	
    	// アラートダイアログの作成
    	return builder.create();	// builder.createで作成したDialogオブジェクトを返す.
    	
    }
    */
    
    // onPrepareDialog(int id, Dialog dialog)でダイアログ準備.
    /*
    @Override
    protected void onPrepareDialog(int id, Dialog dialog){
    	
    	// "onPrepareDialog(id, dialog)"が呼ばれたことを表示.
    	Toast.makeText(this, "onPrepareDialog(id = " + id + ", dialog)", Toast.LENGTH_LONG).show();	// "onPrepareDialog(id, dialog)"を表示.(idの値も.)
    	super.onPrepareDialog(id, dialog);	// 親クラスのメソッドを呼ぶ.
    	
    }
    */
    
    // onPrepareDialog(int id, Dialog dialog, Bundle args)でダイアログ準備.
    @Override
    protected void onPrepareDialog(int id, Dialog dialog, Bundle args){
    	
    	// "onPrepareDialog(id, dialog, args)"が呼ばれたことを表示.
    	Toast.makeText(this, "onPrepareDialog(id = " + id + ", dialog, args)", Toast.LENGTH_LONG).show();	// "onPrepareDialog(id, dialog, args)"を表示.(idの値も.)
    	if (id == DIALOG_ID_1){	// DIALOG_ID_1
    		Toast.makeText(this, "c1 = " + args.getInt("count1"), Toast.LENGTH_LONG).show();	// c1を表示.
    	}
    	else if (id == DIALOG_ID_2){	// DIALOG_ID_2
    		Toast.makeText(this, "c2 = " + args.getInt("count2"), Toast.LENGTH_LONG).show();	// c2を表示.
    	}
    	super.onPrepareDialog(id, dialog, args);	// 親クラスのメソッドを呼ぶ.
    	
    }
    
    // onCreateDialogでダイアログ作成.
    @Override
    protected Dialog onCreateDialog(int id, Bundle args){
    	
    	// アラートダイアログビルダーの生成
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);	// AlertDialog.Builerのインスタンスbuilderの生成.
    	
    	// "onCreateDialog(id, args)"が呼ばれたことを表示.
    	Toast.makeText(this, "onCreateDialog(id, args)", Toast.LENGTH_LONG).show();	// "onCreateDialog(id, args)"を表示.
    	
    	// argsで渡された"title"と"message"を取り出す.
    	/*
    	String title = args.getString("title");	// titleを取得.
    	Toast.makeText(this, "title = " + title, Toast.LENGTH_LONG).show();	// titleを表示.
    	String message = args.getString("message");	// messageを取得.
    	Toast.makeText(this, "message = " + message, Toast.LENGTH_LONG).show();	// messageを表示.
    	*/
    	
    	// IDごとに変える.
    	if (id == DIALOG_ID_1){	// DIALOG_ID_1
    		
	    	// アラートダイアログの設定
    		/*
	    	builder.setTitle(title);	// setTitleでtitleをセット.
	    	builder.setMessage(message);	// setMessageでmessageをセット.
			*/
    		builder.setTitle("dialog1");	// タイトルは"dialog1".
    		int c1 = args.getInt("count1");	// "count1"の値をc1に格納.
    		builder.setMessage("c1 = " + c1);	// c1の値を表示.
    		LayoutInflater inflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);	// inflater生成.
    		View layout = inflater.inflate(R.layout.dialog_main, (ViewGroup)findViewById(R.id.layout_root));	// layout生成.
    		EditText editText1 = (EditText)layout.findViewById(R.id.dialog_edittext1);	// editText1を取得.
    		String strCount1 = String.valueOf(c1);	// c1をstrCount1に変換.
    		editText1.setText(strCount1);	// strCount1をセット.
    		Button button1 = (Button)layout.findViewById(R.id.dialog_button1);	// button1を取得.
    		button1.setOnClickListener(new View.OnClickListener() {	// クリックリスナーをセット.
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					dismissDialog(DIALOG_ID_1);	// DIALOG_ID_1を非表示.
				}
				
			});
    		builder.setView(layout);	// layoutをセット.
    		
	    	// ポジティブボタンの設定
	    	builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {	// builder.setPositiveButtonでポジティブボタン"OK"のDialogInterface.OnClickListenerをセット. 
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					Log.v(TAG, "Activity.showDialog(1) OK onClick!");	// Log.vで"Activity.showDialog(1) OK onClick!"を表示.
				}
				
			});
    	
    	}
    	else if (id == DIALOG_ID_2){ // DIALOG_ID_2
    		
    		// アラートダイアログの設定
    		/*
    		builder.setTitle(title);	// setTitleでtitleをセット.
	    	builder.setMessage(message);	// setMessageでmessageをセット.
			*/
    		builder.setTitle("dialog2");	// タイトルは"dialog2".
    		int c2 = args.getInt("count2");	// "count2"の値をc2に格納.
    		builder.setMessage("c2 = " + c2);	// c2の値を表示.
    		LayoutInflater inflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);	// inflater生成.
    		View layout = inflater.inflate(R.layout.dialog_main, (ViewGroup)findViewById(R.id.layout_root));	// layout生成.
    		EditText editText1 = (EditText)layout.findViewById(R.id.dialog_edittext1);	// editText1を取得.
    		String strCount2 = String.valueOf(c2);	// c2をstrCount2に変換.
    		editText1.setText(strCount2);	// strCount2をセット.
    		Button button1 = (Button)layout.findViewById(R.id.dialog_button1);	// button1を取得.
    		button1.setOnClickListener(new View.OnClickListener() {	// クリックリスナーをセット.
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					dismissDialog(DIALOG_ID_2);	// DIALOG_ID_2を非表示.
				}
				
			});
    		builder.setView(layout);	// layoutをセット.
    		
	    	// ポジティブボタンの設定
	    	builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {	// builder.setPositiveButtonでポジティブボタン"OK"のDialogInterface.OnClickListenerをセット. 
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					Log.v(TAG, "Activity.showDialog(2) OK onClick!");	// Log.vで"Activity.showDialog(2) OK onClick!"を表示.
				}
				
			});
    		
    	}

    	// アラートダイアログの作成
    	return builder.create();	// builder.createで作成したDialogオブジェクトを返す.
    	
    }
	
}