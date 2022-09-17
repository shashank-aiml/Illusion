package com.example.myapplication;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapter.CollegeCardAdapter;
import com.example.myapplication.Classes.CollegeCardData;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageView button;
    TextView search_Text;
    private RecyclerView.Adapter recyclerViewAdapter;

    private ArrayAdapter<String> arrayAdapter;

    RecyclerView recyclerView;
    private DatabaseReference database;
    CollegeCardAdapter collegeCardadapter;
    ArrayList<CollegeCardData> list;
    ArrayList<CollegeCardData> filterList = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        search_Text = findViewById(R.id.main_recycler_search);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,CollegeDataEntry.class);
                startActivity(intent);
            }
        });

        //RECYCLERVIEW SECTION
        recyclerView = findViewById(R.id.recyclerViewplates);
        database = FirebaseDatabase.getInstance().getReference("CollegeData");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        collegeCardadapter = new CollegeCardAdapter(this,list);
        recyclerView.setAdapter(collegeCardadapter);

        //RECYCLER SEARCH//
        search_Text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                filterList.clear();
                if(editable.toString().isEmpty()){
                    recyclerView.setAdapter(new CollegeCardAdapter(getApplicationContext(),list));
                    collegeCardadapter.notifyDataSetChanged();
                }else{
                    FilterRecyclerView(editable.toString());
                }
            }
        });

        ///////RECYCLER SEARCH//////////

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    CollegeCardData user = dataSnapshot.getValue(CollegeCardData.class);
                    list.add(user);
                }
                collegeCardadapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                error.getMessage();
            }
        });
    }

    private void FilterRecyclerView(String toString) {
        String filterPattern = toString.toLowerCase().trim();
        for(CollegeCardData post : list){
            if(post.getCollegeName().toLowerCase().contains(filterPattern)){
                filterList.add(post);
            }
        }
        recyclerView.setAdapter(new CollegeCardAdapter(getApplicationContext(),filterList));
        collegeCardadapter.notifyDataSetChanged();
    }
    //private void readData(){
//        reference = FirebaseDatabase.getInstance().getReference("CollegeData");
//        reference.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DataSnapshot> task) {
//                if(task.isSuccessful()){
//                    if(task.getResult().exists()){
//                        Toast.makeText(MainActivity.this, "Succesfully Read", Toast.LENGTH_SHORT).show();
//                        DataSnapshot dataSnapshot = task.getResult();
//                        String gettingCollegeName = String.valueOf(dataSnapshot.child("collegeName").getValue());
//                        String gettingCollegeImageUrl = String.valueOf(dataSnapshot.child("imageURI").getValue());
//                        CollegeCardData cd1 = new CollegeCardData(gettingCollegeName,gettingCollegeImageUrl);
//                        AdapterArray.add(0,cd1);
//                        //AdapterArray.get(0).getCollegeName();
//                        System.out.println(AdapterArray.get(0).getCollegeName());
//                    }else{
//                        Toast.makeText(MainActivity.this, "User Doesn't Exist", Toast.LENGTH_SHORT).show();
//                    }
//                }else{
//                    Toast.makeText(MainActivity.this, "Failed To Read", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//    }
}