package spring.ai.learning.OpenAI.controller;


import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmbeddingController {

    private final EmbeddingModel embeddingModel;

    public EmbeddingController(EmbeddingModel embeddingModel) {
        this.embeddingModel = embeddingModel;
    }

    @GetMapping("/embed")
    public void embed(@RequestParam String s1, @RequestParam String s2) {
        float[] vector1 = embeddingModel.embed(s1);

        float[] vector2 = embeddingModel.embed(s2);

        for(int i=0;i<vector1.length;i++)
            System.out.print(vector1[i]+ " , ");

        System.out.println("---------------------------");

        for(int i=0;i<vector2.length;i++)
            System.out.print(vector1[i]+ " , ");
    }
}