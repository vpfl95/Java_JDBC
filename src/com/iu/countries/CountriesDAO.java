package com.iu.countries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.util.DBConnector;

public class CountriesDAO {
	//setCountry
	public int setCountry(CountriesDTO country) throws Exception{
		Connection con = DBConnector.getConnection();
		
		String sql = "INSERT INTO COUNTRIES VALUES(?,?,?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1,country.getCountry_id());
		st.setString(2, country.getCountry_name());
		st.setInt(3, country.getRegion_id());
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		
		return result;
	}
	
	
	
	//getDetail : country_id
	public CountriesDTO getDetail(String country_id) throws Exception {
		CountriesDTO country = null;
		
		Connection con = DBConnector.getConnection();
		
		String sql = "SELECT * FROM COUNTRIES WHERE COUNTRY_ID=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, country_id);
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			country = new CountriesDTO();
			country.setCountry_id(rs.getString("COUNTRY_ID"));
			country.setCountry_name(rs.getString("COUNTRY_NAME"));
			country.setRegion_id(rs.getInt("REGION_ID"));
		}
		
		//6.자원 해제
		DBConnector.disConnect(rs, st, con);
		
		return country;
	}
	
	public ArrayList<CountriesDTO> getList() throws Exception {
		
		ArrayList<CountriesDTO> countries = new ArrayList();
		
		Connection con = DBConnector.getConnection();
		
//		String sql = "SELECT * FROM COUNTRIES WHERE COUNTRY_ID LIKE ?";
		String sql = "SELECT * FROM COUNTRIES";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		// ? 있으면 값 세팅
		//st.setString(1, "%"+search+"%");
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			CountriesDTO country = new CountriesDTO();
			country.setCountry_id(rs.getString("COUNTRY_ID"));
			country.setCountry_name(rs.getString("COUNTRY_NAME"));
			country.setRegion_id(rs.getInt("REGION_ID"));
			countries.add(country);
		}
		
		//6.자원 해제
		DBConnector.disConnect(rs, st, con);
		
		return countries;
	}
	
}
