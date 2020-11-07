package com.springboot.service;

import java.util.List;

import com.springboot.bean.Company;

public interface CompanyService {

/**
 * 获取所有用户对象
 * @return
 */
List<Company> findByCompanyProv();
}
