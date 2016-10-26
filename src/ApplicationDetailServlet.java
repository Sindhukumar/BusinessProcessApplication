

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
import model.Bpstage;

/**
 * Servlet implementation class ApplicationDetailServlet
 */
@WebServlet("/ApplicationDetailServlet")
public class ApplicationDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplicationDetailServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextURL = "/EmployerHomeServlet";
		HttpSession session = request.getSession();
		long id = Long.parseLong(request.getParameter("id"));
		Bpapplication currentapplication = ManageApplication.getApplication(id);
		if (currentapplication != null) {
			List<Bpstage> currentapplicationstages = ManageStage.getStagesByApplication(currentapplication);
			session.setAttribute("currentapplication", currentapplication);
			session.setAttribute("currentapplicationstages", currentapplicationstages);
			nextURL = "/ApplicationDetails.jsp";
		}
		response.sendRedirect(request.getContextPath() + nextURL);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
