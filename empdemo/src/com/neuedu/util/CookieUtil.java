package com.neuedu.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;

public class CookieUtil {

	public static Map<String, Cookie> cookieToMap(Cookie[] cookies){
		Map<String, Cookie> cookiemap = new HashMap<String, Cookie>();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				cookiemap.put(cookie.getName(), cookie);
			}
		}
		return cookiemap;
	}
	
}
