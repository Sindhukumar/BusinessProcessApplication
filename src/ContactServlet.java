

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


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
			e.printStackTrace();
		}

		String nextURL = "/Success.jsp";
		response.sendRedirect(request.getContextPath() + nextURL);

	}

}
