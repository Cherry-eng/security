package com.travel.domain;

public class TabSeller {
    private int sid;
    private String sname;
    private String address;
    private String consphone;

    public TabSeller() {
    }

    public TabSeller(int sid, String sname, String address, String consphone) {
        this.sid = sid;
        this.sname = sname;
        this.address = address;
        this.consphone = consphone;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getConsphone() {
        return consphone;
    }

    public void setConsphone(String consphone) {
        this.consphone = consphone;
    }

    @Override
    public String toString() {
        return "TabSeller{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", address='" + address + '\'' +
                ", consphone='" + consphone + '\'' +
                '}';
    }
}
