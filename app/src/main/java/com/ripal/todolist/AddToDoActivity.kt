package com.ripal.todolist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import io.realm.Realm

/**
 * Created by Ripal on 04/Nov/17.
 */


class AddToDoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_to_do)

        title = "New ToDo"

        val button = findViewById<Button>(R.id.addButton)
        button.setOnClickListener {

            Realm.init(applicationContext)
            val realm = Realm.getDefaultInstance()

            val editText = findViewById<EditText>(R.id.toDoEditText)
            val checkBox = findViewById<CheckBox>(R.id.importantCheckBox)

            val todo = ToDoItem()
            todo.name = editText.text.toString()
            todo.important = checkBox.isChecked

            realm.beginTransaction()
            realm.copyToRealm(todo)
            realm.commitTransaction()

            finish()
        }
    }
}
