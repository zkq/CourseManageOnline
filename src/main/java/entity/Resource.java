package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Flyme on 2017/1/29.
 */
@Entity
public class Resource {
    private String rid;
    private String cid;
    private String roleid;
    private String type;
    private String resourcemd5;
    private String resourcename;
    private String introduction;
    private Date creattime;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "rid")
    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    @Basic
    @Column(name = "cid")
    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
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
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "resourcemd5")
    public String getResourcemd5() {
        return resourcemd5;
    }

    public void setResourcemd5(String resourcemd5) {
        this.resourcemd5 = resourcemd5;
    }

    @Basic
    @Column(name = "resourcename")
    public String getResourcename() {
        return resourcename;
    }

    public void setResourcename(String resourcename) {
        this.resourcename = resourcename;
    }

    @Basic
    @Column(name = "introduction")
    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Basic
    @Column(name = "creattime")
    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resource resource = (Resource) o;

        if (rid != null ? !rid.equals(resource.rid) : resource.rid != null) return false;
        if (cid != null ? !cid.equals(resource.cid) : resource.cid != null) return false;
        if (roleid != null ? !roleid.equals(resource.roleid) : resource.roleid != null) return false;
        if (type != null ? !type.equals(resource.type) : resource.type != null) return false;
        if (resourcemd5 != null ? !resourcemd5.equals(resource.resourcemd5) : resource.resourcemd5 != null)
            return false;
        if (resourcename != null ? !resourcename.equals(resource.resourcename) : resource.resourcename != null)
            return false;
        if (introduction != null ? !introduction.equals(resource.introduction) : resource.introduction != null)
            return false;
        if (creattime != null ? !creattime.equals(resource.creattime) : resource.creattime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rid != null ? rid.hashCode() : 0;
        result = 31 * result + (cid != null ? cid.hashCode() : 0);
        result = 31 * result + (roleid != null ? roleid.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (resourcemd5 != null ? resourcemd5.hashCode() : 0);
        result = 31 * result + (resourcename != null ? resourcename.hashCode() : 0);
        result = 31 * result + (introduction != null ? introduction.hashCode() : 0);
        result = 31 * result + (creattime != null ? creattime.hashCode() : 0);
        return result;
    }
}
