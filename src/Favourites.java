import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
		JSONObject info = new JSONObject();
		JSONArray  addresses = new JSONArray();
				
		try {
			info.put("city",request.getParameter("city"));
			info.put("weather",request.getParameter("weather"));
			info.put("temp",request.getParameter("temp"));
			info.put("min_temp",request.getParameter("min_temp"));
			info.put("max_temp",request.getParameter("max_temp"));
			info.put("wind_speed",request.getParameter("wind_speed"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			
			FileWriter jsonFileWriter = new FileWriter("C:\\Users\\Nikhil\\Documents\\Workspace\\ClearSky\\src\\fav.json");
			//System.out.println(info.toString());
			jsonFileWriter.write(info.toString());
			jsonFileWriter.flush();
			jsonFileWriter.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			response.setContentType("application/json");
			response.getWriter().write(info.toString());
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
