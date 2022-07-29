package com.iu.main;

import java.util.ArrayList;

import com.iu.countries.CountriesDAO;
import com.iu.countries.CountriesDTO;
import com.iu.countries.CoutriesView;
import com.iu.employees.EmployeesDAO;
import com.iu.regions.RegionsDAO;
import com.iu.regions.RegionsDTO;
import com.iu.regions.RegionsView;

public class TestMain {

	public static void main(String[] args) {
		RegionsDAO regionsDAO = new RegionsDAO();
		CountriesDAO countriesDAO = new CountriesDAO();
		RegionsView regionsView = new RegionsView();
		CoutriesView coutriesView = new CoutriesView();
		
		ArrayList<RegionsDTO> regions = new ArrayList();
		ArrayList<CountriesDTO> countries = new ArrayList();
		EmployeesDAO employeesDAO = new EmployeesDAO();
		try {
//			employeesDAO.getSalaryInfo();
//			RegionsDTO regionsDTO = new RegionsDTO();
//			regionsDTO.setRegion_id(6);
//			regionsDTO.setRegion_name("Mars");
//			regionsDAO.setRegion(regionsDTO);
//			regions = regionsDAO.getList();
//			regionsView.view(regions);
//			RegionsDTO region = regionsDAO.getDetail(2);
//			regionsView.view(region);
//			
//			CountriesDTO countriesDTO = new CountriesDTO();
//			countriesDTO.setCountry_id("CU");
//			countriesDTO.setCountry_name("Cuba");
//			countriesDTO.setRegion_id(2);
//			countriesDAO.setCountry(countriesDTO);
			countries = countriesDAO.getList();
			coutriesView.view(countries);
//			CountriesDTO country =  countriesDAO.getDetail("AR");
//			coutriesView.view(country);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
