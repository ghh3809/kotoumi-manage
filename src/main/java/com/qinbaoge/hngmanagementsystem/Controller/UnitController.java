package com.qinbaoge.hngmanagementsystem.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qinbaoge.hngmanagementsystem.Entity.PoolEvent;
import com.qinbaoge.hngmanagementsystem.Entity.Unit;
import com.qinbaoge.hngmanagementsystem.Service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class UnitController {
    @Autowired
    private UnitService unitService;

    public JSONObject jsonObject(Object data) {
        JSONObject obj = new JSONObject();
        //前台通过key值获得对应的value值
        obj.put("code", 0);
        obj.put("msg", "");
        obj.put("count", 1000);
        obj.put("data", data);
        return obj;
    }

    @RequestMapping("/unit_type")
    public ModelAndView unit_type() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("unit_type");
        mv.addObject("unit_type_1", jsonObject(unitService.Find_Unit_Type_1()));
        mv.addObject("unit_type_2", jsonObject(unitService.Find_Unit_Type_2()));
        mv.addObject("unit_type_3", jsonObject(unitService.Find_Unit_Type_3()));
        return mv;
    }

    @RequestMapping("/unit_type_sel/{type}")
    @ResponseBody
    public String unit_type(@PathVariable("type") int type) {
        Object data = "";
        if (type == 1) {
            data = unitService.Find_Unit_Type_1();
        } else if (type == 2) {
            data = unitService.Find_Unit_Type_2();
        } else if (type == 3) {
            data = unitService.Find_Unit_Type_3();
        } else {
            return "error_1";
        }

        return jsonObject(data).toJSONString();
    }

    @RequestMapping("/unit_type_add")
    public ModelAndView unit_type_add() {
        ModelAndView mv = new ModelAndView();
        int id = unitService.FindFinalIdByUnitType(1) + 1;
        mv.setViewName("unit_type_add");
        mv.addObject("ThisUnitTypeID", id);
        return mv;
    }

    @GetMapping("/unit_type_edit/{id}")
    public ModelAndView unit_type_edit(@PathVariable("id") String id) throws ParseException {
        ModelAndView mv = new ModelAndView();
        Unit un = unitService.FindThisUnitType(id);
        mv.setViewName("unit_type_edit");
        mv.addObject("ThisUnitType", un);
        return mv;
    }

    @RequestMapping(value = "/to_change_this_unit_type_id", method = RequestMethod.POST)
    @ResponseBody
    public String to_change_this_unit_type_id(@RequestParam(value = "fjson") String fjson) {
        int this_unit_type_final_id = JSON.parseObject(fjson, Integer.class);
        return String.valueOf(unitService.FindFinalIdByUnitType(this_unit_type_final_id) + 1);
    }

    @RequestMapping(value = "/to_change_this_unit", method = RequestMethod.POST)
    @ResponseBody
    public String to_change_this_unit(@RequestParam(value = "fjson") String fjson) {
        Unit un = JSON.parseObject(fjson, Unit.class);
        int i = unitService.ChangeThisIdUnit(un);
        if (i != 0) {
            return "success";
        } else {
            return "error_1";
        }
    }

    @RequestMapping(value = "/del_this_id_unit", method = RequestMethod.POST)
    @ResponseBody
    public String del_this_id_unit(@RequestParam(value = "fjson") String fjson) {
        System.out.println(fjson);
        int i = unitService.RemoveThisUnit(Integer.parseInt(fjson));
        if (i != 0) {
            return "success";
        } else {
            return "error_1";
        }

    }

    @RequestMapping(value = "/to_add_this_unit", method = RequestMethod.POST)
    @ResponseBody
    public String to_add_this_unit(@RequestParam(value = "fjson") String fjson) {
        Unit un = JSON.parseObject(fjson, Unit.class);
        int i = unitService.AddNewUnitType(un);
        if (i != 0) {
            return "success";
        } else {
            return "error_1";
        }

    }
}
