package org.zerock.mapper;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {

	
	//?…Œ?Š¤?Š¸ ? „?— ?•´?‹¹ ë²ˆí˜¸?˜ ê²Œì‹œë¬¼ì´ ì¡´ì¬?•˜?Š”ì§? ë°˜ë“œ?‹œ ?™•?¸?•  ê²?
	private Long[] bnoArr = { 3097L, 3098L, 3099L, 3100L, 3101L };
			
	@Autowired
	private ReplyMapper mapper;
	
	
	@Test
	public void testCreate() {
		
		IntStream.rangeClosed(1, 10).forEach(i -> {
			
			ReplyVO vo = new ReplyVO();
			
			//ê²Œì‹œë¬¼ì˜ ë²ˆí˜¸
			vo.setBno(bnoArr[i % 5]);
			vo.setReply("?Œ“ê¸? ?…Œ?Š¤?Š¸" + i);
			vo.setReplyer("replyer" + i);
			
			mapper.insert(vo);
			
		});
	}
	
	
	@Test
	public void testMapper() {
		
		log.info(mapper);
	}
	
	
	@Test
	public void testRead() {
		
		Long targetRno = 5L;
		
		ReplyVO vo = mapper.read(targetRno);
		
		log.info(vo);
	}

	
	@Test
	public void testDelete() {
		
		Long targetRno = 1L;
		
		mapper.delete(targetRno);

	}
	
	
	
	@Test
	public void testUpdate() {
		
		Long targetRno = 10L;
		
		ReplyVO vo = mapper.read(targetRno);
		
		vo.setReply("Update Reply ");
		
		int count = mapper.update(vo);
		
		log.info("UPDATE COUNT: " + count);
	}
	
	
	
	@Test
	public void testList() {
		Criteria cri = new Criteria();
		
		List<ReplyVO> replies = mapper.getListWithPaging(cri, bnoArr[0]);
		
		replies.forEach(reply -> log.info(reply));
	}
	
	
	
	@Test
	public void testList2() {
		
		Criteria cri = new Criteria(2,10);
		
		List<ReplyVO> replies = mapper.getListWithPaging(cri, 16L);
		
		replies.forEach(reply -> log.info(reply));
	}
	
	
	
	
	
	
	
	
	
}
