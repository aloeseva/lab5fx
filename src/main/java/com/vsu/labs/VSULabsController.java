package com.vsu.labs;

import com.vsu.labs.lab5.Lab5Service;
import com.vsu.labs.lab6.Lab6Service;
import com.vsu.labs.lab7.Lab7Service;
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

    public Menu menuLabs;
    public Pane paneLab5;
    public Label labelTypeLab5;
    public Button buttonCreateFigureLab5;
    public TextField textFieldSizeOfFigureLab5;
    public TextArea textAreaOutputFigureLab5;
    public Pane paneLab6;
    public Label labelTypeLab6;
    public Button buttonLab6;
    public TextArea textAreaOutputLab6;
    public TextField textFieldXLab6;
    public TextField textFieldNLab6;
    public TextField textFieldELab6;
    public MenuItem menuItemLab5;
    public MenuItem menuItemLab6;
    public Button buttonTestLab7;
    public Button buttonSearchSolution;
    public TextArea textAreaOutputLab7;
    public TextArea textAreaInputLab7;
    public Label labelTypeLab7;
    public Pane paneLab7;
    public MenuItem menuItemLab7;
    public Button buttonCleanLab7;
    private Pane selectedPane;
    private double x, y;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        selectedPane = paneLab7;
        selectedPane.setVisible(true);
        paneLab6.setVisible(false);
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
    public void menuLab7Click() {
        selectPane(paneLab7);

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
            textAreaOutputLab6.setText(Lab6Service.result(x, n, e));
        }
    }

    @FXML
    public void buttonSearchSolutionOnClick() {
        String str = textAreaInputLab7.getText();
        if (!str.isEmpty()) {
            try {
                int[] mas = Lab7Service.parsToMassive(str);
                textAreaOutputLab7.setText(Lab7Service.solution(mas));
            } catch (NumberFormatException ex) {
                textAreaOutputLab7.setText("Введите массив целых чисел через один пробел!");
//                ex.printStackTrace();
            }
        }
    }

    @FXML
    public void buttonTestLab7OnClick() {
        String str = """
                1 = {2 3 4 5 13 1 2 3 4 5 5 1}
                2 = {2 3 4 5 13 1 2 3 4 5 5 1}
                3 = {2 3 4 5 13 1 2 3 4 5 5 1}
                4 = {2 3 4 5 13 1 2 3 4 5 5 1}
                5 = {2 3 4 5 13 1 2 3 4 5 5 1}
                6 = {2 3 4 5 13 1 2 3 4 5 5 1}
                7 = {2 3 4 5 13 1 2 3 4 5 5 1}
                8 = {2 3 4 5 13 1 2 3 4 5 5 1}
                9 = {2 3 4 5 13 1 2 3 4 5 5 1}
                10 = {2 3 4 5 13 1 2 3 4 5 5 1}
                """;
        textAreaInputLab7.setText(str);
        String s = textAreaInputLab7.getText();
        String[] tokens = s.split("}\n");
        StringBuilder strResult = new StringBuilder();
        int l = tokens.length;
        for (int i = 0; i < l - 1; i++) {
            int[] mas = Lab7Service.parsToMassive(tokens[i].split(i + 1 + " = \\{")[1]);
            String solution = Lab7Service.solution(mas);
            strResult.append(i + 1).append(" = ").append(solution).append("; ");
        }
        int[] mas = Lab7Service.parsToMassive(tokens[l - 1].split(10 + " = \\{")[1]);
        String solution = Lab7Service.solution(mas);
        strResult.append(l).append(" = ").append(solution).append(";");

        textAreaOutputLab7.setText(strResult.toString());
    }

    @FXML
    public void buttonCleanLab7OnClick() {
        textAreaInputLab7.setText("");
        textAreaOutputLab7.setText("");
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
            if (s < 2 || s % 2 != 0) {
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
            textAreaOutputLab6.setText("s и/или e не числа!");
            ex.printStackTrace();
        }

        return s;
    }

    private int inputCheck3(String str) {
        int s = -1;

        try {
            s = Integer.parseInt(str);
            if (s < 2) {
                textAreaOutputLab6.setText("Введите n большее или равное 2!");
                s = -1;
            }
        } catch (NumberFormatException ex) {
            textAreaOutputLab6.setText("Введите n, как целое число!");
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