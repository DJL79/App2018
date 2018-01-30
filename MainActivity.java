package uk.co.boonapp.app2018;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    public String textInfoOne, textInfoTwo, textInfoThree;
    ListView listViewTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> AppInfo = new ArrayList<>();

        final PackageManager pm = getPackageManager();
        //get a list of installed apps.
        List<ApplicationInfo> packages = pm.getInstalledApplications(PackageManager.GET_META_DATA);

        for (ApplicationInfo packageInfo : packages) {
            Log.d(TAG, "Installed package :" + packageInfo.packageName);
            Log.d(TAG, "Source dir : " + packageInfo.sourceDir);
            Log.d(TAG, "Launch Activity :" + pm.getLaunchIntentForPackage(packageInfo.packageName));
            textInfoOne = packageInfo.packageName;
            textInfoTwo = packageInfo.sourceDir;


            AppInfo.add(textInfoOne + textInfoTwo);

        }
        // the getLaunchIntentForPackage returns an intent that you can use with startActivity()

        listViewTwo = (ListView) findViewById(R.id.listviewone);


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                AppInfo);

        listViewTwo.setAdapter(arrayAdapter);




/*

        for (int i = 0; i < AppInfo.size(); i++) {
                System.out.println("DETAILS X:" + AppInfo.get(i));

        }*/


    }
}
