package com.qinbaoge.hngmanagementsystem.Service.ServiceImpl;

import com.qinbaoge.hngmanagementsystem.Entity.Unit;
import com.qinbaoge.hngmanagementsystem.Mapper.UnitMapper;
import com.qinbaoge.hngmanagementsystem.Service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UnitServiceImpl implements UnitService {

    @Autowired
    private UnitMapper mapper;
    @Override
    public List<Unit> Find_Unit_Type_1() {
        return mapper.Select_Unit_Type_1();
    }

    @Override
    public List<Unit> Find_Unit_Type_2() {
        return mapper.Select_Unit_Type_2();
    }

    @Override
    public List<Unit> Find_Unit_Type_3() {
        return mapper.Select_Unit_Type_3();
    }

    @Override
    public Unit FindThisUnitType(String id) {
        return mapper.Select_This_Unit_Type_3(id);
    }

    @Override
    public int ChangeThisIdUnit(Unit un) {
        return mapper.Update_ThisIdUnit(un);
    }

    @Override
    public int RemoveThisUnit(int id) {
        return mapper.Delete_ThisUnit(id);
    }

    @Override
    public int FindFinalIdByUnitType(int type) {
        return mapper.Select_Id_By_Unit_Type(type);
    }

    @Override
    public int AddNewUnitType(Unit un) {
        return mapper.Insert_New_Unit_Type(un);
    }

    @Override
    public List<Unit> FindThisRarityAll() {
        return mapper.Select_This_Rarity_All();
    }
}
