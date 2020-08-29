package com.example.webviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.example.base.autoservice.WebServiceLoader;
import com.example.common.autoservice.*;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.open_webviewactivity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IWebViewService webviewService = WebServiceLoader.load(IWebViewService.class);
                if(webviewService != null) {
                    webviewService.startDemoHtml(MainActivity.this);
                }
            }
        });
    }
}