package com.example.ruslan.test.activities;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.ruslan.test.Note;
import com.example.ruslan.test.NoteAdapter;
import com.example.ruslan.test.interfaces.OnNoteClickListener;
import com.example.ruslan.test.R;
import com.example.ruslan.test.fragments.NoteInfoFragment;
import com.example.ruslan.test.services.EasyService;

import java.util.ArrayList;
import java.util.List;

public class NoteListActivity extends AppCompatActivity implements OnNoteClickListener{

    private RecyclerView rvNotes;
    private NoteAdapter adapter;
    private List<Note> notes;
    private Button btnStart;
    private Button btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);

        fillUpTheNotes();

        adapter = new NoteAdapter(notes,this);
        adapter.setOnNoteClickListener(this);

        rvNotes = (RecyclerView) findViewById(R.id.rv_notes);
        rvNotes.setAdapter(adapter);
        rvNotes.setLayoutManager(new LinearLayoutManager(this));

        btnStart = (Button) findViewById(R.id.btn_service);
        final Context context = getApplicationContext();
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(context, EasyService.class));
            }
        });

    }

    private void fillUpTheNotes(){
        notes = new ArrayList<Note>();
        for(int i = 0;i < 15; i++){
            notes.add(new Note("Заметка","Всякая чушь, которую обычно пишут в заметках"));
        }
        return;
    }

    private boolean isOrientationLand(){
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
            return false;
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
            return true;
        return false;
    }

    @Override
    public void onClickListener(int position) {
        if(isOrientationLand()){
            Fragment fragment = NoteInfoFragment.newInstance(notes.get(position).getName(),notes.get(position).getText());
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.note_info_fragment_container,fragment,NoteInfoFragment.class.getName())
                    .commit();
        } else {
            Intent intent = new Intent(NoteListActivity.this,NoteInfoActivity.class);

            intent.putExtra("name",notes.get(position).getName());
            intent.putExtra("text",notes.get(position).getText());

            startActivity(intent);
        }
    }
}
