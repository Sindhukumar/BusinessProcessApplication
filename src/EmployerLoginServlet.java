
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Tools.ManageApplication;
import Tools.ManageEmployer;
import Tools.ManageStage;
import model.Bpapplication;
import model.Bpemployer;
import model.Bpstage;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/EmployerLoginServlet")
public class EmployerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployerLoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nextURL = "/EmployerLoginPage.jsp";
		HttpSession session = request.getSession();
		if ("true".equalsIgnoreCase(request.getParameter("logout"))) {
			session.setAttribute("employer", null);
			session.setAttribute("applications", null);
			session.setAttribute("currentapplication", null);
			session.setAttribute("currentapplicationstages", null);
		}
		response.sendRedirect(request.getContextPath() + nextURL);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("useremail");
		String password = request.getParameter("userpassword");

		String nextURL = "/error.jsp";

		Bpemployer employer = ManageEmployer.isValidEmployer(email, password);
		HttpSession session = request.getSession();
		session.setAttribute("employer", employer);
		if (employer != null) {
			nextURL = "/EmployerHomeServlet";
		}

		else {
			nextURL = "/EmployerLoginPage.jsp?error=nomatch";
		}
		response.sendRedirect(request.getContextPath() + nextURL);

	}

}
