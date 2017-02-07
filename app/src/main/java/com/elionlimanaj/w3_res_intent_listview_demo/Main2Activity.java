package com.elionlimanaj.w3_res_intent_listview_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.elionlimanaj.w3_res_intent_listview_demo.utils.Utils.MSG_KEY_INTENT;
import static com.elionlimanaj.w3_res_intent_listview_demo.utils.Utils.MSG_KEY2_INTENT;

public class Main2Activity extends AppCompatActivity {
    private TextView tv;
    private TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv = (TextView) findViewById(R.id.tv1_ma2);
        tv.setText(getIntent().getStringExtra(MSG_KEY_INTENT));
        tv2 = (TextView) findViewById(R.id.tv2_ma2);
        tv2.setText(getIntent().getStringExtra(MSG_KEY2_INTENT));
    }
}