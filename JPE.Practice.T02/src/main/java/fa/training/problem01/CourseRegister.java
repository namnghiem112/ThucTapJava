package fa.training.problem01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CourseRegister {
    public Map<String, Integer> countStudent(String filePath) {
        Map<String, Integer> languageCount = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                getClass().getResourceAsStream(filePath)))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    String[] parts = line.split("_");
                    String language = parts[2];
                    languageCount.put(language, languageCount.getOrDefault(language, 0) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return languageCount;
    }

    public static void main(String[] args) {
        CourseRegister cr = new CourseRegister();
        Map<String, Integer> result = cr.countStudent("/course_register.txt");
        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
