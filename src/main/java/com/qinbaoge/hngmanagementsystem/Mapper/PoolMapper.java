package com.qinbaoge.hngmanagementsystem.Mapper;

import com.qinbaoge.hngmanagementsystem.Entity.PoolEvent;
import com.qinbaoge.hngmanagementsystem.Entity.Unit;
import com.qinbaoge.hngmanagementsystem.Entity.Username;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PoolMapper {
    public List<PoolEvent> Select_AllPoolEvent();
    public PoolEvent Select_ThisPoolEvnet(String id);
    public int Update_ThisIdPoolEvent(PoolEvent pe);
    public int Delete_ThisPoolEvent(int id);
    public int Select_Final_Pool_Event_ID();
    public List<Unit> Select_All_This_Rarity(Unit un);
    public List<PoolEvent> Select_FindAllPoolType();
    public List<PoolEvent> Select_ThisTypePool(int wish_type);
    public int Insert_New_PoolEvent(PoolEvent poolEvent);
}
