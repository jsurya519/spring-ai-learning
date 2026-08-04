package spring.ai.learning.OpenAI.controller;


import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.ai.learning.OpenAI.util.CosineSimilarityCalculator;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmbeddingController {

    private final EmbeddingModel embeddingModel;

    private List<float[]> vectors;

    public EmbeddingController(EmbeddingModel embeddingModel) {
        this.embeddingModel = embeddingModel;
        vectors = new ArrayList<>();

        String s1 = "Spring Boot supports REST APIs";
        String s2 = "Kafka is a distributed messaging system";

        vectors.add(embeddingModel.embed(s1));
        vectors.add(embeddingModel.embed(s2));
    }

    @GetMapping("/embed")
    public double embed(@RequestParam String s1, @RequestParam String s2) {
        float[] vector1 = embeddingModel.embed(s1);
        float[] vector2 = embeddingModel.embed(s2);

        return CosineSimilarityCalculator.calculate(vector1, vector2);
    }


    @GetMapping("/getRelevant")
    public String getRelevant(@RequestParam String s1) {
        float[] vector1 = embeddingModel.embed(s1);



        double res1 = CosineSimilarityCalculator.calculate(vector1, vectors.get(0));
        double res2 = CosineSimilarityCalculator.calculate(vector1, vectors.get(1));

        return res1 > res2 ? "S1":"S2";
    }



}