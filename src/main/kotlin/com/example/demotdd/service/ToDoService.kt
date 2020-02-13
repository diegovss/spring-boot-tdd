package com.example.demotdd.service

import com.example.demotdd.model.ToDo
import com.example.demotdd.repository.ToDoRepository
import org.springframework.stereotype.Service
import java.util.*


@Service
class ToDoService (private var toDoRepository: ToDoRepository) {
    fun findAll(): List<ToDo> {
        return toDoRepository.findAll()
    }

}
