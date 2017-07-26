package com.ggr.ssm.web.controller;

import com.ggr.ssm.bean.User;
import com.ggr.ssm.service.IUserService;
import com.ggr.ssm.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
	private IUserService userService;

    @RequestMapping(value="/add",method=RequestMethod.GET)
    public String showRegister(User user, Model model){
        if(!model.containsAttribute("user")){
            User user1 = new User();
            model.addAttribute("user",user1);
        }
        return "register";
    }

	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(@Valid User user, BindingResult bindingResult,RedirectAttributes redirectAttributes){
        user.setId(StringUtils.getUUID());
        //如果验证数据中有错误信息,将保存在bindingResult对象中
        if(bindingResult.hasErrors()){
            List<ObjectError> errorList = bindingResult.getAllErrors();
            for(ObjectError error : errorList){
                System.out.println(error.getDefaultMessage());
            }
            //验证不通过在跳到valid页面,因为页面上有显示错误的标签
            return "register";
        }
        try {
			userService.register(user);
			redirectAttributes.addFlashAttribute("msg", "注册成功!");
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("msg", "注册失败!");
			return "redirect:/error";
		}
		return "redirect:/success";
	}
	
	@RequestMapping(value="/getAll",method=RequestMethod.POST,produces="application/json")
	@ResponseBody
	public List<User> getAllUsers(){
		List<User> list = null;
		try {
			list = userService.findAllUsers();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
