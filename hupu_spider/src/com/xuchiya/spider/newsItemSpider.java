package com.xuchiya.spider;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.xuchiya.model.NewsBean;
import com.xuchiya.util.DownLoadHtml;
import com.xuchiya.util.URLUtils;

public class newsItemSpider {

	public List<NewsBean> getNews(int newsTpye, int currentPage) {

		String url = URLUtils.generateUrl(newsTpye, currentPage);
		String result = DownLoadHtml.download(url);
		List<NewsBean> lists = new ArrayList<NewsBean>();
		try {
			Document doc = Jsoup.parse(result);

			Elements units = doc.getElementsByClass("tag-list-box").get(0)
					.getElementsByClass("list");

			NewsBean item = null;
			for (int i = 0; i < units.size(); i++) {
				item = new NewsBean();

				// list-content txt video
				boolean hasimage = units.get(i).child(1)
						.getElementsByClass("video").size() != 0;
				if (hasimage) {
					item.setImgLink(units.get(i).child(1).child(1).child(0)
							.child(0)
							// list-content
							.child(0).attr("src"));
					item.setContent(units.get(i).getElementsByClass("txt").get(0)
							.child(1).text());
				}
				else {
					item.setContent(units.get(i).getElementsByClass("txt").get(0)
							.child(0).text());
				}
				item.setLink(units.get(i).getElementsByClass("time").get(0).child(0)
						.attr("href"));
				item.setTitle(units.get(i).getElementsByClass("name").get(0)
						.child(0).child(0).text());
				item.setDate(units.get(i).getElementsByClass("time").get(0)
						.child(0).text());
				item.setNewsType(newsTpye);
				lists.add(item);

				
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("解析出问题");
		}

		return lists;

	}

//	public static void main(String[] args) {
//		newsItemSpider test = new newsItemSpider();
//		List<NewsBean> lists = test.getNews(5, 2);
//		for (NewsBean item : lists) {
//			System.out.println(item);
//		}
//	}
}
