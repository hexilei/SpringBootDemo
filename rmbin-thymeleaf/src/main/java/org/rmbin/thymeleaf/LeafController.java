package org.rmbin.thymeleaf;

import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rmbin.model.UserModel;

@Controller
@RequestMapping(value="/thymeleaf")
public class LeafController {

	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String home(ModelMap map)
	{
		map.addAttribute("host","http://www.rmbin.com");
		return "index";
	}
	
	@RequestMapping(value="/getUsers",method=RequestMethod.GET)
	public String getUsers()
	{
		UserModel user = new UserModel(UUID.randomUUID().toString(), "Louis's first thymeleaf");
		return "/user/userList";
	}
}
