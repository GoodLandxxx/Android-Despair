package jordan.despair.com.despair;


import android.support.v4.app.FragmentManager;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import jordan.despair.com.despair.tool.Activitytool;

public class MainActivity extends Activitytool implements RadioGroup.OnCheckedChangeListener {
    private ViewPager mViewPager;
    private FragmentPagerAdapter mAdapter;
    private List<android.support.v4.app.Fragment> mFragments = new ArrayList<android.support.v4.app.Fragment>();
    private TextView bar;
    private RadioButton mBBS;
    private RadioButton mHot;
    private RadioButton mContact;
    private RadioButton mMyself;
    private RadioGroup rrrrrr;
    private int position = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bar = (TextView) findViewById(R.id.title_text);
        bar.setText(R.string.hot);
        bar.setBackgroundColor(Color.parseColor("#10000000"));//......
        rrrrrr = (RadioGroup) findViewById(R.id.rg___);
        mBBS = ((RadioButton) findViewById(R.id.rb_bbs));
        mHot = ((RadioButton) findViewById(R.id.rb_hot));
        mContact = ((RadioButton) findViewById(R.id.rb_contact));
        mMyself = ((RadioButton) findViewById(R.id.rb_user));
        mViewPager = (ViewPager) findViewById(R.id._viewpager);
        initView();

        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public int getCount() {
                return mFragments.size();
            }

            @Override
            public Fragment getItem(int arg0) {
                return mFragments.get(arg0);
            }
        };
        mViewPager.setAdapter(mAdapter);
        mViewPager.setCurrentItem(1);
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            private int currentIndex;

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                switch (position) {
                    case 0:
                        mBBS.setChecked(true);
                        bar.setText(R.string.bbs);
                        break;
                    case 1:
                        mHot.setChecked(true);
                        bar.setText(R.string.hot);
                        break;
                    case 2:
                        mContact.setChecked(true);
                        bar.setText(R.string.contact);
                        break;
                    case 3:
                        mMyself.setChecked(true);
                        bar.setText(R.string.myself);
                        break;
                }

                currentIndex = position;
            }


            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    private void initView() {
        rrrrrr.setOnCheckedChangeListener(this);
        BBSActivity BBS = new BBSActivity();
        HotActivity hot = new HotActivity();
        ContactActivity contact = new ContactActivity();
        MyselfActivity MY = new MyselfActivity();
        mFragments.add(0, BBS);
        mFragments.add(1, hot);
        mFragments.add(2, contact);
        mFragments.add(3, MY);


    }
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_bbs:
                mViewPager.setCurrentItem(0);
                break;
            case R.id.rb_hot:
                mViewPager.setCurrentItem(1);
                break;
            case R.id.rb_contact:
                mViewPager.setCurrentItem(2);
                break;
            case R.id.rb_user:
                mViewPager.setCurrentItem(3);
                break;
            default:
                break;
        }
    }
}




