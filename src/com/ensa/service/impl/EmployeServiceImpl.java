package com.ensa.service.impl;

import com.ensa.dao.impl.EmployeDaoImpl;
import com.ensa.entity.Employe;
import com.ensa.service.EmployeService;

public class EmployeServiceImpl implements EmployeService {

	@Override
	public Boolean seConnecter(String email, String password) {

		EmployeDaoImpl e = new EmployeDaoImpl();
		
		Employe emp=new Employe();
		emp.setEmail_empl(email);
		emp.setMot_passe_empl(password);
		int c=e.findByLoginMdp(email, password);
		//int c=e.login(email, password);
		if (c != 0) {
			return true;
		}else
			return false;
		
		}

}
