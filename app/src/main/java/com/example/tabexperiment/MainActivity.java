package com.example.tabexperiment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import android.os.Bundle;
import android.widget.Switch;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager2 mViewPager2;
    private int adapterCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        // this command sets the toolbar to act like an action bar
        setSupportActionBar(toolbar);

        mTabLayout = findViewById(R.id.tab_Layout);

        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        mViewPager2 = findViewById(R.id.viewPager2);

        // call the function below that creates the tabAdapter and set it to our viewPager
        mViewPager2.setAdapter(createTabAdapter());

        // successively add labels to the three tabs using "tab configuration strategy"
        for (int i = 0; i < adapterCount; i++) {
            int finalI = i;
            // TabLayoutMediator has as parameters; (tabLayout, viewPager, tabConfiguration)
            // tabConfiguration is a callback interface that must be implemented to set the text
            // and styling of newly created tabs
            new TabLayoutMediator(mTabLayout, mViewPager2,
                    (tab, position) -> tab.setText(PagerAdapter.getPageTitle(position))).attach();
            // every cycle of the loop accesses a different "position" from PagerAdapter class
            // "getPageTitle" method as that method is called with "PagerAdapter.getPateTitle(position)
        }
    }   // this method
        private PagerAdapter createTabAdapter () {
            // set the PagerAdapter to our variable, adapter, with parameters of (fragmentActivity, and
            // number of tabs), where number of tabs is acquired through mTabLayout of class TabLayout
            // getTabCount() returns the number of tabs currently registered with the action bar
            PagerAdapter adapter = new PagerAdapter(this, mTabLayout.getTabCount());
            // get the itemCount from PagerAdapter for use in  the for-loop in onCreate, above
            adapterCount = adapter.getItemCount();
            // return adapter to the calling method or code, in this case, line 31, above
            return adapter;
        }
    }
