
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Tools.ManageApplication;
import Tools.ManageQuestions;
import Tools.ManageStage;
import model.Bpapplication;
import model.Bpemployer;
import model.Bpquestion;
import model.Bpstage;

/**
 * Servlet implementation class UpdateStageServlet
 */
@WebServlet("/UpdateStageServlet")
public class UpdateStageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateStageServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nextURL = "/EmployerActionServlet";
		HttpSession session = request.getSession();
		long stageid = Long.parseLong(request.getParameter("stageid"));
		Bpstage currenstage = ManageStage.getStage(stageid);
		session.setAttribute("currenstage", null);
		
		String tittle = currenstage.getBpapplication().getBpjob().getTittle();
		String stagequestions = currenstage.getStagename();
		System.out.println("the title is " +tittle);
		System.out.println("the stage name is " +stagequestions);
		
		
		if (currenstage != null) {
			session.setAttribute("currenstage", currenstage);
			
			if(stagequestions.equalsIgnoreCase("hrinterview")||stagequestions.equalsIgnoreCase("secondinterview")||stagequestions.equalsIgnoreCase("groupinterview"))
			{
				List<Bpquestion> questions = ManageQuestions.getStagesByTitle(tittle, stagequestions);
				session.setAttribute("questions", questions);
			}
				nextURL = "/UpdateStage.jsp";
		}
		
		response.sendRedirect(request.getContextPath() + nextURL);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String nextURL = "/EmployerActionServlet";
		Bpstage currenstage = (Bpstage) session.getAttribute("currenstage");
		Bpemployer employer = (Bpemployer) session.getAttribute("employer");
		String stageresult = request.getParameter("stageresult");
		String stagecomment = request.getParameter("comment");
		BigDecimal score = new BigDecimal( request.getParameter("score"));
		
		currenstage.setStageresult(stageresult);
		currenstage.setStagecomment(stagecomment);
		currenstage.setBpemployer(employer);
		currenstage.setScore(score);
		
		ManageStage.update(currenstage);
		Bpapplication application = currenstage.getBpapplication();
		if ("failed".equalsIgnoreCase(stageresult)) {
			application.setStatus("declined");
			ManageApplication.update(application);
		} else {
			Bpstage newstage = new Bpstage();
			newstage.setBpapplication(application);
			newstage.setStageresult("inprogress");
			switch (currenstage.getStagename().toLowerCase()) {
			case "nationality":
				newstage.setStagename("history");
				break;
			case "history":
				newstage.setStagename("degree");
				break;
			case "degree":
				newstage.setStagename("drugstandard");
				break;
			case "drugstandard":
				newstage.setStagename("drugpot");
				break;
			case "drugpot":
				newstage.setStagename("drugalchol");
				break;
			case "drugalchol":
				newstage.setStagename("veteran");
				break;
			case "veteran":
				newstage.setStagename("hrinterview");
				break;
			case "hrinterview":
				newstage.setStagename("secondinterview");
				break;
			case "secondinterview":
				newstage.setStagename("groupinterview");
				break;
			case "groupinterview":
				if ("technical".equalsIgnoreCase(application.getBpjob().getJobtype())) {
					newstage.setStagename("codingtest");
				}else{
					application.setStatus("hired");
				}
				
				break;
			case "codingtest":
				application.setStatus("hired");
				break;
			}
			if(!"".equalsIgnoreCase(newstage.getStagename())){
				ManageStage.add(newstage);
			}
		}
		response.sendRedirect(request.getContextPath() + nextURL);
	}

}
