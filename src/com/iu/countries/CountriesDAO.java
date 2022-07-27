package com.iu.countries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.iu.util.DBConnector;

public class CountriesDAO {
	
	public void getList() throws Exception {
		Connection con = DBConnector.getConnection();
		
		String sql = "SELECT * FROM COUNTRIES";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			String cid = rs.getString("COUNTRY_ID");
			String cname = rs.getString("COUNTRY_NAME");
			int region_id = rs.getInt("REGION_ID");
			System.out.println(cid +" "+ cname +" "+ region_id);
		}
		
		
	}
	
}
