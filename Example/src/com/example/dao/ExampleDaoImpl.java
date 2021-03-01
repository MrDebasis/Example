package com.example.dao;

import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.example.dto.POJO1;
import com.example.repo.RepositoryUtils;

/*
 * this ExampleDaoImpl class implement the methods to access the database
 * */
public class ExampleDaoImpl implements ExampleDao {
	java.sql.Connection con = null;
	java.sql.PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;
	boolean b = false;
	PrintWriter out = new PrintWriter(System.out);

	private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	/*
	 * this method is used to fatch the data to database
	 * 
	 * @param List<POJO1> data
	 * 
	 * @return boolean
	 */
	@Override
	public boolean UpdateDetails(List<POJO1> data) {
		try {
			Class.forName(RepositoryUtils.getDriverName());
			LOGGER.info("fatching connection for database");
			con = DriverManager.getConnection(RepositoryUtils.getDbUrl());

			for (POJO1 details : data) {

				LOGGER.info("inserting datas in database UpdatedDetails method" + details.getBusiness_code());
				String query = "insert into tutorials_tbl values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, details.getBusiness_code());
				pstmt.setString(2, details.getCust_number());
				pstmt.setString(3, details.getName_customer());
				pstmt.setString(4, details.getClear_date());
				pstmt.setString(5, details.getBusiness_year());
				pstmt.setString(6, details.getDoc_id());
				pstmt.setString(7, details.getPosting_date());
				pstmt.setString(8, details.getDocument_create_date());
				pstmt.setString(9, details.getDue_in_date());
				pstmt.setString(10, details.getInvoice_currency());
				pstmt.setString(11, details.getDocument_type());
				pstmt.setString(12, details.getPosting_id());
				pstmt.setString(13, details.getArea_business());
				pstmt.setString(14, details.getTotal_open_amount());
				pstmt.setString(15, details.getBaseline_create_date());
				pstmt.setString(16, details.getCust_payment_terms());
				pstmt.setString(17, details.getInvoice_id());
				pstmt.setString(18, details.getIsOpen());

				int count = pstmt.executeUpdate();
				if (count > 0) {
					b = true;
				} else {
					b = false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return b;
	}

	/*
	 * this method retrives all the data which is present in database
	 * 
	 * @param List<POJO1> data
	 * 
	 * @return boolean
	 */
	@Override
	public List<POJO1> getall() {
		POJO1 pojo = new POJO1();
		List<POJO1> listOfDetails = new ArrayList<POJO1>();
		try {
			Class.forName(RepositoryUtils.getDriverName());

			LOGGER.info("fatching connection for database");
			con = DriverManager.getConnection(RepositoryUtils.getDbUrl());
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from  tutorials_tbl");
			while (rs.next()) {

				pojo.setBusiness_code(rs.getString("business_code"));
				pojo.setCust_number(rs.getString("cust_number"));
				pojo.setName_customer(rs.getString("name_customer"));
				pojo.setClear_date(rs.getString("clear_date"));
				pojo.setBusiness_year(rs.getString("business_year"));
				pojo.setDoc_id(rs.getString("doc_id"));
				pojo.setPosting_date(rs.getString("posting_date"));
				pojo.setDocument_create_date(rs.getString("document_create_date"));
				pojo.setDue_in_date(rs.getString("due_in_date"));
				pojo.setInvoice_currency(rs.getString("invoice_currency"));
				pojo.setDocument_type(rs.getString("document_type"));
				pojo.setPosting_id(rs.getString("posting_id"));
				pojo.setArea_business(rs.getString("area_business"));
				pojo.setTotal_open_amount(rs.getString("total_open_amount"));
				pojo.setBaseline_create_date(rs.getString("baseline_create_date"));
				pojo.setCust_payment_terms(rs.getString("cust_payment_terms"));
				pojo.setInvoice_id(rs.getString("invoice_id"));
				pojo.setIsOpen(rs.getString("isOpen"));
				listOfDetails.add(pojo);
				LOGGER.info("retrive data sucessfull");
				
			}
			System.out.println(listOfDetails);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return listOfDetails;

	}
}
