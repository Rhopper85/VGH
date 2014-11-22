package com.rufflez.pagertabstriplistview.pagertabstriplistview;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    DrawerLayout mDrawerLayout;
    ListView mDrawerList;
    ActionBarDrawerToggle mDrawerToggle;
    CustomNavAdapter mAdapter;
    String[] drawerListItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //New to Android 5.0 and the support library, the Toolbar
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView)findViewById(R.id.drawerList);
        //Drawer Layout List items...
        drawerListItems = new String[]{
                "Consoles",
                "Handhelds",
                "About"
        };
        //Simple adapter that has been modified to bold the selected item
        mAdapter = new CustomNavAdapter(this, android.R.layout.simple_list_item_1, drawerListItems);
        mDrawerList.setAdapter(mAdapter);
        //set out onItemClickListener to change the main view...which is the same in each of these examples.
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        mDrawerToggle = new ActionBarDrawerToggle(
                this,  mDrawerLayout, mToolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close
        ){
            //Helper methods for the Toggle
            public void onDrawerClosed(View view)
            {
                super.onDrawerClosed(view);
                invalidateOptionsMenu();
                syncState();
            }

            public void onDrawerOpened(View drawerView)
            {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
                syncState();
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        //We are replacing the ActionBar with our Toolbar which allows us to do more with less code
        setSupportActionBar(mToolbar);
        //This allows us to show and click the home button which is our arrow/hamburger icon
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        mDrawerToggle.syncState();
        //This is called so we select the first item in the drawer list by default
        selectItem(0);
        //This is called so we set the default Actionbar title to our first item
        getSupportActionBar().setTitle(drawerListItems[0]);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean  onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home: {
                if (mDrawerLayout.isDrawerOpen(mDrawerList)) {
                    mDrawerLayout.closeDrawer(mDrawerList);
                } else {
                    mDrawerLayout.openDrawer(mDrawerList);
                }
                return true;
            }
            default: return super.onOptionsItemSelected(item);
        }
    }

    private class DrawerItemClickListener implements
            ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            //change the item visually
            selectItem(position);
            //change the item in the drawer so the new item is bolded
            mAdapter.selectedItem(position);
            //set the title of the ActionBar so its the new item shown
            getSupportActionBar().setTitle(drawerListItems[position]);
        }
    }

    private void selectItem(int position) {
        /*
            This is where you will change your PagerTabStrip based on which item is selected in the drawer
            this bit of code changes the main view with pagertitlestrip
        */
        switch (position) {
            case 0:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.container,
                                PagerTabStripFragment.newInstance(),
                                PagerTabStripFragment.TAG).commit();
                break;

            case 1:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.container,
                                PagerTabStripFragment.newInstance(),
                                PagerTabStripFragment.TAG).commit();
                break;
            case 2:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.container,
                                PagerTabStripFragment.newInstance(),
                                PagerTabStripFragment.TAG).commit();
                break;
        }

        mDrawerLayout.closeDrawer(mDrawerList);
    }
}
