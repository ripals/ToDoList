package com.ripal.todolist

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

/**
 * Created by Ripal on 04/Nov/17.
 */

open class ToDoItem : RealmObject() {
    @PrimaryKey

    private var id = UUID.randomUUID().toString()
    var name = ""
    var important = false

    fun getId() : String {

        return id
    }

    override fun toString() : String {
        return name
    }

}


/*
open class Dog : RealmObject() {

    public var name = ""
    public var age = 0

}
*/