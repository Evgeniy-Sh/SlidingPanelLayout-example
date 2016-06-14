package com.sple.slidingpanellayout_example;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import helper.MyViewPager;
import helper.ReaderViewPagerTransformer;
import helper.RecyclerAdapter;

public class Main extends AppCompatActivity implements ViewPager.OnPageChangeListener, SlidingPaneLayout.PanelSlideListener {

    protected SlidingPaneLayout spMain;

    protected RecyclerView rvRecycler;
    protected RecyclerAdapter rvAdapter;

    protected MyViewPager vpPager;
    protected PagerAdapter pagerAdapter;

    public void initPager(int _pagerNumber) {
        if(spMain != null) {
            spMain.closePane();
        }
        if(vpPager != null) {
            pagerAdapter = new PagerAdapter(getSupportFragmentManager());

            pagerAdapter.setData(_pagerNumber);

            vpPager.setAdapter(pagerAdapter);
        }
    }

    @Override
    public void onPanelSlide(View panel, float slideOffset) {

    }

    @Override
    public void onPanelOpened(View panel) {

    }

    @Override
    public void onPanelClosed(View panel) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        spMain = (SlidingPaneLayout) findViewById(R.id.spMain);

        spMain.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent e) {

                if(vpPager != null) {
                    //Log.v("111", vpPager.getCurrentItem() + "");
                    if(vpPager.getCurrentItem() > 0) {
                        return vpPager.onTouchEvent(e);
                    } else {
                        v.onTouchEvent(e);
                    }
                }
                return false;
            }
        });

        spMain.setPanelSlideListener(this);
        rvRecycler = (RecyclerView) findViewById(R.id.rvRecycler);
        rvRecycler.setHasFixedSize(true);
        LinearLayoutManager almp = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvRecycler.setLayoutManager(almp);

        rvAdapter = new RecyclerAdapter(this);
        for(int i = 0; i < 100; i ++) {
            rvAdapter.addItem("Item # " + i);
        }
        rvRecycler.setAdapter(rvAdapter);

        vpPager = (MyViewPager) findViewById(R.id.vpPager);
        pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(pagerAdapter);
        vpPager.setOnPageChangeListener(this);
        vpPager.setPageTransformer(true, new ReaderViewPagerTransformer(ReaderViewPagerTransformer.TransformType.DEPTH));
        vpPager.setOffscreenPageLimit(0);

        vpPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                return false;
            }
        });

        pagerAdapter.setData(0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
