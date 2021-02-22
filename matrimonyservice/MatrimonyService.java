package com.xworkz.matrimonyservice;

import java.util.List;

import com.xworkz.matrimonydto.BrideDTO;

public interface MatrimonyService {
public BrideDTO getBride(int id);
public BrideDTO getAllBride();
public int validateAndCreateBride(BrideDTO bride);
public int validateAndUpdatePhone(String phone_number,int id);
public int validateAndDelete(int id);
public int[] validateAndInsertBrides(List<BrideDTO>brides);
public int[] validateAndUpdateBrides(List<BrideDTO>brides);
public int[] validateAndDeleteBrides(List<Integer> ids);

}
