package spring.ai.learning.OpenAI.tools;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import spring.ai.learning.OpenAI.models.EmailResponse;

@Component
public class WeatherTool {

    @Tool(description = "Get current weather for a city")
    public String getWeather(String city) {

        if(city.equalsIgnoreCase("Hyderabad"))
            return "Temperature is 30°C and Sunny";

        if(city.equalsIgnoreCase("Chennai"))
            return "Temperature is 41°C and Humid";

        return "Weather not available";
    }

    @Tool(description = "Get current time")
    public long getTime() {
        return System.currentTimeMillis();
    }

    @Tool(description = "Get stock price for a stock")
    public Double getStockPrice(String stockName) {
        return 286.8D;
    }


    @Tool(description = """
Send an email.

IMPORTANT:
Only call this tool after all required information is available.
The email body must contain the actual content to send.
Never send an email with empty subject or empty body.
If email content depends on another tool result, wait for that tool result first.
""")
    public EmailResponse sendEmail(String body, String subject, String toMailId, String fromMailId) {

        if(!StringUtils.hasText(body) ||  !StringUtils.hasText(subject) || !StringUtils.hasText(toMailId) || !StringUtils.hasText(fromMailId))
            return new EmailResponse(false, "Missing mandatory fields");
        return new EmailResponse(true, "Email sent successfully!");
    }


}
