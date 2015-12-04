package org.nganga.sesame.utilities;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.nganga.sesame.R;

import java.util.Collections;
import java.util.List;

/**
 * Created by nganga on 9/21/15.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private LayoutInflater inflater;

    private ClickListener clickListener;

    Context context;

    List<RecyclerData> data = Collections.emptyList(); //This ensures we do not get nullPointers exception

    public RecyclerAdapter(Context context, List<RecyclerData> data){

        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    public void delete(int position) {

        data.remove(position);
        notifyItemRemoved(position);
    }

    // Objects need to initialize this method so as to implement listener

    public void setClickListener(ClickListener clickListener){

        this.clickListener = clickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.custom_row, parent, false);  //Inflate view elements in root custom xml
        MyViewHolder holder = new MyViewHolder(view);   //custom viewholder used to reuse view components.
        return holder;
    }


    //This is where we fill in the data items.
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        RecyclerData current = data.get(position);
        holder.title.setText(current.title);
        holder.icon.setImageResource(current.iconId);
    }


    @Override
    public int getItemCount() {
        return data.size();
    }


    class  MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView title;
        ImageView icon;

        public MyViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.listText);
            icon = (ImageView) itemView.findViewById(R.id.listIcon);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            if(clickListener != null) {

                clickListener.itemClicked(view, getPosition());
            }

        }
    }

    public interface ClickListener {


        public void itemClicked (View view, int position);
    }
}
