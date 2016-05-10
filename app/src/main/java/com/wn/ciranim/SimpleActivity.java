package com.wn.ciranim;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class SimpleActivity extends AppCompatActivity {
    private static final DemoInfo[] DEMOS = {
            new DemoInfo(R.string.simple_1, R.string.simple_desc_1, CirRoundActivity.class),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);

        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(new ListSimpleAdapter());
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(SimpleActivity.this, DEMOS[position].demoClass));
            }
        });
    }


    private static class DemoInfo {
        private final int title;
        private final int desc;
        private final Class<? extends Activity> demoClass;

        public DemoInfo(int title, int desc, Class<? extends Activity> demoClass) {
            this.title = title;
            this.desc = desc;
            this.demoClass = demoClass;
        }
    }


    class ListSimpleAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return DEMOS.length;
        }

        @Override
        public Object getItem(int position) {
            return DEMOS[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = View.inflate(SimpleActivity.this,
                    R.layout.demo_info_item, null);
            TextView title = (TextView) convertView.findViewById(R.id.title);
            TextView desc = (TextView) convertView.findViewById(R.id.desc);
            title.setText(DEMOS[position].title);
            desc.setText(DEMOS[position].desc);
            return convertView;
        }
    }
}
