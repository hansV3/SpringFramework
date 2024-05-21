package org.zerock.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardServiceTests {

	@Autowired
	private BoardService service;
	
	@Test
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}
	
	
	//?“±ë¡? ?‘?—…?˜ êµ¬í˜„ê³? ?…Œ?Š¤?Š¸
	@Test
	public void testRegister() {
		BoardVO board = new BoardVO();
		board.setTitle("?ƒˆë¡? ?‘?„±?•˜?Š” ê¸?");
		board.setContent("?ƒˆë¡? ?‘?„±?•˜?Š” ?‚´?š©");
		board.setWriter("newbie");
		
		service.register(board);
		
		log.info("?ƒ?„±?œ ê²Œì‹œë¬? ë²ˆí˜¸: " + board.getBno());
	}
	
	
	//ëª©ë¡(ë¦¬ìŠ¤?Š¸) ?‘?—…?˜ êµ¬í˜„ê³? ?…Œ?Š¤?Š¸
	@Test
	public void testGetList() {
		
		//service.getList().forEach(board -> log.info(board));
		service.getList(new Criteria(2,10)).forEach(board -> log.info(board));
	}
	
	
	//ì¡°íšŒ ?‘?—…?˜ êµ¬í˜„ê³? ?…Œ?Š¤?Š¸
	@Test
	public void testGet() {
		
		log.info(service.get(1L));
	}
	
	
	
	//?‚­? œ/?ˆ˜? • êµ¬í˜„ê³? ?…Œ?Š¤?Š¸
	@Test
	public void testDelete() {
		//ê²Œì‹œë¬? ë²ˆí˜¸?˜ ì¡´ì¬ ?—¬ë¶?ë¥? ?™•?¸?•˜ê³? ?…Œ?Š¤?Š¸ ?•  ê²?
		log.info("REMOVE: " + service.remove(2L));
	}
	//?‚­? œ/?ˆ˜? • êµ¬í˜„ê³? ?…Œ?Š¤?Š¸
	@Test
	public void testUpdate() {
		BoardVO board = service.get(1L);
		
		if(board == null) {
			return;
		}
		
		board.setTitle("? œëª? ?ˆ˜? •?•©?‹ˆ?‹¤.");
		log.info("MODIFY RESULT: " + service.modify(board));
	}
	
	
	
	
	
	
	
	
	
}
