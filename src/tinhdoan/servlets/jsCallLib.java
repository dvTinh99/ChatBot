package tinhdoan.servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tinhdoan.BO.AnswerHumanBO;

/**
 * Servlet implementation class jsCallLib
 */
@WebServlet("/jsCallLib")
public class jsCallLib extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public jsCallLib() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext sc = this.getServletContext();
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		if(request.getCharacterEncoding() == null)
	    {
	        request.setCharacterEncoding("utf-8");
	    }
		HttpSession session = request.getSession();
		AnswerHumanBO answerHumanBO = new AnswerHumanBO() ;
		if (session.getAttribute("on") == null) {
			session.setAttribute("on", "on");
			
			String human = request.getParameter("human");
			answerHumanBO.start();
			String answer = answerHumanBO.answerHuman(human);
			session.setAttribute("answer", answer);
			request.setAttribute("answer", answer);
			response.sendRedirect("chatWithBot.jsp");
			
		}else {
			String human = request.getParameter("human");
			String answer = answerHumanBO.answerHuman(human);
			session.setAttribute("answer", answer);
			request.setAttribute("answer", answer);
			response.sendRedirect("chatWithBot.jsp");
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
