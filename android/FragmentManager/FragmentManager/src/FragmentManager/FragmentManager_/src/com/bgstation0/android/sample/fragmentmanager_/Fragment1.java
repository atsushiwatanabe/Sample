package com.bgstation0.android.sample.fragmentmanager_;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

// Fragment1�N���X�̒�`.
public class Fragment1 extends Fragment{
	
	// �t���O�����g�̃r���[������.
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		// Fragment1�̃��\�[�X���x�[�X�Ƀ��C�A�E�g�쐬.
		return inflater.inflate(R.layout.fragment1_main, null);	// inflater.inflace��R.layout.fragment1_main���x�[�X�Ƀ��C�A�E�g�쐬.
	}
}