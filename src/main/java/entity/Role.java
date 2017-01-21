package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Flyme on 2017/1/21.
 */
@Entity
public class Role {
    private String roleid;
    private String type;
    private String name;
    private String sex;
    private Integer age;
    private String education;
    private String nativeplace;
    private String contact;
    private String email;
    private String school;
    private String college;
    private String major;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Basic
    @Column(name = "education")
    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Basic
    @Column(name = "nativeplace")
    public String getNativeplace() {
        return nativeplace;
    }

    public void setNativeplace(String nativeplace) {
        this.nativeplace = nativeplace;
    }

    @Basic
    @Column(name = "contact")
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "school")
    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Basic
    @Column(name = "college")
    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    @Basic
    @Column(name = "major")
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (roleid != null ? !roleid.equals(role.roleid) : role.roleid != null) return false;
        if (type != null ? !type.equals(role.type) : role.type != null) return false;
        if (name != null ? !name.equals(role.name) : role.name != null) return false;
        if (sex != null ? !sex.equals(role.sex) : role.sex != null) return false;
        if (age != null ? !age.equals(role.age) : role.age != null) return false;
        if (education != null ? !education.equals(role.education) : role.education != null) return false;
        if (nativeplace != null ? !nativeplace.equals(role.nativeplace) : role.nativeplace != null) return false;
        if (contact != null ? !contact.equals(role.contact) : role.contact != null) return false;
        if (email != null ? !email.equals(role.email) : role.email != null) return false;
        if (school != null ? !school.equals(role.school) : role.school != null) return false;
        if (college != null ? !college.equals(role.college) : role.college != null) return false;
        if (major != null ? !major.equals(role.major) : role.major != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleid != null ? roleid.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (education != null ? education.hashCode() : 0);
        result = 31 * result + (nativeplace != null ? nativeplace.hashCode() : 0);
        result = 31 * result + (contact != null ? contact.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (school != null ? school.hashCode() : 0);
        result = 31 * result + (college != null ? college.hashCode() : 0);
        result = 31 * result + (major != null ? major.hashCode() : 0);
        return result;
    }
}
