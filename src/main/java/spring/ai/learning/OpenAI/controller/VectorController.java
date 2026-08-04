package spring.ai.learning.OpenAI.controller;

import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VectorController {

    private final VectorStore vectorStore;

    public VectorController(VectorStore vectorStore) {
        this.vectorStore = vectorStore;
    }


    @GetMapping("/store")
    public String store() {

        Document document =
                new Document("Spring Boot supports REST APIs");

        vectorStore.add(List.of(document));

        return "stored";
    }
}