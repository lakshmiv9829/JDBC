package com.xworkz.matrimonyservice;

import java.util.List;

import com.xworkz.matrimonydao.MatrimonyDAO;
import com.xworkz.matrimonydto.BrideDTO;

public class MatrimonyServiceImpl implements MatrimonyService {
	private MatrimonyDAO matrimonyDAO;

	public MatrimonyServiceImpl(MatrimonyDAO matrimonyDAO) {
		this.matrimonyDAO = matrimonyDAO;
	}

	@Override
	public BrideDTO getBride(int id) {
		if (id == 0) {
			System.out.println("invalid id");
			return null;
		}

		return matrimonyDAO.getById(1);
	}

	@Override
	public BrideDTO getAllBride() {
		return matrimonyDAO.getAll();
	}

	@Override
	public int validateAndCreateBride(BrideDTO bride) {
		if (bride == null) {
			System.out.println("Bride can not be null");
			return 0;
		} else if (bride.getId() == 0) {
			System.out.println("invalid id");
			return 0;
		} else {
			return matrimonyDAO.create(bride);
		}
	}

	@Override
	public int validateAndUpdatePhone(String phone_number, int id) {

		if (id == 0 && phone_number == null) {
			System.out.println("invaild id");
			return 0;
		} else {
			return matrimonyDAO.updatePhone(phone_number, id);
		}

	}

	@Override
	public int validateAndDelete(int id) {
		if (id == 0) {
			System.out.println("invalid id");
			return 0;
		} else {
			return matrimonyDAO.delete(id);
		}
	}

	
//sql injection,callable stnt vs statement,store procuder;
	@Override
	public int[] validateAndInsertBrides(List<BrideDTO> brides) {
		if(brides==null ) {
			System.out.println("bride list is null");
			int[] result=new int[brides.size()];
			for(int i=0;i<result.length;i++) {
				result[i]=0;
			}
			return result;
	}
		else {
			return matrimonyDAO.insertBride(brides);
		}
	
		
	}

	@Override
	public int[] validateAndUpdateBrides(List<BrideDTO> brides) {
		if(brides==null) {
			System.out.println("Brides list can not be null");
			int[] result=new int [brides.size()];
			for(int i=0;i<result.length;i++) {
				result[i]=0;
			}
			return result;
		}else {
			return matrimonyDAO.updateBride(brides);
		}
	}

	@Override
	public int[] validateAndDeleteBrides(List<Integer> ids) {
		if (ids == null) {
			System.out.println("brides list can not be null");
			int[] results = new int[ids.size()];
			for (int i = 0; i < results.length; i++) {
				results[i] = 0;
			}
			return results;
		} else {
			return matrimonyDAO.deleteBridesUsingPreparedStmt(ids);
		}

	}

		
}
