package com.cclz.myapp_170504_01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        String msg=getIntent().getStringExtra("msg");
        TextView tv2 = (TextView) findViewById(R.id.textView2);
        tv2.setText(msg);
    }
}
