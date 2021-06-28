package com.company;

public class Main {
    public static SpreadSheet makeTestSheet() {

        SpreadSheet grades = new SpreadSheet(4, 4);

        // Smith's grades
        Cell smithAvg = grades.getCell(0, 3);
        smithAvg.setFormula("3.0 * s0 + 2.0 * s1 + 1.0 * s2");
        Cell exam = grades.getCell(0, 0);
        exam.setValue(8); // Smith's midterm 1
        smithAvg.addSubject(exam);
        exam = grades.getCell(0, 1);
        exam.setValue(10); // Smith's midterm 2
        smithAvg.addSubject(exam);
        exam = grades.getCell(0, 2);
        exam.setValue(5); // Smith's final, oops!
        smithAvg.addSubject(exam);

        // Jones's grades
        Cell jonesAvg = grades.getCell(1, 3);
        jonesAvg.setFormula("s0 +  s1 + s2");
        exam = grades.getCell(1, 0);
        exam.setValue(5); // Jones's midterm 1
        jonesAvg.addSubject(exam);
        exam = grades.getCell(1, 1);
        exam.setValue(7); // Jones's midterm 2
        jonesAvg.addSubject(exam);
        exam = grades.getCell(1, 2);
        exam.setValue(2); // Jones's final
        jonesAvg.addSubject(exam);

        Cell avg = grades.getCell(2, 3);
        avg.addSubject(smithAvg);
        avg.addSubject(jonesAvg);
        avg.setFormula("s0 + s1 + s2");

        return grades;
    }

    public static void main(String[] args) {

        SpreadSheet grades = makeTestSheet();
        System.out.println(grades);

        grades.getCell(0, 2).setValue(6); // Smith begged
        grades.getCell(1, 2).setValue(9); // Jones begged

        System.out.println(grades);

    }
}
