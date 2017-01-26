package entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Flyme on 2017/1/25.
 */
public class ConcernPK implements Serializable {
    private String roleid1;
    private String roleid2;

    @Column(name = "roleid1")
    @Id
    public String getRoleid1() {
        return roleid1;
    }

    public void setRoleid1(String roleid1) {
        this.roleid1 = roleid1;
    }

    @Column(name = "roleid2")
    @Id
    public String getRoleid2() {
        return roleid2;
    }

    public void setRoleid2(String roleid2) {
        this.roleid2 = roleid2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConcernPK concernPK = (ConcernPK) o;

        if (roleid1 != null ? !roleid1.equals(concernPK.roleid1) : concernPK.roleid1 != null) return false;
        if (roleid2 != null ? !roleid2.equals(concernPK.roleid2) : concernPK.roleid2 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleid1 != null ? roleid1.hashCode() : 0;
        result = 31 * result + (roleid2 != null ? roleid2.hashCode() : 0);
        return result;
    }
}
