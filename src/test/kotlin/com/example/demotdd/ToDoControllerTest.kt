package com.example.demotdd

import com.example.demotdd.model.ToDo
import com.example.demotdd.service.ToDoService
import org.hamcrest.Matchers.hasSize
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import java.util.*


@ExtendWith(SpringExtension::class)
@WebMvcTest
internal class ToDoControllerTest {
    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var toDoService: ToDoService

    @Test
    fun getAllToDos(){
        val toDoList : MutableList<ToDo> = ArrayList()

        toDoList.add(ToDo(1L, "Eat thrice", true))
        toDoList.add(ToDo(2L, "Sleep Twice", true))
        `when` (toDoService.findAll()).thenReturn(toDoList)
        mockMvc.perform(MockMvcRequestBuilders.get("/todos")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(jsonPath("$", hasSize<ToDo>(2))).andDo(print())

    }
//    @Test
//    @Throws(Exception::class)
//    fun getAllToDos() {
//        val toDoList: MutableList<ToDo> = ArrayList()
//        toDoList.add(ToDo(1L, "Eat thrice", true))
//        toDoList.add(ToDo(2L, "Sleep Twice", true))
//        `when`(toDoService.findAll()).thenReturn(toDoList)
//        mockMvc.perform(MockMvcRequestBuilders.get("/todos")
//                .contentType(MediaType.APPLICATION_JSON)
//        ).andExpect(jsonPath("$", hasSize(2))).andDo(print())
//    }
}