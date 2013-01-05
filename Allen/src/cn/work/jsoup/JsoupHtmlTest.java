package cn.work.jsoup;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class JsoupHtmlTest {

	/**
	 * jsoup网页解析
	 * @author lwm
	 *
	 */
	public static void main(String[] args) {

		// TODO Auto-generated method stub
		String html = "<html><head><title> 开源中国社区 </title></head>"  
			+ "<body><p id='jsoup'> 这里是 jsoup 项目的相关文章 </p><a href=http://www.oschina.net/project></body></html>"; 
		Document doc = Jsoup.parse(html); 
		Elements links=doc.select("a").attr("rel", "nofollow");
		System.out.println(doc.html());
//		System.out.println(doc.getElementById("jsoup"));
//		System.out.println(doc.getElementsByTag("a"));
//		 doc.select("a").attr("rel", "nofollow"); 
//		 System.out.println(doc.getElementsByTag("a"));
		 
		 
		 // 从 URL 直接加载 HTML 文档
		 Document doc1;
		try {
			doc1 = Jsoup.connect("http://www.baidu.com").get();
//			System.out.println(doc1.getElementsByTag("a"));
//			Elements links = doc1.select("a[href]").attr("rel", "Good"); //在a标签上增加 rel=good的属性
//			links.html();
//			System.out.println(links);
			
//			String title = doc1.title(); 
//			System.out.println(title);
			
//			System.out.println(doc1.getElementsByTag("a"));
//			doc1.select("a[href]").removeAttr("rel"); //清除属性
//			System.out.println(doc1.getElementsByTag("a"));
			
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
