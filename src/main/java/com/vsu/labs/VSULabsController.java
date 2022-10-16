package com.vsu.labs;

import com.vsu.labs.lab5.Lab5Service;
import com.vsu.labs.lab6.Lab6Service;
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
    public Button buttonLab6;
    public TextArea textAreaOutputFigureLab6;
    public TextField textFieldXLab6;
    public TextField textFieldNLab6;
    public TextField textFieldELab6;
    public MenuItem menuItemLab5;
    public MenuItem menuItemLab6;
    private Pane selectedPane;
    private double x, y;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        selectedPane = paneLab6;
        selectedPane.setVisible(true);
        paneLab5.setVisible(false);
    }

    @FXML
    private void menuLab5Click() {
        selectPane(paneLab5);
    }

    @FXML
    private void menuLab6Click() {
        selectPane(paneLab6);
    }

    @FXML
    private void buttonCreateFigureOnClick() {
        int s = inputCheck(textFieldSizeOfFigureLab5.getText());
        if (s != -1) {
            textAreaOutputFigureLab5.setText(Lab5Service.figure(s));
        }
    }

    @FXML
    private void buttonLab6OnClick() {
        double x = inputCheck2(textFieldXLab6.getText());
        int n = inputCheck3(textFieldNLab6.getText());
        double e = inputCheck2(textFieldELab6.getText());
        if (x != -1 && n != -1 && e != -1) {
            textAreaOutputFigureLab6.setText(Lab6Service.result(x, n, e));
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
            if (s < 2 || s%2 != 0) {
                textAreaOutputFigureLab5.setText("Введите четное число большее или равное 2!");
                s = -1;
            }
        } catch (NumberFormatException ex) {
            textAreaOutputFigureLab5.setText("Введите целое число!");
            ex.printStackTrace();
        }

        return s;
    }

    private double inputCheck2(String str) {
        double s = -1;

        try {
            s = Double.parseDouble(str);
        } catch (NumberFormatException ex) {
            textAreaOutputFigureLab6.setText("s и/или e не числа!");
            ex.printStackTrace();
        }

        return s;
    }

    private int inputCheck3(String str) {
        int s = -1;

        try {
            s = Integer.parseInt(str);
            if (s < 2) {
                textAreaOutputFigureLab6.setText("Введите n большее или равное 2!");
                s = -1;
            }
        } catch (NumberFormatException ex) {
            textAreaOutputFigureLab6.setText("Введите n, как целое число!");
            ex.printStackTrace();
        }

        return s;
    }

    private void selectPane(Pane pane) {
        this.selectedPane.setVisible(false);
        pane.setVisible(true);
        selectedPane = pane;
    }
}