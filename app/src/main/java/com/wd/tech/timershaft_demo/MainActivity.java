package com.wd.tech.timershaft_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wd.tech.timershaft_demo.timelineview.TimeIineLayout;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button addItemButton;
    private Button subItemButton;


    private TimeIineLayout mTimelineLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        addItemButton = (Button) findViewById(R.id.add_item);
        subItemButton = (Button) findViewById(R.id.sub_item);

        mTimelineLayout = (TimeIineLayout) findViewById(R.id.timeline_layout);

        addItemButton.setOnClickListener(this);
        subItemButton.setOnClickListener(this);

    }
    private int index = 0;
    private void addItem() {

        View view = LayoutInflater.from(this).inflate(R.layout.empty_view, mTimelineLayout, false);
        ((TextView) view.findViewById(R.id.tv_action)).setText("北京");


        mTimelineLayout.addView(view);
        index++;
    }

    private void subItem() {
        if (mTimelineLayout.getChildCount() > 0) {
            mTimelineLayout.removeViews(mTimelineLayout.getChildCount() - 1, 1);
            index--;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_item:
                addItem();
                break;
            case R.id.sub_item:
                subItem();
                break;

            default:
                break;
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
