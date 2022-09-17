package com.example.myapplication.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.Classes.CollegeCardData;
import com.example.myapplication.CollegeInfoActivityAdapter;
import com.example.myapplication.R;

import java.util.ArrayList;

public class CollegeCardAdapter extends RecyclerView.Adapter<CollegeCardAdapter.MyViewHolder> {
    static Context context;
    static ArrayList<CollegeCardData> list;


    public CollegeCardAdapter(Context context, ArrayList<CollegeCardData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public CollegeCardAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.collegedata,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        CollegeCardData user = list.get(position);
//        holder.recyCollegeImage.setImageURI(Uri.parse(user.getImageURI()));
//        Log.d("Check",user.getImageUrl());
        Glide.with(context).load(list.get(position).getImageURI()).into(holder.recyCollegeImage);
        holder.recyCollegeNAme.setText(list.get(position).getCollegeName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView recyCollegeNAme;
        ImageView recyCollegeImage;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            recyCollegeNAme = itemView.findViewById(R.id.cardtextView);
            recyCollegeImage = itemView.findViewById(R.id.cardImageView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();

            Intent intent = new Intent(context,CollegeInfoActivityAdapter.class);
            intent.putExtra("Name",list.get(position).getCollegeName());
            intent.putExtra("Description",list.get(position).getDescription());
            intent.putExtra("Courses",list.get(position).getCourseAvailable());
            intent.putExtra("Fees",list.get(position).getFees());
            intent.putExtra("HighestPackage",list.get(position).getHighestPackage());
            intent.putExtra("AveragePackage",list.get(position).getAveragePackage());
            intent.putExtra("LowestPackage",list.get(position).getLowestPackage());
            intent.putExtra("StudentsPlaced",list.get(position).getStudentPlaced());

            context.startActivity(intent);
        }
    }
}
