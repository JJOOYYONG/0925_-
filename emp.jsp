<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="com.exam.dao.EmpDao"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%


	EmpDao empDao = EmpDao.getInstance();
	
	List<Map<String,Object>>list = empDao.getCountAndMaxSalGroupByJob();
	
	JSONArray jsonArray = new JSONArray();
	//열제목 JSONArray 준비하기
	JSONArray titleArray = new JSONArray();
	titleArray.add("직무");
	titleArray.add("총 인원수");
	titleArray.add("최고연봉");
	
	//열제목 JSOMArray 첫번째 요소로 추가
	jsonArray.add(titleArray);
	
	
	for(Map<String,Object>map : list){
		
		JSONArray rowArray = new JSONArray();
		rowArray.add(map.get("job"));
		rowArray.add(map.get("cnt"));
		rowArray.add(map.get("maxsal"));
		
		jsonArray.add(rowArray);
		
		
		
	}//for

%>

	<%=jsonArray%>


