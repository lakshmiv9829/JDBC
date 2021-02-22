package com.xworkz.matrimonydao;

import java.util.List;

import com.xworkz.matrimonydto.BrideDTO;

public interface MatrimonyDAO {
	public BrideDTO getById(int id);
	public BrideDTO getAll();
	public int create(BrideDTO bride);
	public int updatePhone(String phone_Number,int id);
	public int delete(int id);
	public int[] insertBride(List<BrideDTO>brides);
	public int[] updateBride(List<BrideDTO>brides);
	public int[] deleteBridesUsingPreparedStmt(List<Integer> ids);
	
	
}
