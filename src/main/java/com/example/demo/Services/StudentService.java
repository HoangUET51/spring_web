package com.example.demo.Services;

import com.example.demo.models.Students;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Students createOrupdate(Students st) {

        if (st.getId() != 0) {
            Optional<Students> student = studentRepository.findById(st.getId());
            if (student.isEmpty()) {
                return null;
            }
            Students editSt = student.get();
            editSt.setName(st.getName() != null ? st.getName() : student.get().getName());
            editSt.setDate(st.getDate() != null ? st.getDate() : student.get().getDate());
            studentRepository.save(editSt);
            return editSt;
        }
        studentRepository.save(st);
        return st;
    }

    @Override
    public Students remove(int id) {
        Optional<Students> student = studentRepository.findById(id);
        if (student.isEmpty()) {
            return null;
        }
        studentRepository.delete(student.get());
        return student.get();

    }

    @Override
    public List<Students> getAll() {
        return studentRepository.findAll();
    }


}
