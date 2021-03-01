package com.example.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.example.dao.ExampleDao;
import com.example.dao.ExampleDaoImpl;
import com.example.dto.POJO1;

/*
 * this service class will read the data from sourcefile
 * */
public class ExampleService {
	private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	public List<POJO1> readCsvFile() {
		String line = "";
		String splitBy = ",";
		List<POJO1> user;
		List<POJO1> pojo2 = null ;
		try {
			
			/* parsing a CSV file into BufferedReader class constructor */
			BufferedReader br = new BufferedReader(new FileReader("resources/deba.csv"));

			LOGGER.info("reading the data from .csv file");
			while ((line = br.readLine()) != null) {

				String[] row = line.split(splitBy);

				POJO1 pojo = new POJO1();
				pojo.setBusiness_code(row[0]);
				pojo.setCust_number(row[1]);
				pojo.setName_customer(row[2]);
				pojo.setClear_date(row[3]);
				pojo.setBusiness_year(row[4]);
				pojo.setDoc_id(row[5]);
				pojo.setPosting_date(row[6]);
				pojo.setDocument_create_date(row[7]);
				pojo.setDue_in_date(row[8]);
				pojo.setInvoice_currency(row[9]);
				pojo.setDocument_type(row[10]);
				pojo.setPosting_id(row[11]);
				pojo.setArea_business(row[12]);
				pojo.setTotal_open_amount(row[13]);
				pojo.setBaseline_create_date(row[14]);
				pojo.setCust_payment_terms(row[15]);
				pojo.setInvoice_id(row[16]);
				pojo.setIsOpen(row[17]);

				LOGGER.info("Read all the values from .csv file");
				user = new ArrayList<POJO1>();
				user.add(pojo);
				ExampleDao DaoImpl = new ExampleDaoImpl();

				LOGGER.info("calling service method UpdateDetails()");
				DaoImpl.UpdateDetails(user);

				LOGGER.info("calling service method getall()");
				pojo2 = DaoImpl.getall();
			}
		} catch (IOException e) {
			LOGGER.info("exception occored while reading data from .csv file");
			e.printStackTrace();
		}
		return pojo2;
	}
}
