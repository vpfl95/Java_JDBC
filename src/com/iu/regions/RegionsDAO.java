package com.iu.regions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.util.DBConnector;

public class RegionsDAO {
	
	//3.Regions에 데이터 추가
	public int setRegion(RegionsDTO region) throws Exception{
		//1.DB연결
		Connection con = DBConnector.getConnection();
		//2.sql 생성
		String sql = "INSERT INTO REGIONS VALUES(?,?)";
		//3.미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		//4.?값 처리
		st.setInt(1,region.getRegion_id());
		st.setString(2,region.getRegion_name());
		//5.최종 전송 후 결과 처리
		int result = st.executeUpdate();
		//6.자원해제
		DBConnector.disConnect(st, con);
		return result;
	}
	
	//2. Regions에서 하나의 결과(row)
	public RegionsDTO getDetail(int region_id) throws Exception{
		RegionsDTO region = null;
		
		//1.DB연결
		Connection con = DBConnector.getConnection();
	
		//2.SQL문 작성
		//String sql ="SELECT * FROM REGIONS WHERE REGION_ID=" + region_id;  //SQL injection 공격에 취약함
		String sql ="SELECT * FROM REGIONS WHERE REGION_ID=?";
		
		//3.미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. ?값 세팅
		// WHERE NUM BETWEEN ?(1) AND ?(2)인덱스;
		st.setInt(1, region_id);
		
		//5.최종 전송 후 결과 처리
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			region = new RegionsDTO();
			region.setRegion_id(rs.getInt(1));
			region.setRegion_name(rs.getString(2));

		}
		
		//6.자원 해제
		DBConnector.disConnect(rs, st, con);
		
		return region;
		
	}
	
	
	
	//1. Regions의 모든 데이터 가져오기
		public ArrayList<RegionsDTO> getList() throws Exception {

			ArrayList<RegionsDTO> regions = new ArrayList();
			
			//1.DB 연결
			Connection con = DBConnector.getConnection();
			
			//2. Query문 작성
			String sql = "SELECT * FROM REGIONS";
			
			//3.Query문 미리 전송
			PreparedStatement st = con.prepareStatement(sql);
			
			//4.
			
			//5.최종 전송 후 결과를 처리
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				RegionsDTO region = new RegionsDTO();
				region.setRegion_id(rs.getInt("Region_id"));
				region.setRegion_name(rs.getString("Region_name"));
				regions.add(region);
			}
			//6.자원 해제
			DBConnector.disConnect(rs, st, con);
			
			return regions;
			
		}
		
		
}
