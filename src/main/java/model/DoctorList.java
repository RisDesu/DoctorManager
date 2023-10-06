/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import common.Validation;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class DoctorList {
    ArrayList<Doctor> ld = new ArrayList<>();
    private Validation validation;
     
     
     public void addDoctor() {
        System.out.print("Enter code: ");
        String code = validation.checkInputString();
        //check code exist or not
        if (!validation.checkCodeExist(ld, code)) {
            System.err.println("Code exist.");
            return;
        }
        System.out.print("Enter name: ");
        String name = validation.checkInputString();
        System.out.print("Enter specialization: ");
        String specialization = validation.checkInputString();
        System.out.print("Enter availability: ");
        int availability = validation.checkInputInt();
        //check worker duplicate
        if (!validation.checkDuplicate(ld, code, name, specialization, availability)) {
            System.err.println("Duplicate.");
            return;
        }
        ld.add(new Doctor(code, name, specialization, availability));
        System.err.println("Add successful.");
    }

    public void updateDoctor() {
        System.out.print("Enter code: ");
        String code = validation.checkInputString();
        //check code exist or not
        if (validation.checkCodeExist(ld, code)) {
            System.err.println("Not found doctor");
            return;
        }
        System.out.print("Enter code: ");
        String codeUpdate = validation.checkInputString();
        Doctor doctor = getDoctorByCode(code);
        System.out.print("Enter name: ");
        String name = validation.checkInputString();
        System.out.print("Enter specialization: ");
        String specialization = validation.checkInputString();
        System.out.print("Enter availability: ");
        int availability = validation.checkInputInt();
        //check user change infomation or not
        if (!validation.checkChangeInfo(doctor, code, name, specialization, availability)) {
            System.err.println("No change");
            return;
        }
        doctor.setCode(codeUpdate);
        doctor.setName(name);
        doctor.setSpecialization(specialization);
        doctor.setAvailability(availability);
        System.err.println("Update successful");
    }

   
    public void deleteDoctor() {
        System.out.print("Enter code: ");
        String code = validation.checkInputString();
        Doctor doctor = getDoctorByCode(code);
        if (doctor == null) {
            System.err.println("Not found doctor.");
            return;
        } else {
            ld.remove(doctor);
        }
        System.err.println("Delete successful.");
    }

    //allow user search doctor
    public void searchDoctor() {
        System.out.print("Enter name: ");
        String nameSearch = validation.checkInputString();
        ArrayList<Doctor> listFoundByName = listFoundByName(nameSearch);
        if (listFoundByName.isEmpty()) {
            System.err.println("List empty.");
        } else {
            System.out.printf("%-10s%-15s%-25s%-20s\n", "Code", "Name",
                    "Specialization", "Availability");
            for (Doctor doctor : listFoundByName) {
                System.out.printf("%-10s%-15s%-25s%-20d\n", doctor.getCode(),
                        doctor.getName(), doctor.getSpecialization(),
                        doctor.getAvailability());
            }
        }
    }

    //get docter by code
    public Doctor getDoctorByCode(String code) {
        for (Doctor doctor : ld) {
            if (doctor.getCode().equalsIgnoreCase(code)) {
                return doctor;
            }
        }
        return null;
    }

    //get list found by name
    public ArrayList<Doctor> listFoundByName(String name) {
        ArrayList<Doctor> listFoundByName = new ArrayList<>();
        for (Doctor doctor : ld) {
            if (doctor.getName().contains(name)) {
                listFoundByName.add(doctor);
            }
        }
        return listFoundByName;
    }
}
