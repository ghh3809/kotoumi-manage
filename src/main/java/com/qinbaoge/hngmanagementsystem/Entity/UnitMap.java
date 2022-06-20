package com.qinbaoge.hngmanagementsystem.Entity;

public class UnitMap {
    private int id;
    private int wish_event_id;
    private int unit_id;

    public UnitMap() {
    }

    public UnitMap(int wish_event_id, int unit_id, int is_up) {
        this.wish_event_id = wish_event_id;
        this.unit_id = unit_id;
        this.is_up = is_up;
    }

    private int is_up;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWish_event_id() {
        return wish_event_id;
    }

    public void setWish_event_id(int wish_event_id) {
        this.wish_event_id = wish_event_id;
    }

    public int getUnit_id() {
        return unit_id;
    }

    public void setUnit_id(int unit_id) {
        this.unit_id = unit_id;
    }

    public int getIs_up() {
        return is_up;
    }

    public void setIs_up(int is_up) {
        this.is_up = is_up;
    }
}
