package com.qinbaoge.hngmanagementsystem.Service;

import com.qinbaoge.hngmanagementsystem.Entity.PoolEvent;
import com.qinbaoge.hngmanagementsystem.Entity.Unit;

import java.util.List;

public interface PoolService{
    public List<PoolEvent> FindAllPoolEvent();
    public PoolEvent FindThisPoolEvnet(String id);
    public int ChangeThisIdPoolEvent(PoolEvent pe);
    public int RemoveThisPoolEvent(int id);
    public int FindFinalPoolEventID();
    public List<Unit> FindAllThisRarity(Unit un);
    public List<PoolEvent> FindAllPoolType();
    public List<PoolEvent> FindThisTypePool(int wish_type);
    public int AddNewPoolEvnet(PoolEvent poolEvent);
}
