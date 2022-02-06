package com.example.darshanpractical.models.pojo;

public class Status {

    private int statusId;
    private String statusName;
    private int statusVal;
    private boolean isSelected;

    public Status() {
    }

    public Status(int statusId, String statusName, int statusVal, boolean isSelected) {
        this.statusId = statusId;
        this.statusName = statusName;
        this.statusVal = statusVal;
        this.isSelected = isSelected;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public int getStatusVal() {
        return statusVal;
    }

    public void setStatusVal(int statusVal) {
        this.statusVal = statusVal;
    }
}
