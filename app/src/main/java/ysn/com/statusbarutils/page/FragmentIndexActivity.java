package ysn.com.statusbarutils.page;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import ysn.com.statusbarutils.R;

/**
 * @Author yangsanning
 * @ClassName FragmentIndexActivity
 * @Description 一句话概括作用
 * @Date 2019/7/26
 * @History 2019/7/26 author: description:
 */
public class FragmentIndexActivity extends AppCompatActivity implements
        ViewPager.OnPageChangeListener, BottomNavigationView.OnNavigationItemSelectedListener {

    private ViewPager viewPager;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_index_activity);

        viewPager = findViewById(R.id.fragment_index_activity_view_pager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.setFragments(new Fragment[]{
                TestFragment.newInstance(0),
                TestFragment.newInstance(1),
                TestFragment.newInstance(2),
                TestFragment.newInstance(3)});
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(this);

        bottomNavigationView = findViewById(R.id.fragment_index_activity_menu);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                bottomNavigationView.setSelectedItemId(R.id.menu_bottom1);
                break;
            case 1:
                bottomNavigationView.setSelectedItemId(R.id.menu_bottom2);
                break;
            case 2:
                bottomNavigationView.setSelectedItemId(R.id.menu_bottom3);
                break;
            case 3:
                bottomNavigationView.setSelectedItemId(R.id.menu_bottom4);
                break;
            default:
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.menu_bottom1:
                viewPager.setCurrentItem(0, false);
                break;
            case R.id.menu_bottom2:
                viewPager.setCurrentItem(1, false);
                break;
            case R.id.menu_bottom3:
                viewPager.setCurrentItem(2, false);
                break;
            case R.id.menu_bottom4:
                viewPager.setCurrentItem(3, false);
                break;
            default:
                break;
        }
        return true;
    }


    public class ViewPagerAdapter extends FragmentPagerAdapter {

        private Fragment[] fragments;

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments[position];
        }

        @Override
        public int getCount() {
            return fragments.length;
        }

        public void setFragments(Fragment[] fragments) {
            this.fragments = fragments;
        }
    }
}