package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Flyme on 2017/1/30.
 */
@Entity
public class Message {
    private String mid;
    private String sid;
    private String tid;
    private String actiontype;
    private Date actiontime;
    private String content;
    private Boolean readed;
    private Boolean deleted;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "mid")
    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    @Basic
    @Column(name = "sid")
    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    @Basic
    @Column(name = "tid")
    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    @Basic
    @Column(name = "actiontype")
    public String getActiontype() {
        return actiontype;
    }

    public void setActiontype(String actiontype) {
        this.actiontype = actiontype;
    }

    @Basic
    @Column(name = "actiontime")
    public Date getActiontime() {
        return actiontime;
    }

    public void setActiontime(Date actiontime) {
        this.actiontime = actiontime;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "readed")
    public Boolean getReaded() {
        return readed;
    }

    public void setReaded(Boolean readed) {
        this.readed = readed;
    }

    @Basic
    @Column(name = "deleted")
    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if (mid != null ? !mid.equals(message.mid) : message.mid != null) return false;
        if (sid != null ? !sid.equals(message.sid) : message.sid != null) return false;
        if (tid != null ? !tid.equals(message.tid) : message.tid != null) return false;
        if (actiontype != null ? !actiontype.equals(message.actiontype) : message.actiontype != null) return false;
        if (actiontime != null ? !actiontime.equals(message.actiontime) : message.actiontime != null) return false;
        if (content != null ? !content.equals(message.content) : message.content != null) return false;
        if (readed != null ? !readed.equals(message.readed) : message.readed != null) return false;
        if (deleted != null ? !deleted.equals(message.deleted) : message.deleted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mid != null ? mid.hashCode() : 0;
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (tid != null ? tid.hashCode() : 0);
        result = 31 * result + (actiontype != null ? actiontype.hashCode() : 0);
        result = 31 * result + (actiontime != null ? actiontime.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (readed != null ? readed.hashCode() : 0);
        result = 31 * result + (deleted != null ? deleted.hashCode() : 0);
        return result;
    }
}
