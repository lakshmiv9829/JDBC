package com.xworkz.matrimonyApplication;

import java.util.ArrayList;
import java.util.List;

import com.xworkz.matrimonydao.MatrimonyDAO;
import com.xworkz.matrimonydao.MatrimonyDAOImpl;
import com.xworkz.matrimonydto.BrideDTO;
import com.xworkz.matrimonyservice.MatrimonyService;
import com.xworkz.matrimonyservice.MatrimonyServiceImpl;

public class DeleteBrideApplication {

	public static void main(String[] args) {
		MatrimonyDAO dao = new MatrimonyDAOImpl();
		MatrimonyService service = new MatrimonyServiceImpl(dao);

		List<Integer> ids = new ArrayList<Integer>();
		ids.add(4);
		ids.add(7);
		int[] results = service.validateAndDeleteBrides(ids);
		for (int i = 0; i < results.length; i++) {
			if (results[i] == 0) {
				System.out.println(results[i] + "bride failed to delete");

			} else {
				System.out.println(results[i] + "bride deleted");
			}

		}
		
		}
	}


