package com.qinbaoge.hngmanagementsystem.Service;

import com.qinbaoge.hngmanagementsystem.Entity.Unit;

import java.util.List;

public interface UnitService {
    public List<Unit> Find_Unit_Type_1();
    public List<Unit> Find_Unit_Type_2();
    public List<Unit> Find_Unit_Type_3();
    public Unit FindThisUnitType(String id);
    public int ChangeThisIdUnit(Unit un);
    public int RemoveThisUnit(int id);
    public int FindFinalIdByUnitType(int type);
    public int AddNewUnitType(Unit un);
    public List<Unit> FindThisRarityAll();
}
