package in.socialninja.cgpscguru;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.MyViewHolder> {
   String filelink;
    Context context;
    ArrayList<survey> surveyArrayList;

    public MyAdapter2(Context c, ArrayList<survey> s)
    {
        context = c;
        surveyArrayList = s;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.survey_type_layout,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.sHeader.setText(surveyArrayList.get(i).getName());
        filelink = surveyArrayList.get(i).getLink();
        myViewHolder.onClick(i);


    }

    @Override
    public int getItemCount() {
        return surveyArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView sHeader;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            sHeader = (TextView) itemView.findViewById(R.id.sHeader);

        }
        public void onClick(final int i)
        {
            sHeader.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(String.valueOf(filelink)));
                    context.startActivity(intent);
                }
            });
        }
    }
}
