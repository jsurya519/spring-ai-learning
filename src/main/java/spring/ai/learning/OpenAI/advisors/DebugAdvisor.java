package spring.ai.learning.OpenAI.advisors;

import org.springframework.ai.chat.client.ChatClientRequest;
import org.springframework.ai.chat.client.ChatClientResponse;
import org.springframework.ai.chat.client.advisor.api.CallAdvisor;
import org.springframework.ai.chat.client.advisor.api.CallAdvisorChain;


public class DebugAdvisor implements CallAdvisor {


    @Override
    public String getName() {
        return "debugAdvisor";
    }


    @Override
    public int getOrder() {
        return 0;
    }


    @Override
    public ChatClientResponse adviseCall(
            ChatClientRequest request,
            CallAdvisorChain chain) {


        System.out.println("========== REQUEST TO LLM ==========");
        System.out.println(request.prompt());
        System.out.println("====================================");


        ChatClientResponse response = chain.nextCall(request);


        System.out.println("========== RESPONSE FROM LLM ==========");
        System.out.println(response.chatResponse());
        System.out.println("=======================================");


        return response;
    }
}