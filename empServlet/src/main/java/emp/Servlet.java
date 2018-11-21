package emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import empDAO.DAO;
import empDAO.emp;

public class Servlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		/*
		 * 开发规范
		 * 查询员工：/find.emp
		 * 增加员工：/add.emp
		 */
		String path = req.getServletPath();
		if("/find.emp".equals(path)){
			find_emp(req,res);
		}else if("/add.emp".equals(path)){
			add_emp(req,res);
		}else{
			throw new RuntimeException();
		}
	}
	protected void find_emp(HttpServletRequest req, HttpServletResponse res) throws IOException{
		//1 接收参数
				//2 处理数据
				DAO dao = new DAO();
				List<emp> list = dao.findAll();
				//3发送响应
				res.setContentType("text/html;charset=utf-8");
				PrintWriter pw = res.getWriter();
				pw.println("<a href='add_emp.html'>增加</a>");
				pw.println("<table border='1' cellspacing='0' width='30%'>");
				pw.println("<tr>"
						+"<td>name</td>"
						+"<td>stu</td>"
						+"<td>sex</td>"
						+"<td>score</td>"
						+ "</tr>");
				if(list!=null){
					for(emp e :list){
						pw.println("<tr>"
								+"<td>"+e.getName()+"</td>"
								+"<td>"+e.getStu()+"</td>"
								+"<td>"+e.getSex()+"</td>"
								+"<td>"+e.getScore()+"</td>"
								+ "</tr>"
								);
					}
				}
				pw.println("</table>");
	}
	protected void add_emp(HttpServletRequest req, HttpServletResponse res) throws IOException{
		req.setCharacterEncoding("utf-8");
		//1 接收参数
		String name = req.getParameter("name");
		String stu = req.getParameter("stu");
		String sex = req.getParameter("sex");
		String score = req.getParameter("score");
		//2处理业务
		emp e = new emp();
		e.setName(name);
		e.setStu(Integer.valueOf(stu));
		e.setSex(sex);
		e.setScore(Double.valueOf(score));
		//3发送数据
		/*res.setContentType("text/html;charset=utf-8");
		PrintWriter pw = res.getWriter();
		pw.println("<p>保存成功</p>");
		pw.close();*/
		//重定向到查询页面
		//给浏览器一个建议，让浏览器自己去访问查询页面
		res.sendRedirect("find.emp");
		
	}
	

}
