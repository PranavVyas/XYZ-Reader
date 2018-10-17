package com.example.xyzreader.data;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xyzreader.R;

import java.util.List;

public class RecylerTextLoader extends RecyclerView.Adapter<RecylerTextLoader.TextHolder> {

    List<String> paragraphs;
    Context context;

    public RecylerTextLoader(Context context) {
        this.context = context;
    }


    @NonNull
    @Override
    public TextHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_paragraph_holder_recycler,parent,false);
        return new TextHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TextHolder holder, int position) {
        holder.tv.setText(paragraphs.get(position));
    }

    @Override
    public int getItemCount() {
        return (paragraphs == null ? 0 : paragraphs.size());
    }

    public void updateParagraph(List<String> paragraph){
        this.paragraphs = paragraph;
        notifyDataSetChanged();
    }

    public class TextHolder extends RecyclerView.ViewHolder{
        TextView tv;
        public TextHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.recycler_text_main);
        }
    }
}
