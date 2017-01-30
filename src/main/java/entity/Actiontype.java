package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Flyme on 2017/1/30.
 */
@Entity
public class Actiontype {
    private String aid;
    private String actionname;
    private String tip;

    @Id
    @Column(name = "aid")
    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    @Basic
    @Column(name = "actionname")
    public String getActionname() {
        return actionname;
    }

    public void setActionname(String actionname) {
        this.actionname = actionname;
    }

    @Basic
    @Column(name = "tip")
    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Actiontype that = (Actiontype) o;

        if (aid != null ? !aid.equals(that.aid) : that.aid != null) return false;
        if (actionname != null ? !actionname.equals(that.actionname) : that.actionname != null) return false;
        if (tip != null ? !tip.equals(that.tip) : that.tip != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = aid != null ? aid.hashCode() : 0;
        result = 31 * result + (actionname != null ? actionname.hashCode() : 0);
        result = 31 * result + (tip != null ? tip.hashCode() : 0);
        return result;
    }
}
