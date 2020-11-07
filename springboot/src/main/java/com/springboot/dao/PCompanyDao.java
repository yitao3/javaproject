package com.springboot.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.bean.PCompany;

@Repository
public interface PCompanyDao extends CommonDao<PCompany>{
	List<PCompany> findBycompanyprovinceIs(String string);	
}
