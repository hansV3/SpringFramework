package poly.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import lombok.extern.log4j.Log4j;

@Log4j
public class Crawling {

	
	

		
		public static String naverCrawling(String url, String area) throws Exception{
			
			
			//String url = "https://n.news.naver.com/mnews/article/014/0005182567";
			//String area = "#dic_area";
			
			
			Document doc = Jsoup.connect(url).timeout(5000).get();
			
			Elements elements = doc.select(area);
			
			String str = "";
			
			elements.forEach(a-> log.info(a));
			
			for(int i =0; i< elements.size(); i++) {
				
				str += (elements.get(i).toString()+" ");
				
			}
			
			log.info(str);
			//model.addAttribute("title",elements);
			return str;

		}
		
		
public String crawling(String url, String area) throws Exception{
			
			
			//String url = "https://n.news.naver.com/mnews/article/014/0005182567";
			//String area = "#dic_area";
			
			
			Document doc = Jsoup.connect(url).timeout(5000).get();
			
			Elements elements = doc.select(area);
			
			String str = "";
			
			elements.forEach(a-> log.info(a));
			
			for(int i =0; i< elements.size(); i++) {
				
				str += (elements.get(i).toString()+" ");
				
			}
			
			log.info(str);
			//model.addAttribute("title",elements);
			return str;

		}
	
}
