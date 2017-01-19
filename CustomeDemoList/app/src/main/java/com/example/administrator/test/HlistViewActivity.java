package com.example.administrator.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HlistViewActivity extends AppCompatActivity {

    @Bind(R.id.horizontalScrollView1)
    MyHScrollView horizontalScrollView1;
    @Bind(R.id.scroollContainter)
    InterceptScrollContainer scroollContainter;
    @Bind(R.id.recycleView)
    RecyclerView recycleView;
    @Bind(R.id.head)
    LinearLayout llHead;

    MyRecycleAdapter mMyRecycleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hlist_view);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        llHead.setFocusable(true);
        llHead.setClickable(true);
        llHead.setOnTouchListener(new ListViewTouchListener());
        recycleView.setOnTouchListener(new ListViewTouchListener());
        mMyRecycleAdapter = new MyRecycleAdapter(horizontalScrollView1);
        recycleView.setAdapter(mMyRecycleAdapter);
        recycleView.setLayoutManager(new LinearLayoutManager(this));
    }

    class ListViewTouchListener implements View.OnTouchListener {

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            Log.d("onTouch", motionEvent.getX() + "..." + motionEvent.getY());
            horizontalScrollView1.onTouchEvent(motionEvent);
            return false;
        }
    }
}
