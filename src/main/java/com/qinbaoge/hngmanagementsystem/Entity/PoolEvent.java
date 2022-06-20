package com.qinbaoge.hngmanagementsystem.Entity;

public class PoolEvent {
   private int  id;
   private String wish_event_name;
    private String unit_five_region;
    private String unit_four_region;
    private int wish_type;
    private String start_time;
    private String end_time;

    public PoolEvent(int id, String wish_event_name, String unit_five_region, String unit_four_region, int wish_type, String start_time, String end_time) {
        this.id = id;
        this.wish_event_name = wish_event_name;
        this.unit_five_region = unit_five_region;
        this.unit_four_region = unit_four_region;
        this.wish_type = wish_type;
        this.start_time = start_time;
        this.end_time = end_time;
    }

    public PoolEvent() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWish_event_name() {
        return wish_event_name;
    }

    public void setWish_event_name(String wish_event_name) {
        this.wish_event_name = wish_event_name;
    }

    public String getUnit_five_region() {
        return unit_five_region;
    }

    public void setUnit_five_region(String unit_five_region) {
        this.unit_five_region = unit_five_region;
    }

    public String getUnit_four_region() {
        return unit_four_region;
    }

    public void setUnit_four_region(String unit_four_region) {
        this.unit_four_region = unit_four_region;
    }

    public int getWish_type() {
        return wish_type;
    }

    public void setWish_type(int wish_type) {
        this.wish_type = wish_type;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }
}
