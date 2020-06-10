package in.socialninja.cgpscguru;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    int Nos;
    Context context;
    ArrayList<quiz> questionHeads;

    public MyAdapter(Context c, ArrayList<quiz> q)
    {
        context = c;
        questionHeads = q;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.quiz_type_layout,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
            myViewHolder.qHeader.setText(questionHeads.get(i).getQhead());
            Nos=getItemCount();
            myViewHolder.onClick(i);


    }

    @Override
    public int getItemCount() {
        return questionHeads.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView qHeader;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                qHeader = (TextView) itemView.findViewById(R.id.qHeader);

            }
            public void onClick(final int i)
            {
                qHeader.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context,quiz1.class);
                        intent.putExtra("type",String.valueOf(i));
                        intent.putExtra("NoQue",String.valueOf(Nos));
                        context.startActivity(intent);
                    }
                });
            }
        }
}
