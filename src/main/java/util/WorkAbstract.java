package util;

import java.util.Date;

/**
 * Created by Flyme on 2017/1/28.
 */
public class WorkAbstract {

    String name;
    String sid;
    Date handtime;
    String attachmd5;
    String attachname;
    Double score;
    Date commenttime;

    public WorkAbstract(String name, String sid, Date handtime, String attachmd5, String attachname, Double score, Date commenttime) {
        this.name = name;
        this.sid = sid;
        this.handtime = handtime;
        this.attachmd5 = attachmd5;
        this.attachname = attachname;
        this.score = score;
        this.commenttime = commenttime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public Date getHandtime() {
        return handtime;
    }

    public void setHandtime(Date handtime) {
        this.handtime = handtime;
    }

    public String getAttachmd5() {
        return attachmd5;
    }

    public void setAttachmd5(String attachmd5) {
        this.attachmd5 = attachmd5;
    }

    public String getAttachname() {
        return attachname;
    }

    public void setAttachname(String attachname) {
        this.attachname = attachname;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Date getCommenttime() {
        return commenttime;
    }

    public void setCommenttime(Date commenttime) {
        this.commenttime = commenttime;
    }
}
