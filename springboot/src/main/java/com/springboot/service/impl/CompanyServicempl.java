package com.springboot.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.springboot.bean.Company;
import com.springboot.service.CompanyService;

import com.springboot.dao.CompanyDao;


@Service
public class CompanyServicempl implements CompanyService{
	@Autowired
	private CompanyDao companyDao;

	@Override
	public List<Company> findByCompanyProv() {
	  String s = "广东";
      return companyDao.findBycompanyprovinceIs(s);
	}
}
