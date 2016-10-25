
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Tools.ManageApplication;
import Tools.ManageStage;
import model.Bpapplication;
import model.Bpemployer;
import model.Bpstage;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/EmployerActionServlet")
public class EmployerActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployerActionServlet() {
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
			List<Bpstage> stages = null;
			switch (employer.getRole().toLowerCase()) {
			case "complianceofficer":
				stages = ManageStage.getStagesByName("nationality");
				break;
			case "hrassistant":
				stages = ManageStage.getStagesByName("history", "veteran");
				break;
			case "hrspecialist":
				stages = ManageStage.getStagesByName("degree");
				break;
			case "healthcarespecialist":
				stages = ManageStage.getStagesByName("drugStandard", "drugPot", "drugAlchol");
				break;
			case "hrmanager":
				stages = ManageStage.getStagesByName("hrinterview");
				break;
			case "hiringmanager":
				stages = ManageStage.getStagesByName("secondinterview","codingtest");
				break;
			case "interviewleader":
				stages = ManageStage.getStagesByName("groupinterview","codingtest");
				break;
			}
			session.setAttribute("stages", stages);
			nextURL = "/EmployerActionItems.jsp";
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
