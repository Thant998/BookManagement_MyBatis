package bookspringmybatis.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import bookspringmybatis.bean.BookBean;
import bookspringmybatis.dao.BookDAO;
import bookspringmybatis.dto.BookRequestDTO;
import bookspringmybatis.dto.BookResponseDTO;
@Controller
public class BookController {
	@Autowired
	BookDAO bookDAO;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String showAllBook(ModelMap model) {
		System.out.println("a");
		ArrayList<BookResponseDTO> list=(ArrayList<BookResponseDTO>) bookDAO.selectAll();
		model.addAttribute("list", list);
		return "displaybook";
	}
	
	@RequestMapping(value="/setupAddBook", method=RequestMethod.GET)
	public ModelAndView setupAddBook() {
		return new ModelAndView("addbook","bean",new BookBean());
	}
	
	@RequestMapping(value="/addBook", method=RequestMethod.POST)
	public String addBook(@ModelAttribute("bean") @Validated BookBean bean,
			BindingResult result,ModelMap model) {
		if(result.hasErrors()) {
			return "addbook";
		}
		BookRequestDTO dto=new BookRequestDTO();
		dto.setBookCode(bean.getBookCode());
		dto.setBookTitle(bean.getBookTitle());
		dto.setBookAuthor(bean.getBookAuthor());
		dto.setBookPrice(bean.getBookPrice());
		int i=bookDAO.insert(dto);
		if(i>0) {
			return "redirect:/";
		}else {
			model.addAttribute("error","Insert fail");
			return "addbook";
		}

	}
	
	@RequestMapping(value="setupUpdateBook/{code}", method=RequestMethod.GET)
	public ModelAndView setupUpdateBook(@PathVariable("code") String code) {
		BookRequestDTO dto=new BookRequestDTO();
		dto.setBookCode(code);
		return new ModelAndView("updatebook", "bean",bookDAO.selectOne(dto));
	}
	
	@RequestMapping(value="/updateBook", method=RequestMethod.POST)
	public String updateBook(@ModelAttribute("bean") @Validated BookBean bean,
			BindingResult result,ModelMap model) {
		if(result.hasErrors()) {
			return "updatebook";
		}
		BookRequestDTO dto=new BookRequestDTO();
		dto.setBookCode(bean.getBookCode());
		dto.setBookTitle(bean.getBookTitle());
		dto.setBookAuthor(bean.getBookAuthor());
		dto.setBookPrice(bean.getBookPrice());
		int i=bookDAO.update(dto);
		if(i>0) {
			return "redirect:/";
		}else {
			model.addAttribute("error","Update fail");
			return "updateBook";
		}

	}
	
	@RequestMapping(value="/deleteBook/{code}", method=RequestMethod.GET)
	public String deleteBook(@PathVariable("code") String code) {
		BookRequestDTO dto=new BookRequestDTO();
		dto.setBookCode(code);
		bookDAO.delete(dto);
		return "redirect:/";
	}
}
