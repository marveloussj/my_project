package xyz.marsj.o2o.util;

import javax.servlet.http.HttpServletRequest;

public class CodeUtil {
	public static boolean checkVerifyCode(HttpServletRequest request){
		String verifyCodeReal = (String) request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		String verifyCodeWrite = HttpServletRequestUtil.getString(request,"verifyCode");
		 
		if(verifyCodeWrite==null || !verifyCodeWrite.equals(verifyCodeReal) ){
			if(verifyCodeWrite.toUpperCase().equals(verifyCodeReal.toUpperCase())){
				return true;
			}
			return false;
		}
		return true;
	}
}
