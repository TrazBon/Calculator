package com.example.javafx.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.util.*;

public class Controller {
    @FXML
    javafx.scene.control.TextField display;
    @FXML
    javafx.scene.control.TextField displayTop;

    boolean isLastButtonIsNumber = false; //Последняя нажатая кнопка цифровая
    public LinkedList<Operand> listOfOperands = new LinkedList<>(); //Массив с операндами
    char lastOperation = ' '; //переменная для хранения последней введенной операции

    //Действие цифровых клавиш
    public void buttonEnterDigital(ActionEvent actionEvent) {
        if (!isLastButtonIsNumber) //Если последняя кнопка не номер то чистим дисплей
            display.setText("");
        Button button = (Button) actionEvent.getSource(); //Тащим кнопку из экшена
        display.setText(display.getText()+button.getText()); //Дописываем в дисплей значение кликнутой кнопки
        isLastButtonIsNumber = true; //Меняем флаг последней нажатой кнопки
    }

    //Действие операционных клавиш
    public void buttonDoubleOperation(ActionEvent actionEvent) {
        float digital = Float.valueOf(display.getText()); //Переменная для числового выражения в дисплее
        Button button = (Button) actionEvent.getSource(); //Тащим кнопку
        char operation = button.getText().charAt(0); //Вытаскиваем из кнопки символ операции
        float result; //Переменная с результатом

        Operand operand = new Operand(digital, lastOperation);//Создаем Операнд с последней операцией
        listOfOperands.add(operand); //Добавляем операнд в лист
        result = Lib.calculateResultOfOperandsList(listOfOperands);//Расчитываем результат и печатаем операнды в верхнем дисплее
        displayTop.setText(Lib.printOperandsList(listOfOperands));//Выводим на верхний дисплей весь лист
        display.setText(String.valueOf(result)); //Выводим на дисплей результат(Расчитываем текущий результат)

        lastOperation = operation;//Сохраняем текущую операцию
        isLastButtonIsNumber = false;//Меняем флаг последней нажатой кнопки на не цифру
    }
    //Дейстмие кнопки СЕ
    public void buttonCEClick(ActionEvent actionEvent){
        listOfOperands.clear();//чистим лист с операндами
        displayTop.clear();//Чистим дисплеи
        display.clear();

        lastOperation = ' ';
        isLastButtonIsNumber = false;//Меняем флаг последней нажатой кнопки на не цифру
    }

    //Действие кнопки равно
    public void buttonResultClick(ActionEvent actionEvent){
        float result; //Переменная с результатом
        float digital = Float.valueOf(display.getText());
        result = Lib.calculateResultOfOperandsList(listOfOperands);//Расчитываем результат и печатаем операнды в верхнем дисплее
        Operand operand = new Operand(digital, lastOperation);//Создаем Операнд с последней операцией
        listOfOperands.add(operand); //Добавляем операнд в лист
        displayTop.setText(Lib.printOperandsList(listOfOperands));//Выводим на верхний дисплей весь лист
        display.setText(String.valueOf(result)); //Выводим на дисплей результат(Расчитываем текущий результат)

        lastOperation = ' ';
        isLastButtonIsNumber = false;//Меняем флаг последней нажатой кнопки на не цифру
    }
}
