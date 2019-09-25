package com.exam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmpDao {

	private static final EmpDao instance = new EmpDao();

	public static EmpDao getInstance() {
		return instance;
	}
	
	private EmpDao() {
	}
	
	
	//차트 불러오기 메소드
	public List<Map<String,Object>>getCountAndMaxSalGroupByJob(){
		
		 List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		 
		 Connection con = null;
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 String sql ="";
		 
		 try {
			con=DBManager.getConnection();
			
			sql ="select job, count(*) as cnt, round(max(sal)*0.001) as maxsal";
			sql +=" from emp ";
			sql +=" group by job";
			sql +=" order by job asc";
			
			pstmt = con.prepareStatement(sql);
			rs= pstmt.executeQuery();
			
			
			while(rs.next()) {
				
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("job", rs.getString("job"));
				map.put("cnt", rs.getInt("cnt"));
				map.put("maxsal", rs.getInt("maxsal"));
				
				list.add(map);
				
				
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
		 
		return list;
	}//getCountAndMaxSalGroupByJob





















}//empdao
