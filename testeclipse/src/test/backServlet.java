package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class backServlet
 */
@WebServlet("/backServlet")
public class backServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public backServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int a=Integer.parseInt(request.getParameter("firstnumber"));
		int b=Integer.parseInt(request.getParameter("secondnumber"));
		RequestDispatcher dispatcher =  request.getRequestDispatcher("/backpage.jsp");
		String c = request.getParameter("option");
		response.setContentType("text/html");
		//PrintWriter out = response.getWriter();
		if(c.equals("add")) {
			int d = a+b;
			request.setAttribute("output",d);
	    	//RequestDispatcher dispatcher =  request.getRequestDispatcher("/backpage.jsp");
	    	dispatcher.forward(request, response);
		}
		else if(c.equals("subtract")) {
			int d = a-b;
			request.setAttribute("output",d);
	    	//RequestDispatcher dispatcher =  request.getRequestDispatcher("/backpage.jsp");
	    	dispatcher.forward(request, response);
		}
		else if(c.equals("multiply")) {
			int d = a*b;
			request.setAttribute("output",d);
	    	//RequestDispatcher dispatcher =  request.getRequestDispatcher("/backpage.jsp");
	    	dispatcher.forward(request, response);
		}
		else if(c.equals("divide")) {
		if(b == 0) {
			RequestDispatcher dispatch =  request.getRequestDispatcher("/redirect.jsp");
			dispatch.forward(request, response);
		}
		else {
			int d = a/b;
			request.setAttribute("output",d);
	    	//RequestDispatcher dispatcher =  request.getRequestDispatcher("/backpage.jsp");
	    	dispatcher.forward(request, response);
		}
		}
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
