package com.project.muliains.todolist_firebase;

import android.media.Image;

public class Todo {
    String id, nama, desc;
    Image img;

    public Todo() {
    }

    public Todo(String id, String nama, String desc, Image img) {
        this.id = id;
        this.nama = nama;
        this.desc = desc;
        this.img = img;
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

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }
}
