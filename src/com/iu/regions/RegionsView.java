package com.iu.regions;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RegionsView {
	//view
	public void view(ArrayList<RegionsDTO> regions) throws SQLException {
		for(RegionsDTO region: regions) {
			System.out.println(region.getRegion_id()+" " +region.getRegion_name());
		}
	}
	
	public void view(RegionsDTO region) {
		System.out.println(region.getRegion_id()+" "+region.getRegion_name());
	}
}
