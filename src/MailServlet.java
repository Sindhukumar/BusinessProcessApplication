

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import javax.servlet.http.HttpSession;

import model.Bpapplication;

/**
 * Servlet implementation class MailServlet
 */
@WebServlet("/MailServlet")
public class MailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		HttpSession session = request.getSession();
		String action =request.getParameter("action");
		//System.out.println(action);
		Bpapplication application= (Bpapplication) session.getAttribute("application");
		
		

			String firstname=application.getFullname();
			String email= application.getEmail();

			session.setAttribute("email", email);
			
		
			String to = email;
			String from ="bpa.com";
			String subject="Thank you for your application";
			long applicationid = application.getBpapplicationid();
			String body = "Thank you for your application . Your application is is"+applicationid ;
			 
			 
			boolean isBodyHTML=false;
			System.out.println(isBodyHTML);
			
				try {
					
					JavaMail.sendMail(to, from, subject, body, isBodyHTML);	
					System.out.println(body);
				} catch (javax.mail.MessagingException e) {
					// TODO Auto-generated catch block
					String errorMessage="Error: Unable to send message";
				}
				
				String nextURL="/confirm.jsp";
				response.sendRedirect(request.getContextPath() + nextURL);
				
		}



	}

