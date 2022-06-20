package com.qinbaoge.hngmanagementsystem.Mapper;

import com.qinbaoge.hngmanagementsystem.Entity.Unit;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UnitMapper {
    public List<Unit> Select_Unit_Type_1();
    public List<Unit> Select_Unit_Type_2();
    public List<Unit> Select_Unit_Type_3();
    public Unit Select_This_Unit_Type_3(String id);
    public int Update_ThisIdUnit(Unit un);
    public int Delete_ThisUnit(int id);
    public int Select_Id_By_Unit_Type(int type);
    public int Insert_New_Unit_Type(Unit unit);
    public List<Unit> Select_This_Rarity_All();
}
