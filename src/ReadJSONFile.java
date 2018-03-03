import java.io.FileReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Servlet implementation class ReadJSONFile
 */
@WebServlet("/ReadJSONFile")
public class ReadJSONFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int count;
	private String path = "C:\\Users\\Nikhil\\Documents\\Workspace\\ClearSky\\src\\fav.json";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadJSONFile() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		JSONObject main = new JSONObject();
		JSONArray  cities = new JSONArray();
		JSONObject city = new JSONObject();
		
			JSONParser parser = new JSONParser();
		    try {
				main = (JSONObject) parser.parse(new FileReader(path));
				this.count = Integer.parseInt(String.valueOf(main.get("Count")));
				
				System.out.println(this.count);
				cities = (JSONArray) main.get("cities");
				city = (JSONObject) cities.get(0);
				System.out.println(city.get("city"));
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
