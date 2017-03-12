package com.example.ruslan.test;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ruslan.test.interfaces.OnNoteClickListener;

import java.util.List;

/**
 * Created by Ruslan on 19.11.2016.
 */

public class NoteAdapter extends RecyclerView.Adapter {

    private List<Note> notes;
    private Context context;
    private OnNoteClickListener onNoteClickListener;

    public void setOnNoteClickListener(OnNoteClickListener onNoteClickListener) {
        this.onNoteClickListener = onNoteClickListener;
    }

    public NoteAdapter(List<Note> notes, Context context) {
        this.notes = notes;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NoteHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((NoteHolder) holder).bind(position);
        TextView tvName = ((NoteHolder) holder).tvName;
        TextView tvText = ((NoteHolder) holder).tvText;

        tvName.setText(notes.get(position).getName());
        tvText.setText(notes.get(position).getText());

    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    class NoteHolder extends RecyclerView.ViewHolder{

        private TextView tvName;
        private TextView tvText;

        public NoteHolder(View itemView) {
            super(itemView);

            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvText = (TextView) itemView.findViewById(R.id.tv_text);
        }

        public void bind(final int position){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onNoteClickListener.onClickListener(position);
                }
            });
        }


    }
}
