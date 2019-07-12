package com.ui.web.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ParseValue {
	public JSONArray parse(JSONObject json_obj) {
		
		JSONObject json = json_obj.getJSONArray("payconf").getJSONObject(0);
		System.out.println(json.toString());
		JSONArray list = json.getJSONArray("list");
		System.out.println(list.toString());
		return list;
		
		
	}
	//处理list数据
	public Map<String, String> get_val(JSONArray list) {
		
		Iterator<JSONObject> it = list.iterator();
		Map<String,String> map_list = new HashMap<String,String>();
		
		while(it.hasNext()) {
			JSONObject json = it.next();
			String actid = json.getString("actid");
			String activeId = json.getString("activeId");
			String acttips = json.getString("acttips");
			String cashlist = json.getString("cashlist").toString();
			Boolean isselect = json.getBoolean("isselect");
			String month = json.getString("month");
			String original_cost = json.getString("original_cost");
			String other_name = json.getString("other_name");
			JSONArray payway = json.getJSONArray("payway");
			String price = json.getString("price");
			String prime_cost = json.getString("prime_cost");
			String productId = json.getString("productId");
			String productName = json.getString("productName");
			String tips = json.getString("tips");
			String usecash = json.getString("usecash");
			
			map_list.put("actid", actid);
			map_list.put("activeId", activeId);
			map_list.put("acttips", acttips);
			map_list.put("cashlist", cashlist);
			map_list.put("isselect", isselect.toString());
			map_list.put("month", month);
			map_list.put("original_cost", original_cost);
			map_list.put("other_name", other_name);
			map_list.put("payway", payway.toString());
			map_list.put("price", price);
			map_list.put("prime_cost", prime_cost);
			map_list.put("productId", productId);
			map_list.put("productName", productName);
			map_list.put("tips", tips);
			map_list.put("usecash", usecash);
			
			
			System.out.println(map_list.get(activeId)+"fertrytr");
		}
		return map_list;
		
	}
}
