package com.springboot.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.bean.PCompany;
import com.springboot.bean.User;

@Repository
public interface PCompanyDao extends CommonDao<PCompany>{
	List<PCompany> findBycompanyprovinceIs(String string);	

}
