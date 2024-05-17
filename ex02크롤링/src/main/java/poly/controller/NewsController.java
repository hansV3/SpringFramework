package poly.controller;

import java.io.IOException;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/news/*")
public class NewsController {

	@GetMapping("/naver")
	public void naver(Model model) throws Exception{
		
		
		String url = "https://news.naver.com/section/101";
		
		Document doc = Jsoup.connect(url).timeout(5000).get();
		
		Elements elements = doc.select(".sa_text");
		
		
		elements.forEach(a-> log.info(a));
		//log.info(elements.text());
		
//		String aa = elements.text().toString();
//		log.info(aa);
		
		
		model.addAttribute("title",elements);
		
//		String address = "https://news.naver.com/section/105";
//		
//		
//		Document doc = Jsoup.connect(address).timeout(5000).get();
//		
//		log.info(doc);
//		
//		Elements elements = doc.select(".sa_text");
//		
//		for(int inx=0; inx < elements.size(); inx++) {
//			Element element = elements.get(inx);
//			Elements contentATags = doc.select(".sa_txt a");
//			
//			String viewPageUrl = contentATags.first().attr("abs:href");			
//		}
//		
//		
//		elements.forEach(a-> log.info(a));
//		
		//model.addAttribute("title",element);
		
		
		//return "redirect:/word/analysis";
	}
}
