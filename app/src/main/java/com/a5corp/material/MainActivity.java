package com.a5corp.material;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Toolbar toolbar;
    Button button;
    FloatingActionButton fab;
    private Window window;
    private int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        button = (Button) findViewById(R.id.button);
        window = this.getWindow();
        if (android.os.Build.VERSION.SDK_INT > 18) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        if (android.os.Build.VERSION.SDK_INT > 20) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        }
        button.setOnClickListener(this);
        fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ScrollingActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (i) {
            case 0:
                toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                if (android.os.Build.VERSION.SDK_INT > 20) {
                    window.setStatusBarColor(getApplicationContext().getResources().getColor(R.color.colorPrimaryDark));
                }
                break;
            case 1:
                toolbar.setBackgroundColor(getResources().getColor(R.color.redNormal));
                if (android.os.Build.VERSION.SDK_INT > 20) {
                    window.setStatusBarColor(getApplicationContext().getResources().getColor(R.color.redDark));
                }
                break;
            case 2:
                toolbar.setBackgroundColor(getResources().getColor(R.color.tealNormal));
                if (android.os.Build.VERSION.SDK_INT > 20) {
                    window.setStatusBarColor(getApplicationContext().getResources().getColor(R.color.tealDark));
                }
                break;
        }
        i++;
        i = i % 3;
    }
}
