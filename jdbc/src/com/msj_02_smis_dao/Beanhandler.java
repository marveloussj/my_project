package com.msj_02_smis_dao;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Beanhandler<T> implements IStudentHandler<T> {
	private Class<T> clz;

	public Beanhandler(Class<T> clz) {
		this.clz = clz;
	}

	@Override
	public T handle(ResultSet rs) throws SQLException {
		try {
			T obj = clz.newInstance();
			BeanInfo info = Introspector.getBeanInfo(clz, Object.class);
			PropertyDescriptor[] pds = info.getPropertyDescriptors();
			if (rs.next()) {
				for (PropertyDescriptor pd : pds) {
					String name = pd.getName();
					Object value = rs.getObject(name);
					pd.getWriteMethod().invoke(obj, value);
				}

			}return obj;
		} catch (Exception e) {
			throw new RuntimeException();
		}

		
	}

}
