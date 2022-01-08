package com.michaldabski.filemanager.sort;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.michaldabski.filemanager.AppPreferences;
import com.michaldabski.filemanager.R;
import com.michaldabski.utils.FontApplicator;
import com.michaldabski.filemanager.FileManagerApplication;

public class SortActivity extends Activity implements OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort);
        setupActionBar();

        new FontApplicator(getApplicationContext(), "Roboto_Light.ttf").applyFont(getWindow().getDecorView());

        findViewById(R.id.btn_sort_name).setOnClickListener(this);
        findViewById(R.id.btn_sort_type).setOnClickListener(this);
        findViewById(R.id.btn_sort_size).setOnClickListener(this);
        findViewById(R.id.btn_sort_size_all).setOnClickListener(this);
    }

    private void setupActionBar()
    {

        getActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.sort, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId()) {
            case R.id.btn_sort_name:
                NavUtils.navigateUpFromSameTask(this);
                FileManagerApplication application = (FileManagerApplication) getApplication();
                application.getAppPreferences().setSortBy(AppPreferences.SORT_BY_NAME);
                break;
            case R.id.btn_sort_type:
                NavUtils.navigateUpFromSameTask(this);
                application = (FileManagerApplication) getApplication();
                application.getAppPreferences().setSortBy(AppPreferences.SORT_BY_TYPE);
                break;
            case R.id.btn_sort_size:
                NavUtils.navigateUpFromSameTask(this);
                application = (FileManagerApplication) getApplication();
                application.getAppPreferences().setSortBy(AppPreferences.SORT_BY_SIZE);
                break;
            case R.id.btn_sort_size_all:
                NavUtils.navigateUpFromSameTask(this);
                application = (FileManagerApplication) getApplication();
                application.getAppPreferences().setSortBy(AppPreferences.SORT_BY_SIZE_ALL);
                break;
            default:return;
        }
    }
}