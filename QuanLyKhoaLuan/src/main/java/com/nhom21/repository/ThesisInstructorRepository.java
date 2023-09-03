/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhom21.repository;

import com.nhom21.pojo.InstructorThesis;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author WIN10
 */
public interface ThesisInstructorRepository {
    List<InstructorThesis> getInstructor();
     boolean addOrUpdateThesisInstructor(InstructorThesis ti);
     boolean addOrUpdateThesisInstructor(ArrayList<InstructorThesis> ti);
     InstructorThesis getIDI(int id);
}
