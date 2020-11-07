package com.springboot.dao;
 
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.bean.Company;

@Repository
public interface CompanyDao extends CommonDao<Company> {
 
List<Company> findBycompanyprovinceIs(String string);	
}