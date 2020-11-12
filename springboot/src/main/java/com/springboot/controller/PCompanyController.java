package com.springboot.controller;

import com.springboot.bean.Condition;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import com.springboot.service.PCompanyService;
import com.springboot.bean.PCompany;

@Controller
public class PCompanyController {
	@Autowired
	private PCompanyService pcompanyService; 
	
	@RequestMapping("/compage")
    public String compage(Model model, @RequestParam(value = "pageNum", defaultValue = "0") int pageNum, @RequestParam(value = "pageSize", defaultValue = "50") int pageSize,@ModelAttribute("type") String tp) {
    	System.out.println("type是:"+tp);
		System.out.println("============================");
        Page<PCompany> PCompanys=pcompanyService.getComList(pageNum, pageSize,tp);
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
	
	  @RequestMapping(value="/save",method = RequestMethod.POST)
		public String buildRequest(HttpServletRequest request){			
			// 方式一：getParameterMap()，获得请求参数map
			Map<String,String> parmMap=new HashMap<String,String>();
			Map<String,String[]> map= request.getParameterMap();
			//参数名称
			Set<String> key=map.keySet();
			//参数迭代器
			Iterator<String> iterator = key.iterator();
			while(iterator.hasNext()){
				String k=iterator.next();
				parmMap.put(k, map.get(k)[0]);
			}
			System.out.println("parmMap====="+parmMap.toString());
			return "compage";
	  }
	    @RequestMapping("/search123")
		public String search(RedirectAttributes attr,@RequestParam("type") String str){			
	    	attr.addFlashAttribute("type",str);
	    	System.out.println("str是:"+str);
	        return "redirect:/compage";

	  }
	    @RequestMapping(value="/search", method=RequestMethod.GET)
	    public String sayHelloForm(Model model) {
	        model.addAttribute("condition", new Condition());
	        return "search";
	    }

	    //表单提交，进行处理，并返回结果页面
	    @RequestMapping(value="/test", method=RequestMethod.POST)
	    public String sayHello(@ModelAttribute Condition condition, Model model) throws Exception {
	    	System.out.println("str是:"+condition.getconditionName());
	        return "";
	    }
}
