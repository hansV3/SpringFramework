package poly.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.log4j.Log4j;
import poly.service.IWordAnalysisService;
import poly.util.Crawling;

@Controller("WordController")
@Log4j
public class WordController {

	private Logger log = Logger.getLogger(this.getClass());
	
	//@Resource(name="WordAnalysisService")
	@Autowired
	private IWordAnalysisService wordAnalysisService;
	
	@RequestMapping(value = "/word/analysis")
	@ResponseBody
	public Map<String, Integer> analysis() throws Exception {
		
		log.info(this.getClass().getName() + ".inputForm !");
		
		String url="https://news.naver.com/section/101";
		String area = ".sa_text";
		
		
		//분석할 문장
		String text = Crawling.naverCrawling(url, area);
		
		
		log.info(text);
		
		Map<String, Integer> rMap = wordAnalysisService.doWordAnalysis(text);
		
		if(rMap == null) {
			rMap = new HashMap<String, Integer>();
		}
		
		return rMap;
	}
}