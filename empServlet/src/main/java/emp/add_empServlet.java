package emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import empDAO.emp;

public class add_empServlet extends HttpServlet implements Serializable {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
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
		res.sendRedirect("emp");
	}

}
