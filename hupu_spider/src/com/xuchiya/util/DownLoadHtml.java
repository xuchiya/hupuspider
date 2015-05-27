package com.xuchiya.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class DownLoadHtml {

	// 下载HTML格式的数据
	public static String download(String str_url) {
		StringBuffer sb = new StringBuffer();
		try {
			URL url = new URL(str_url);
			URLConnection connection = url.openConnection();
			InputStream is = connection.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			String line;
			while ((line = br.readLine()) != null) {
				
//				System.out.println(line);
				sb.append(line);
			}
			br.close();
			isr.close();
			is.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sb.toString();
	}
	
	
//  测试	
//	public static void main(String[] args) {
//		DownLoadHtml test=new DownLoadHtml();
//		test.download(URLUtils.generateUrl(Constant.NEWS_TYPE_ENGLAND,2));
//	}

}
