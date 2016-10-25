

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ContactServlet
 */
@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactServlet() {
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

		HttpSession session = request.getSession();

		String to = request.getParameter("to");
		String from = request.getParameter("from");
		String subject = request.getParameter("subject");

		String body = "";
		body = request.getParameter("body");

		boolean isBodyHTML = false;
		System.out.println(isBodyHTML);
		System.out.println(to + from + subject + body);
		try {

			JavaMail.sendMail(to, from, subject, body, isBodyHTML);
			System.out.println(body);
		} catch (javax.mail.MessagingException e) {
			// TODO Auto-generated catch block
			String errorMessage = "Error: Unable to send message";
		}

		String nextURL = "/Success.jsp";
		response.sendRedirect(request.getContextPath() + nextURL);

	}

}
