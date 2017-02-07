package com.elionlimanaj.w3_res_intent_listview_demo;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import static com.elionlimanaj.w3_res_intent_listview_demo.utils.Utils.MSG_KEY_INTENT;
import static com.elionlimanaj.w3_res_intent_listview_demo.utils.Utils.MSG_KEY2_INTENT;

public class MainActivity extends AppCompatActivity {
    private Button btn1;
    private EditText editText;
    private EditText editText2;
    private ListView listView;
    private String[] myItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myItems = getResources().getStringArray(R.array.my_courses_items);
        listView = (ListView) findViewById(R.id.list_view_ma1);
        btn1 = (Button) findViewById(R.id.btn1_ma1);
        btn1.setOnClickListener(new MyLstnr());
        editText = (EditText) findViewById(R.id.edit_text_age_ma1);
        editText2 = (EditText) findViewById(R.id.edit_text_name_ma1);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, myItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                view.setBackgroundColor(Color.LTGRAY);
                Intent exIntent = new Intent(MainActivity.this, Main2Activity.class);
                exIntent.putExtra(MSG_KEY_INTENT, "Selected Course: " + myItems[position]);
                startActivity(exIntent);
            }
        });
    }

    public void showMap(View view) {
        Intent impIntent = new Intent(Intent.ACTION_VIEW);
        impIntent.setData(Uri.parse("geo:0,0?q=" + editText.getText()));
//        impIntent.setData(Uri.parse("geo:0,0?q=Montclair+State+University\n" +
//                "   +New Jersey+USA"));
//        impIntent.setData(Uri.parse("tel:+9732225544"));
        startActivity(impIntent);
    }

    class MyLstnr implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            intent.putExtra(MSG_KEY_INTENT, "Age is " + editText.getText());
            intent.putExtra(MSG_KEY2_INTENT, "Name is " + editText2.getText());
            startActivity(intent);
        }
    }
}