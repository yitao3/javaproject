package com.springboot.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "company")
public class PCompany extends BaseBean implements Serializable{

		@Column(name="company_name")
		public String companyname;
		@Column(name="company_province")
		public String companyprovince;
		@Column(name="telephone")
		public String telephone;
	 
		public String companyprovince() {
			return companyname;
		}
		public void setName(String name) {
			this.companyname = name;
		} 
		public void setProv(String company_province) {
			this.companyprovince = company_province;
		}
		public String getProv() {
			return companyprovince;
		}
	 
		public String gettelephone() {
			return telephone;
		}
	 
		public void setCell(String telephone) {
			this.telephone = telephone;
		}
	  
	 
	}