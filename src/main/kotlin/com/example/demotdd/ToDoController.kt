package com.example.demotdd

import com.example.demotdd.model.ToDo
import com.example.demotdd.service.ToDoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ToDoController {
    @Autowired
    private lateinit var toDoService : ToDoService

    @GetMapping("/todos")
    fun getAllToDos() : ResponseEntity<List<ToDo>>{
        return ResponseEntity<List<ToDo>>(toDoService.findAll(), HttpStatus.OK)
    }

}