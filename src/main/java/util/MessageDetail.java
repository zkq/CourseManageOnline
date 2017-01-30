package util;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Date;
import java.util.Map;

/**
 * Created by Flyme on 2017/1/30.
 */
public class MessageDetail {

    String mid;
    String sid;
    String tid;
    String tname;
    String actiontype;
    String actionname;
    String tip;
    Date actiontime;
    String content;
    Boolean readed;
    Boolean deleted;

    Boolean sameday;

    public Boolean getSameday() {
        return sameday;
    }

    public void setSameday(Boolean sameday) {
        this.sameday = sameday;
    }

    public MessageDetail(String mid, String sid, String tid, String tname, String actiontype,
                         String actionname, String tip, Date actiontime, String content, Boolean readed, Boolean deleted) {
        this.mid = mid;
        this.sid = sid;
        this.tid = tid;
        this.tname = tname;
        this.actiontype = actiontype;
        this.actionname = actionname;
        this.tip = tip;
        this.actiontime = actiontime;
        this.content = content;
        this.readed = readed;
        this.deleted = deleted;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getActiontype() {
        return actiontype;
    }

    public void setActiontype(String actiontype) {
        this.actiontype = actiontype;
    }

    public String getActionname() {
        return actionname;
    }

    public void setActionname(String actionname) {
        this.actionname = actionname;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public Date getActiontime() {
        return actiontime;
    }

    public void setActiontime(Date actiontime) {
        this.actiontime = actiontime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getReaded() {
        return readed;
    }

    public void setReaded(Boolean readed) {
        this.readed = readed;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
