package entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Flyme on 2017/1/25.
 */
@Entity
@IdClass(SelectcPK.class)
public class Selectc {
    private String cid;
    private String sid;
    private Date selecttime;
    private String gread;

    @Id
    @Column(name = "cid")
    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
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
    @Column(name = "selecttime")
    public Date getSelecttime() {
        return selecttime;
    }

    public void setSelecttime(Date selecttime) {
        this.selecttime = selecttime;
    }

    @Basic
    @Column(name = "gread")
    public String getGread() {
        return gread;
    }

    public void setGread(String gread) {
        this.gread = gread;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Selectc selectc = (Selectc) o;

        if (cid != null ? !cid.equals(selectc.cid) : selectc.cid != null) return false;
        if (sid != null ? !sid.equals(selectc.sid) : selectc.sid != null) return false;
        if (selecttime != null ? !selecttime.equals(selectc.selecttime) : selectc.selecttime != null) return false;
        if (gread != null ? !gread.equals(selectc.gread) : selectc.gread != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cid != null ? cid.hashCode() : 0;
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (selecttime != null ? selecttime.hashCode() : 0);
        result = 31 * result + (gread != null ? gread.hashCode() : 0);
        return result;
    }
}
