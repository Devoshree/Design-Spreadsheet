package com.company;

import java.util.*;

public class Cell extends Observable implements Observer{
    private String formula = null;
    private final List<Cell> subjects = new ArrayList<>();
    private double value;

    public void addSubject(Cell subject) {
        subject.addObserver(this);
        this.subjects.add(subject);
    }

    public void setValue(double val) {
        this.value = val;
        setChanged();
        notifyObservers();
    }

    public void setValue() {
        if (formula != null && !subjects.isEmpty()) {
            setValue(eval());
        }
    }

    public void update(Observable o, Object arg) {
        setValue();
    }

    public double getValue() { return value; }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public String toString() { return "" + value; }


    private double eval() {
        double result = 0.0;
        Scanner tokens = new Scanner(formula);
        for (Cell subject : subjects) {
            double value = subject.getValue();
            double factor = tokens.nextDouble();
            result += factor * value;
            if (tokens.hasNext()) tokens.next(); // skip *
            if (tokens.hasNext()) tokens.next(); // skip si
            if (tokens.hasNext()) tokens.next(); // skip +
        }
        return result;
    }
}
