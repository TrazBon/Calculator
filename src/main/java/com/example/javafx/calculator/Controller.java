package com.example.javafx.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.util.*;

import static com.example.javafx.calculator.Lib.calculateResultOfOperandsList;

public class Controller {
    @FXML
    javafx.scene.control.TextField display;
    @FXML
    javafx.scene.control.TextField displayTop;

    private LastButtonType lastButton = new LastButtonType(); //Последняя нажатая кнопка
    private LinkedList<Operand> listOfOperands = new LinkedList<>(); //Массив с операндами
    private char lastOperation = ' '; //переменная для хранения последней введенной операции

    //Действие цифровых клавиш
    public void buttonEnterDigital(ActionEvent actionEvent) {
        if (!lastButton.isDigital()) //Если последняя кнопка не номер то чистим дисплей
            display.clear();

        Button button = (Button) actionEvent.getSource(); //Тащим кнопку из экшена
        display.setText(display.getText()+button.getText()); //Дописываем в дисплей значение кликнутой кнопки
        lastButton.setDigital(); //Меняем последноо кнопку
    }

    //Действие операционных клавиш
    public void buttonDualOperation(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource(); //Тащим кнопку
        char operation = button.getText().charAt(0); //Вытаскиваем из кнопки символ операции

        // Если последняя кнопка была цифрой то добавить запись в
        // лист операций, расчитать его и вывести информацию на дисплеи
        if (lastButton.isDigital()){
            float result; //Переменная с результатом
            float digital = Float.valueOf(display.getText()); //Переменная для числового выражения в дисплее

            Operand operand = new Operand(digital, lastOperation);//Создаем Операнд с последней операцией
            listOfOperands.add(operand); //Добавляем операнд в лист
            result = calculateResultOfOperandsList(listOfOperands);//Расчитываем результат и печатаем операнды в верхнем дисплее
            display.setText(String.valueOf(result)); //Выводим на дисплей результат(Расчитываем текущий результат)
        }

        lastOperation = operation;//Сохраняем текущую операцию
        displayTop.setText(Lib.printOperandsList(listOfOperands));//Выводим на верхний дисплей весь лист
        displayTop.setText(displayTop.getText() + " " + lastOperation);// дописываем последноо операцию
        lastButton.isDualOperation(); //Меняем последноо кнопку на двойную операцию
    }

    //Дейстмие кнопки СЕ
    public void buttonCEClick(ActionEvent actionEvent){
        listOfOperands.clear();//чистим лист с операндами
        displayTop.clear();//Чистим дисплеи
        display.clear();

        lastOperation = ' ';
        lastButton.setCE(); //Меняем флаг последней нажатой кнопки на CE
    }

    //Действие кнопки равно
    public void buttonResultClick(ActionEvent actionEvent){
        float result; //Переменная с результатом
        float digital = Float.valueOf(display.getText());
        displayTop.clear(); // Чистим верхний дисплей

        Operand operand = new Operand(digital, lastOperation);//Создаем Операнд с последней операцией
        listOfOperands.add(operand); //Добавляем операнд в лист
        result = calculateResultOfOperandsList(listOfOperands);//Расчитываем результат
        listOfOperands.clear(); // Чистим лист операндов

        display.setText(String.valueOf(result)); // Выводим на дисплей результат(Расчитываем текущий результат)

        lastOperation = ' ';
        lastButton.isCalculate(); //Меняем флаг последней нажатой кнопки на не цифру
    }
}
