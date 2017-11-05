package com.ripal.todolist

import android.app.Application
import io.realm.Realm

/**
 * Created by Ripal on 04/Nov/17.
 */

public class ToDoList : Application() {
    public fun onCrete() {
        super.onCreate()
        Realm.init(this)

    }

}