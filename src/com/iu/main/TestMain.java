package com.iu.main;

import com.iu.countries.CountriesDAO;
import com.iu.regions.RegionsDAO;

public class TestMain {

	public static void main(String[] args) {
		RegionsDAO regionsDAO = new RegionsDAO();
		CountriesDAO countriesDAO = new CountriesDAO();
		try {
			regionsDAO.getList();
			countriesDAO.getList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
