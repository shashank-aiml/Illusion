package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class CollegeInfoActivityAdapter extends AppCompatActivity {

    TextView info_colle_name, info_college_description, info_college_courses, info_college_fees, info_college_highestPackage, info_college_averagePackage, info_college_lowest_package, info_college_student_placed;
    ImageView college_image;
    ConstraintLayout cc;
    Context cont;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college_info_adapter);
        info_colle_name = findViewById(R.id.Info_college_content);
        info_college_description = findViewById(R.id.info_description_content);
        info_college_courses = findViewById(R.id.info_course_content);
        info_college_fees = findViewById(R.id.info_fees_content);
        info_college_highestPackage = findViewById(R.id.info_highestPackage_content);
        info_college_lowest_package = findViewById(R.id.info_lowestPackage_content);
        info_college_averagePackage = findViewById(R.id.info_averagePackage_content);
        info_college_student_placed = findViewById(R.id.info_studentsPlaced_content);
        college_image = findViewById(R.id.info_arimage);


        Intent intent = getIntent();
        String textview_set_name = intent.getStringExtra("Name");
        String textview_set_description = intent.getStringExtra("Description");
        String textview_set_courses = intent.getStringExtra("Courses");
        String textview_set_fees = intent.getStringExtra("Fees");
        String textview_set_highestPackage = intent.getStringExtra("HighestPackage");
        String textview_set_lowestPackage = intent.getStringExtra("LowestPackage");
        String textview_set_averagePackage = intent.getStringExtra("AveragePackage");
        String textview_set_studentsPackage = intent.getStringExtra("StudentsPlaced");
        String imageview_set_image = intent.getStringExtra("ImageUri");
        //Uri uri = Uri.parse(imageview_set_image);

        info_colle_name.setText(textview_set_name);
        info_college_description.setText(textview_set_description);
        info_college_courses.setText(textview_set_courses);
        info_college_fees.setText(textview_set_fees);
        info_college_highestPackage.setText(textview_set_highestPackage);
        info_college_lowest_package.setText(textview_set_lowestPackage);
        info_college_averagePackage.setText(textview_set_averagePackage);
        info_college_student_placed.setText(textview_set_studentsPackage);

        college_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CollegeInfoActivityAdapter.this, ARactivity.class);
                startActivity(intent);
            }
        });
//        ArImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                Intent intent1 = new Intent(CollegeInfoActivityAdapter.this,ARactivity.class);
////                startActivity(intent1);
//            }
//        });

    }

}