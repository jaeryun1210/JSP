package ch06;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/news")
public class News extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public News() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(name == null || name.trim().isEmpty() || email == null || email.trim().isEmpty()) {
			out.append("다시 입력하세요");
			response.sendRedirect("ch06/News.html");
		}
		else {
			out.append("<html><body><h2>"+name+"님 구독 감사합니다.</h2><hr>").append("뉴스 레터를 "+email+" 으로 보내드렸습니다.</body></html>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
		
		
	}

}
