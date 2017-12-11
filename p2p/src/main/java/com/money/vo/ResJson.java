package com.money.vo;

public class ResJson {
    private int id;
    private String text;
    private String url;
    private Integer _parentId;
    private boolean checked;

    public boolean getChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
    /*public ResJson(){}

    public ResJson(int id, String text, Integer _parentId){
        this.id = id;
        this.text = text;
        this._parentId = _parentId;
    }

    public ResJson(int id, String text, String url, Integer _parentId){
        this.id = id;
        this.text = text;
        this.url = url;
        this._parentId = _parentId;
    }*/

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer get_parentId() {
        if (_parentId == 0) {
            return _parentId=null;
        }else {
            return _parentId;
        }
    }

    public void set_parentId(Integer _parentId) {

        this._parentId = _parentId;
    }
}
