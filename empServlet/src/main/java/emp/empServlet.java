package emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import empDAO.DAO;
import empDAO.emp;

public class empServlet extends HttpServlet implements Serializable {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
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
}
