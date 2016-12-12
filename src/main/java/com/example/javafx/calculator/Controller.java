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

    //Результат вычислений
    long activeResult;
    //Активная строка, хранит текущее значение вводимое юзером
    String fieldActive = new String();
    long longActive;
    //Последняя нажатая кнопка цифровая
    boolean isLastButtonIsNumber = false;
    //Массив с операндами и операциями
    public LinkedList<Operand> mapOperations = new LinkedList<>();

    //Действие цифровых клавиш
    public void enterDigital(ActionEvent actionEvent) {
        //Если последняя кнопка не номер то чистим дисплей
        if (isLastButtonIsNumber){
            display.setText("я");
        }
        //Тащим кнопку из экшена
        Button button = (Button) actionEvent.getSource();
        //Дописываем в активную строку значение кликнутой кнопки
        fieldActive += button.getText();
        //Выводим значение активной строки на дисплей
        System.out.println(fieldActive);
        setDisplayText(fieldActive);
        //Меняем флаг последней нажатой кнопки
        isLastButtonIsNumber = true;
    }

    //Действие операционных клавиш
    public void doubleOperation(ActionEvent actionEvent) {
        
        //Выводим на дисплей результат(Расчитываем текущий результат)
        setDisplayText(String.valueOf(calculateResult()));

        //Записываем в массив операнд и операцию
        writeToMapOfOperations();

        //Меняем флаг последней нажатой кнопки
        isLastButtonIsNumber = false;

//        //Чистим дисплей
//        setDisplayText("");
//
//        //Преобразуем активную строку в лонг
//        try {
//                longActive = Long.valueOf(fieldActive);
//        }catch (NumberFormatException e){
//            System.err.println("Неверный формат строки");
//        }
//
//        //Тащим кнопку из экшена
//        Button button = (Button) actionEvent.getSource();
//
//
//        //Результат переносим в активную строку
//        fieldActive = String.valueOf(calculationResult);
//
//        //Выводим на дисплей
//        setDisplayText(fieldActive);
//

    }
    private void writeToMapOfOperations() {
    }

    private long calculateResult() {
        //Тут храним результат
        long result = 0;
        //Проходим массив и последовательно выполняем операции
        for (Operand operand : mapOperations) {
            switch (operand.getOperation()){
                case '+':
                    result += operand.getOperand();
                    break;
                case '-':
                    result -= operand.getOperand();
                    break;
                case '*':
                    result = result * operand.getOperand();
                    break;
                case '/':
                    result = result / operand.getOperand();
                    break;
                default:
                    System.out.println("действие не распознано");
            }
        }
        return result;
    }

    //Сеттер текста для дисплея
    public void setDisplayText(String s){
        display.setText(s);
    }
}
