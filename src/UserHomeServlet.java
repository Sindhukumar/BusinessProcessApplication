
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Tools.ManageApplication;
import model.Bpapplication;
import model.Bpuser;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/UserHomeServlet")
public class UserHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserHomeServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nextURL = "/UserLoginPage.jsp";
		HttpSession session = request.getSession();
		Bpuser user = (Bpuser) session.getAttribute("user");
		if (user != null) {

			List<Bpapplication> appliedapplications = ManageApplication.getApplicationsByEmail(user.getEmail());
			session.setAttribute("appliedapplications", appliedapplications);		
			nextURL = "/UserHome.jsp";
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
