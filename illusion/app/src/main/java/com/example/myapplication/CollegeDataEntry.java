package com.example.myapplication;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Classes.CollegeCardData;
import com.example.myapplication.Classes.CollegeData;
import com.example.myapplication.databinding.ActivityCollegeDataEntryBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CollegeDataEntry extends AppCompatActivity {

    ActivityCollegeDataEntryBinding binding;
    String CollegeNAME, Description, CourseAvailable, Fees, HighestPackage , LowestPackage, AveragePackage, StudentPlaced,  imagelink;
    String ImageURI;
    FirebaseDatabase db,db2;
    FirebaseStorage storage;
    DatabaseReference reference;
    ArrayList<CollegeCardData> AdapterArray = new ArrayList<>();
    ActivityResultLauncher<String> launcher;
    //public ArrayList<CollegeCardData> aaaa = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCollegeDataEntryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        db2 = FirebaseDatabase.getInstance();
        storage = FirebaseStorage.getInstance();
        db2.getReference().child("document/").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String image1 = snapshot.getValue(String.class);
                Picasso.get().load(image1).into(binding.uploadedImage);
                System.out.println(image1);
                Log.d("image","image-"+image1);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        launcher = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
            @Override
            public void onActivityResult(Uri result) {
                binding.uploadedImage.setImageURI(result);
//                imageFileName = result.toString();
                //ImageURI = String.valueOf(result);
                final StorageReference  referen = storage.getReference().child("result"+result);
                referen.putFile(result).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        referen.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                imagelink = uri.toString();
                                Toast.makeText(CollegeDataEntry.this, "Image Uploaded :) ", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
            }
        });
        binding.uploadBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launcher.launch("image/*");
            }
        });

        binding.submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CollegeNAME = binding.collegeName.getText().toString();
                Description = binding.description.getText().toString();
                CourseAvailable = binding.courses.getText().toString();
                Fees = binding.fees.getText().toString();
                HighestPackage = binding.hPackage.getText().toString();
                LowestPackage = binding.lPackage.getText().toString();
                AveragePackage = binding.apackage.getText().toString();
                StudentPlaced = binding.stuPlaced.getText().toString();
                ImageURI = binding.uploadedImage.toString();

                if(!CollegeNAME.isEmpty() && !Description.isEmpty() && !CourseAvailable.isEmpty() && !Fees.isEmpty() && !HighestPackage.isEmpty() && !LowestPackage.isEmpty() && !AveragePackage.isEmpty() && !StudentPlaced.isEmpty()){
                    ImageURI = String.valueOf(imagelink);
                    CollegeData collegeData = new CollegeData(CollegeNAME, Description, CourseAvailable, Fees, HighestPackage , LowestPackage, AveragePackage, StudentPlaced, ImageURI);
                    db = FirebaseDatabase.getInstance();
                    reference = db.getReference("CollegeData");
                    reference.child(CollegeNAME).setValue(collegeData).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            Toast.makeText(CollegeDataEntry.this, "SuccesFull Updated", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                //readData();
            }
        });

    }

}