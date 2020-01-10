package com.bgstation0.android.sample.arrayadapter_;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // ArrayAdapter�̐���.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);	// �����android.R.layout.simple_spinner_item�ŃA�_�v�^�쐬.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);	// �h���b�v�_�E�����X�g�\�����̃r���[�͊����android.R.layout.simple_spinner_dropdown_item���Z�b�g.
        // �A�C�e���̒ǉ�.
        adapter.add("Item1");	// Item1��ǉ�.
        adapter.add("Item2");	// Item2��ǉ�.
        adapter.add("Item3"); 	// Item3��ǉ�.
        // �X�s�i�[�ɃA�_�v�^���Z�b�g.
        Spinner spinner = (Spinner)findViewById(R.id.spinner);	// spinner���擾.
        spinner.setAdapter(adapter);	// adapter���Z�b�g.
        
    }
    
}