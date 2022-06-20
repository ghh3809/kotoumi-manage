package com.qinbaoge.hngmanagementsystem.Service.ServiceImpl;

import com.qinbaoge.hngmanagementsystem.Entity.PoolEvent;
import com.qinbaoge.hngmanagementsystem.Entity.Unit;
import com.qinbaoge.hngmanagementsystem.Mapper.PoolMapper;
import com.qinbaoge.hngmanagementsystem.Service.PoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PoolServiceImpl implements PoolService {

    @Autowired
    private PoolMapper poolMapper;
    @Override
    public List<PoolEvent> FindAllPoolEvent() {
        return poolMapper.Select_AllPoolEvent();
    }

    @Override
    public PoolEvent FindThisPoolEvnet(String id) {
        return poolMapper.Select_ThisPoolEvnet(id);
    }

    @Override
    public int ChangeThisIdPoolEvent(PoolEvent pe) {
        return poolMapper.Update_ThisIdPoolEvent(pe);
    }

    @Override
    public int RemoveThisPoolEvent(int id) {
        return poolMapper.Delete_ThisPoolEvent(id);
    }

    @Override
    public int FindFinalPoolEventID() {
        return poolMapper.Select_Final_Pool_Event_ID();
    }

    @Override
    public List<Unit> FindAllThisRarity(Unit un) {
        return poolMapper.Select_All_This_Rarity(un);
    }

    @Override
    public List<PoolEvent> FindAllPoolType() {
        return poolMapper.Select_FindAllPoolType();
    }

    @Override
    public List<PoolEvent> FindThisTypePool(int wish_type) {
        return poolMapper.Select_ThisTypePool(wish_type);
    }

    @Override
    public int AddNewPoolEvnet(PoolEvent poolEvent) {
        return poolMapper.Insert_New_PoolEvent(poolEvent);
    }
}
