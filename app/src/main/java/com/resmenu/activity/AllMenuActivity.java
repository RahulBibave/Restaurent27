package com.resmenu.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.resmenu.POJO.PagerList;
import com.resmenu.R;
import com.resmenu.adapters.MenuAdapterViewPager;
import com.resmenu.base.BaseBackstackManagerActivity;
import com.resmenu.base.BaseToolbarActivity;
import com.resmenu.fragment.Breakfast;
import com.resmenu.fragment.MainCourseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AllMenuActivity extends BaseBackstackManagerActivity {

    @BindView(R.id.view_pager_menu)
    ViewPager mViewPagerMenu;
    public static final String TAG = AllMenuActivity.class.getSimpleName();
    MenuAdapterViewPager mMenuAdapter;

   /* @BindView(R.id.toolbar_menu)
    Toolbar mToolbar;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_all_menu);
        super.onCreate(savedInstanceState);
      //  setSupportActionBar(mToolbar);
        showTitle("Menu List");

        showCartImage(R.id.ibmycart, new ICartImageClicked() {
            @Override
            public void onCartImageClicked() {
                Toast.makeText(AllMenuActivity.this, "My Cart", Toast.LENGTH_SHORT).show();
            }
        });

        showSearchImage(R.id.ibsearch, new ISearchImageClicked() {
            @Override
            public void onSearchImageClicked() {
                Toast.makeText(AllMenuActivity.this, "Search Menu", Toast.LENGTH_SHORT).show();

            }
        });

        mMenuAdapter = new MenuAdapterViewPager(getSupportFragmentManager());
        mViewPagerMenu.setAdapter(mMenuAdapter);

        mViewPagerMenu.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float v, int i1) {

                Toast.makeText(AllMenuActivity.this, "scrolled", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });





    }

/*    private List<PagerList> setPagerData() {
        List<PagerList> pagerLists = new ArrayList<>();
        pagerLists.add(new PagerList("Breakfast"));
        pagerLists.add(new PagerList("MainCourse"));
        pagerLists.add(new PagerList("Sweets"));
        pagerLists.add(new PagerList("Chinese"));
        pagerLists.add(new PagerList("Coffee"));
        pagerLists.add(new PagerList("Beverages"));
        return pagerLists;
    }*/

    public class MenuAdapterViewPager extends FragmentPagerAdapter {

        List<PagerList> mPagerList;
        Context mContext;
        private LayoutInflater inflater=null;
        public static final int NUMBERS = 1;



        public MenuAdapterViewPager(FragmentManager fm) {
            super(fm);
        }


        @Override
        public int getCount() {
            return NUMBERS;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:// Fragment # 0 - This will show FirstFragment
                    doChangeFragment(Breakfast.newInstance(), TAG, false);
                    break;
                case 1:
                    doChangeFragment(MainCourseFragment.newInstance(), TAG, false);
                    break;

            }return null;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return super.getPageTitle(position);
        }
    }

}
