package util;

import java.util.Date;

/**
 * Created by Flyme on 2017/1/29.
 */
public class ResourceDetail {

    String rid;
    String cid;
    String coursename;
    String roleid;
    String rolename;
    String type;
    String resourcemd5;
    String resourcename;
    String introduction;
    Date creattime;

    public ResourceDetail(String rid, String cid, String coursename, String roleid, String rolename, String type, String resourcemd5, String resourcename, String introduction, Date creattime) {
        this.rid = rid;
        this.cid = cid;
        this.coursename = coursename;
        this.roleid = roleid;
        this.rolename = rolename;
        this.type = type;
        this.resourcemd5 = resourcemd5;
        this.resourcename = resourcename;
        this.introduction = introduction;
        this.creattime = creattime;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getResourcemd5() {
        return resourcemd5;
    }

    public void setResourcemd5(String resourcemd5) {
        this.resourcemd5 = resourcemd5;
    }

    public String getResourcename() {
        return resourcename;
    }

    public void setResourcename(String resourcename) {
        this.resourcename = resourcename;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }
}
