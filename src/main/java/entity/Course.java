package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Flyme on 2017/1/23.
 */
@Entity
public class Course {
    private String cid;
    private String tid;
    private String name;
    private String code;
    private String type;
    private String introduction;
    private Date creattime;
    private Date starttime;
    private Date joinendtime;
    private Date finishtime;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "cid")
    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    @Basic
    @Column(name = "starttime")
    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    @Basic
    @Column(name = "joinendtime")
    public Date getJoinendtime() {
        return joinendtime;
    }

    public void setJoinendtime(Date joinendtime) {
        this.joinendtime = joinendtime;
    }

    @Basic
    @Column(name = "finishtime")
    public Date getFinishtime() {
        return finishtime;
    }

    public void setFinishtime(Date finishtime) {
        this.finishtime = finishtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (cid != null ? !cid.equals(course.cid) : course.cid != null) return false;
        if (tid != null ? !tid.equals(course.tid) : course.tid != null) return false;
        if (name != null ? !name.equals(course.name) : course.name != null) return false;
        if (code != null ? !code.equals(course.code) : course.code != null) return false;
        if (type != null ? !type.equals(course.type) : course.type != null) return false;
        if (introduction != null ? !introduction.equals(course.introduction) : course.introduction != null)
            return false;
        if (creattime != null ? !creattime.equals(course.creattime) : course.creattime != null) return false;
        if (starttime != null ? !starttime.equals(course.starttime) : course.starttime != null) return false;
        if (joinendtime != null ? !joinendtime.equals(course.joinendtime) : course.joinendtime != null) return false;
        if (finishtime != null ? !finishtime.equals(course.finishtime) : course.finishtime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cid != null ? cid.hashCode() : 0;
        result = 31 * result + (tid != null ? tid.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (introduction != null ? introduction.hashCode() : 0);
        result = 31 * result + (creattime != null ? creattime.hashCode() : 0);
        result = 31 * result + (starttime != null ? starttime.hashCode() : 0);
        result = 31 * result + (joinendtime != null ? joinendtime.hashCode() : 0);
        result = 31 * result + (finishtime != null ? finishtime.hashCode() : 0);
        return result;
    }
}
