package com.dao;

import java.util.List;

import com.dto.Instagram;
import com.exception.NOrecordFound;
import com.exception.SomeThingWentWrong;

public interface Inter {

	void AdddPrompt(Instagram a) throws SomeThingWentWrong;

	void UpdatePrompt(int id, String name) throws SomeThingWentWrong;

	void DeletePrompt(int id) throws SomeThingWentWrong;

	Instagram FindPrompt(int id) throws SomeThingWentWrong, NOrecordFound;

	List<Instagram> PrintPrompt() throws SomeThingWentWrong, NOrecordFound;

}
