package com.example.demotdd.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class ToDo {
    @Id
    @GeneratedValue
    var id: Long = 0
    var text: String? = null
    var completed = false

    constructor() {}
    constructor(text: String?, completed: Boolean) {
        this.text = text
        this.completed = completed
    }

    constructor(id: Long, text: String?, completed: Boolean) {
        this.id = id
        this.text = text
        this.completed = completed
    }

}