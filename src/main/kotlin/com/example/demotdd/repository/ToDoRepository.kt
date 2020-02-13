package com.example.demotdd.repository

import com.example.demotdd.model.ToDo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository("toDoRepository")
interface ToDoRepository : JpaRepository<ToDo, Long> {

}
