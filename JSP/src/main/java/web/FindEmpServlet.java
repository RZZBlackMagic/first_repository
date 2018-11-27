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
		//���ղ���
		//����ҵ�񣺲�ѯ���е�Ա��
		DAO d = new DAO();
		List<emp> list = d.findAll();
		//�����ݰ󶨵�request����Ϊ�ڷ������ڲ���Servlet��ת����JSP�ϣ����������Ӧ������Ҫ��request��
		req.setAttribute("emps", list);//list��ֵ��emps������
		//������ת����emp_list.jsp
		//��ǰ��JSP/findEmp
		//Ŀ�꣺JSP/emp_list.jsp
		req.getRequestDispatcher("emp_list.jsp").forward(req, res);//������Ϊ·��
	}

}
