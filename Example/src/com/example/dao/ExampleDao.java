package com.example.dao;

import java.util.List;

import com.example.dto.POJO1;

/*
 *this interface expose the methods for repository 
 * */
public interface ExampleDao {
	public boolean UpdateDetails(List<POJO1> data);

	public List<POJO1> getall();

}
