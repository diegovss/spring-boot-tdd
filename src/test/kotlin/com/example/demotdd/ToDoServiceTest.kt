package com.example.demotdd

import com.example.demotdd.model.ToDo
import com.example.demotdd.repository.ToDoRepository
import com.example.demotdd.service.ToDoService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean


@SpringBootTest
class ToDoServiceTest {

    @Autowired
    private lateinit var toDoRepository: ToDoRepository

    @Test
    fun getAllToDos(){
        var todoSample : ToDo = ToDo("Todo Sample 1", true)
        toDoRepository.save(todoSample)
        var todoSample2 : ToDo = ToDo("Todo Sample 2", false)
        toDoRepository.save(todoSample2)
        var toDoService: ToDoService = ToDoService(toDoRepository)

        var firstResult:ToDo = toDoService.findAll().get(1)

        var toDoList: List<ToDo> = toDoService.findAll()
        var a = toDoList.size
        var lastToDo: ToDo = toDoList.get(a-1)

        Assertions.assertEquals(todoSample2.text, firstResult.text)
        Assertions.assertEquals(todoSample2.completed, firstResult.completed)
        Assertions.assertEquals(todoSample2.id, firstResult.id)

        Assertions.assertEquals(todoSample2.text, lastToDo.text)
        Assertions.assertEquals(todoSample2.completed, lastToDo.completed)
        Assertions.assertEquals(todoSample2.id, lastToDo.id)
    }
}