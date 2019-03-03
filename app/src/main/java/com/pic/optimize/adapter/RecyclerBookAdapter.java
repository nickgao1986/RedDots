package com.pic.optimize.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.pic.optimize.DensityUtils;
import com.pic.optimize.R;
import com.pic.optimize.bean.RecentContact;

import java.util.ArrayList;

import nickgao.com.reddots2.BadgeTextView;


public class RecyclerBookAdapter extends RecyclerView.Adapter<RecyclerBookAdapter.BookHolder> {

    private Context mContext;
    private ArrayList<RecentContact> mBookList = new ArrayList<>();
    private LayoutInflater mLayoutInflater;

    public RecyclerBookAdapter(Context context, ArrayList<RecentContact> bookList) {
        mBookList = bookList;
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);

    }

    public void setList(ArrayList<RecentContact> list) {
        this.mBookList = list;
        notifyDataSetChanged();
    }


    @Override
    public BookHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.test_list_item, parent, false);
        return new BookHolder(itemView);
    }

    @Override
    public void onBindViewHolder(BookHolder holder, final int position) {
        updateNewIndicator(holder,mBookList.get(position));
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void updateNewIndicator(BookHolder holder,RecentContact contact) {
        int unreadNum = contact.mMessageCount;
        holder.tvUnread.setVisibility(unreadNum > 0 ? View.VISIBLE : View.GONE);
        if(unreadNum > 99) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)holder.tvUnread.getLayoutParams();
            layoutParams.width = DensityUtils.dip2px(holder.tvUnread.getContext(),28);
        }else if(unreadNum > 9) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)holder.tvUnread.getLayoutParams();
            layoutParams.width = DensityUtils.dip2px(holder.tvUnread.getContext(),25);
        } else{
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)holder.tvUnread.getLayoutParams();
            layoutParams.width = DensityUtils.dip2px(holder.tvUnread.getContext(),16);
        }
        holder.tvUnread.setBadgeCount(unreadNum);
    }

    @Override
    public int getItemCount() {
        return mBookList.size();
    }


    public class BookHolder extends RecyclerView.ViewHolder {

        protected BadgeTextView tvUnread;
        private View mView;



        private BookHolder(View itemView) {
            super(itemView);
            mView = itemView;
            tvUnread = (BadgeTextView)itemView.findViewById(R.id.unread_number_tip);
        }
    }

}
