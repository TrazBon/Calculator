package com.example.javafx.calculator;


public class LastButtonType {
    private short condition;

    //Конструктор ставит флаг как "без последней кнопки"
    public LastButtonType() {
        this.condition = '0';
    }

    // Получить состояние стрингом
    public String getCondition() {
        switch (condition){
            case '1': return "digital";
            case '2': return "dualOperation";
            case '3': return "singleOperation";
            case '4': return "calculate";
            case '5': return "CE";
            default: return "noLastButton";
        }
    }

    //Булевые проверки на состояние
    public boolean isDigital(){
        if (this.condition == 1)
            return true;
        else return false;
    }
    public boolean isDualOperation(){
        if (this.condition == 2)
            return true;
        return false;
    }
    public boolean isSingleOperation(){
        if (this.condition == 3)
            return true;
        return false;
    }
    public boolean isCalculate(){
        if (this.condition == 4)
            return true;
        return false;
    }
    public boolean isCE(){
        if (this.condition == 5)
            return true;
        return false;
    }

    //Сеттеры состояний
    public void setDigital() {
        this.condition = 1;
    }
    public void setDualOperation() {
        this.condition = 2;
    }
    public void setSingleOperation() {
        this.condition = 3;
    }
    public void setCalculate() {
        this.condition = 4;
    }
    public void setCE() {
        this.condition = 5;
    }
}
