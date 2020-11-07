package com.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springboot.bean.PCompany;
import com.springboot.dao.PCompanyDao;
import com.springboot.service.CompanyService;
import com.springboot.service.PCompanyService;

@Service
public class PCompanyServiceimpl implements PCompanyService{
	@Autowired
	private PCompanyDao pcompanyDao;

    @Override
    public Page<PCompany> getComList(int pageNum, int pageSize) {

        //Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<PCompany> pcompanys = pcompanyDao.findAll(pageable);

        return pcompanys;
    }
}
