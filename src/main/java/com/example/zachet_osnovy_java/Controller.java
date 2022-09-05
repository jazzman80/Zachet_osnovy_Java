package com.example.zachet_osnovy_java;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.List;

public class Controller {
    @FXML
    private Label name;

    @FXML
    private Label instructions;

    @FXML
    private ImageView imageView;

    @FXML
    protected void onButtonClick() {
        try{
            URL url = new URL("https://www.themealdb.com/api/json/v1/1/random.php");
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            connection.disconnect();

            ObjectMapper objectMapper = new ObjectMapper();
            LinkedList<Meal> mealList = new LinkedList<Meal>();

            mealList = objectMapper.readValue(content.toString(), new TypeReference<LinkedList<Meal>>(){});
            System.out.println(mealList);

            System.out.println(mealList.get(0).strMeal);
            //name.setText(jsonNode.get("strMeal").asText());
            //instructions.setText(jsonNode.get("strInstructions").asText());
            //Image image = new Image(jsonNode.get("strMealThumb").asText());
            //imageView.setImage(image);
        }
        catch (Exception exception){
            exception.getStackTrace();
        }


    }
}