package com.isilaev.test;

public class Employee implements Comparable<Employee> {
    private String firstName;
    private String lastName;
    private int roomNumber;

    public Employee(String firstName, String lastName, int roomNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.roomNumber = roomNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public int compareTo(Employee o) {
        if(roomNumber > o.getRoomNumber())
             return 1;
        else if(o.getRoomNumber() == roomNumber)
            return 0;

        return -1;
    }
}
