package com.pic.optimize;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.pic.optimize.adapter.RecyclerBookAdapter;
import com.pic.optimize.bean.RecentContact;

import java.util.ArrayList;

public class TestRecycleViewActivity extends Activity {

    private static final String TAG = TestRecycleViewActivity.class.getSimpleName();

    private RecyclerView mListRecyclerView;
    private RecyclerBookAdapter mBookMainAdapter;
    private ArrayList<RecentContact> mBookList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity);
        mListRecyclerView = (RecyclerView) findViewById(R.id.book_recycler_view);
        mBookList.add(new RecentContact("aa",12));
        mBookList.add(new RecentContact("bb",4));
        mBookList.add(new RecentContact("cc",34));
        mBookList.add(new RecentContact("dd",110));
        mBookMainAdapter = new RecyclerBookAdapter(this, mBookList);

        //你想控制横向或者纵向滑动列表效果可以通过LinearLayoutManager这个类来进行控制
        mListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mListRecyclerView.setAdapter(mBookMainAdapter);
    }
}
