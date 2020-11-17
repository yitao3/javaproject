package com.springboot.service.impl;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.springboot.bean.Condition;
import com.springboot.bean.PCompany;
import com.springboot.bean.User;
import com.springboot.dao.PCompanyDao;
import com.springboot.service.PCompanyService;

@Service
public class PCompanyServiceimpl implements PCompanyService{
	@Autowired
	private PCompanyDao pcompanyDao;
    @Override
    public Page<PCompany> getComList(int pageNum, int pageSize,String type,String district) {
    	Specification<PCompany> spec = new Specification<PCompany>() {
    		/**
    		 * @param *root: 代表查询的实体类. 
    		 * @param query: 可以从中可到 Root 对象, 即告知 JPA Criteria 查询要查询哪一个实体类. 还可以
    		 * 来添加查询条件, 还可以结合 EntityManager 对象得到最终查询的 TypedQuery 对象. 
    		 * @param *cb: CriteriaBuilder 对象. 用于创建 Criteria 相关对象的工厂. 当然可以从中获取到 Predicate 对象
    		 * @return: *Predicate 类型, 代表一个查询条件. 
    		 */
    		@Override
    		public Predicate toPredicate(Root<PCompany> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
    			List<Predicate> listAnd=new ArrayList<>(); //组装and语句
                if(type == null || type.length() <= 0) {
                    listAnd.add(cb.like(root.get("type"), "%" +type ));  //姓名 模糊查询
                }

                Predicate predicateAnd = cb.and(listAnd.toArray(new Predicate[listAnd.size()])); //AND查询加入查询条件
                List<Predicate> listOr = new ArrayList<>();///组装or语句
            	String[] dists = district.split(",");
                if(dists!=null && dists.length>0) {
                    for (int i = 0 ; i<dists.length;i++) {
                        //爱好多选 用OR链接
                        listOr.add(cb.equal(root.get("companyprovince"),dists[i]));
                    }
                }
                Predicate predicateOR = cb.or(listOr.toArray(new Predicate[listOr.size()])); //OR查询加入查询条件
                return query.where(predicateAnd,predicateOR).getRestriction();
    		}
    	};
        //Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        System.out.println(spec);
        Page<PCompany> pcompanys = pcompanyDao.findAll(spec,pageable);

        return pcompanys;
    }
	public void save(Condition cond) {
		/*
		 * // TODO Auto-generated method stub pcompanyDao.save(cond);
		 * System.out.println(cond.getName());
		 */
	}
}
