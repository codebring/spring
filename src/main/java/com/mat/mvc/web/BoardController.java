package com.mat.mvc.web;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mat.mvc.service.BoardService;
import com.mat.mvc.vo.BoardVO;


@Controller // 컨트롤러임을 알려주기 위해서
@RequestMapping("/board/*") // 모든 파일에 접근 할 수 있게 되엇어요
public class BoardController {

	@Inject
	BoardService service;


	// 게시물 읽어오기
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void getList(Model model) throws Exception {

		List list = null;
		list = service.list();
		model.addAttribute("list", list);

	}

	// 게시물 작성
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public void getWrite(HttpSession session, Model model) throws Exception {
		Object loginInfo = session.getAttribute("member");

		if (loginInfo == null) {
			model.addAttribute("msg", "login_error");
		}

	}

	// 게시물 작성
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String postWrite(BoardVO vo) throws Exception {
		service.write(vo);

		return "redirect:/board/list";
	}

	// 게시물 조회
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public void getView(@RequestParam("bno") int bno, Model model) throws Exception {

		BoardVO vo = service.view(bno);

		model.addAttribute("view", vo);

	}

	// 게시물 수정
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void getModify(@RequestParam("bno") int bno, Model model) throws Exception {

		BoardVO vo = service.view(bno);

		model.addAttribute("view", vo);
	}

	// 게시물 수정
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String postModify(BoardVO vo) throws Exception {

		service.modify(vo);

		return "redirect:/board/view?bno=" + vo.getBno();
	}

	// 게시물 삭제
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String getDelete(@RequestParam("bno") int bno) throws Exception {

		service.delete(bno);

		return "redirect:/board/list";
	}
}
