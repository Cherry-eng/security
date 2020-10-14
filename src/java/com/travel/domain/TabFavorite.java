package com.travel.domain;

import com.oracle.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class TabFavorite {
      private int fid;
      private int rid;
      @DateTimeFormat(pattern = "yyyy-MM-dd")
      private Date date;
      private int uid;
      private String dateStr;

    public String getDateStr() {
        if (date!=null){
            dateStr= DateUtils.date2String(date,"yyyy-MM-dd");
        }
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

    private TabRoute tabRoute;
      private TabUser tabUser;

    public TabFavorite() {
    }

    public TabFavorite(int fid, int rid, Date date, int uid, String dateStr, TabRoute tabRoute, TabUser tabUser) {
        this.fid = fid;
        this.rid = rid;
        this.date = date;
        this.uid = uid;
        this.dateStr = dateStr;
        this.tabRoute = tabRoute;
        this.tabUser = tabUser;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public TabRoute getTabRoute() {
        return tabRoute;
    }

    public void setTabRoute(TabRoute tabRoute) {
        this.tabRoute = tabRoute;
    }

    public TabUser getTabUser() {
        return tabUser;
    }

    public void setTabUser(TabUser tabUser) {
        this.tabUser = tabUser;
    }

    @Override
    public String toString() {
        return "TabFavorite{" +
                "fid=" + fid +
                ", rid=" + rid +
                ", date=" + date +
                ", uid=" + uid +
                ", dateStr='" + dateStr + '\'' +
                ", tabRoute=" + tabRoute +
                ", tabUser=" + tabUser +
                '}';
    }
}
