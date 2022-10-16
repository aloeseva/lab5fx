package com.vsu.labs;

import com.vsu.labs.lab5.Lab5Service;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class VSULabsController implements Initializable {

    public Menu menuLab5;
    public Pane paneLab5;
    public Label labelTypeLab5;
    public Button buttonCreateFigureLab5;
    public TextField textFieldSizeOfFigureLab5;
    public TextArea textAreaOutputFigureLab5;
    public Menu menuLab6;
    public Pane paneLab6;
    public Label labelTypeLab6;
    public Button buttonCreate1Lab6;
    public Button buttonCreate2Lab6;
    public Button buttonCreate3Lab6;
    public Button buttonCreate4Lab6;
    public TextArea textAreaOutputFigureLab6;
    public TextField textField1Lab6;
    public TextField textField2Lab6;
    public TextField textField3Lab6;
    public MenuItem menuItemLab5;
    public MenuItem menuItemLab6;
    private Pane selectedPane;
    private double x, y;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        selectedPane = paneLab5;
        selectedPane.setVisible(true);
        paneLab6.setVisible(false);
    }

    @FXML
    public void menuLab5Click() {
        selectPane(paneLab5);
    }

    @FXML
    public void menuLab6Click() {
        selectPane(paneLab6);
    }

    @FXML
    protected void buttonCreateFigureOnClick() {
        int s = inputCheck(textFieldSizeOfFigureLab5.getText());
        if (s != -1) {
            textAreaOutputFigureLab5.setText(Lab5Service.figure(s));
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

        try {
            s = Integer.parseInt(str);
            if (s < 2) {
                textAreaOutputFigureLab5.setText("Введите число большее или равное 2!");
                s = -1;
            }
        } catch (NumberFormatException ex) {
            textAreaOutputFigureLab5.setText("Введите целое число!");
            ex.printStackTrace();
        }

        return s;
    }

    private void selectPane(Pane pane) {
        this.selectedPane.setVisible(false);
        pane.setVisible(true);
        selectedPane = pane;
    }

    public void buttonCreate4OnClick() {

    }

    public void buttonCreate3OnClick() {

    }

    public void buttonCreate2OnClick() {

    }

    public void buttonCreate1OnClick() {

    }
}