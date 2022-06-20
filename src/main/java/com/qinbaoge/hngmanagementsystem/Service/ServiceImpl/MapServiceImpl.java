package com.qinbaoge.hngmanagementsystem.Service.ServiceImpl;

import com.qinbaoge.hngmanagementsystem.Entity.UnitMap;
import com.qinbaoge.hngmanagementsystem.Mapper.LoginMapper;
import com.qinbaoge.hngmanagementsystem.Mapper.MapMapper;
import com.qinbaoge.hngmanagementsystem.Service.MapService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MapServiceImpl implements MapService {
    @Autowired
    private MapMapper mapper;


    @Override
    public List<UnitMap> FindNormalAllRole() {
        return mapper.Select_ALL_Normal_Role();
    }

    @Override
    public List<UnitMap> FindNormalAllWeapon() {
        return mapper.Select_ALL_Normal_Weapon();
    }

    @Override
    public int AddPoolUnitMap(UnitMap unitMap) {
        return mapper.Insert_New_PoolEvent(unitMap);
    }

    @Override
    public UnitMap FindLastUnitMap() {
        return mapper.Select_Final_Map_ID();
    }
}
