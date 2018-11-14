package com.student.controller;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.student.bean.Student;
import com.student.bean.Stutea;
import com.student.bean.Teacher;
import com.student.dao.StudentDao;
import com.student.dao.StuteaDao;
//import com.student.dao.TeacherDao;
//import com.teacher.bean.Teacher;
import com.student.dao.TeacherDao;

@Controller   //main()
public class StudentController {
	/**
	 *
	 * 从數據庫中取全部学生信息，将数据返回index,jsp
	 *
	 * @param model
	 * @return 返回值型： String
	 */
	@RequestMapping(value = "/login1")
	public String login(@RequestParam("username")String username,@RequestParam("password")String password,Model model) {
		if(username.equals("admin") && password.equals("admin")) {
			model.addAttribute("username",username);
			return "login";
		}else {
			model.addAttribute("username",username);
		}
		return "loginNG";

	}
	@RequestMapping(value = "/all")
	public String queryAll(Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 从ioc容器中?取dao
		StudentDao studao = (StudentDao) context.getBean("dao");
		ArrayList<Student> studentList = new ArrayList<Student>();
		studentList = (ArrayList<Student>) studao.queryAll();
		model.addAttribute("students", studentList);
		return "index";
	}
	@RequestMapping(value = "/stuteaall")
	public String  querystuteaAll(Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 从ioc容器中?取dao
		StuteaDao stuteadao = (StuteaDao) context.getBean("stuteadao");
		ArrayList<Stutea> stuteaList = new ArrayList<Stutea>();
		stuteaList = (ArrayList<Stutea>) stuteadao.queryAll();
//		System.out.println("teacher id:"+stuteaList.get(1).getTeacher().getId());
 		model.addAttribute("stuteas", stuteaList);
		return "NewFile";
	}
	/**
	 * 通過姓名查找学生，使用模糊查找，将結果返回index.jsp
	 *
	 * @param name
	 * @param model
	 * @return 返回值型： String
	 */
	@RequestMapping(value = "/queryByName")
	public String queryByName(String name, Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 从ioc容器中?取dao
		StudentDao dao = (StudentDao) context.getBean("dao");
		model.addAttribute("students", dao.queryByName(name));
		return "index";
	}


	@RequestMapping(value = "/add")
	public String Addstudent(String name, String birthday, String age, String score, String classid, Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentDao dao = (StudentDao) context.getBean("dao");
		Student student = new Student();
		student.setName(name);
		student.setBirthday(birthday);
		student.setAge(Integer.valueOf(age));
		student.setScore(Double.parseDouble(score));
		student.setClassid(Integer.valueOf(classid));
		boolean result = dao.addStu(student);
		if (result) {
			model.addAttribute("msg", "<script>alert('添加成功！')</script>");
		} else {
			model.addAttribute("msg", "<script>alert('添加失敗！')</script>");
		}
		model.addAttribute("students", dao.queryAll());
		return "index";
	}

	/**
	 * 通過id除学生
	 *
	 * @param id
	 * @param model
	 * @return 返回值型： String
	 */
	@RequestMapping(value = "/deleteById")
	public String deleteById(String id, Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentDao dao = (StudentDao) context.getBean("dao");
		boolean result = dao.deleteStu(Integer.parseInt(id));

		if (result) {
		System.out.println("消除成功");
		} else {
			System.out.println("消除失敗");
		}

		model.addAttribute("students", dao.queryAll());
		return "index";
	}
	@RequestMapping(value = "/update")
	public String updateStudent(String id, String name, String birthday, String age, String score, String classid,
			Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentDao dao = (StudentDao) context.getBean("dao");
		Student student = new Student();
		student.setId(Integer.parseInt(id));
//		System.out.println(student.getId());
		student.setName(name);
		student.setBirthday(birthday);
		student.setAge(Integer.valueOf(age));
		student.setScore(Double.parseDouble(score));
		student.setClassid(Integer.valueOf(classid));
		boolean result = dao.updateStudent(student);
		if (result) {
			System.out.println("update成功");
		} else {
			System.out.println("update失敗");
		}
		model.addAttribute("students", dao.queryAll());
		return "index";
	}
}
//
// /**
// *
// * @param id
// * @param name
// * @param birthday
// * @param age
// * @param sex
// * @param score
// * @param model
// * @return 返回??型： String
// */
// @RequestMapping(value = "/update")
// public String updateStu(String id, String name, String birthday, String
// age,String score, String classid,
// Model model) {
//
// ApplicationContext context = new
// ClassPathXmlApplicationContext("applicationContext.xml");
// StudentDao dao = (StudentDao) context.getBean("dao");
// Student student = new Student();
// student.setId(Integer.parseInt(id));
// student.setName(name);
// student.setBirthday(birthday);
// student.setAge(Integer.valueOf(age));
// student.setScore(Double.parseDouble(score));
// //student.setClassid();
// // 電話番号、郵便番号を追加する
//
//
// boolean result = dao.updateStu(student);
//
// if (result) {
// model.addAttribute("msg", msg("修改成功"));
// } else {
// model.addAttribute("msg", msg("修改失?"));
// }
//
// model.addAttribute("students", dao.queryAll());
// return "index";
// }
//
// /**
// * 要?出的?面消息
// *
// * @param msg
// * @return 返回??型： String
// */
// public String msg(String msg) {
// return "<script>alert('" + msg + "')</script>";
// }
//
// /**
// * 通?姓名?找学生，使用模糊?找，将?果返回?index.jsp
// *
// * @param name
// * @param model
// * @return 返回??型： String
// */
// @RequestMapping(value = "/quaeryMaxAge")
// public String queryMaxAge(String name, Model model) {
// ApplicationContext context = new
// ClassPathXmlApplicationContext("applicationContext.xml");
// // 从ioc容器中?取dao
// StudentDao dao = (StudentDao) context.getBean("dao");
// model.addAttribute("studentsMaxAge", dao.queryMaxAge());
// return "index";
// }
