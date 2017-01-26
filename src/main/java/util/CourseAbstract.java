package util;

/**
 * Created by Flyme on 2017/1/24.
 */
public class CourseAbstract {

    String id;
    String name;
    String code;

    public CourseAbstract(String id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
