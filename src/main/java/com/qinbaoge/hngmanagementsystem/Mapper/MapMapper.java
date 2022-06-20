package com.qinbaoge.hngmanagementsystem.Mapper;

import com.qinbaoge.hngmanagementsystem.Entity.PoolEvent;
import com.qinbaoge.hngmanagementsystem.Entity.UnitMap;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface MapMapper {
    public List<UnitMap> Select_ALL_Normal_Role();
    public List<UnitMap> Select_ALL_Normal_Weapon();
    public int Insert_New_PoolEvent(UnitMap unitMap);
    public UnitMap Select_Final_Map_ID();
}
