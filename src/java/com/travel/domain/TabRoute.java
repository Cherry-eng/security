package com.travel.domain;

public class TabRoute {
    public int rid;
    public String rname;
    public double price;
    public String routeIntroduce;
    public String rflag;
    public String rdate;
    public String isThemeTour;
    public int count;
    public TabCategory tabCategory;
    public String rimage;
    public TabSeller tabSeller;

    public TabRoute(int rid, String rname, double price, String routeIntroduce, String rflag, String rdate, String isThemeTour, int count, TabCategory tabCategory, String rimage, TabSeller tabSeller) {
        this.rid = rid;
        this.rname = rname;
        this.price = price;
        this.routeIntroduce = routeIntroduce;
        this.rflag = rflag;
        this.rdate = rdate;
        this.isThemeTour = isThemeTour;
        this.count = count;
        this.tabCategory = tabCategory;
        this.rimage = rimage;
        this.tabSeller = tabSeller;
    }

    public TabRoute() {
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRouteIntroduce() {
        return routeIntroduce;
    }

    public void setRouteIntroduce(String routeIntroduce) {
        this.routeIntroduce = routeIntroduce;
    }

    public String getRflag() {
        return rflag;
    }

    public void setRflag(String rflag) {
        this.rflag = rflag;
    }

    public String getRdate() {
        return rdate;
    }

    public void setRdate(String rdate) {
        this.rdate = rdate;
    }

    public String getIsThemeTour() {
        return isThemeTour;
    }

    public void setIsThemeTour(String isThemeTour) {
        this.isThemeTour = isThemeTour;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public TabCategory getTabCategory() {
        return tabCategory;
    }

    public void setTabCategory(TabCategory tabCategory) {
        this.tabCategory = tabCategory;
    }

    public String getRimage() {
        return rimage;
    }

    public void setRimage(String rimage) {
        this.rimage = rimage;
    }

    public TabSeller getTabSeller() {
        return tabSeller;
    }

    public void setTabSeller(TabSeller tabSeller) {
        this.tabSeller = tabSeller;
    }
}
