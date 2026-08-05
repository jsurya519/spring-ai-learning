package spring.ai.learning.OpenAI.tools;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

@Component
public class WeatherTool {

    @Tool(description = "Get current weather for a city")
    public String getWeather(String city) {

        if(city.equalsIgnoreCase("Hyderabad"))
            return "Temperature is 32°C and Sunny";

        if(city.equalsIgnoreCase("Chennai"))
            return "Temperature is 35°C and Humid";

        return "Weather not available";
    }
}
