package org.zerock.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

	@Autowired
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
		mapper.getList().forEach(board -> log.info(board));
	}
	
	
	//create(insert)처리
	@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("?���? ?��?��?��?�� �?");
		board.setContent("?���? ?��?��?��?�� ?��?��");
		board.setWriter("newbie");
		
		mapper.insert(board);
		
		log.info(board);
	}
	
	@Test
	public void testInsertSelectKey() {
		
		BoardVO board = new BoardVO();
		board.setTitle("?���? ?��?��?��?�� �? select key");
		board.setContent("?���? ?��?��?��?�� ?��?�� select key");
		board.setWriter("newbie");
		
		mapper.insertSelectKey(board);
		
		log.info(board);
	}
	
	
	//read(select)처리
	@Test
	public void testRead() {
		//존재?��?�� 게시�? 번호 ?��?��
		BoardVO board = mapper.read(5L);
		
		log.info(board);
	}
	
	
	//delete 처리
	@Test
	public void testDelete() {
		log.info("DELETE COUNT: " + mapper.delete(3L));
	}
	
	
	//update 처리
	@Test
	public void testUpdate() {
		
		BoardVO board = new BoardVO();
		//?��?��?��?�� 존재?��?�� 번호?���? ?��?��
		board.setBno(5L);
		board.setTitle("?��?��?�� ?���?");
		board.setContent("?��?��?�� ?��?��");
		board.setWriter("user00");
		
		int count = mapper.update(board);
		log.info("UPDATE COUNT: "+ count);
		
	}
	
	@Test
	public void testPaging() {
		Criteria cri = new Criteria();
		
		//10개씩 3?��?���?
		cri.setPageNum(1);
		cri.setAmount(10);
		
		List<BoardVO> list = mapper.getListWithPaging(cri);
		
		list.forEach(board -> log.info(board));
		
	}
	
	@Test
	public void testSearch() {
		Criteria cri = new Criteria();
		cri.setKeyword("?���?");
		cri.setType("TC");
		
		List<BoardVO> list = mapper.getListWithPaging(cri);
		
		list.forEach(board -> log.info(board));
	}
	
	
	
	
	
}
