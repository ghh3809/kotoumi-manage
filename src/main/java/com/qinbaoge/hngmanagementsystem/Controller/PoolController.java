package com.qinbaoge.hngmanagementsystem.Controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qinbaoge.hngmanagementsystem.Entity.KeyValue;
import com.qinbaoge.hngmanagementsystem.Entity.PoolEvent;
import com.qinbaoge.hngmanagementsystem.Entity.Unit;
import com.qinbaoge.hngmanagementsystem.Entity.UnitMap;
import com.qinbaoge.hngmanagementsystem.Service.MapService;
import com.qinbaoge.hngmanagementsystem.Service.PoolService;
import com.qinbaoge.hngmanagementsystem.Service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class PoolController {

    @Autowired
    private PoolService service;
    @Autowired
    private UnitService unitService;
    @Autowired
    private MapService mapService;

    @GetMapping("/pool_info_sel/{wish_type}")
    @ResponseBody
    public String pool_info_sel(@PathVariable("wish_type") int wish_type) {
        JSONObject obj = new JSONObject();
        //前台通过key值获得对应的value值
        obj.put("code", 0);
        obj.put("msg", "");
        obj.put("count", 1000);
        obj.put("data", service.FindThisTypePool(wish_type));
        return obj.toJSONString();
    }

    @RequestMapping(value = "/find_all_this_rarity", method = RequestMethod.POST)
    @ResponseBody
    public String find_all_this_rarity(@RequestParam(value = "fjson") String fjson) {
        Unit un = JSON.parseObject(fjson, Unit.class);
        return JSON.toJSONString(service.FindAllThisRarity(un));
    }

    @GetMapping("/pool_info_edit/{id}")
    public ModelAndView pool_info_edit(@PathVariable("id") String id) throws ParseException {
        ModelAndView mv = new ModelAndView();
        PoolEvent pe = service.FindThisPoolEvnet(id);
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date start_date = fmt.parse(pe.getStart_time());
        Date end_date = fmt.parse(pe.getEnd_time());
        String start_time = fmt.format(start_date);
        String end_time = fmt.format(end_date);
        pe.setStart_time(start_time);
        pe.setEnd_time(end_time);
        mv.setViewName("pool_info_edit");
        mv.addObject("ThisPoolEvnet", pe);
        return mv;
    }

    @GetMapping("/pool_info_add")
    public ModelAndView pool_info_add() {
        ModelAndView mv = new ModelAndView();
        int id = service.FindFinalPoolEventID() + 1;
        mv.setViewName("pool_add");
        mv.addObject("id", id);
        return mv;
    }

    @RequestMapping(value = "/to_change_this_pool", method = RequestMethod.POST)
    @ResponseBody
    public String to_change_this_pool(@RequestParam(value = "fjson") String fjson) {
        PoolEvent pe = JSON.parseObject(fjson, PoolEvent.class);
        int i = service.ChangeThisIdPoolEvent(pe);
        if (i != 0) {
            return "success";
        } else {
            return "error_1";
        }
    }

    @RequestMapping(value = "/to_add_this_pool", method = RequestMethod.POST)
    @ResponseBody
    public String to_add_this_pool(@RequestParam(value = "fjson") String fjson, @RequestParam(value = "get_sel_4") String get_sel_4, @RequestParam(value = "get_sel_5") String get_sel_5) {
        ArrayList<Integer> fiveRole = new ArrayList<>(Arrays.asList(1004, 1010, 1019, 1020, 1021));
        ArrayList<Integer> fiveWeapon = new ArrayList<>(Arrays.asList(2009, 2010, 2020, 2021, 2031, 2032, 2037, 2038, 2049, 2050));
        ArrayList<Integer> threeWeapon = new ArrayList<>(Arrays.asList(2001, 2002, 2003, 2012, 2013, 2014, 2023, 2024, 2025, 2033, 2040, 2041, 2042));
        PoolEvent pe = JSON.parseObject(fjson, PoolEvent.class);
        service.AddNewPoolEvnet(pe);
        PoolEvent get_new_pool_event = service.FindThisTypePool(pe.getWish_type()).get(0);
        int get_new_poolevent_id = get_new_pool_event.getId();
        JSONArray jsonArray4 = JSONArray.parseArray(get_sel_4);
        JSONArray jsonArray5 = JSONArray.parseArray(get_sel_5);
        List<Unit> un = unitService.FindThisRarityAll();
        List<Integer> all_unit_ID = new ArrayList<>();
        List<UnitMap> un_is_up = new ArrayList<UnitMap>();
        UnitMap unitMap = null;
        if (pe.getWish_type() == 3) {
            all_unit_ID.addAll(fiveRole);
            all_unit_ID.addAll(threeWeapon);
        } else if (pe.getWish_type() == 2) {
            all_unit_ID.addAll(fiveWeapon);
            all_unit_ID.addAll(threeWeapon);
        } else if (pe.getWish_type() == 1) {
            System.out.printf("122222222222222222222222222222222222222223");
            List<Unit> allSBQY = unitService.Find_Unit_Type_3();
            for(int i=0;i<allSBQY.size();i++){
                System.out.println("size"+allSBQY.size());
                if(allSBQY.get(i).getRarity()==5){
                    all_unit_ID.add(allSBQY.get(i).getId());
                    System.out.printf(allSBQY.get(i).getId()+"---");
                }

            }
        }
        for (int i = 0; i < un.size(); i++) {
            if (un.get(i).getId() == 1001 || un.get(i).getId() == 1002 || un.get(i).getId() == 1003) {
                continue;
            } else if (pe.getWish_type()==1) {
                continue;
            } else {
                all_unit_ID.add(un.get(i).getId());
            }
        }


        for (int i = 0; i < jsonArray4.size(); i++) {
            KeyValue keyValue = JSON.parseObject(jsonArray4.get(i).toString(), KeyValue.class);
            all_unit_ID.add(keyValue.getValue());
        }

        for (int i = 0; i < jsonArray5.size(); i++) {
            KeyValue keyValue = JSON.parseObject(jsonArray5.get(i).toString(), KeyValue.class);
            all_unit_ID.add(keyValue.getValue());
        }
        for(int i=0;i<all_unit_ID.size();i++){
            System.out.println(all_unit_ID.get(i));
        }
        all_unit_ID = all_unit_ID.stream().distinct().collect(Collectors.toList());
        System.out.printf("------------------");
        for(int i=0;i<all_unit_ID.size();i++){
            System.out.println(all_unit_ID.get(i));
        }
        for (int i = 0; i < all_unit_ID.size(); i++) {
            if(all_unit_ID.get(i)==1001||all_unit_ID.get(i)==1002||all_unit_ID.get(i)==1003){

            }else {
                unitMap = new UnitMap();
                unitMap.setUnit_id(all_unit_ID.get(i));
                unitMap.setIs_up(0);
                unitMap.setWish_event_id(get_new_poolevent_id);
                un_is_up.add(unitMap);
            }
        }
        for (int i = 0; i < jsonArray4.size(); i++) {
            KeyValue keyValue = JSON.parseObject(jsonArray4.get(i).toString(), KeyValue.class);
            if(keyValue.getValue()==1001||keyValue.getValue()==1002||keyValue.getValue()==1003){

            }else {
                for (int j = 0; j < un_is_up.size(); j++) {
                    if (un_is_up.get(j).getUnit_id() == keyValue.getValue()) {
                        un_is_up.get(j).setIs_up(1);
                    }
                }
            }

        }

        if(pe.getWish_type()==3){
            for(int k=0;k<fiveRole.size();k++){
                for(int i=0;i<un_is_up.size();i++){
                    if(un_is_up.get(i).getUnit_id()==fiveRole.get(k)){
                        un_is_up.get(i).setIs_up(0);
                    }
                }

            }
        } else if (pe.getWish_type()==2) {
            for(int k=0;k<fiveWeapon.size();k++){
                for(int i=0;i<un_is_up.size();i++){
                    if(un_is_up.get(i).getUnit_id()==fiveWeapon.get(k)){
                        un_is_up.get(i).setIs_up(0);
                    }
                }
            }
        }
        for(int k=0;k<threeWeapon.size();k++){
            for(int i=0;i<un_is_up.size();i++){
                if(un_is_up.get(i).getUnit_id()==threeWeapon.get(k)){
                    un_is_up.get(i).setIs_up(0);
                }
            }
        }

        for (int i = 0; i < jsonArray5.size(); i++) {
            KeyValue keyValue = JSON.parseObject(jsonArray5.get(i).toString(), KeyValue.class);
            for (int j = 0; j < un_is_up.size(); j++) {
                if (un_is_up.get(j).getUnit_id() == keyValue.getValue()) {
                    un_is_up.get(j).setIs_up(1);
                }
            }
        }

        List<String> rusult_str = new ArrayList<>();
//        int id =mapService.FindLastUnitMap().getId();
        for (int i = 0; i < un_is_up.size(); i++) {
//            un_is_up.get(i).setId(id+1);
            int x = mapService.AddPoolUnitMap(un_is_up.get(i));
            System.out.println(un_is_up.get(i).getUnit_id());
            if (x != 0) {
                rusult_str.add("success");
            } else {
                rusult_str.add("error_1");
            }
//            id++;
        }
        rusult_str = rusult_str.stream().distinct().collect(Collectors.toList());

        if (rusult_str.size() == 1) {
            return "success";
        } else {
            return "error_1";
        }


//        for(int j = 0; j < get_sel_4.size(); j++) {
//
//        }
//
//
//        int i = service.ChangeThisIdPoolEvent(pe);
//        if (i != 0) {
//            return "success";
//        } else {
//            return "error_1";
//        }
//        return "error_1";
    }

    @RequestMapping(value = "/del_this_id_pool", method = RequestMethod.POST)
    @ResponseBody
    public String del_this_id_pool(@RequestParam(value = "fjson") String fjson) {
        System.out.println(fjson);
        int i = service.RemoveThisPoolEvent(Integer.parseInt(fjson));
        if (i != 0) {
            return "success";
        } else {
            return "error_1";
        }


    }

    public List<Object> objToList(Object obj) {
        List<Object> list = new ArrayList<Object>();
        if (obj instanceof ArrayList<?>) {
            for (Object o : (List<?>) obj) {
                list.add(o);
            }
            return list;
        }
        return null;
    }

}
