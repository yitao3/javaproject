package com.springboot.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.springboot.bean.Condition;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import com.springboot.service.PCompanyService;
import com.springboot.bean.PCompany;

@Controller
public class PCompanyController {
	@Autowired
	private PCompanyService pcompanyService; 
	
	@RequestMapping("/compage")
    public String compage(Model model, @RequestParam(value = "pageNum", defaultValue = "0") int pageNum, @RequestParam(value = "pageSize", defaultValue = "50") int pageSize,@ModelAttribute("type") String tp,@ModelAttribute("district") String dist) {
    	System.out.println("type是:"+dist);
		System.out.println("============================");
        Page<PCompany> PCompanys=pcompanyService.getComList(pageNum, pageSize,tp,dist);
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

	    @RequestMapping(value="/search", method=RequestMethod.GET)
	    public String sayHelloForm(Model model) {
	        model.addAttribute("condition", new Condition());
	        return "search";
	    }

	    //表单提交，进行处理，并返回结果页面
	    //@RequestMapping(value="/test", method=RequestMethod.POST)
	    //public String sayHello(@ModelAttribute Condition condition, Model model) throws Exception {
	    //	System.out.println("str是:"+condition.getconditionName());
	    //    return "";
	    //}
	    //表单提交，进行处理，并返回结果页面
	    @RequestMapping(value="/tosearch", method=RequestMethod.POST)
	    public String sayHello(@RequestParam("district") String district,@RequestParam(value="type") String type, Model model,RedirectAttributes attr) throws Exception {
	    	System.out.println("输出一："+district);
	    	System.out.println("输出二："+type);
	    	//model.addAttribute("type", "浙江");
	    	attr.addAttribute("district",district);
	    	attr.addAttribute("type",type);
	        return "redirect:/compage";
	    }
	    @RequestMapping(value="/tokenhead", method=RequestMethod.POST)
	    protected void doPost(HttpServletRequest request,
	            HttpServletResponse response, BufferedReader br)
	            throws ServletException, IOException {
	//Header部分
	        System.out.print(request.getHeaderNames());
	        Enumeration<?> enum1 = request.getHeaderNames();
	        while (enum1.hasMoreElements()) {
	            String key = (String) enum1.nextElement();
	            String value = request.getHeader(key);
	            System.out.println(key + "\t" + value);
	        }
	//body部分
	        String inputLine;
	        String str = "";
	        try {
	            while ((inputLine = br.readLine()) != null) {
	                str += inputLine;
	            }
	            br.close();
	        } catch (IOException e) {
	            System.out.println("IOException: " + e);
	        }
	        System.out.println("str:" + str);
	    }
	    @RequestMapping(value="/tokenbody", method=RequestMethod.POST)
	    protected void doPostbody(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			String nickname = request.getParameter("name");
			String region = request.getParameter("user");
			System.out.println("nickname:" + nickname);
			System.out.println("region:" + region);
			}
	    @RequestMapping(value="/token")
	    protected String token(){
	    	return "token";
	    }
}
