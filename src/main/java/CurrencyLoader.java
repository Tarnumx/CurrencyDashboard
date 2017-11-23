import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CurrencyLoader {

    static final String CURRENCY_API = "https://www.cbr-xml-daily.ru/daily_json.js";


    static JSONObject getJSONData(String source) {
        try {
            URL url = new URL(source);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder rawData = new StringBuilder();

            String temp;
            while ((temp = reader.readLine()) != null) {
                rawData.append(temp).append("\n");
            }
            reader.close();

            JSONObject jsonObject = new JSONObject(rawData.toString());
            return jsonObject;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
