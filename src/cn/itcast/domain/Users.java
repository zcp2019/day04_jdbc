package cn.itcast.domain;

/**
 * @author :zh
 * @PACKAGE_NAME :cn.itcast.domain
 * @NAME : Users
 * @date :2022Äê08ÔÂ24ÈÕ9:41
 */
public class Users {
    private int id;
    private String name;
    private String passwd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", passwd='" + passwd + '\'' +
                '}';
    }
}
