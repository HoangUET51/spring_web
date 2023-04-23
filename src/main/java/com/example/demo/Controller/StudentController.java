package com.example.demo.Controller;

import com.example.demo.Services.StudentService;
import com.example.demo.models.Students;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @RequestMapping(value = "student",method = RequestMethod.GET)
    public List<Students> getAll() {
        return studentService.getAll();
    }
    @RequestMapping(value = "student",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Students createOrUpdate(@RequestBody String student) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
                    public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
                        return  LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
                    }
                })
                .create();
        Students st = gson.fromJson(student,Students.class);
        return studentService.createOrupdate(st);
    }
    @RequestMapping(value = "student",method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Students remove(@RequestParam int id) {
        return studentService.remove(id);
    }

}
