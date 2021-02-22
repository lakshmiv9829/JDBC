package com.xworkz.matrimonyApplication;

import com.xworkz.matrimonydao.MatrimonyDAO;
import com.xworkz.matrimonydao.MatrimonyDAOImpl;
import com.xworkz.matrimonydto.BrideDTO;
import com.xworkz.matrimonyservice.MatrimonyService;
import com.xworkz.matrimonyservice.MatrimonyServiceImpl;

public class DeleteApplication {

	public static void main(String[] args) {
		MatrimonyDAO matrimonydao=new MatrimonyDAOImpl();
		MatrimonyService service=new MatrimonyServiceImpl(matrimonydao);
		BrideDTO bride=new BrideDTO();
		
		int result = service.validateAndDelete(4);
		if (result == 1) {
			System.out.println("Deleted Successfully");
		} else {
			System.out.println("not deleted");
		}
	}

}
