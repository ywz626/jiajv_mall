package com.ywz.furns.bean;

/**
 * @author 于汶泽
 */
public class Manger {
    private String name;
    private String pwd;

    public Manger() {
    }

    @Override
    public String toString() {
        return "Manger{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Manger(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }
}
