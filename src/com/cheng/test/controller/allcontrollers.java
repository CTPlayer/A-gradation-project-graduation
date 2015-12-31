package com.cheng.test.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cheng.test.dao.AnnouncementDao;
import com.cheng.test.dao.UserDao;
import com.cheng.test.entity.Announcement;
import com.cheng.test.entity.Answer;
import com.cheng.test.entity.Item;
import com.cheng.test.entity.Lessions;
import com.cheng.test.entity.Paper;
import com.cheng.test.entity.Teacher;
import com.cheng.test.entity.Bbs;
import com.cheng.test.entity.User;
import com.cheng.test.service.Announcementservice;
import com.cheng.test.service.Userservice;
import com.cheng.test.utils.FileUtil;

@Controller
public class allcontrollers {

	@Autowired
	private Userservice userservice;
	@Autowired
	private Announcementservice announcementservice;
	@Autowired
	private AnnouncementDao Announcementdao;
	@Autowired
	private UserDao Userdao;
	
	@RequestMapping("login.do")
	public String login(String Username,String Password,Model model,String Remember,HttpServletResponse response,
			Integer pageNo,HttpServletRequest request,HttpSession session) throws UnsupportedEncodingException{
		boolean flag = userservice.checkLogin(Username, Password);
		if(flag){
			session.setAttribute("username", Username);
			if(Remember!=null&&Remember.length()>0){
				//把用户名和密码保存在Cookie对象中
				Username = URLEncoder.encode(Username,"utf-8");   //使Cookie能够保存中文
				Cookie cookiename = new Cookie("username", Username);
				Cookie cookiepassword = new Cookie("password",Password);
				cookiename.setPath("/");
				cookiepassword.setPath("/");
				cookiename.setMaxAge(864000);
				cookiepassword.setMaxAge(864000);
				response.addCookie(cookiename);
				response.addCookie(cookiepassword);
			}else{
				Cookie[] cookies = request.getCookies();
				if(cookies.length>0&&cookies.length>0){
					for(Cookie c:cookies){
						if(c.getName().equals("username")||c.getName().equals("password")){
							c.setMaxAge(0);
							c.setPath("/");
							response.addCookie(c);
						}
					}
				}
			}
			List<Announcement> list = Announcementdao.findLimt_3();
			model.addAttribute("ALimt_3", list);
			List<Announcement> allList = Announcementdao.findAll(6, pageNo);
			model.addAttribute("allList", allList);
			model.addAttribute("pageNo", pageNo);
			List<Bbs> bbs = Announcementdao.findAllBbs(6,1);
			model.addAttribute("bbs", bbs);
			return "index";
		}else{
		model.addAttribute("error1", "用户名或者密码错误！");
		return "login";
		}
	}
	
	@RequestMapping("home.do")
	public String home(Model model){
		List<Announcement> list = Announcementdao.findLimt_3();
		model.addAttribute("ALimt_3", list);
		List<Announcement> allList = Announcementdao.findAll(6, 1);
		model.addAttribute("allList", allList);
		model.addAttribute("pageNo", 1);
		List<Bbs> bbs = Announcementdao.findAllBbs(6,1);
		model.addAttribute("bbs", bbs);
		return "index";
	}
	
	@RequestMapping("teacherName.do")
	public String teacherName(Model model){
		List<Teacher> jisuanji = Userdao.findByInstitute("计算机科学与技术学院");
		List<Teacher> tiyu = Userdao.findByInstitute("体育学院");
		List<Teacher> shengming = Userdao.findByInstitute("生命科学学院");
		List<Teacher> yinyue = Userdao.findByInstitute("音乐学院");
		List<Teacher> meishu = Userdao.findByInstitute("美术学院");

		model.addAttribute("jisuanji", jisuanji);
		model.addAttribute("tiyu", tiyu);
		model.addAttribute("shengming", shengming);
		model.addAttribute("yinyue", yinyue);
		model.addAttribute("meishu", meishu);
		return "view/jiaoxueyuandi";
	}
	
	@RequestMapping("resource.do")
	public String resource(Model model,String teachername,HttpServletRequest request) throws UnsupportedEncodingException{
		request.setCharacterEncoding("UTF-8");
		teachername = new String(teachername.getBytes("ISO-8859-1"),"UTF-8");
		List<Teacher> teacher = Userdao.findByTeachername(teachername);
		Set<Lessions> lessions = teacher.get(0).getLessions();
		model.addAttribute("lessions", lessions);
		return "view/teach";
	}
	
	@RequestMapping("scientist.do")
	public String scientist(Model model){
		List<Teacher> jisuanji = Userdao.findByInstituteHaveResource("计算机科学与技术学院");
		List<Teacher> tiyu = Userdao.findByInstituteHaveResource("体育学院");
		List<Teacher> shengming = Userdao.findByInstituteHaveResource("生命科学学院");
		List<Teacher> yinyue = Userdao.findByInstituteHaveResource("音乐学院");
		List<Teacher> meishu = Userdao.findByInstituteHaveResource("美术学院");
		
		model.addAttribute("jisuanji", jisuanji);
		model.addAttribute("tiyu", tiyu);
		model.addAttribute("shengming", shengming);
		model.addAttribute("yinyue", yinyue);
		model.addAttribute("meishu", meishu);
		return "view/keyankongjian";
	}
	
	@RequestMapping("scientistinfo.do")
	public String scientistinfo(Model model,String teachername,HttpServletRequest request) throws UnsupportedEncodingException{
		request.setCharacterEncoding("UTF-8");
		teachername = new String(teachername.getBytes("ISO-8859-1"),"UTF-8");
		List<Teacher> teacher = Userdao.findByTeachername(teachername);
		Set<Paper> paper = teacher.get(0).getPaper();
		Set<Item> item = teacher.get(0).getItem();
		model.addAttribute("paper", paper);
		model.addAttribute("item", item);
		return "view/keyan";
	}
	
	@RequestMapping("blog.do")
	public String blog(Model model,Integer pageNo){
		if(pageNo<=1){
			pageNo=1;
		}
		Integer totalPages = announcementservice.getTotalPages();
		if(pageNo>=totalPages){
			pageNo= totalPages;
		}
		List<Teacher> teacher = Userdao.findAll(10, pageNo);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("teacher", teacher);
		model.addAttribute("pageNo", pageNo);
		return "view/blog";
	}
	
	@RequestMapping("bbs.do")
	public String Bbs(Model model){
		List<Bbs> bbs = Announcementdao.findAll();
		model.addAttribute("bbs", bbs);
		return "view/luntan";
	}
	
	@RequestMapping("discuss.do")
	public String discuss(Integer bbsid,Model model){
		List<Bbs> bbs = Announcementdao.findByBbsid(bbsid);
		model.addAttribute("bbs", bbs.get(0));
		Set<Answer> answers = bbs.get(0).getAnswer();
		model.addAttribute("answers", answers);
		return "view/tiezi";
	}
	
	@RequestMapping("addbbs.do")
	public String addbbs(Bbs bbs,Model model,HttpSession session){
		String username = session.getAttribute("username").toString();
		if(username!=null&&username.contains("@")){
			List<Teacher> teacher = Userdao.findByEmail(username);
			bbs.setTeacher(teacher.get(0));
		}else{
			List<User> user = Userdao.findByUsername(username);
			bbs.setUser(user.get(0));
		}
		Date date = new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.format(date);
		bbs.setTimes(date);
		Announcementdao.AddBbs(bbs);
		List<Bbs> bbsAll = Announcementdao.findAll();
		model.addAttribute("bbs", bbsAll);
		return "view/luntan";
	}
	
	@RequestMapping("mybbs.do")
	public String mybbs(Model model,HttpSession session){
		String username = session.getAttribute("username").toString();
		Set<Bbs> bbs;
		if(username!=null&&username.contains("@")){
			List<Teacher> teacher = Userdao.findByEmail(username);
		    bbs = teacher.get(0).getBbs();
		}else{
			List<User> user = Userdao.findByUsername(username);
			bbs = user.get(0).getBbs();
		}
		model.addAttribute("bbs", bbs);
		return "view/luntan";
	}
	
	@RequestMapping("answer.do")
	public String answer(Model model,Answer answer,HttpSession session,String bbsid){
		Date date = new Date();
		answer.setRetime(date);
		String username = session.getAttribute("username").toString();
		if(username!=null&&username.contains("@")){
			List<Teacher> teacher = Userdao.findByEmail(username);
			answer.setTeacher(teacher.get(0));
		}
			answer.setBbsid(Integer.parseInt(bbsid));
			Announcementdao.AddAnswer(answer);			
		List<Bbs> bbs2 = Announcementdao.findByBbsid(Integer.parseInt(bbsid));
		model.addAttribute("bbs", bbs2.get(0));
		Set<Answer> answers = bbs2.get(0).getAnswer();
			model.addAttribute("answers", answers);
		return "view/tiezi";
	}
	
	@RequestMapping("download.do")
	public ModelAndView download(HttpServletRequest request,HttpServletResponse response,String storeName) throws Exception{
		storeName = new String(storeName.getBytes("ISO-8859-1"),"UTF-8");
		request.setCharacterEncoding("UTF-8");
        String contentType = "application/octet-stream";  
        FileUtil.download(request, response, storeName, contentType);
		return null;
	}
}
