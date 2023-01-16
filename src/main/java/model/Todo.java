package model;

import db.DataBase;

public class Todo {


    private final Integer id;
    private String title;
    private Boolean completed = false;
    private String userid;

    public Todo(String title, String userid) {
        this.id = DataBase.toDoList.size()+1;

        this.title = title;
        this.userid = userid;
        this.completed = false;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public String getUser() {
        return userid;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                ", user=" + userid +
                '}';
    }
}
