package com.helong.viewpageslide.fragment;

import com.helong.viewpageslide.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MineTopicFragment extends Fragment {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View contentView=inflater.inflate(R.layout.fragment_play,container,false);
		TextView textView=(TextView) contentView.findViewById(R.id.tv_content);
		textView.setText("话题");
		return contentView;
	}
}
