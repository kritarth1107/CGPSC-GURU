package in.socialninja.cgpscguru;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Result extends AppCompatActivity {

    TextView t1,t2,t3,sc,rm;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        sc= (TextView)findViewById(R.id.score);
        t1= (TextView)findViewById(R.id.textView2);
        t2= (TextView)findViewById(R.id.textView3);
        t3= (TextView)findViewById(R.id.textView4);
        rm = (TextView) findViewById(R.id.remark);
        b1 = (Button)findViewById(R.id.button4);

        ImageView piccture = (ImageView) findViewById(R.id.ProfileImage);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        Glide.with(getApplicationContext()).load(user.getPhotoUrl())
                .thumbnail(0.5f)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(piccture);
        TextView nameTxt = (TextView) findViewById(R.id.ProfileName);
        nameTxt.setText(user.getDisplayName());

        Intent i=getIntent();
        Bundle b = this.getIntent().getExtras();
        int correct=b.getInt("correct");
        String questions = i.getStringExtra("total");
       //String correct = i.getStringExtra("correct");
        int wrong=b.getInt("wrong");;


  if (correct==0 && wrong==0)
  {
      CardView c=(CardView)findViewById(R.id.correctAns);
      c.setVisibility(View.INVISIBLE);
      CardView c2=(CardView)findViewById(R.id.incorrectAns);
      c2.setVisibility(View.INVISIBLE);
      t1.setText("TOTAL QUESTION : " + "20");
      sc.setText("You Haven't Attempted any Question");
      b1.setBackgroundColor(Color.RED);
      sc.setTextColor(Color.RED);
      rm.setText("Ooopss...!!");
      rm.setTextColor(Color.RED);
  }
  else{
      if(correct>15)
      {
          if(correct==20)
          {
              rm.setText("Mind Blowing...!!");
          }
          else
          {
              rm.setText("Great Job...!!");
          }
          b1.setBackgroundColor(Color.parseColor("#229a43"));
          sc.setTextColor(Color.parseColor("#229a43"));

          rm.setTextColor(Color.parseColor("#229a43"));
      }
      else if(correct>=11 && correct<=15)
      {
          b1.setBackgroundColor(Color.parseColor("#fecc0c"));
          sc.setTextColor(Color.parseColor("#fecc0c"));
          rm.setText("Good Job...!!");
          rm.setTextColor(Color.parseColor("#fecc0c"));
      }
      else if(correct>=6 && correct<=10)
      {
          b1.setBackgroundColor(Color.parseColor("#fa8109"));
          sc.setTextColor(Color.parseColor("#fa8109"));
          rm.setText("Nice Try...!!");
          rm.setTextColor(Color.parseColor("#fa8109"));
      }
      else{
          b1.setBackgroundColor(Color.RED);
          sc.setTextColor(Color.RED);
          rm.setText("Poor Performance...!!");
          rm.setTextColor(Color.RED);
      }
      int atmpt = correct+wrong;
      sc.setText(correct + "/20");
      t1.setText("TOTAL QUESTION : 20\nATTEMPT QUE : " + atmpt);
      t2.setText("CORRECT  : " + correct);
      t3.setText("INCORRECT: " + wrong);
  }

    }
    @Override
    public void onBackPressed(){

           finish();
        }


}
