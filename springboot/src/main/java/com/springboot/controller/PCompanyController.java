package com.springboot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import com.springboot.service.PCompanyService;
import com.springboot.bean.PCompany;

@Controller
public class PCompanyController {
	@Autowired
	private PCompanyService pcompanyServie; 
	
	@RequestMapping("/compage")
    public String compage(Model model, @RequestParam(value = "pageNum", defaultValue = "0") int pageNum, @RequestParam(value = "pageSize", defaultValue = "200") int pageSize) {
        System.out.println("============================");
        Page<PCompany> PCompanys=pcompanyServie.getComList(pageNum, pageSize);
        System.out.println("总页数" + PCompanys.getTotalPages());
        System.out.println("当前页是：" + pageNum);
        System.out.println("分页数据：");
        Iterator<PCompany> u = PCompanys.iterator();
        while (u.hasNext()){

            System.out.println(u.next().toString());
        }
        model.addAttribute("pcompanys", PCompanys);
        return "compage";
    }
}