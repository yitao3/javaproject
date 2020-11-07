package com.springboot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import com.springboot.service.CompanyService;
import com.springboot.bean.Company;

@Controller
public class CompanyController {
	@Autowired
	private CompanyService companyServie; 

@RequestMapping("/comList")
public String comList(Model model) {
    List<Company> comList = companyServie.findByCompanyProv();
    model.addAttribute("comList", comList);
    return "comlist";
}
}