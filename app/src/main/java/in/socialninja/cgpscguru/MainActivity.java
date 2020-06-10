package in.socialninja.cgpscguru;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.Menu;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    AdView mAdView;
    GridLayout mainGrid;
   // private DrawerLayout drawer;
    public InterstitialAd interstitialAd;
    public InterstitialAd interstitialAd2;
    private Drawer result = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawableResource(R.drawable.bg);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this,"ca-app-pub-3940256099942544~3347511713");
        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       /* drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            public boolean onNavigationItemSelected(MenuItem menuItem) {


                return false;
            }
        });
        toggle.syncState();
        View header = navigationView.getHeaderView(0);
        ImageView piccture = (ImageView)header. findViewById(R.id.imageView);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        Glide.with(getApplicationContext()).load(user.getPhotoUrl())
                .thumbnail(0.5f)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(piccture);
        TextView nameTxt = (TextView)header. findViewById(R.id.textView);
        nameTxt.setText(user.getDisplayName());
        TextView emailTxt = (TextView)header. findViewById(R.id.Email);
        emailTxt.setText(user.getEmail());*/

            mainGrid =(GridLayout)

            findViewById(R.id.mainGrid);

            setSingleEvent(mainGrid);

            mAdView = (AdView)findViewById(R.id.adView);
        final AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        interstitialAd.loadAd(adRequest);

        interstitialAd2 = new InterstitialAd(this);
        interstitialAd2.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        interstitialAd2.loadAd(adRequest);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String personName = user.getDisplayName();
        String personEmail = user.getEmail();

        // Create the AccountHeader
        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.header)
                .addProfiles(
                        new ProfileDrawerItem().withName(personName).withEmail(personEmail).withIcon(user.getPhotoUrl())
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })
                .build();



        //create the drawer and remember the `Drawer` result object
        result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withAccountHeader(headerResult)
                .addDrawerItems(
                        new PrimaryDrawerItem().withIdentifier(1).withName("Home").withIcon(R.drawable.home),
                        new SectionDrawerItem().withName("Communication"),
                        new SecondaryDrawerItem().withName("Developer's Message").withIcon(R.drawable.ic_message).withIdentifier(2),
                        new SecondaryDrawerItem().withName("Contact Us").withIcon(R.drawable.ic_contact).withIdentifier(3),
                        new SectionDrawerItem().withName("Other"),
                        new SecondaryDrawerItem().withName("Credits").withIcon(R.drawable.credits).withIdentifier(4),
                        new SecondaryDrawerItem().withName("Share").withIcon(R.drawable.ic_screen_share_black_24dp).withIdentifier(5),
                        new SecondaryDrawerItem().withName("Rate App").withIcon(R.drawable.rate_review).withIdentifier(6),
                        new SecondaryDrawerItem().withName("Donate").withIcon(R.drawable.ic_monetization_on_black_24dp).withIdentifier(7)




                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        if (drawerItem.getIdentifier() == 1) {
                            result.closeDrawer();
                            Toast.makeText(MainActivity.this, "HOME", Toast.LENGTH_SHORT).show();
                        } else if (drawerItem.getIdentifier() == 2) {
                            result.closeDrawer();
                            final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("About Us");
                            builder.setMessage("This Application is for helping our Friends who are preapring for Chhattisgarh Public Service Commision Examination.\n" +
                                    "This Application Provides You Everything About Chhattisgarh and Provides a Free Quiz Section From Where you can test your Mind.\n\n" +
                                    "Developed By - Kritarth Agrawal(Socialninja.in)");
                            builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });
                            AlertDialog alertDialog = builder.create();
                            alertDialog.show();
                        } else if (drawerItem.getIdentifier() == 3) {
                            result.closeDrawer();
                            Toast.makeText(MainActivity.this, "CONTACT US", Toast.LENGTH_SHORT).show();

                        } else if (drawerItem.getIdentifier() == 4) {
                            result.closeDrawer();
                            Toast.makeText(MainActivity.this, "CREDITS", Toast.LENGTH_SHORT).show();
                        } else if (drawerItem.getIdentifier() == 5) {
                            result.closeDrawer();
                            Intent shareintent = new Intent();
                            shareintent.setAction(Intent.ACTION_SEND);
                            shareintent.putExtra(Intent.EXTRA_TEXT, "Search for CGPSC GURU in PlayStore and Download To Show Support To Us :)");
                            shareintent.setType("text/plain");
                            startActivity(shareintent);
                        } else if (drawerItem.getIdentifier() == 6) {
                            result.closeDrawer();
                            Toast.makeText(MainActivity.this, "RATE APP", Toast.LENGTH_SHORT).show();
                        } else if (drawerItem.getIdentifier() == 7) {
                            result.closeDrawer();
                            Toast.makeText(MainActivity.this, "Donate Us", Toast.LENGTH_SHORT).show();
                        }
                        return false;
                    }
                })
                .build();



    }
    @Override
    public void onBackPressed(){
            result.closeDrawer();
            final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Quit Application");
            builder.setMessage("Are You Sure, Want To Exit App....!!");
            builder.setNegativeButton("Stay", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    finish();
                    if(interstitialAd2.isLoaded()){
                            interstitialAd2.show();
                    }
                }
            });
            AlertDialog alertDialog=builder.create();
            alertDialog.show();
       // }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return  super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.exit)
        {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void setSingleEvent(GridLayout mainGrid) {
        for (int i=0;i<mainGrid.getChildCount();i++)
        {
            CardView cardView = (CardView)mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(finalI==0)
                    {
                        if(interstitialAd.isLoaded()){
                            interstitialAd.show();
                        }

                            Intent intent = new Intent(MainActivity.this, syllabus.class);
                            startActivity(intent);

                    }
                    else if(finalI==1)
                    {
                        if(interstitialAd.isLoaded()){
                            interstitialAd.show();
                        }

                            Intent intent = new Intent(MainActivity.this, freequiz.class);
                            startActivity(intent);

                    }
                    else if(finalI==2)
                    {
                        Intent intent = new Intent(MainActivity.this,testseries.class);
                        startActivity(intent);
                    }
                    else if(finalI==3)
                    {
                        Toast.makeText(MainActivity.this, "E-books Comming Soon", Toast.LENGTH_SHORT).show();
                    }
                    else if(finalI==4)
                    {
                        Intent intent = new Intent(MainActivity.this,aboutcg.class);
                        startActivity(intent);
                    }
                    else if(finalI==5)
                    {
                        Intent intent = new Intent(MainActivity.this,subscribe.class);
                        startActivity(intent);
                    }
                    else if(finalI==6)
                    {
                        Intent intent = new Intent(MainActivity.this,news.class);
                        startActivity(intent);
                    }
                    else if(finalI==7)
                    {
                        Intent intent = new Intent(MainActivity.this,economicsurvey.class);
                        startActivity(intent);
                    }
                    else if(finalI==8)
                    {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube://user/results?search_query=cgpsc+topper+interview"));
                        startActivity(intent);
                    }
                    else if(finalI==9)
                    {
                        Toast.makeText(MainActivity.this, "Question Papers Comming Soon", Toast.LENGTH_SHORT).show();
                    }
                    else if(finalI==10)
                    {
                        Intent intent = new Intent(MainActivity.this,youtubevid.class);
                        startActivity(intent);
                    }
                    else if(finalI==11)
                    {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube://user/results?search_query=cgpsc+tips"));
                        startActivity(intent);
                    }

                }
            });




        }
    }





    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {


        return false;
    }



}
