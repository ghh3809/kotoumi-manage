package com.qinbaoge.hngmanagementsystem.Entity;

public class Unit {
    private int  id;
    private int unit_type;
    private String unit_name;
    private int rarity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUnit_type() {
        return unit_type;
    }

    public void setUnit_type(int unit_type) {
        this.unit_type = unit_type;
    }

    public String getUnit_name() {
        return unit_name;
    }

    public void setUnit_name(String unit_name) {
        this.unit_name = unit_name;
    }

    public int getRarity() {
        return rarity;
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }
}
