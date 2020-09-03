package com.example.webviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableArrayMap;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.databinding.ObservableMap;

import android.os.Bundle;

import com.example.webviewdemo.databinding.ActivityDataBindBinding;


public class DataBindActivity extends AppCompatActivity {
    ActivityDataBindBinding mActivityMainBinding;
    ObservableField<String> title=new ObservableField<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //activity中使用
        mActivityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_data_bind);

        //Fragment/ListView/RecyclerView 中使用
//        mActivityMainBinding = ActivityMainBinding.inflate(R.layout.activity_main, null, false);

        mActivityMainBinding.setLifecycleOwner(this);


        ObservableMap<String,Integer> observableArrayMap=new ObservableArrayMap();
        observableArrayMap.put("count",2);
        mActivityMainBinding.setMap(observableArrayMap);

        ObservableList<String> observableList=new ObservableArrayList<>();
        observableList.add("lsitsd");
        mActivityMainBinding.setList(observableList);


        observableArrayMap.put("count",7);
        observableList.add(0,"34323242343243");

    }
}