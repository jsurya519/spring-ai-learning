package spring.ai.learning.OpenAI.models;

public class EmailResponse {

    boolean success;
    String message;

    public EmailResponse(boolean success, String message)
    {
        this.success=success;
        this.message=message;
    }
}
