package com.xworkz.matrimonyApplication;

import com.xworkz.matrimonydao.MatrimonyDAO;
import com.xworkz.matrimonydao.MatrimonyDAOImpl;
import com.xworkz.matrimonydto.BrideDTO;
import com.xworkz.matrimonyservice.MatrimonyService;
import com.xworkz.matrimonyservice.MatrimonyServiceImpl;

public class BrideApplication {

	public static void main(String[] args) {

		MatrimonyDAO matrimonyDAO = new MatrimonyDAOImpl();
		MatrimonyService matrimonyService = new MatrimonyServiceImpl(matrimonyDAO);
		BrideDTO bride = new BrideDTO();
		bride.setId(5);
		bride.setName("seema");
		bride.setAge(22);
		bride.setHeight(5.6);
		bride.setWeight(50);
		bride.setQualification("BE");
		bride.setPhone_number("8625683748");
		bride.setExpectation("BE");
		bride.setSalary(300000);
		bride.setOccupatation("developer");
		System.out.println(bride);
		int result = matrimonyService.validateAndCreateBride(bride);
		if (result == 1) {
			System.out.println("bride is created");
		} else {
			System.out.println("bride is not created");
		}

	}

}
