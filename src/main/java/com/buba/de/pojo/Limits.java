package com.buba.de.pojo;

/**
 * @author Administrator
 * @desc
 * @create 2019-11-10 16:24
 **/

public class Limits {
    private Integer id;
    private String name;
    private Integer pid;
    private String href;

    public Limits(Integer id, String name, Integer pid, String href) {
        this.id = id;
        this.name = name;
        this.pid = pid;
        this.href = href;
    }

    public Limits() {
    }

    @Override
    public String toString() {
        return "Limits{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pid=" + pid +
                ", href='" + href + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
