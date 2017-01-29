package entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Flyme on 2017/1/28.
 */
@Entity
@IdClass(WorkPK.class)
public class Work {
    private String taskid;
    private String sid;
    private Date handtime;
    private String title;
    private String explain;
    private String attachmd5;
    private String attachname;
    private String tcomment;
    private Double score;
    private Date commenttime;

    @Id
    @Column(name = "taskid")
    public String getTaskid() {
        return taskid;
    }

    public void setTaskid(String taskid) {
        this.taskid = taskid;
    }

    @Id
    @Column(name = "sid")
    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    @Basic
    @Column(name = "handtime")
    public Date getHandtime() {
        return handtime;
    }

    public void setHandtime(Date handtime) {
        this.handtime = handtime;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "`explain`")
    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    @Basic
    @Column(name = "attachmd5")
    public String getAttachmd5() {
        return attachmd5;
    }

    public void setAttachmd5(String attachmd5) {
        this.attachmd5 = attachmd5;
    }

    @Basic
    @Column(name = "attachname")
    public String getAttachname() {
        return attachname;
    }

    public void setAttachname(String attachname) {
        this.attachname = attachname;
    }

    @Basic
    @Column(name = "tcomment")
    public String getTcomment() {
        return tcomment;
    }

    public void setTcomment(String tcomment) {
        this.tcomment = tcomment;
    }

    @Basic
    @Column(name = "score")
    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Basic
    @Column(name = "commenttime")
    public Date getCommenttime() {
        return commenttime;
    }

    public void setCommenttime(Date commenttime) {
        this.commenttime = commenttime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Work work = (Work) o;

        if (taskid != null ? !taskid.equals(work.taskid) : work.taskid != null) return false;
        if (sid != null ? !sid.equals(work.sid) : work.sid != null) return false;
        if (handtime != null ? !handtime.equals(work.handtime) : work.handtime != null) return false;
        if (title != null ? !title.equals(work.title) : work.title != null) return false;
        if (explain != null ? !explain.equals(work.explain) : work.explain != null) return false;
        if (attachmd5 != null ? !attachmd5.equals(work.attachmd5) : work.attachmd5 != null) return false;
        if (attachname != null ? !attachname.equals(work.attachname) : work.attachname != null) return false;
        if (tcomment != null ? !tcomment.equals(work.tcomment) : work.tcomment != null) return false;
        if (score != null ? !score.equals(work.score) : work.score != null) return false;
        if (commenttime != null ? !commenttime.equals(work.commenttime) : work.commenttime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = taskid != null ? taskid.hashCode() : 0;
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (handtime != null ? handtime.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (explain != null ? explain.hashCode() : 0);
        result = 31 * result + (attachmd5 != null ? attachmd5.hashCode() : 0);
        result = 31 * result + (attachname != null ? attachname.hashCode() : 0);
        result = 31 * result + (tcomment != null ? tcomment.hashCode() : 0);
        result = 31 * result + (score != null ? score.hashCode() : 0);
        result = 31 * result + (commenttime != null ? commenttime.hashCode() : 0);
        return result;
    }
}
