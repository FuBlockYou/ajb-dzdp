package org.imooc.bean;

import java.util.List;

public class BusinessList {
    private boolean hashMore;
    private List<Business> data;

    public boolean isHashMore() {
        return hashMore;
    }

    public void setHashMore(boolean hashMore) {
        this.hashMore = hashMore;
    }

    public List<Business> getData() {
        return data;
    }

    public void setData(List<Business> data) {
        this.data = data;
    }
}
