package com.ripal.todolist

import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import io.realm.Realm

/**
 * Created by Ripal on 04/Nov/17.
 */

class FinishToDoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish_to_do)

        title = "Complete ToDo"
        val toDoItemId = intent.getStringExtra("toDoItem")
        Realm.init(applicationContext)
        val realm = Realm.getDefaultInstance()
        val toDoItem = realm.where(ToDoItem::class.java).equalTo("id", toDoItemId).findFirst()

        val textView = findViewById<TextView>(R.id.toDoNameTextView)
        textView.text = toDoItem?.name

        if (toDoItem?.important!!) {

            textView.setTypeface(Typeface.DEFAULT_BOLD)
        }

        val completeButton = findViewById<Button>(R.id.completeButton)

        completeButton.setOnClickListener {

            realm.beginTransaction()
            toDoItem?.deleteFromRealm()
            realm.commitTransaction()

            finish()
        }
    }
}
