package com.example.helmikhairullah.helmikhairullahsetiana_1202154144_modul5;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Helmi Khairullah on 25/03/2018.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private ArrayList<TODO_LIST> mListData;
    private Context mContext;
    private ListHelper mDB;

    public static final String EXTRA_ID = "ID";

    public ListAdapter(Context mContext, ListHelper DB) {
        this.mListData = mListData;
        this.mContext = mContext;
        this.mDB = DB;
    }

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.recycle_list, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TODO_LIST current = mDB.query(position);
        holder.bindTo(current);

        // final WordViewHolder h = holder;
    }

    @Override
    public int getItemCount() {
        return (int) mDB.count();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView Xjalan;
        private TextView Akegiatan;
        private TextView Lprioritas;

        public ViewHolder(View itemView) {
            super(itemView);
            Xjalan = (TextView)itemView.findViewById(R.id.jalan)  ;
            Akegiatan = (TextView)itemView.findViewById(R.id.kegiatanyangdilakukan) ;
            Lprioritas = (TextView)itemView.findViewById(R.id.besarprioritas) ;
        }

        void bindTo(TODO_LIST list){

            //Populate the textviews with data
            Xjalan.setText(list.getNamaKegiatan());
            Akegiatan.setText(list.getKegiatan());
            Lprioritas.setText(String.valueOf(list.getPrioritas()));
        }
    }
}
