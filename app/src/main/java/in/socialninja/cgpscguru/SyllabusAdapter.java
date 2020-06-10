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

public class SyllabusAdapter extends RecyclerView.Adapter<SyllabusAdapter.MyViewHolder> {
    String filelink;
    Context context;
    ArrayList<syllabus_cgpsc> syllabuslist;

    public SyllabusAdapter(Context c, ArrayList<syllabus_cgpsc> s)
    {
        context = c;
        syllabuslist = s;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.syllabus_type_layout,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.sHeader.setText(syllabuslist.get(i).getHeader());
        filelink = syllabuslist.get(i).getLink();
        myViewHolder.onClick(i);


    }

    @Override
    public int getItemCount() {
        return syllabuslist.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView sHeader;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            sHeader = (TextView) itemView.findViewById(R.id.syHeader);

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
