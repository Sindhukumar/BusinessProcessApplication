

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Tools.ManageApplication;
import Tools.ManageJob;
import Tools.ManageStage;
import model.Bpapplication;
import model.Bpstage;

/**
 * Servlet implementation class ApplicationServlet
 */
@WebServlet("/ApplicationServlet")
public class ApplicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplicationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String jobid = request.getParameter("jobid");
		System.out.println("****************** JOB ID *************" +jobid);
		session.setAttribute("jobid", jobid);

		String nextURL="/Application.jsp";
		response.sendRedirect(request.getContextPath() + nextURL);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String nextURL = null;
			long jobid = Long.parseLong(session.getAttribute("jobid").toString());
			System.out.println("the job id in the session is" +jobid);
			
			String fullname = request.getParameter("fullname");
			String email = request.getParameter("email");
			String address = request.getParameter("address");
			String birthday = request.getParameter("birthday");
			String summary = request.getParameter("summary");
			String objective = request.getParameter("objective");
			String skills = request.getParameter("skills");
			String education = request.getParameter("education");
			String jobhistory = request.getParameter("jobhistory");	
			String references = request.getParameter("references");
			String druguse = request.getParameter("druguse");
			String veteran = request.getParameter("veteran");
			String citizenship = request.getParameter("citizenship");
			
		
			Bpapplication application = new Bpapplication();
			
			application.setBpjob(ManageJob.getjob(jobid));
			application.setFullname(fullname);
			application.setEmail(email);
			application.setAddress(address);	
			application.setBirthday(birthday);
			application.setEducation(education);
			application.setSummary(summary);
			application.setObjective(objective);
			application.setSkills(skills);
			application.setJobhistory(jobhistory);
			application.setReferences(references);
			application.setDruguse(druguse);
			application.setVeteran(veteran);
			application.setCitizenship(citizenship);
			application.setStatus("processing");
			
			session.setAttribute("application", application);
			
			
			if("resume".equalsIgnoreCase(request.getParameter("action"))){
				nextURL = "/Resume.jsp";
			}
			

			else if("apply".equalsIgnoreCase(request.getParameter("action")))
			{
			application = ManageApplication.add(application);
			System.out.println("Application added");
			Bpstage  stage = new Bpstage();
			stage.setStagename("nationality");
			stage.setBpapplication(application);
			stage.setStageresult("inprogress");
			ManageStage.add(stage);
			
			nextURL="/MailServlet";
			}
			response.sendRedirect(request.getContextPath() + nextURL);	
			
			
	}

}
