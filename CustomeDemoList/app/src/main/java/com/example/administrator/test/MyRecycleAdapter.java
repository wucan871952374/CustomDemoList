package com.example.administrator.test;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/1/19.
 */

public class MyRecycleAdapter extends RecyclerView.Adapter<MyRecycleAdapter.ViewHolder> {
    MyHScrollView myHScrollView;

    public MyRecycleAdapter(MyHScrollView myHScrollView) {
        this.myHScrollView = myHScrollView;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        myHScrollView.AddOnScrollChangedListener(new OnScrollChangedListenerImp(holder.horizontalScrollView1));
        holder.textView2.setText(position + "2");
        holder.textView3.setText(position + "3");
        holder.textView4.setText(position + "4");
        holder.textView5.setText(position + "5");
        holder.textView6.setText(position + "6");
        holder.textView7.setText(position + "7");
    }

    @Override
    public int getItemCount() {
        return 250;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.textView2)
        TextView textView2;
        @Bind(R.id.textView3)
        TextView textView3;
        @Bind(R.id.textView4)
        TextView textView4;
        @Bind(R.id.textView5)
        TextView textView5;
        @Bind(R.id.textView6)
        TextView textView6;
        @Bind(R.id.textView7)
        TextView textView7;
        @Bind(R.id.horizontalScrollView1)
        MyHScrollView horizontalScrollView1;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class OnScrollChangedListenerImp implements MyHScrollView.OnScrollChangedListener {
        MyHScrollView mScrollViewArg;

        public OnScrollChangedListenerImp(MyHScrollView myHScrollView) {
            mScrollViewArg = myHScrollView;
        }

        @Override
        public void onScrollChanged(int l, int t, int oldl, int oldt) {
            mScrollViewArg.smoothScrollTo(l, t);
        }
    }
}
