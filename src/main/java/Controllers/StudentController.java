package Controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.StudentDAO;
import DTO.StudentDTO;


@WebServlet("*.student")
public class StudentController extends HttpServlet {
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		StudentDAO dao = new StudentDAO();
		System.out.println(uri);
		
		try {

			if(uri.equals("/create.student")) { // 한중
				
				
				
				
				
				
				
				
				
				
			} else if (uri.equals("/read.student")) { // 서호
			
				List<StudentDTO> list = dao.selectAll();
				request.setAttribute("list", list);
				
				request.getRequestDispatcher("read.jsp").forward(request, response);
				
				
			} else if (uri.equals("/delete.student")){
				
				int sid = Integer.parseInt(request.getParameter("sid"));
				dao.delete(sid);
				response.sendRedirect("/deleteList.student");
					
			} else if (uri.equals("/deleteList.student")){
				List<StudentDTO> list = dao.selectAll();
				request.setAttribute("list", list);
				request.getRequestDispatcher("delete.jsp").forward(request, response);
						
				
			} else if (uri.equals("/update.student")) { // 세훈
				
				int sid = Integer.parseInt(request.getParameter("sid"));
				String name = request.getParameter("name");
			    int kor = Integer.parseInt(request.getParameter("kor"));
			    int eng = Integer.parseInt(request.getParameter("eng"));
				int math = Integer.parseInt(request.getParameter("math"));
				
<<<<<<< HEAD
			    int result = dao.update(new StudentDTO(0,sid,name,kor,eng,math,null));
				response.sendRedirect("updatelist.Student");	
=======
				
				
				
				
>>>>>>> 9c6143ef385d01821d6567b9064cb52ed556fb39
			}
						
		}catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
		
		
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
