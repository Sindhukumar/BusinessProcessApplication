
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Tools.ManageApplication;
import Tools.ManageQuestions;
import model.Bpapplication;
import model.Bpemployer;
import model.Bpquestion;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/EmployerHomeServlet")
public class EmployerHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployerHomeServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nextURL = "/EmployerLoginPage.jsp";
		HttpSession session = request.getSession();
		Bpemployer employer = (Bpemployer) session.getAttribute("employer");
		if (employer != null) {

			List<Bpapplication> applications = ManageApplication.getApplicationList();
			session.setAttribute("applications", applications);		
			nextURL = "/EmployerHome.jsp";
		}
		response.sendRedirect(request.getContextPath() + nextURL);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
