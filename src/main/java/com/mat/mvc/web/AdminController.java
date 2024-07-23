package com.mat.mvc.web;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mat.mvc.service.AdminService;
import com.mat.mvc.vo.CategoryVO;
import com.mat.mvc.vo.GoodsVO;
import com.mat.mvc.vo.GoodsViewVO;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/admin/*")
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	@Inject
	AdminService adminService;
	
	
	//관리자 화면
	@RequestMapping(value="/index", method = RequestMethod.GET)
	public void getIndex() throws Exception {
		logger.info("get Index");
	}
	
	@RequestMapping(value="/goods/register", method = RequestMethod.GET)
	public void getGoodsRegister(Model model) throws Exception {
		logger.info("get goods register");
		
		List<CategoryVO> category = null;
		category = adminService.category();
		model.addAttribute("category", JSONArray.fromObject(category));
	}
	
	@RequestMapping(value="/goods/register", method = RequestMethod.POST)
	public String postGoodsRegister(GoodsVO vo) throws Exception {
		adminService.register(vo);
		
		return "redirect:/admin/index";
	}
	
	@RequestMapping(value="/goods/list", method = RequestMethod.GET)
	public void getList(Model model) throws Exception {
		logger.info("get List");
		
		List<GoodsVO> list = adminService.goodsList();
		
		model.addAttribute("list", list);
		
	}
	
	@RequestMapping(value="/goods/view", method = RequestMethod.GET)
	public void getGoodsview(@RequestParam("n") int gdsNum, Model model) throws Exception {
		logger.info("get goods view");
		
		GoodsViewVO goods = adminService.goodsView(gdsNum);
		
		model.addAttribute("goods", goods);
		
	}
	
	@RequestMapping(value="/goods/modify", method = RequestMethod.GET)
	public void getGoodsModify(@RequestParam("n") int gdsNum, Model model) throws Exception {
		logger.info("get goods Modify");
		
		GoodsViewVO goods = adminService.goodsView(gdsNum);
		model.addAttribute("goods", goods);
		
		List<CategoryVO> category = null;
		category = adminService.category();
		model.addAttribute("category", JSONArray.fromObject(category));
		
	}
	
	@RequestMapping(value="/goods/modify", method = RequestMethod.POST)
	public String postGoodsModify(GoodsVO vo) throws Exception {
		logger.info("post goods modify");
		
		adminService.goodsModify(vo);
		
		return "redirect:/admin/index";
		
	}
	
	@RequestMapping(value="/goods/delete", method = RequestMethod.POST)
	public String getGoodsDelete(@RequestParam("n") int gdsNum) throws Exception {
		logger.info("post goods delete");
		
		adminService.goodsDelete(gdsNum);

		
		return "redirect:/admin/goods/list";
		
	}

	
	
	
	
}
