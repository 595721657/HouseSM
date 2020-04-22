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
		//���ñ����ʽ
		req.setCharacterEncoding("UTF-8");
		//����ҳ������
		String op=req.getParameter("op");
		if("login".equals(op)) {
			//��¼��֤�ķ���
			loginUsers(req,resp);
		}else if("add".equals(op)) {
			//ע��ķ���
			addUser(req,resp);
		}else if("out_login".equals(op)) {
			//ע���˻�
			out_loginUser(req,resp);
		}
	}
	//ע���˻�
	private void out_loginUser(HttpServletRequest req, HttpServletResponse resp) {
		try {
			//���serssion������
			req.getSession().invalidate();
			resp.sendRedirect("login.jsp");
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	//ע��ķ���
	private void addUser(HttpServletRequest req, HttpServletResponse resp) {
		try {
			//����ҳ����Ϣ
			String cardid=req.getParameter("cardid");
			String psw=req.getParameter("password");
			String name=req.getParameter("name");
			String repassword=req.getParameter("repassword");
			int gender=0;
			//��ȡ���֤���һλ
			String ss=cardid.substring(cardid.length()-1,cardid.length());
			if(Integer.parseInt(ss) %2==0) {
				gender=1;
			}else {
				gender=2;
			}
			//��֤����
			if (repassword.equals(psw)) {
				//�ж����֤�Ƿ����
				if(us.getByCarId(cardid) ==null) {
					user=new Users(cardid, name, gender, new Date(), psw);
					//��֤ע��
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
	//��¼��֤�ķ���
	private void loginUsers(HttpServletRequest req, HttpServletResponse resp) {
		try {
			//����������˺�
			String cardid=req.getParameter("cardid");
			String psw=req.getParameter("password");
			//��֤��¼
			isOK=us.isValidation(cardid, psw);
			if(isOK) {
				user=us.getByCarId(cardid);
				//�жϵ�¼״̬�Ƿ�Ϊ2,��ʾ�˺ŷ���
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
