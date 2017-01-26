package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Flyme on 2017/1/25.
 */
@Entity
public class Task {
    private String taskid;
    private String cid;
    private String title;
    private String requirement;
    private Date creattime;
    private Date endtime;
    private Boolean deleted;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "taskid")
    public String getTaskid() {
        return taskid;
    }

    public void setTaskid(String taskid) {
        this.taskid = taskid;
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
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "requirement")
    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
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
    @Column(name = "endtime")
    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
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

        Task task = (Task) o;

        if (taskid != null ? !taskid.equals(task.taskid) : task.taskid != null) return false;
        if (cid != null ? !cid.equals(task.cid) : task.cid != null) return false;
        if (title != null ? !title.equals(task.title) : task.title != null) return false;
        if (requirement != null ? !requirement.equals(task.requirement) : task.requirement != null) return false;
        if (creattime != null ? !creattime.equals(task.creattime) : task.creattime != null) return false;
        if (endtime != null ? !endtime.equals(task.endtime) : task.endtime != null) return false;
        if (deleted != null ? !deleted.equals(task.deleted) : task.deleted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = taskid != null ? taskid.hashCode() : 0;
        result = 31 * result + (cid != null ? cid.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (requirement != null ? requirement.hashCode() : 0);
        result = 31 * result + (creattime != null ? creattime.hashCode() : 0);
        result = 31 * result + (endtime != null ? endtime.hashCode() : 0);
        result = 31 * result + (deleted != null ? deleted.hashCode() : 0);
        return result;
    }
}
