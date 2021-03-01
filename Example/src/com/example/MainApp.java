package com.example;

import java.util.List;

import com.example.dto.POJO1;
import com.example.service.ExampleService;

public class MainApp {
	public static void main(String[] args){
		ExampleService exampleService = new ExampleService();
		List<POJO1> data = exampleService.readCsvFile();
		System.out.println(data);
	}
}