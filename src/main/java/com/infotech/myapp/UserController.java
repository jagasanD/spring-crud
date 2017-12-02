package com.infotech.myapp;



import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.infotech.myapp.bean.UserBean;
import com.infotech.myapp.model.FileEntity;
import com.infotech.myapp.model.User;
import com.infotech.myapp.service.FileEntityService;
import com.infotech.myapp.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	UserService userServiceImpl;
	
	@Autowired
	FileEntityService fileEntityService;
	
	@RequestMapping(value="/user-registration-form",method=RequestMethod.GET)
	public ModelAndView getForm() {
		return new ModelAndView("registration");
	}
	
	@RequestMapping(value="/save-user",method=RequestMethod.POST)
	public @ResponseBody Map<Object,String> userSave( @RequestParam(required = false) MultipartFile file,@ModelAttribute UserBean bean) {
		User user1 = new User(bean);
		 UserBean user = userServiceImpl.saveOrudate(user1,file);
		

		Map<Object,String>map = new HashMap<Object,String>();
		
		map.put("id", user.getUserId()+"");
		map.put("name", user.getUserName());
		map.put("email", user.getEmail());
		map.put("password", user.getPassword());
		map.put("fileId", user.getFileId()+"");
		
		return map;
		
	}
	@RequestMapping(value="/get-user-list")
	public @ResponseBody Map<Object,Object> getUserList() {
		
		List list = userServiceImpl.getUserList();
		
		Map<Object,Object>map = new HashMap<Object,Object>();
		if(list!=null && !list.isEmpty()) {
			map.put("data", list);
		}
	
		return map;
		
		
	}
	
	@RequestMapping(value="/delete-user/{userId}",method=RequestMethod.POST)
	public @ResponseBody Map<Object,Object> deleteUser(@PathVariable String userId){
		User user= userServiceImpl.getUserById(userId);
		System.out.println(user);
		userServiceImpl.delete(user);
		Map<Object,Object>map = new HashMap<Object,Object>();
		map.put("status","SUCCESS");
		return map;
	}
	
	
	@RequestMapping("/download/{fileId}")
	public String download(@PathVariable("fileId")
			Integer fileId, HttpServletResponse response) {
		
		FileEntity doc = fileEntityService.getFileById(fileId);
		try {
			if(doc!=null) {
			response.setHeader("Content-Disposition", "inline;filename=\"" +doc.getFileName()+ "\"");
			OutputStream out = response.getOutputStream();
			response.setContentType(doc.getMimeType());
			 InputStream targetStream = new ByteArrayInputStream(doc.getSizeInBytes());
			IOUtils.copy(targetStream, out);
			out.flush();
			out.close();
			}
			
	
		
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	
}
