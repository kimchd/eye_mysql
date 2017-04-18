package org.eye.persistence;

import java.util.List;

import javax.inject.Inject;

import org.eye.domain.BoardVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {

	@Inject
	private SqlSessionTemplate sess;
	
	public void create(BoardVO vo){
		sess.insert("org.eye.BoardMapper.create", vo);
	}
	
	public BoardVO show(int bno){
		return sess.selectOne("org.eye.BoardMapper.show",bno);
	}
	
	public List<BoardVO> listall(){
		return sess.selectList("org.eye.BoardMapper.getList");
	}
	
	public void update(BoardVO vo){
		sess.update("org.eye.BoardMapper.update",vo);
	}
	
	public void delete(int bno){
		sess.delete("org.eye.BoardMapper.delete",bno);
	}
	
	public List<BoardVO> paging(int page){
		return sess.selectList("org.eye.BoardMapper.paging",page);
	}
	
}
