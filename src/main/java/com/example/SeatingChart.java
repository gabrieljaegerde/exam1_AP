package com.example;

import java.util.List;

public class SeatingChart {
    private Student[][] seats;

    public SeatingChart(List<Student> studentList, int rows, int cols) {
        seats = new Student[rows][cols];
        int studentIndex = 0;

        for (int c = 0; c < cols; c++) {
            for (int r = 0; r < rows; r++) {
                if (studentIndex < studentList.size()) {
                    seats[r][c] = studentList.get(studentIndex);
                    studentIndex++;
                } else {
                    seats[r][c] = null;
                }
            }
        }
    }

    public int removeAbsentStudents(int allowedAbsences) {
        int removedStudentsCount = 0;

        for (int r = 0; r < seats.length; r++) {
            for (int c = 0; c < seats[r].length; c++) {
                Student student = seats[r][c];
                if (student != null && student.getAbsenceCount() > allowedAbsences) {
                    seats[r][c] = null;
                    removedStudentsCount++;
                }
            }
        }

        return removedStudentsCount;
    }

    public Student[][] getSeats() {
        return seats;
    }
}
