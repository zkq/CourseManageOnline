package entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Flyme on 2017/1/28.
 */
public class WorkPK implements Serializable {
    private String taskid;
    private String sid;

    @Column(name = "taskid")
    @Id
    public String getTaskid() {
        return taskid;
    }

    public void setTaskid(String taskid) {
        this.taskid = taskid;
    }

    @Column(name = "sid")
    @Id
    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WorkPK workPK = (WorkPK) o;

        if (taskid != null ? !taskid.equals(workPK.taskid) : workPK.taskid != null) return false;
        if (sid != null ? !sid.equals(workPK.sid) : workPK.sid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = taskid != null ? taskid.hashCode() : 0;
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        return result;
    }
}
