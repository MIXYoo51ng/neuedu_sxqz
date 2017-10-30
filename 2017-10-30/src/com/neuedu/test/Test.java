package com.neuedu.test;

import java.util.ArrayList;
import java.util.List;

import com.neuedu.entity.User;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Test {
	public static void main(String[] args) {
		User user = new User("zs", "1234");
//		String testjson = "{";
//		testjson += "\"username\":";
//		testjson += "\"zs\"";
//		testjson += ",";
//		testjson += "\"password\":";
//		testjson += "1234}";
//		System.out.println(testjson);
		//fromBean方法能把java对象转化成json对象
//		JSONObject json = JSONObject.fromBean(user);
//		User user1 = (User) JSONObject.toBean(json, User.class);
//		System.out.println(user1.getUsername());
		List<User> userlist = new ArrayList<User>();
		userlist.add(new User("zs","1234"));
		userlist.add(new User("ls","123456"));
		userlist.add(new User("ww","123456789"));
		//将集合转化为json
		JSONArray json = JSONArray.fromCollection(userlist);
		System.out.println(json);
	}
}
