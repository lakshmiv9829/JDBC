package com.xworkz.matrimonyApplication;

import java.util.ArrayList;
import java.util.List;

import com.xworkz.matrimonydao.MatrimonyDAO;
import com.xworkz.matrimonydao.MatrimonyDAOImpl;
import com.xworkz.matrimonydto.BrideDTO;
import com.xworkz.matrimonyservice.MatrimonyService;
import com.xworkz.matrimonyservice.MatrimonyServiceImpl;

public class UpdateBride {

	public static void main(String[] args) {
		BrideDTO bride1 = new BrideDTO();
		bride1.setId(4);
		bride1.setName("nagashree");
		bride1.setAge(22);
		bride1.setHeight(6.0);
		bride1.setWeight(42);
		bride1.setQualification("M-tech");
		bride1.setPhone_number("8625686434212");
		bride1.setExpectation("BE");
		bride1.setSalary(800000);
		bride1.setOccupatation("Engineer");

		BrideDTO bride2 = new BrideDTO();
		bride2.setId(7);
		bride2.setName("Lalitha");
		bride2.setAge(23);
		bride2.setHeight(4.2);
		bride2.setWeight(50);
		bride2.setQualification("M-tech");
		bride2.setPhone_number("8625919382");
		bride2.setExpectation("BE");
		bride2.setSalary(600000);
		bride2.setOccupatation("SE");
		
		MatrimonyDAO matrimonyDAO = new MatrimonyDAOImpl();
		MatrimonyService matrimonyService = new MatrimonyServiceImpl(matrimonyDAO);

		List<BrideDTO> brides = new ArrayList<BrideDTO>();
		brides.add(bride1);
		brides.add(bride2);

		int[] results = matrimonyService.validateAndUpdateBrides(brides);
		for (int i = 0; i < results.length; i++) {
			if (results[i] == 0) {
				System.out.println(brides.get(i).getName() +" "+ "bride is failed to update");

			} else {
				System.out.println(brides.get(i).getName() +" "+ "bride is updated");
			}
		}


	}

}
