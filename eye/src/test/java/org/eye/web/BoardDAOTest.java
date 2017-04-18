package org.eye.web;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.eye.domain.BoardVO;
import org.eye.persistence.BoardDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })
public class BoardDAOTest {

	private static Logger logger = Logger.getLogger(eyetest.class);

	@Inject
	BoardDAO dao;

	@Test
	public void create() {
		for (int i = 0; i <= 200; i++) {
			BoardVO vo = new BoardVO();
			vo.setTitle("제목");
			vo.setContent("내용");
			vo.setWriter("작성자");
			dao.create(vo);
		}
	}

	@Test
	public void show() {
		System.out.println(dao.show(1));
	}

	@Test
	public void listall() {

		List<BoardVO> list = dao.listall();

		for (BoardVO boardVO : list) {
			logger.info(boardVO.getBno() + ":" + boardVO.getTitle() + ":" + boardVO.getContent() + ":"
					+ boardVO.getWriter() + ":" + boardVO.getRegdate() + ":" + boardVO.getUpdatedate());
		}
	}

	@Test
	public void update() {
		BoardVO vo = new BoardVO();
		vo.setBno(400);
		vo.setTitle("바뀐제목");
		vo.setContent("바뀐내용");
		dao.update(vo);
	}

	@Test
	public void delete() {
		dao.delete(300);
	}

	@Test
	public void paging() {
		int page = 3;

		page = (page - 1) * 10;

		List<BoardVO> list = dao.paging(page);
		logger.info(page / 10 + "페이지");
		for (BoardVO boardVO : list) {
			logger.info(boardVO.getBno() + ":" + boardVO.getTitle() + ":" + boardVO.getContent() + ":"
					+ boardVO.getWriter() + ":" + boardVO.getRegdate() + ":" + boardVO.getUpdatedate());
		}
	}

}
