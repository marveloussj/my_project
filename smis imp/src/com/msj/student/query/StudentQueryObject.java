package com.msj.student.query;

import java.util.ArrayList;
import java.util.List;

import com.msj.student.util.StringUtil;

public class StudentQueryObject {
private String studentName;
private Integer minAge;
private Integer maxAge;
private List<Object> params=new ArrayList<>();
public List<Object> getParams() {
	return params;
}
public StudentQueryObject() {
}
public String getQuery(){
	
	List<String> conditions =new ArrayList<>();
	if(StringUtil.haslength(studentName)){
		conditions.add(" name like ? ");
		params.add("%"+studentName+"%");
	}
	if(minAge!=null){
		conditions.add(" age >= ? ");
		params.add(minAge);
	}
	if(maxAge!=null){
		conditions.add(" age <= ? ");
		params.add(maxAge);
	}
	StringBuilder sql=new StringBuilder();
	if(conditions.size()>0){
		sql.append(" where ");
		sql.append(org.apache.commons.lang3.StringUtils.join(conditions, " and "));
	}
	return sql.toString(); 
}
public String getStudentName() {
	return studentName;
}
public void setStudentName(String studentName) {
	this.studentName = studentName;
}
public Integer getMinAge() {
	return minAge;
}
public void setMinAge(Integer minAge) {
	this.minAge = minAge;
}
public Integer getMaxAge() {
	return maxAge;
}
public void setMaxAge(Integer maxAge) {
	this.maxAge = maxAge;
}
}
