package util;

import java.util.Date;

/**
 * Created by Flyme on 2017/1/24.
 */
public class CourseDetail {

    boolean hasjoined;
    Date jointime;

    String teacherid;
    String teachername;

    String cid;
    String name;
    String code;
    String type;
    String introduction;

    Date createdate;
    Date startdate;
    Date finishdate;
    Date joinenddate;


    public CourseDetail(String teacherid, String teachername, String cid, String name, String code, String type, String introduction, Date createdate, Date startdate, Date finishdate, Date joinenddate) {
        this.teacherid = teacherid;
        this.teachername = teachername;
        this.cid = cid;
        this.name = name;
        this.code = code;
        this.type = type;
        this.introduction = introduction;
        this.createdate = createdate;
        this.startdate = startdate;
        this.finishdate = finishdate;
        this.joinenddate = joinenddate;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public boolean isHasjoined() {
        return hasjoined;
    }

    public void setHasjoined(boolean hasjoined) {
        this.hasjoined = hasjoined;
    }

    public Date getJointime() {
        return jointime;
    }

    public void setJointime(Date jointime) {
        this.jointime = jointime;
    }

    public String getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(String teacherid) {
        this.teacherid = teacherid;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getFinishdate() {
        return finishdate;
    }

    public void setFinishdate(Date finishdate) {
        this.finishdate = finishdate;
    }

    public Date getJoinenddate() {
        return joinenddate;
    }

    public void setJoinenddate(Date joinenddate) {
        this.joinenddate = joinenddate;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}
