package com.pic.optimize.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public class RecentContact implements MultiItemEntity {

    public String name;
    public int mMessageCount;

    public RecentContact(String str,int count) {
        this.name = str;
        this.mMessageCount = count;
    }

    @Override
    public int getItemType() {
        return 0;
    }
}
