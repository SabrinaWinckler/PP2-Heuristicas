/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Lucas
 */
public class View extends Application {

    Group group;
    Stage stage;
    Scene scene;
    Button button;
    ArrayList<Rectangle> list;

    int contador;

    @Override
    public void start(Stage stage) {

        list = new ArrayList();

        this.stage = stage;
        stage.setTitle("MPSoc");
        group = new Group();
        scene = new Scene(group, 800, 600);
        stage.setScene(scene);

        button = new Button("Start");
        button.setLayoutX(740);
        button.setLayoutY(570);

        group.getChildren().add(button);

        contador = 0;

        stage.show();

        button.setOnAction(event -> {
            buttonClick();
        });

    }

    public void printTela() {

        Label label = new Label(String.valueOf(contador));
        label.setLayoutX(contador * 100);
        
        list.add(new Rectangle(contador * 100, 0, 30, 30));
        list.get(contador).setFill(Color.BLUE);

        group.getChildren().add(label);
        group.getChildren().add(list.get(contador));
        
        label.toFront();

        stage.show();
    }

    public void buttonClick() {

        printTela();
        contador++;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
