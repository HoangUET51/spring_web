package com.example.demo.Services;

import com.example.demo.models.Classic;
import com.example.demo.models.Students;
import com.example.demo.repository.ClassicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService implements IClassic {
    @Autowired
    private ClassicRepository classicRepository;

    @Override
    public List<Students> getAllStudent(int classId) {
        Classic classic = classicRepository.findById(classId).get();
        return classic.getStudents();
    }
}
