package com.springboot.service;

import org.springframework.data.domain.Page;

import com.springboot.bean.Condition;
import com.springboot.bean.PCompany;

public interface PCompanyService {

	Page<PCompany> getComList(int pageNum, int pageSize,String tp,String district);
	void save(Condition cond);
}