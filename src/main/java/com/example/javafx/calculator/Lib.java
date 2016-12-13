package com.example.javafx.calculator;

import java.util.List;

/**
 * Created by sdv on 11.12.2016.
 * it's library for sdvCalculator
 */
public class Lib {

    //Вывод листа в строку
    static public String printOperandsList(List<Operand> list){
        String string = "";
        for (Operand operand : list) {
            string += operand.getOperation() + " " + operand.getOperand();
        }
        return string;
    }

    //расчет листа возврат итогового результата
    static public float calculateResultOfOperandsList(List<Operand> list) {
        float result = 0;//Тут храним результат
        for (Operand operand : list) {//Проходим массив и последовательно выполняем операции
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
                case ' ':
                    result += operand.getOperand();
                    break;
                default:
                    System.out.println("действие не распознано");
            }
        }
        return result;
    }

}
