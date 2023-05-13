package edu.xhu.pojo;

public class User {
    private String userName;
    private String passWord;
    private String img;
    private String gender;
    private String name;

    public User() {
    }

    public User(String userName, String passWord, String img, String gender, String name) {
        this.userName = userName;
        this.passWord = passWord;
        this.img = img;
        this.gender = gender;
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
