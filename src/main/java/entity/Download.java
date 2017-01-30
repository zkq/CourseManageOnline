package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Flyme on 2017/1/29.
 */
@Entity
public class Download {
    private String downid;
    private String rid;
    private String roleid;
    private Date time;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "downid")
    public String getDownid() {
        return downid;
    }

    public void setDownid(String downid) {
        this.downid = downid;
    }

    @Basic
    @Column(name = "rid")
    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    @Basic
    @Column(name = "roleid")
    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    @Basic
    @Column(name = "time")
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Download download = (Download) o;

        if (downid != null ? !downid.equals(download.downid) : download.downid != null) return false;
        if (rid != null ? !rid.equals(download.rid) : download.rid != null) return false;
        if (roleid != null ? !roleid.equals(download.roleid) : download.roleid != null) return false;
        if (time != null ? !time.equals(download.time) : download.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = downid != null ? downid.hashCode() : 0;
        result = 31 * result + (rid != null ? rid.hashCode() : 0);
        result = 31 * result + (roleid != null ? roleid.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}
