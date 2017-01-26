package entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Flyme on 2017/1/25.
 */
@Entity
@IdClass(ConcernPK.class)
public class Concern {
    private String roleid1;
    private String roleid2;
    private Date time;

    @Id
    @Column(name = "roleid1")
    public String getRoleid1() {
        return roleid1;
    }

    public void setRoleid1(String roleid1) {
        this.roleid1 = roleid1;
    }

    @Id
    @Column(name = "roleid2")
    public String getRoleid2() {
        return roleid2;
    }

    public void setRoleid2(String roleid2) {
        this.roleid2 = roleid2;
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

        Concern concern = (Concern) o;

        if (roleid1 != null ? !roleid1.equals(concern.roleid1) : concern.roleid1 != null) return false;
        if (roleid2 != null ? !roleid2.equals(concern.roleid2) : concern.roleid2 != null) return false;
        if (time != null ? !time.equals(concern.time) : concern.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleid1 != null ? roleid1.hashCode() : 0;
        result = 31 * result + (roleid2 != null ? roleid2.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}
