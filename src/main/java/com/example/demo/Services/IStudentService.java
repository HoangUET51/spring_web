package com.example.demo.Services;

import com.example.demo.models.Students;

import java.util.List;

public interface IStudentService {
    public List<Students> getAll();
    public Students createOrupdate(Students st);
    public Students remove(int id);
}
