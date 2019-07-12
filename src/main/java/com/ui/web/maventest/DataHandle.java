package com.ui.web.maventest;

import com.google.gson.*;
import com.ui.web.util.PaymentBean;
import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;



public class DataHandle {
	String urlStr = "https://advertpay-vip-ssl.xunlei.com/web/paymentinfo?callback=jQuery1124012478060253752776_1562844226451&userid=690306594&sessionid=ws001.287D4134B05735825D3789B48F42E2C1&payconfid=&_=1562844226454";
	public Map<String, String> map = new HashMap<String, String>();
	public void sendGet(String urlStr) {
		StringBuilder stringBuilder = new StringBuilder();
		HttpURLConnection conn = null;
		URL url;
		try {
			System.out.println("23333333");
			url = new URL(urlStr);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
		    conn.setDoOutput(true);
		    conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36");
			conn.setRequestProperty("cookie","HABOWEBUID=c19125a338f7ec597254c5df67eb5ec5; UM_distinctid=16bc19facbc643-0fea7a565baaad-e343166-1fa400-16bc19facbd23e; deviceid=wdi10.9aef68b1cc7270328a03f70fe2cd6a2505d97d9e6173a25efd128e27952e2940; state=0; flowid=7cb45335-7004-49ff-9c87-4727c26ee82d; xftype=0; vip-superpay-orderid-notify-QR15625796528689969422454784=true; vip-superpay-orderid-notify-QR15625799507279319915214024=true; vip-superpay-orderid-notify-QR15625800429789975805180928=true; vip-superpay-orderid-notify-QR15625801712242224952498690=true; vip-superpay-orderid-notify-QR15625803511641172431896023=true; vip-superpay-orderid-notify-QR15625803929789981539771392=true; mref=501; referfrom=; version=1; XLA_CI=01efc22b89a8eb718cf69320a3636711; vipCookie=vip_sessionid%3Dws001.D9EB484FD590A82C2EA3B6B5E66FA4E6%26quickbird_paytype%3D0%26quickbird_growvalue%3D0%26quickbird_expiredate%3D----%26quickbird_level%3D0%26quickbird_isvip%3D0%26quickbird_type%3D0%26vip_nickname%3Dzhang26%26vip_usrname%3Dzhang26%26vip_growvalue%3D0%26vip_expiredate%3D----%26vip_level%3D0%26vip_isyear%3D0%26vip_paytype%3D0%26vip_isvip%3D0%26vip_daily%3D0%26vip_payname%3D----%26jsq_level%3D0%26vip_autopay%3D-1%26vas_type%3D0%26jsq_type%3D0%26jsq_isvip%3D0%26jsq_expiredate%3D----%26ischild%3D0%26history%3D0; CNZZDATA1260367889=2056055323-1562894677-%7C1562908233; score=; upgrade=; logintype=; sessionid=ws001.110207925EE1B91DAA2B85F94E292ECD; usernewno=; isvip=0; order=; usrname=zhang27; creditkey=ck0.jDH9WF-4XkSMW_fbAkmqIOMfVhNSrQfaV4A2HMioER12pLtTy5L8PxUqKp2bT1Jf; userid=160223252; usertype=0; verify_type=; _x_t_=0; usernick=%E9%9B%B7%E5%8F%8B; vip_sessionid=ws001.110207925EE1B91DAA2B85F94E292ECD; mvip_sessionid=ws001.110207925EE1B91DAA2B85F94E292ECD; mvipCookie=ischild%3D0%26isvip%3D0%26vas_type%3D0%26level%3D0%26growvalue%3D0%26expiredate%3D----%26isyear%3D0%26daily%3D0%26payname%3D----%26autopay%3D-1%26paytype%3D0%26history%3D0%26xftype%3D0%26quickbird_isvip%3D0%26quickbird_type%3D0%26quickbird_level%3D0%26quickbird_expiredate%3D----%26quickbird_growvalue%3D0%26quickbird_paytype%3D0%26jsq_isvip%3D0%26jsqtype%3D0%26jsq_level%3D0%26jsq_expiredate%3D----%26jsq_growvalue%3D0%26jsq_paytype%3D0%26userid%3D160223252%26jsq_type%3D0%26usrname%3Dzhang27%26nickname%3Dzhang27%26usernewno%3D; VERIFY_KEY=5E142DA0851DDA979880CD892BDE2C4AB9F4A7CC1E7EF19F39E47AF69F502E05; appidstack=101%2C102%2C101%2C102%2C101; errdesc=5bqU55So56iL5bqP5ZCN5ZKM5Lia5Yqh6Lef6Liq56CB5LiN5Yy56YWNWzExXQ==; error=appid_notmatch; error_description=\"Application name does not match business tracking number\"");
		    conn.connect();
		    System.out.println("grfgftfh");
		    BufferedReader buffer = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
		    String line = null;
		    while((line=buffer.readLine()) != null) {
		    	
		    	stringBuilder.append(line);
		    }
		    conn.disconnect();
		    System.out.println(stringBuilder.toString()+"------stringbuilder");
			String[] ss = stringBuilder.toString().split("\\(");
			String ss1 = ss[1].substring(0,ss[1].length()-1);
			JsonObject json = new JsonParser().parse(ss1).getAsJsonObject();
			Gson gson = new GsonBuilder().create();
			PaymentBean paymentBean = new PaymentBean();

			int result = json.get("result").getAsInt();
			String msg = json.get("msg").getAsString();
			PaymentBean.DataBean dataObject = new PaymentBean.DataBean();
			PaymentBean.DataBean.PayconfBean payconfBean = new PaymentBean.DataBean.PayconfBean();
			PaymentBean.DataBean.PayconfBean.ListBean listBean = new PaymentBean.DataBean.PayconfBean.ListBean();
			//data json数据
			JsonObject data = json.getAsJsonObject("data");
			//payconf  配置json数组
			JsonArray payconf = data.getAsJsonArray("payconf");

			System.out.println("payconf------------>"+payconf.toString());

			JsonObject baijin = payconf.get(0).getAsJsonObject();


			JsonArray list = baijin.getAsJsonArray("list");
			System.out.println("list------->"+list);

			JsonObject list0 = payconf.get(0).getAsJsonObject();

			JsonArray payway = list0.getAsJsonArray("payway");
			Iterator<JsonElement> it = list.iterator();
			while(it.hasNext()){
				JsonObject jsontmp = it.next().getAsJsonObject();
				if(jsontmp.isJsonArray()){
					//处理payway
					System.out.println("rewtert");
				}
				listBean.setActid(jsontmp.get("actid").getAsString());
				listBean.setActid(jsontmp.get("actid").getAsString());
				listBean.setActid(jsontmp.get("actid").getAsString());
				listBean.setActid(jsontmp.get("actid").getAsString());
				listBean.setActid(jsontmp.get("actid").getAsString());
				listBean.setActid(jsontmp.get("actid").getAsString());
				listBean.setActid(jsontmp.get("actid").getAsString());
				listBean.setActid(jsontmp.get("actid").getAsString());
				listBean.setActid(jsontmp.get("actid").getAsString());
				listBean.setActid(jsontmp.get("actid").getAsString());
				listBean.setActid(jsontmp.get("actid").getAsString());
				listBean.setActid(jsontmp.get("actid").getAsString());
				listBean.setActid(jsontmp.get("actid").getAsString());
				listBean.setActid(jsontmp.get("actid").getAsString());
				listBean.setActid(jsontmp.get("actid").getAsString());
				listBean.setActid(jsontmp.get("actid").getAsString());
				listBean.setActid(jsontmp.get("actid").getAsString());


				System.out.println(listBean.getActid());

			}
			System.out.println(ss1+"-----ss1");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	public void textCompare(WebDriver webd) {
//		try {
//		int index=6;
//		for(int i=1;i<=index;i++) {
//
//			String str="/html/body/div[5]/div[1]/div/div[2]/div[1]/div["+i+"]";
//			String s_tips="/html/body/div[5]/div[1]/div/div[2]/div[1]/div[1]/i["+i+"]";
//			WebElement ele = webd.findElement(By.xpath(str));
//			ele.click();
//			ele = webd.findElement(By.xpath("/html/body/div[5]/div[1]/div/div[2]/div[1]/div[1]/i[1]"));
//			String tip = ele.getText();
//
//			JSONObject json = sendGet(urlStr).getJSONObject("data");
//			System.out.println(json);
//
//			
//			
//			Thread.sleep(500);		
//		}
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
