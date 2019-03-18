package com.example.recyclerviewapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private static final String TAG = "Adapter";

    private ArrayList<String> mImageNames = new ArrayList<>(); //lista przechowująca kolejno nazwy obrazów i linki url do obrazów
    private ArrayList<String> mImages = new ArrayList<>();
    private Context mContext;//definiujemy obiekt adapter, tworzymy konstruktor

    public Adapter(Context mContext, ArrayList<String> mImageNames, ArrayList<String> mImages) {
        this.mImageNames = mImageNames;
        this.mImages = mImages;
        this.mContext = mContext;
    }

    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {//tworzymy uogólniony "trzymacz widoku" dla każdego ładowanego z listy obrazu
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_listitem, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder; //zwracamy widok
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) { //powiązanie "trzymacza widoku" z obrazami, użycie biblioteki glide
        Log.d(TAG, "onBindViewHolder: called");

        Glide.with(mContext)
                .asBitmap().load(mImages.get(i)).into(viewHolder.image);
        viewHolder.imageName.setText(mImageNames.get(i));

        viewHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mImageNames.get(i).equals("Nibiru")) {
                    Toast.makeText(mContext, "The earth is flat!!", Toast.LENGTH_LONG).show();
                } else
                    Log.d(TAG, "onClick: clicked on: " + mImageNames.get(i));
                Toast.makeText(mContext, mImageNames.get(i), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() { //zwraca rozmiar listy
        return mImageNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView image;
        TextView imageName;
        RelativeLayout parentLayout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.image_name);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
