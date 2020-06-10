package in.socialninja.cgpscguru;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class news extends AppCompatActivity {
    AdView mAdView;
    GridLayout mainGrid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        mainGrid =(GridLayout)

                findViewById(R.id.mainGrid2);

        setSingleEvent(mainGrid);
        //AdMob
        MobileAds.initialize(this,"ca-app-pub-3940256099942544~3347511713");
        mAdView = (AdView)findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setSingleEvent(GridLayout mainGrid) {
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (finalI == 0) {

                        Intent intent = new Intent(news.this,news_reader.class);
                        intent.putExtra("type","https://epaperlive.timesofindia.com/");
                        startActivity(intent);

                    }
                    else if (finalI == 1)
                    {
                        Intent intent = new Intent(news.this,news_reader.class);
                        intent.putExtra("type","https://www.indiatoday.in/");
                        startActivity(intent);
                    }
                    else if (finalI == 2)
                    {
                        Intent intent = new Intent(news.this,news_reader.class);
                        intent.putExtra("type","https://epaper.jagran.com/mepaper/");
                        startActivity(intent);
                    }
                    else if (finalI == 3)
                    {
                        Intent intent = new Intent(news.this,news_reader.class);
                        intent.putExtra("type","https://khabar.ndtv.com");
                        startActivity(intent);
                    }

                }
            });
        }
    }

}
