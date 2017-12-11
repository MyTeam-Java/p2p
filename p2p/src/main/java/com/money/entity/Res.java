package com.money.entity;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

public class Res implements Serializable{
    private int id;
    private String text;
    private String url;
    private Integer parentId;
    private boolean checked;//目标:显示用户已有权限

    //isChecked改为getChecked
    public boolean getChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    private Set<Res> children = new LinkedHashSet<>();

    public Set<Res> getChildren() {
        return children;
    }

    public void setChildren(Set<Res> children) {
        this.children = children;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getParentId() {
        if (parentId == null) {
            return parentId = 0;
        }else {
            return parentId;
        }
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
