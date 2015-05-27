package com.xuchiya.util;

public class URLUtils {

	public static final String NEWS_TYPE_ENGLAND_URL = "http://voice.hupu.com/soccer/tag/496";
	public static final String NEWS_TYPE_SPNAN_URL = "http://voice.hupu.com/soccer/tag/225";
	public static final String NEWS_TYPE_GERMAN_URL = "http://voice.hupu.com/soccer/tag/1106";
	public static final String NEWS_TYPE_ITALY_URL = "http://voice.hupu.com/soccer/tag/700";
	public static final String NEWS_TYPE_EUORP_URL = "http://voice.hupu.com/soccer/tag/2011";

	/**
	 * 根据文章类型，和当前页码生成url
	 * 
	 * @param newsType
	 * @param currentPage
	 * @return
	 */
	public static String generateUrl(int newsType, int currentPage) {
		String urlStr = "";
		switch (newsType) {
		case Constant.NEWS_TYPE_ENGLAND:
			urlStr = NEWS_TYPE_ENGLAND_URL;
			break;
		case Constant.NEWS_TYPE_SPNAN:
			urlStr = NEWS_TYPE_SPNAN_URL;
			break;
		case Constant.NEWS_TYPE_GERMAN:
			urlStr = NEWS_TYPE_GERMAN_URL;
			break;
		case Constant.NEWS_TYPE_ITALY:
			urlStr = NEWS_TYPE_ITALY_URL;
			break;
		case Constant.NEWS_TYPE_EUORP:
			urlStr = NEWS_TYPE_EUORP_URL;
			break;

		}

		return urlStr+"-"+currentPage+".html";
		
		
	}

}
