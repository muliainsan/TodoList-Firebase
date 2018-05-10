package com.project.muliains.todolist_firebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class input extends AppCompatActivity {
    EditText etnama, etdesc;
    Button btnsave;
    DatabaseReference dbTodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        dbTodo = FirebaseDatabase.getInstance().getReference("Todo");


        etnama = findViewById(R.id.etnama);
        etdesc = findViewById(R.id.etdesc);
        btnsave = findViewById(R.id.btnsave);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addTodo();

            }
        });
    }

    private void addTodo(){
        String nama = etnama.getText().toString().trim();
        String desc = etdesc.getText().toString().trim();

        if(!TextUtils.isEmpty(nama)){
            String id = dbTodo.push().getKey();

            Todo todo = new Todo(id,nama,desc);

            dbTodo.child(id).setValue(todo);
            Toast.makeText(this, "Todo List Added", Toast.LENGTH_SHORT).show();
            Intent intent;
            intent = new Intent(input.this, MainActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(this, "Enter the Name !", Toast.LENGTH_SHORT).show();
        }
    }

}
