package com.qinbaoge.hngmanagementsystem.Service;

import com.qinbaoge.hngmanagementsystem.Entity.UnitMap;

import java.util.List;

public interface MapService {
    public List<UnitMap> FindNormalAllRole();
    public List<UnitMap> FindNormalAllWeapon();
    public int AddPoolUnitMap(UnitMap unitMap);
    public UnitMap FindLastUnitMap();
}
