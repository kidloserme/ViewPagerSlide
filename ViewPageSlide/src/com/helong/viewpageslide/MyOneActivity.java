package com.helong.viewpageslide;

import com.helong.viewpageslide.fragment.FragmentOne;
import com.helong.viewpageslide.fragment.MainActivityFragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

public class MyOneActivity extends FragmentActivity {

	Button btnSwitch;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_one);
		btnSwitch=(Button) findViewById(R.id.btn_switch);
		
		FragmentOne fragmentOne=new FragmentOne();
		
		FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
		fragmentTransaction.replace(R.id.fl_main_content,fragmentOne);
		fragmentTransaction.commit();
		
		btnSwitch.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
				fragmentTransaction.replace(R.id.fl_main_content,new MainActivityFragment());
				fragmentTransaction.commit();
			}
		});
	}
}
