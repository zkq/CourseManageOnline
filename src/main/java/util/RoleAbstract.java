package util;

/**
 * Created by Flyme on 2017/1/21.
 */
public class RoleAbstract {


    String roleid;
    String name;
    boolean concerned;


    public RoleAbstract(String name, String roleid) {
        this.name = name;
        this.roleid = roleid;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }


    public boolean isConcerned() {
        return concerned;
    }

    public void setConcerned(boolean concerned) {
        this.concerned = concerned;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
