package com.dragon.controller.users;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dragon.pojo.Users;
import com.dragon.service.users.UsersService;
@WebServlet("/Users")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationcontext-mybatis.xml");
    private UsersService us=(UsersService) ctx.getBean("userService");
    private boolean isOK;
    private Users user;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置编码格式
		req.setCharacterEncoding("UTF-8");
		//接收页面数据
		String op=req.getParameter("op");
		if("login".equals(op)) {
			//登录验证的方法
			loginUsers(req,resp);
		}else if("add".equals(op)) {
			//注册的方法
			addUser(req,resp);
		}else if("out_login".equals(op)) {
			//注销账户
			out_loginUser(req,resp);
		}
	}
	//注销账户
	private void out_loginUser(HttpServletRequest req, HttpServletResponse resp) {
		try {
			//清除serssion的数据
			req.getSession().invalidate();
			resp.sendRedirect("login.jsp");
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	//注册的方法
	private void addUser(HttpServletRequest req, HttpServletResponse resp) {
		try {
			//接收页面信息
			String cardid=req.getParameter("cardid");
			String psw=req.getParameter("password");
			String name=req.getParameter("name");
			String repassword=req.getParameter("repassword");
			int gender=0;
			//截取身份证最后一位
			String ss=cardid.substring(cardid.length()-1,cardid.length());
			if(Integer.parseInt(ss) %2==0) {
				gender=1;
			}else {
				gender=2;
			}
			//验证密码
			if (repassword.equals(psw)) {
				//判断身份证是否存在
				if(us.getByCarId(cardid) ==null) {
					user=new Users(cardid, name, gender, new Date(), psw);
					//验证注册
					isOK=us.addUsers(user);
					if(isOK) {
						resp.sendRedirect("login.jsp");
					}else {
						resp.sendRedirect("add.jsp");
					}
				}else {
					resp.sendRedirect("add.jsp");
				}				
			}else {
				resp.sendRedirect("add.jsp");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//登录验证的方法
	private void loginUsers(HttpServletRequest req, HttpServletResponse resp) {
		try {
			//接收密码跟账号
			String cardid=req.getParameter("cardid");
			String psw=req.getParameter("password");
			//验证登录
			isOK=us.isValidation(cardid, psw);
			if(isOK) {
				user=us.getByCarId(cardid);
				//判断登录状态是否为2,表示账号封锁
				if(user.getStatus()==2) {
					resp.sendRedirect("login.jsp");
				}else {
					req.getSession().setAttribute("name",user.getName());
					req.getRequestDispatcher("index.jsp").forward(req, resp);
				} 
			}else {
				resp.sendRedirect("login.jsp");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}

}
