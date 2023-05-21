package gic.i4c.GicCafe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import gic.i4c.GicCafe.repository.UserRepository;
import gic.i4c.GicCafe.model.User;

@Controller
public class GetViewController {
	@Autowired
	private UserRepository userRepo;

	@RequestMapping(value = "/addCashier",method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView returnAddCashier()
	{
	  ModelAndView mv = new ModelAndView();
	  mv.setViewName("addCashier");
	//   mv.addObject("var", "halim");
	  return mv;

	}

	@RequestMapping(value = "/ListCashiers",method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView returnListProduct()
	{
	  ModelAndView mv = new ModelAndView();
	  List<User> cashiers = userRepo.findAll();
	  mv.setViewName("ListCashiers");
	  mv.addObject("cashiers", cashiers);
	  return mv;

	}

}