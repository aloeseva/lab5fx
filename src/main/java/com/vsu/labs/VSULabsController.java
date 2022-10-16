package com.vsu.labs;

import com.vsu.labs.lab5.Lab5Service;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class VSULabsController {

    public Pane paneMain;
    public Label labelType;
    public Button buttonCreateFigure;
    public TextField textFieldSizeOfFigure;
    public Menu menuLab5;
    public TextArea textAreaOutputFigure;
    private double x, y;

    @FXML
    protected void buttonCreateFigureOnClick() {
        int s = inputCheck(textFieldSizeOfFigure.getText());
        if (s != -1) {
            textAreaOutputFigure.setText(Lab5Service.figure(s));
        }
    }

    @FXML
    private void close(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void min(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    private void dragged(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);
    }

    @FXML
    private void pressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }

    private int inputCheck(String str) {
        int s = -1;

        try{
            s = Integer.parseInt(str);
            if (s < 2) {
                textAreaOutputFigure.setText("Введите число большее или равное 2!");
                s = -1;
            }
        }
        catch (NumberFormatException ex){
            textAreaOutputFigure.setText("Введите целое число!");
            ex.printStackTrace();
        }

        return s;
    }
}