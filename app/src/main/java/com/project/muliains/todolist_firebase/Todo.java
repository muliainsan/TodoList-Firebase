package com.project.muliains.todolist_firebase;

public class Todo {
    String id, nama, desc;

    public Todo() {
    }

    public Todo(String id, String nama, String desc) {
        this.id = id;
        this.nama = nama;
        this.desc = desc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
