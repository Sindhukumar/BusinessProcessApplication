
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Tools.DBUtil;
import Tools.ManageUser;
import model.Bpuser;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserLoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nextURL = "/UserLoginPage.jsp";
		HttpSession session = request.getSession();
		if ("true".equalsIgnoreCase(request.getParameter("logout"))) {
			session.setAttribute("user", null);
			session.setAttribute("appliedapplications", null);
			session.setAttribute("currentapplication", null);
			session.setAttribute("currentapplicationstages", null);
			session.setAttribute("usergravatar", null);
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

		Bpuser user = ManageUser.isValidUser(email, password);
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		if (user != null) {
			String usergravatar = DBUtil.getGravatarURL(user.getEmail(), 50);
			System.out.println(usergravatar);
			session.setAttribute("usergravatar", usergravatar);
			nextURL = "/UserHomeServlet";
		}

		else {
			nextURL = "/UserLoginPage.jsp?error=nomatch";
		}
		response.sendRedirect(request.getContextPath() + nextURL);

	}

}
