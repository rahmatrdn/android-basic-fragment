package com.example.tugasfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {

    private TextView tv1, tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tv1 = findViewById(R.id.fr1);
        tv2 = findViewById(R.id.fr2);

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment(new FragmentA(),false,"one");
            }
        });

        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment(new FragmentB(),false,"two");
            }
        });
    }

    public void addFragment(Fragment fragment, boolean addToBackStack, String tag) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();

        if (addToBackStack) {
            ft.addToBackStack(tag);
        }
        ft.replace(R.id.frame_container, fragment, tag);
        ft.commitAllowingStateLoss();
    }
}
