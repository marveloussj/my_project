package com.msj_03register;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyRegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//不支持get方法，支持post方法，推荐
		req.setCharacterEncoding("UTF-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		//先解码再编码，比较麻烦。
		/*byte[] bytes=username.getBytes("ISO-8859-1");
		username=new String(bytes,"UTF-8");*/
		System.out.println(username);
		System.out.println(password);
	}
}
