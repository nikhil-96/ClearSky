import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;/*
import org.json.JSONArray;
import org.json.JSONObject;*/

/**
 * Servlet implementation class Favourites
 */
@WebServlet("/Favourites")
public class Favourites extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Favourites() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String city = request.getParameter("city");
		
//		PrintWriter out = response.getWriter();
//		String s=request.getParameter("fun");
		
//		out.println("yues");
	/*	JSONObject json      = new JSONObject();
		JSONArray  addresses = new JSONArray();
		JSONObject address;
		try
		{
		   int count = 15;

		   for (int i=0 ; i<count ; i++)
		   {
		       address = new JSONObject();
		       address.put("CustomerName"     , "Decepticons" + i);
		       address.put("AccountId"        , "1999" + i);
		       address.put("SiteId"           , "1888" + i);
		       address.put("Number"            , "7" + i);
		       address.put("Building"          , "StarScream Skyscraper" + i);
		       address.put("Street"            , "Devestator Avenue" + i);
		       address.put("City"              , "Megatron City" + i);
		       address.put("ZipCode"          , "ZZ00 XX1" + i);
		       address.put("Country"           , "CyberTron" + i);
		       addresses.put(address);
		   }
		   json.put("Addresses", addresses);
		}
		catch (Exception jse)
		{ 

		}
		response.setContentType("application/json");*/
		response.getWriter().write(request.getParameter("city"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
