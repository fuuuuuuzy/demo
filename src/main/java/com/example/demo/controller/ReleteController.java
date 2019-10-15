package com.example.demo.controller;

import com.example.demo.entity.Relate;
import com.example.demo.service.RelateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/relate")
public class ReleteController {
    @Autowired
    RelateService service;

    @RequestMapping("/select/{id}/{rType}/{rToType}")
    @ResponseBody
    public Relate selectRelate(@PathVariable("id")int id, @PathVariable("rType") String rType, @PathVariable("rToType") String rToType){
        if ((service.selectRelate(id,rType,rToType))!=null){
            Relate relate = service.selectRelate(id,rType,rToType);
            return relate;
        }else {
            return null;
        }
    }

    @RequestMapping("/insert")
    @ResponseBody
    public int insertRelate(@ModelAttribute Relate relate){
        return service.insertRelate(relate);
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public int deleteRelate(@PathVariable("id")int id){
        return service.deleteRelate(id);
    }
}
