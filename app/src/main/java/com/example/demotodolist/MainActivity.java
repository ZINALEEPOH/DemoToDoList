package com.example.demotodolist;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    ListView lvToDoList;
    ArrayList<ToDoItem> alToDoItem;
    CustomAdapter ca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvToDoList = findViewById(R.id.listViewToDoList);
        alToDoItem = new ArrayList<>();

        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(2020, Calendar.AUGUST, 1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(2020, Calendar.AUGUST, 2);
        ToDoItem item1 = new ToDoItem("Go for movie", calendar1);
        ToDoItem item2 = new ToDoItem("Go for haircut", calendar2);

        alToDoItem.add(item1);
        alToDoItem.add(item2);

        ca = new CustomAdapter(this, R.layout.row, alToDoItem);

        lvToDoList.setAdapter(ca);
    }
}
