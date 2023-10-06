/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.DoctorList;
import view.Menu;

/**
 *
 * @author HP
 */
public class DoctorManager extends Menu<String>{
    private DoctorList list= new DoctorList();
    public DoctorManager(String title, String[] s){
        super(title, s);
    }
    
    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                list.addDoctor();
                break;
            case 2:
                list.updateDoctor();
                break;
            case 3:
                list.deleteDoctor();
                break;
            case 4: 
                list.searchDoctor();
                break;
            case 5:
                System.exit(0);        
        }
    }
}
