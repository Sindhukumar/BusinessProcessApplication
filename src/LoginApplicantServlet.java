

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Tools.ManageApplication;
import model.Bpapplication;

/**
 * Servlet implementation class ApplicantServlet
 */
@WebServlet("/LoginApplicantServlet")
public class LoginApplicantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginApplicantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			
		long applicantid = Long.parseLong(request.getParameter("applicationid"));
		Bpapplication application = ManageApplication.getApplication(applicantid);
		
		
		HttpSession session = request.getSession();

		session.setAttribute("application", application);
		String nextURL = "/StatusCheck.jsp";
		response.sendRedirect(request.getContextPath() + nextURL);

	}

}
