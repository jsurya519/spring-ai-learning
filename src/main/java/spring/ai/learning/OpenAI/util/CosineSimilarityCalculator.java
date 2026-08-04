package spring.ai.learning.OpenAI.util;

public class CosineSimilarityCalculator {

    public static double calculate(float[] vector1, float[] vector2) {

        if (vector1.length != vector2.length) {
            throw new IllegalArgumentException("Vectors must have same dimensions");
        }

        double dotProduct = 0.0;
        double magnitude1 = 0.0;
        double magnitude2 = 0.0;

        for (int i = 0; i < vector1.length; i++) {

            dotProduct += vector1[i] * vector2[i];

            magnitude1 += vector1[i] * vector1[i];

            magnitude2 += vector2[i] * vector2[i];
        }

        magnitude1 = Math.sqrt(magnitude1);
        magnitude2 = Math.sqrt(magnitude2);

        return dotProduct / (magnitude1 * magnitude2);
    }
}