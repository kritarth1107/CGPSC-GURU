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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.MyViewHolder> {
    String videolink;
    Context context;
    ArrayList<video> videolist;

    public VideoAdapter(Context c, ArrayList<video> s)
    {
        context = c;
        videolist = s;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.video_type_layout,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.sHeader.setText(videolist.get(i).getName());
        videolink = videolist.get(i).getUrl();
        Picasso.get().load(videolist.get(i).getThumbnail()).into(myViewHolder.vThumbnail);

        myViewHolder.onClick(i);


    }

    @Override
    public int getItemCount() {
        return videolist.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView sHeader;
        ImageView vThumbnail;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            sHeader = (TextView) itemView.findViewById(R.id.vHeader);
            vThumbnail = (ImageView) itemView.findViewById(R.id.vImage);
        }
        public void onClick(final int i)
        {
            sHeader.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(String.valueOf(videolink)));
                    context.startActivity(intent);
                }
            });
            vThumbnail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(String.valueOf(videolink)));
                    context.startActivity(intent);
                }
            });
        }
    }
}
