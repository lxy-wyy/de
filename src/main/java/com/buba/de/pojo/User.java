package com.buba.de.pojo;

/**
 * @author Administrator
 * @desc
 * @create 2019-11-03 19:52
 **/

public class User {

  private  Integer  id;
  private String tel;
  private  String  bianhao;
  private  String  password;
  private  Integer roleid;
  private  String href;
  private  String sex;
  private  String name;
  private  String idcard;

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", tel='" + tel + '\'' +
                ", bianhao='" + bianhao + '\'' +
                ", password='" + password + '\'' +
                ", roleid=" + roleid +
                ", href='" + href + '\'' +
                ", sex='" + sex + '\'' +
                ", name='" + name + '\'' +
                ", idcard='" + idcard + '\'' +
                '}';
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBianhao() {
        return bianhao;
    }

    public void setBianhao(String bianhao) {
        this.bianhao = bianhao;
    }
}
