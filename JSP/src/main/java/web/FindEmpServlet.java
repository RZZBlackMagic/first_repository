package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import empDAO.DAO;
import empDAO.emp;

public class FindEmpServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//接收参数
		//处理业务：查询所有的员工
		DAO d = new DAO();
		List<emp> list = d.findAll();
		//将数据绑定到request，因为在服务器内部从Servlet下转发到JSP上，不是输出响应，所以要用request。
		req.setAttribute("emps", list);//list是值，emps是名字
		//将请求转发给emp_list.jsp
		//当前：JSP/findEmp
		//目标：JSP/emp_list.jsp
		req.getRequestDispatcher("emp_list.jsp").forward(req, res);//引号内为路径
	}

}
