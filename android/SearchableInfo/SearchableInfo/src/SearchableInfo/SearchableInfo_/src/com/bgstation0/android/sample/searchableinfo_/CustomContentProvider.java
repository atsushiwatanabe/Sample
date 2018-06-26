package com.bgstation0.android.sample.searchableinfo_;

import android.app.SearchManager;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.provider.BaseColumns;
import android.util.Log;

public class CustomContentProvider extends ContentProvider {

	// �����X�^�e�B�b�N�N���X�Ƃ���CustomDBHelper���`.
	private static class CustomDBHelper extends SQLiteOpenHelper{
		
		// �����o�t�B�[���h�̒�`.
		private static final String CREATE_TABLE = "create table custom ( " + BaseColumns._ID +  " integer primary key, " + SearchManager.SUGGEST_COLUMN_TEXT_1 + " string, " + SearchManager.SUGGEST_COLUMN_QUERY + " string" + ");";	// CREATE_TABLE��.
		private static final String DROP_TABLE = "drop table custom;";	// DROP_TABLE��.
		
		// �R���X�g���N�^
		CustomDBHelper(Context context){
			super(context, "custom.db", null, 1);	// �e�R���X�g���N�^��context, DB��"custom.db", DB�o�[�W����1�Ȃǂ�n��.
		}
		
		// DB�̍쐬��.
		public void onCreate(SQLiteDatabase db){
			db.execSQL(CREATE_TABLE);	// db.execSQL�Ńe�[�u���쐬.
		}
		
		// �A�b�v�O���[�h��.
		@Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(DROP_TABLE);	// db.execSQL�Ńe�[�u���폜.
            onCreate(db);	// onCreate�ōĂуe�[�u���쐬.
        }
		
	}
	
	// �����o�̒�`.
	private CustomDBHelper customDBHelper;	// DB�w���p�[�̃C���X�^���X.
		
	@Override
	public boolean onCreate() {
		// TODO Auto-generated method stub
		// �\��.
		Log.d("CustomContentProvider", "onCreate");	// Log.d��"onCreate"��\��.
		// DB�w���p�[�̍쐬.
		customDBHelper = new CustomDBHelper(getContext());	// customDBHelper�𐶐�.
		Log.d("CustomContentProvider", "customDBHelper.toString() = " + customDBHelper.toString());	// customDBHelper.toString()��\��.
		ContentValues values1 = new ContentValues();
		values1.put(SearchManager.SUGGEST_COLUMN_TEXT_1, "abc�Ō���.");
		values1.put(SearchManager.SUGGEST_COLUMN_QUERY, "abc");
		ContentValues values2 = new ContentValues();
		values2.put(SearchManager.SUGGEST_COLUMN_TEXT_1, "def�Ō���.");
		values2.put(SearchManager.SUGGEST_COLUMN_QUERY, "def");
		ContentValues values3 = new ContentValues();
		values3.put(SearchManager.SUGGEST_COLUMN_TEXT_1, "ghi�Ō���.");
		values3.put(SearchManager.SUGGEST_COLUMN_QUERY, "ghi");
		customDBHelper.getWritableDatabase().insert("custom",  null,  values1);
		customDBHelper.getWritableDatabase().insert("custom",  null,  values2);
		customDBHelper.getWritableDatabase().insert("custom",  null,  values3);
		//return false;
		return true;	// true��Ԃ�.
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		// TODO Auto-generated method stub
		Log.d("SearchableInfo", "uri = " + uri.toString() + ", selection = " + selection + ", selectionArgs[0] = " + selectionArgs[0]);	// uri��selection�����O�ɏo��.
		// �₢���킹.
		SQLiteDatabase db = customDBHelper.getReadableDatabase();	// �ǂݍ��ݐ�p�f�[�^�x�[�Xdb���擾.
		Cursor c = null;
		if (selectionArgs[0].equals("a")){
			c = db.query("custom", projection, SearchManager.SUGGEST_COLUMN_QUERY + " = ?", new String[]{"abc"}, null, null, null);	// db.query��"custom"����₢���킹��.
		}
		else if (selectionArgs[0].equals("d")){
			c = db.query("custom", projection, SearchManager.SUGGEST_COLUMN_QUERY + " = ?", new String[]{"def"}, null, null, null);	// db.query��"custom"����₢���킹��.
		}
		else if (selectionArgs[0].equals("g")){
			c = db.query("custom", projection, SearchManager.SUGGEST_COLUMN_QUERY + " = ?", new String[]{"ghi"}, null, null, null);	// db.query��"custom"����₢���킹��.
		}
		else{
			c = null;
		}
		if (c != null){	// c��null�łȂ���ΐ���.
			return c;	// c��Ԃ�.
		}
		else{
			return null;	// null��Ԃ�.
		}
	}

	@Override
	public String getType(Uri uri) {
		// TODO Auto-generated method stub
		return null;
	}

	// �}�����鎞.
	@Override
	public Uri insert(Uri uri, ContentValues values) {
		// TODO Auto-generated method stub
		// �\��.
		Log.d("CustomContentProvider", "insert");	// Log.d��"insert"��\��.
		// �s�̑}��.
		SQLiteDatabase db = customDBHelper.getWritableDatabase();	// �������݉\�f�[�^�x�[�Xdb���擾.
		long rowId = db.insert("custom", null, values);	// db.insert�ő}������rowId���擾.
		Log.d("CustomContentProvider", "rowId = " + rowId);	// rowId��\��.
		if (rowId > 0){	// 0���傫���Ȃ琬��.
			return uri;	// uri��Ԃ�.
		}
		else{
			return null;	// null��Ԃ�.
		}
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

}