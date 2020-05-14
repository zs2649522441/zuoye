package com.example.xiangnmu;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import fragment.Homefragment;
import fragment.Myfragment;
import fragment.Specialfragment;
import fragment.Videofragment;

public class MainActivity extends AppCompatActivity {

    private FrameLayout mFram;
    private TabLayout mTab;
    private LinearLayout mLin;
    private NavigationView mNv;
    private DrawerLayout mDraw;
    private FragmentManager manager;
    private Homefragment homefragment;
    private Myfragment myfragment;
    private Videofragment videofragment;
    private Specialfragment specialfragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTab = (TabLayout) findViewById(R.id.tab);
        mFram = (FrameLayout) findViewById(R.id.fram);
        mLin = (LinearLayout) findViewById(R.id.lin);
        mNv = (NavigationView) findViewById(R.id.nv);
        mDraw = (DrawerLayout) findViewById(R.id.draw);

        manager = getSupportFragmentManager();

        homefragment = new Homefragment();
        myfragment = new Myfragment();
        videofragment = new Videofragment();
        specialfragment = new Specialfragment();

        manager.beginTransaction().add(R.id.fram, homefragment).add(R.id.fram, videofragment).add(R.id.fram, specialfragment).add(R.id.fram, myfragment).show(homefragment).hide(videofragment).hide(specialfragment).hide(myfragment).commit();

        mTab.addTab(mTab.newTab().setText("推荐").setIcon(R.drawable.sss));
        mTab.addTab(mTab.newTab().setText("视频").setIcon(R.drawable.video));
        mTab.addTab(mTab.newTab().setText("专题").setIcon(R.drawable.special));
        mTab.addTab(mTab.newTab().setText("我的").setIcon(R.drawable.mine));
        mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 1:
                        manager.beginTransaction().show(homefragment).hide(videofragment).hide(specialfragment).hide(myfragment).commit();
                        break;
                    case 2:
                        manager.beginTransaction().show(videofragment).hide(homefragment).hide(specialfragment).hide(myfragment).commit();
                        break;
                    case 3:
                        manager.beginTransaction().show(specialfragment).hide(videofragment).hide(homefragment).hide(myfragment).commit();
                        break;
                    case 4:
                        manager.beginTransaction().show(myfragment).hide(videofragment).hide(specialfragment).hide(homefragment).commit();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}
