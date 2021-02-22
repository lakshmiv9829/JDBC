package com.xworkz.matrimonyApplication;

import com.xworkz.matrimonydao.MatrimonyDAO;
import com.xworkz.matrimonydao.MatrimonyDAOImpl;
import com.xworkz.matrimonydto.BrideDTO;
import com.xworkz.matrimonyservice.MatrimonyService;
import com.xworkz.matrimonyservice.MatrimonyServiceImpl;

public class PhoneNumberApplication {

	public static void main(String[] args) {
		MatrimonyDAO matrimonydao=new MatrimonyDAOImpl();
		MatrimonyService service=new MatrimonyServiceImpl(matrimonydao);
		BrideDTO bride=new BrideDTO();
		int result = service.validateAndUpdatePhone("9678998766", 1);
		if (result == 1) {
			System.out.println("phone number is updated");
		} else {
			System.out.println("phone number is not updated");
		}

	}

}
