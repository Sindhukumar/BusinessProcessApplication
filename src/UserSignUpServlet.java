
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Tools.HashPassword;
import Tools.ManageUser;
import model.Bpuser;

/**
 * Servlet implementation class ApplicationServlet
 */
@WebServlet("/UserSignUpServlet")
public class UserSignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserSignUpServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nextURL = "/UserSignUp.jsp";

		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String summary = request.getParameter("summary");
		String objective = request.getParameter("objective");
		String skills = request.getParameter("skills");
		String education = request.getParameter("education");
		String password = request.getParameter("password");
		String awards = request.getParameter("awards");
		Bpuser user = new Bpuser();

		user.setEmail(email);
		user.setAddress(address);
		user.setEducation(education);
		user.setSummary(summary);
		user.setObjective(objective);
		user.setSkills(skills);
		user.setAwards(awards);
		user.setPasswordhash(HashPassword.Hash(email, password));

		ManageUser.add(user);
		nextURL = "/UserLoginPage.jsp";
		response.sendRedirect(request.getContextPath() + nextURL);

	}

}
