package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardMapper {
	
	//@Select("select * from tbl_board where bno > 0")
	public List<BoardVO> getList();
	
	
	public List<BoardVO> getListWithPaging(Criteria cri);
	
	
	//create(insert)처리
	public void insert(BoardVO board);
	
	public void insertSelectKey(BoardVO board);
	
	//read(select)처리
	public BoardVO read(Long bno);
	
	//delete 처리
	public int delete(Long bno);
	
	//update 처리
	public int update(BoardVO board);
	
	
	public int getTotalCount(Criteria cri);
	
	
}
