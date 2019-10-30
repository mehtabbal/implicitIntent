package com.example.implicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = findViewById(R.id.tv);
        final WebView wv = findViewById(R.id.wv);
        ListView lv = findViewById(R.id.lv);

        Intent i = getIntent();
        i.getType();
        String action = i.getAction();
        String type = i.getType();
        String data = i.getStringExtra(Intent.EXTRA_TEXT);

        final ArrayList<String> addUrl = new ArrayList<String>();

        if (data==null){
            addUrl.add("");
        }
        else {
            addUrl.add("" + data + "");
        }

        ArrayAdapter<String> ad = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, addUrl);
        lv.setAdapter(ad);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                wv.loadUrl(""+addUrl.get(position)+"");
            }
        });



    }
}
