package org.nganga.sesame;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by nganga on 9/21/15.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private LayoutInflater inflater;

    public RecyclerAdapter(Context context){

        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.custom_row, parent, false);  //Inflate view elements from root custom xml
        MyViewHolder holder = new MyViewHolder(view);   //custom viewholder used to reuse view components.
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return 0;
    }


    class  MyViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        ImageView icon;

        public MyViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.listText);
            icon = (ImageView) itemView.findViewById(R.id.listIcon);
        }
    }
}
