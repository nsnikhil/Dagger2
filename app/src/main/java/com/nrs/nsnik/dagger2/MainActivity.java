package com.nrs.nsnik.dagger2;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.nrs.nsnik.dagger2.fragments.FirstFragment;
import com.nrs.nsnik.dagger2.fragments.SecondFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final String[] FRAGMENT_TAGS = {"First", "Second"};
    @BindView(R.id.mainToolbar)
    Toolbar mMainToolbar;
    @BindView(R.id.mainDrawerLayout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.mainNavigationView)
    NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.transparentStatusBar);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initialize(savedInstanceState);
        initializeDrawer();
        listeners();
    }

    private void initialize(Bundle savedInstanceState) {
        setSupportActionBar(mMainToolbar);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.mainContainer, new FirstFragment(), FRAGMENT_TAGS[0]).commit();
        }
    }

    private void listeners() {
    }

    private void initializeDrawer() {
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mMainToolbar, R.string.drawerOpen, R.string.drawerClose) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        mDrawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        mNavigationView.setNavigationItemSelectedListener(item -> {
            mDrawerLayout.closeDrawers();
            switch (item.getItemId()) {
                case R.id.navItem1:
                    if (getFragmentManager().findFragmentByTag(FRAGMENT_TAGS[0]) == null) {
                        replaceFragment(new FirstFragment(), FRAGMENT_TAGS[0]);
                    }
                    break;
                case R.id.navItem2:
                    if (getFragmentManager().findFragmentByTag(FRAGMENT_TAGS[1]) == null) {
                        replaceFragment(new SecondFragment(), FRAGMENT_TAGS[1]);
                    }
                    break;
                case R.id.navItem3:
                    break;
                case R.id.navItem4:
                    break;
                case R.id.navItem5:
                    break;
            }
            return false;
        });
    }

    public void replaceFragment(Fragment fragment, String tag) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.mainContainer, fragment, tag);
        ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        ft.commit();
    }
}
