/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import controller.DoctorManager;
import java.util.ArrayList;
import model.Doctor;
import model.DoctorList;
import view.Menu;

/**
 *
 * @author HP
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Doctor> ld = new ArrayList<>();
        String title = "Doctor Management ";
        String[] s = new String[]{"Add Doctor ", "Update Doctor",
            "Delete Doctor ", "Search Doctor ", "Exit"};
        Menu<String> menu = new DoctorManager(title, s);
        menu.run();
    }
}
