package com.example.helmikhairullah.helmikhairullahsetiana_1202154144_modul5;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Helmi Khairullah on 25/03/2018.
 */

public class EditList extends AppCompatActivity {

    private TextView xnama;
    private TextView deskrip;
    private TextView prioriti;

    public static final String EXTRA_REPLY = "com.example.android.wordlistsql.REPLY";

    int mId = TodoList.WORD_ADD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addtodo);
        xnama = (TextView) findViewById(R.id.nama);
        deskrip = (TextView) findViewById(R.id.description);
        prioriti = (TextView) findViewById(R.id.editText3);

    }

    public void insertKegiatan(View view) {
        Intent replyIntent = new Intent();
        replyIntent.putExtra(ListAdapter.EXTRA_ID, mId);
        replyIntent.putExtra("nama", xnama.getText().toString());
        replyIntent.putExtra("kegiatan", deskrip.getText().toString());
        replyIntent.putExtra("prioritas", Integer.parseInt(prioriti.getText().toString()));
        setResult(RESULT_OK, replyIntent);
        finish();
//
//        mDb.insert(nama.getText().toString(),
//                kegiatan.getText().toString(),
//                Integer.parseInt(prioritas.getText().toString()));
//        finish();
    }
}
