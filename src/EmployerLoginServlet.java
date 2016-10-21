
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
import model.Bpapplication;
import model.Bpemployer;

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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// TODO Auto-generated method stub
		doGet(request, response);
		String email = request.getParameter("useremail");
		String password = request.getParameter("userpassword");

		String nextURL = "/error.jsp";

		Bpemployer employer = ManageEmployer.isValidEmployer(email, password);
		HttpSession session = request.getSession();
		if (employer != null) {
			session.setAttribute("employer", employer);
			List<Bpapplication> applications = ManageApplication.getApplicationList();
			session.setAttribute("applications", applications);
			nextURL = "/EmployerHome.jsp";
		}

		else {
			nextURL = "/EmployerLoginPage.jsp?error=nomatch";
		}
		response.sendRedirect(request.getContextPath() + nextURL);

	}

}
