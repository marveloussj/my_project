package com.msj_02_smis_dao;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BeanListhandler<T> implements IStudentHandler<List<T>>{
	private Class<T> clz;

	public BeanListhandler(Class<T> clz) {
		this.clz = clz;
	}
	@Override
	public List<T> handle(ResultSet rs) throws SQLException {
		try {
			List<T> list= new ArrayList<>();
			while (rs.next()) {T obj = clz.newInstance();
			BeanInfo info = Introspector.getBeanInfo(clz, Object.class);
			PropertyDescriptor[] pds = info.getPropertyDescriptors();
				for (PropertyDescriptor pd : pds) {
					String name = pd.getName();
					Object value = rs.getObject(name);
					pd.getWriteMethod().invoke(obj, value);
				}

			}
			return list;
		} catch (Exception e) {
			throw new RuntimeException();
	}

}}
