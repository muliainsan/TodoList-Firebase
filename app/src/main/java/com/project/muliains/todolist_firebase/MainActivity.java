package com.project.muliains.todolist_firebase;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    DatabaseReference dbTodo;
    List<Todo> todolist;
    Adapter adapter;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rv = findViewById(R.id.rv);
        dbTodo = FirebaseDatabase.getInstance().getReference("Todo");
        todolist = new ArrayList<>();


    }

    @Override
    protected void onStart() {
        super.onStart();
        dbTodo.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                todolist.clear();
                for(DataSnapshot todosnap: dataSnapshot.getChildren()){
                    Todo todo = todosnap.getValue(Todo.class);
                    Log.i("xxx",todo.getNama());
                    todolist.add(todo);
                }
                adapter = new Adapter(context,todolist);
                RecyclerView.LayoutManager lm = new LinearLayoutManager(getApplicationContext());
                rv.setLayoutManager(lm);
                rv.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    //MENU TOOLBAR
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menuinput:
                Intent intent;
                intent = new Intent(MainActivity.this, input.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
