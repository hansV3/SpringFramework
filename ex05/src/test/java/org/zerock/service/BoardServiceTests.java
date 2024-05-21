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
	
	
	//?±λ‘? ??? κ΅¬νκ³? ??€?Έ
	@Test
	public void testRegister() {
		BoardVO board = new BoardVO();
		board.setTitle("?λ‘? ??±?? κΈ?");
		board.setContent("?λ‘? ??±?? ?΄?©");
		board.setWriter("newbie");
		
		service.register(board);
		
		log.info("??±? κ²μλ¬? λ²νΈ: " + board.getBno());
	}
	
	
	//λͺ©λ‘(λ¦¬μ€?Έ) ??? κ΅¬νκ³? ??€?Έ
	@Test
	public void testGetList() {
		
		//service.getList().forEach(board -> log.info(board));
		service.getList(new Criteria(2,10)).forEach(board -> log.info(board));
	}
	
	
	//μ‘°ν ??? κ΅¬νκ³? ??€?Έ
	@Test
	public void testGet() {
		
		log.info(service.get(1L));
	}
	
	
	
	//?­? /??  κ΅¬νκ³? ??€?Έ
	@Test
	public void testDelete() {
		//κ²μλ¬? λ²νΈ? μ‘΄μ¬ ?¬λΆ?λ₯? ??Έ?κ³? ??€?Έ ?  κ²?
		log.info("REMOVE: " + service.remove(2L));
	}
	//?­? /??  κ΅¬νκ³? ??€?Έ
	@Test
	public void testUpdate() {
		BoardVO board = service.get(1L);
		
		if(board == null) {
			return;
		}
		
		board.setTitle("? λͺ? ?? ?©??€.");
		log.info("MODIFY RESULT: " + service.modify(board));
	}
	
	
	
	
	
	
	
	
	
}
