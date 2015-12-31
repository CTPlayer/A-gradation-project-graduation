package com.cheng.test.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cheng.test.dao.ManagerDao;
import com.cheng.test.entity.Announcement;
import com.cheng.test.entity.Bbs;
import com.cheng.test.entity.Blog;
import com.cheng.test.entity.Item;
import com.cheng.test.entity.Lessions;
import com.cheng.test.entity.Paper;
import com.cheng.test.entity.Teacher;
import com.cheng.test.entity.Upload;
import com.cheng.test.service.Managerservice;
import com.cheng.test.service.Userservice;

@Controller
public class managercontroller {
	
	@Autowired
	private Userservice userservice;
	@Autowired
	private ManagerDao managerdao;
	@Autowired
	private Managerservice managerservice;
	
	@RequestMapping("managerlogin.do")
	public String managerlogin(String email,String Password,Model model,HttpSession session,Integer pageNo){
		Boolean flag = userservice.teacherCheckLogin(email, Password);
		if(flag){
			session.setAttribute("email", email);
			List<Announcement> announce = managerdao.findAll(8,pageNo);
			model.addAttribute("announce", announce);
			Integer totalPages = managerservice.getTotalPages();
			model.addAttribute("totalPages", totalPages);
			model.addAttribute("pageNo", pageNo);
		return "view/manager";
		}else{
			model.addAttribute("error1", "用户名或者密码错误！");
			return "managerlogin";
		}
	}
	
	@RequestMapping("deleteAnnounce.do")
	public String deleteAnnounce(Model model,Integer pageNo){
		List<Announcement> announce = managerdao.findAll(8,pageNo);
		model.addAttribute("announce", announce);
		Integer totalPages = managerservice.getTotalPages();
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("pageNo", pageNo);
		return "view/manager";
	}
	
	@RequestMapping("delete.do")
	public String deleteannounce(Model model,Integer id,Integer pageNo){
		Announcement announcement = managerdao.findById(id);
		if(announcement!=null){
			managerdao.deleteAnnounce(announcement);
		}
		List<Announcement> announce = managerdao.findAll(8,pageNo);
		model.addAttribute("announce", announce);
		Integer totalPages = managerservice.getTotalPages();
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("pageNo", pageNo);
		return "view/manager";
	}
	
	@RequestMapping("addAnnounce.do")
	public String addAnnounce(Announcement announcement,Model model){
		Date date = new Date();
		announcement.setCreatetime(date);
		announcement.setUpdatetime(date);
		managerdao.save(announcement);
		List<Announcement> announce = managerdao.findAll(8,1);
		model.addAttribute("announce", announce);
		Integer totalPages = managerservice.getTotalPages();
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("pageNo", 1);
		return "view/manager";
	}
	
	@RequestMapping("view/uploadFile.do")
	public String uploadFile(Model model,Upload upload,String subject,@RequestParam(value = "file", required = false)MultipartFile file,
			@RequestParam(value = "video", required = false)MultipartFile video,HttpServletRequest request){
		String realPath1 = request.getSession().getServletContext().getRealPath("/uploadfile");//获取保存文件的文件夹路径
		String realPath2 = request.getSession().getServletContext().getRealPath("/uploadvideo");//获取保存文件的文件夹路径

		String videoName = video.getOriginalFilename();
		String fileName = file.getOriginalFilename();//获取上传文件的路径
		
		File targetFile1 = new File(realPath1,fileName);//将上传文件复制到文件夹中
		File targetFile2 = new File(realPath2,videoName);
		
		if(!targetFile1.exists()){ //如果文件夹不存该文件在则保存
			targetFile1.mkdirs();
		}
		if(!targetFile2.exists()){
			targetFile2.mkdirs();
		}
		
		try {
			file.transferTo(targetFile1);
			video.transferTo(targetFile2);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
		
		upload.setFilename(fileName);
		upload.setVideoname(videoName);
		List<Lessions> lessions = managerdao.findBySubject(subject);
		if(lessions.size()>0){
			upload.setLid(lessions.get(0).getLid());
			managerdao.save(upload);
			model.addAttribute("mess", "添加成功！");
		}else{
			model.addAttribute("mess", "添加失败，请重新添加！");
			
		}
		
		return null;		
	}
	
	@RequestMapping("addLessions.do")
	public String addLessions(Lessions lessions2,HttpSession session,Model model){
		String email = session.getAttribute("email").toString();
		Teacher teacher = managerdao.findByEmail(email).get(0);
		lessions2.setTid(teacher.getTid());
		managerdao.save(lessions2);
		
		List<Lessions> lessions = managerdao.findAllLessions();
		model.addAttribute("lessions", lessions);
		return "view/myLessions";
	}
	
	@RequestMapping("myLessions.do")
	public String myLessions(Model model,HttpSession session){
		String email = session.getAttribute("email").toString();
		if(managerdao.findByEmail(email).size()>0){
		Teacher teacher = managerdao.findByEmail(email).get(0);
		Set<Lessions> lessions = teacher.getLessions();
		model.addAttribute("lessions", lessions);
		}
		return "view/myLessions";
	}
	
	@RequestMapping("deleteLession.do")
	public String deleteLession(Integer lid,Model model,HttpSession session){
		Lessions lession = managerdao.findLessionsById(lid);
		if(lession!=null){
			managerdao.deleteLession(lession);
		}
		String email = session.getAttribute("email").toString();
		Teacher teacher = managerdao.findByEmail(email).get(0);
		Set<Lessions> lessions = teacher.getLessions();
		model.addAttribute("lessions", lessions);
		return "view/myLessions";
	}
	
	@RequestMapping("view/addPaper.do")
	public String addPaper(Paper paper,HttpSession session,String announcetimes,Model model) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		paper.setAnnouncetime(sdf.parse(announcetimes));
		String email = session.getAttribute("email").toString();
		Teacher teacher = managerdao.findByEmail(email).get(0);
		teacher.setResource("true");
		paper.setTid(teacher.getTid());
		managerdao.save(paper);
		managerdao.update(teacher);
		model.addAttribute("mess", "添加成功！");
		return null;
	}
	
	@RequestMapping("myScientist.do")
	public String myScientist(HttpSession session,Model model){
		String email = session.getAttribute("email").toString();
		Teacher teacher = managerdao.findByEmail(email).get(0);
		Set<Paper> papers = teacher.getPaper();
		Set<Item> items = teacher.getItem();
		model.addAttribute("papers", papers);
		model.addAttribute("items", items);
		return "view/myScientist";
	}
	
	@RequestMapping("view/addItem.do")
	public String addItem(String itemtimes,Item item,HttpSession session,Model model) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		item.setItemtime(sdf.parse(itemtimes));
		String email = session.getAttribute("email").toString();
		Teacher teacher = managerdao.findByEmail(email).get(0);
		teacher.setResource("true");
		item.setTid(teacher.getTid());
		managerdao.save(item);
		managerdao.update(teacher);
		model.addAttribute("mess", "添加成功！");
		return null;
	}
	
	@RequestMapping("deleteItem.do")
	public String deleteItem(Integer iid,Model model,HttpSession session){
		Item item = managerdao.findByIid(iid);
		if(item!=null){
			managerdao.deleteItem(item);
		}
		String email = session.getAttribute("email").toString();
		Teacher teacher = managerdao.findByEmail(email).get(0);
		Set<Item> items = teacher.getItem();
		Set<Paper> papers = teacher.getPaper();
		if(items.size()==0&&papers.size()==0){
			teacher.setResource("false");
			managerdao.update(teacher);
		}
		model.addAttribute("items", items);
		model.addAttribute("papers", papers);
		return "view/myScientist";
	}
	
	@RequestMapping("deletePaper.do")
	public String deletePaper(Integer pid,Model model,HttpSession session){
		Paper paper = managerdao.findByPid(pid);
		if(paper!=null){
			managerdao.deletePaper(paper);
		}
		String email = session.getAttribute("email").toString();
		Teacher teacher = managerdao.findByEmail(email).get(0);
		Set<Item> items = teacher.getItem();
		Set<Paper> papers = teacher.getPaper();
		if(items.size()==0&&papers.size()==0){
			teacher.setResource("false");
			managerdao.update(teacher);
		}
		model.addAttribute("items", items);
		model.addAttribute("papers", papers);
		return "view/myScientist";
	}
	
	@RequestMapping("forum.do")
	public String forum(Model model){
		List<Bbs> bbss = managerdao.findAllBbs();
		model.addAttribute("bbss", bbss);
		return "view/forum";
	}
	
	@RequestMapping("deleteBbs.do")
	public String deleteBbs(Integer bbsid,Model model,HttpSession session){
		Bbs bbs = managerdao.findBbsById(bbsid);
		System.out.println(bbsid);
		if(bbs!=null){
			managerdao.deleteBbs(bbs);
		}
		List<Bbs> bbss = managerdao.findAllBbs();
		model.addAttribute("bbss", bbss);
		return "view/forum";
	}
	
	@RequestMapping("myBlog.do")
	public String myBlog(Model model,HttpSession session){
		String email = session.getAttribute("email").toString();
		Teacher teacher = managerdao.findByEmail(email).get(0);
		model.addAttribute("myAddress", teacher.getBlog().getAddress());
		return "view/addBlog";
	}
	
	@RequestMapping("updateBlog.do")
	public String updateBlog(HttpSession session,String myAddress,Model model,Blog blog2){
		String email = session.getAttribute("email").toString();
		Teacher teacher = managerdao.findByEmail(email).get(0);
		Blog blog = teacher.getBlog();
		if(blog!=null){
			blog.setAddress(myAddress);
			managerdao.updateBlog(blog);
			model.addAttribute("mess", "修改成功！");
			model.addAttribute("myAddress", myAddress);
		}else{
			blog2.setAddress(myAddress);
			blog2.setTid(teacher.getTid());
			managerdao.saveBlog(blog2);
			model.addAttribute("mess", "添加成功！");
			model.addAttribute("myAddress", myAddress);
		}
		return "view/addBlog";
	}
}
