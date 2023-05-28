package com.dao;

import java.util.List;

import com.dto.Farmer;
import com.exception.NorecorsFounf;
import com.exception.SomethingWentWrong;

public interface Inter {

	void AddUi(Farmer a) throws SomethingWentWrong;

	void UpdateUi(Farmer a) throws SomethingWentWrong;

	void DeleteUi(int id) throws SomethingWentWrong;

	Farmer FindUi(int id) throws NorecorsFounf, SomethingWentWrong;

	List<Farmer> PrintUi() throws NorecorsFounf, SomethingWentWrong;

}
