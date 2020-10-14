package com.travel.domain;

public class TabCategory {
    private int cid;
    private String cname;

    public TabCategory(int cid, String cname) {
        this.cid = cid;
        this.cname = cname;
    }

    public TabCategory() {
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "TabCategory{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                '}';
    }
}
