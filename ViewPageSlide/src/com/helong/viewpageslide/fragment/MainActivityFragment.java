package com.helong.viewpageslide.fragment;

import java.util.ArrayList;
import java.util.List;
import com.helong.viewpageslide.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivityFragment extends Fragment implements View.OnClickListener{

	private ViewPager mPageVp;
	private List<Fragment> mFragmentList = new ArrayList<Fragment>();
	private FragmentAdapter mFragmentAdapter;
	private RelativeLayout rlOverlay;
	
	private MineAlbumFragment mineAlbumFragment;
	private MineFriendsFragment mineFriendsFragment;
	private MineMessageFragment mineMessageFragment;
	private MineTopicFragment mineTopicFragment;
	
	TextView tvOne;
	TextView tvTwo;
	TextView tvThree;
	TextView tvFour;
	/**
	 * ViewPager的当前选中页
	 */
	private int currentIndex=0;
	private int screenWidth;
	private int pageNum=4;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View contentVIew=inflater.inflate(R.layout.fragment_main,container,false);
		mPageVp=(ViewPager) contentVIew.findViewById(R.id.id_page_vp);
		rlOverlay=(RelativeLayout) contentVIew.findViewById(R.id.rl_overlay);

		tvOne=(TextView) contentVIew.findViewById(R.id.tv_one);
		tvTwo=(TextView) contentVIew.findViewById(R.id.tv_two);
		tvThree=(TextView) contentVIew.findViewById(R.id.tv_three);
		tvFour=(TextView) contentVIew.findViewById(R.id.tv_four);
		tvOne.setOnClickListener(this);
		tvTwo.setOnClickListener(this);
		tvThree.setOnClickListener(this);
		tvFour.setOnClickListener(this);

		DisplayMetrics dpMetrics = new DisplayMetrics();
		getActivity().getWindow().getWindowManager().getDefaultDisplay()
		.getMetrics(dpMetrics);
		screenWidth = dpMetrics.widthPixels;
		RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) rlOverlay
				.getLayoutParams();
		lp.width = screenWidth/pageNum;
		rlOverlay.setLayoutParams(lp);

		mineAlbumFragment=new MineAlbumFragment();
		mineTopicFragment=new MineTopicFragment();
		mineFriendsFragment=new MineFriendsFragment();
		mineMessageFragment=new MineMessageFragment();

		mFragmentList.add(mineAlbumFragment);
		mFragmentList.add(mineTopicFragment);
		mFragmentList.add(mineFriendsFragment);
		mFragmentList.add(mineMessageFragment);
		mFragmentAdapter = new FragmentAdapter(getChildFragmentManager());
		mPageVp.setAdapter(mFragmentAdapter);
		mPageVp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				currentIndex = position;
			}

			@Override
			public void onPageScrolled(int position, float offset,
					int offsetPixels) {
				if(currentIndex>position&&(currentIndex-position)==1)
				{
					int xOffset = (int) (-(1 - offset)
							* (screenWidth * 1.0 /pageNum) + currentIndex
							* (screenWidth /pageNum));
					rlOverlay.setX(xOffset);
				}else if(currentIndex==position)
				{
					int xOffset = (int) (offset * (screenWidth * 1.0 /pageNum) + currentIndex
							* (screenWidth /pageNum));
					rlOverlay.setX(xOffset);
				}
			}

			@Override
			public void onPageScrollStateChanged(int state) {
				//在这里来改变被选中的item的高亮样式
			}
		});
		mPageVp.setCurrentItem(0);
		return contentVIew;
	}

	class FragmentAdapter extends FragmentPagerAdapter {
		public FragmentAdapter(FragmentManager fm)
		{
			super(fm);
		}
		@Override
		public Fragment getItem(int position) 
		{
			return mFragmentList.get(position);
		}
		@Override
		public int getCount() 
		{
			return mFragmentList.size();
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tv_one:
			mPageVp.setCurrentItem(0,true);
			break;
		case R.id.tv_two:
			mPageVp.setCurrentItem(1,true);
			break;
		case R.id.tv_three:
			mPageVp.setCurrentItem(2,true);
			break;
		case R.id.tv_four:
			mPageVp.setCurrentItem(3,true);
			break;
		}
	}
}
