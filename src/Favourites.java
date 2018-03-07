import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Servlet implementation class Favourites
 */
@WebServlet("/Favourites")
public class Favourites extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int count;
	private String path = "C:\\Users\\Nikhil\\Documents\\Workspace\\ClearSky\\src\\fav.json";
       
    public Favourites() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action=request.getParameter("action");
		System.out.println("here" +action);
		
		if(action.equalsIgnoreCase("add"))
		{
			JSONObject main = new JSONObject();
			JSONArray  cities = new JSONArray();
			JSONObject city = new JSONObject();
			
				JSONParser parser = new JSONParser();
			    try {
					main = (JSONObject) parser.parse(new FileReader(path));		//reading json file & get count
					this.count = Integer.parseInt(String.valueOf(main.get("Count")));
					
					//System.out.println(this.count);
					cities = (JSONArray) main.get("cities");
					
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			
			try {
				count++;			//if json file doesn't exist create one otherwise append at end
				if(count>10)
				{
					cities.remove(0);
					count--;
				}
				main.put("Count",count );
				System.out.println(request.getParameter("city"));
				city.put("city",request.getParameter("city"));
				city.put("weather",request.getParameter("weather"));
				city.put("temp",request.getParameter("temp"));
				city.put("min_temp",request.getParameter("min_temp"));
				city.put("max_temp",request.getParameter("max_temp"));
				city.put("wind_speed",request.getParameter("wind_speed"));
				cities.add(city);
				main.put("cities",cities);
				
				FileWriter jsonFileWriter = new FileWriter(path);
				//System.out.println(info.toString());
				jsonFileWriter.write(main.toString());
				jsonFileWriter.flush();
				jsonFileWriter.close();
				
			} catch (Exception e) {
				
				e.printStackTrace();
			} finally {
				response.setContentType("application/json");
				response.getWriter().write(main.toString());	//sending response to add ajax call
			}
		}
		
		if(action.equalsIgnoreCase("view"))
		{
			JSONParser parser = new JSONParser();
			try {
				JSONObject main = (JSONObject) parser.parse(new FileReader(path));
				response.setContentType("application/json");
				response.getWriter().write(main.toString());	//sending response to view ajax call
			} catch (ParseException e) {
				e.printStackTrace();
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
