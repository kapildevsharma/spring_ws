import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;

public class ConsumeRestAPI {
	public static void main(String[] args) {
	
		ConsumeRestAPI api = new ConsumeRestAPI();
		List<String> countryList = api.getCountryList();
		System.out.println("Country List here :");
		for(String name : countryList){
			System.out.println(name);
		}
    }
	
	public List<String> getCountryList(){
		
		List<String> countriesList = new ArrayList<String>();
		try {
            URL url = new URL("http://restcountries.eu/rest/v2/all");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("User-Agent", "Mozilla/5.0");
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
            
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            
            StringBuffer jsonBuffer = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                jsonBuffer.append(line);
            }
            br.close();
            
            String jsonString = new String(jsonBuffer);
            
            try {
                JSONArray jsonarray = new JSONArray(jsonString);
                for (int i =0 ;i<jsonarray.length();i++){
                	countriesList.add(jsonarray.getJSONObject(i).getString("name"));
                }
            } catch (JSONException ex) {
               System.out.println("Invalid json : " + ex.getMessage());
               ex.printStackTrace();
            }
            
            conn.disconnect();
        } catch (Exception e) {
            System.out.println("Exception in " + e.getMessage());
            e.printStackTrace();
        }
		return countriesList;
	}
}


