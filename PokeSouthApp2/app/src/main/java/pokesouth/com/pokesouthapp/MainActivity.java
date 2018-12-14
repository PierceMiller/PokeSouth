package pokesouth.com.pokesouthapp;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.applovin.sdk.AppLovinPrivacySettings;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.applovin.sdk.AppLovinSdk;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawer;

    private String purple = "#BB75E9";
    private String brown = "#A26A06";
    private String yellow = "#F2EB04";
    private String pink = "#E545E5";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);

        toolbar.setTitle(" ");

        BitmapDrawable background = new BitmapDrawable (BitmapFactory.decodeResource(getResources(), R.drawable.ic_test1));
        background.setTileModeX(android.graphics.Shader.TileMode.REPEAT);
        toolbar.setBackground(background);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.draw_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new Frag1_CurrentPokemon()).commit();
            navigationView.setCheckedItem(R.id.nav_current_raids);
        }

        navigationView.getMenu()
                .findItem(R.id.nav_map)
                .getIcon()
                .setColorFilter(Color.parseColor(brown), PorterDuff.Mode.DST);

        navigationView.getMenu()
                .findItem(R.id.nav_current_raids)
                .getIcon()
                .setColorFilter(Color.parseColor(brown), PorterDuff.Mode.DST);

        navigationView.getMenu()
                .findItem(R.id.nav_level_5)
                .getIcon()
                .setColorFilter(Color.parseColor(purple), PorterDuff.Mode.DST);

        navigationView.getMenu()
                .findItem(R.id.nav_level_4)
                .getIcon()
                .setColorFilter(Color.parseColor(yellow), PorterDuff.Mode.DST);

        navigationView.getMenu()
                .findItem(R.id.nav_level_3)
                .getIcon()
                .setColorFilter(Color.parseColor(yellow), PorterDuff.Mode.DST);

        navigationView.getMenu()
                .findItem(R.id.nav_level_2)
                .getIcon()
                .setColorFilter(Color.parseColor(pink), PorterDuff.Mode.DST);

        navigationView.getMenu()
                .findItem(R.id.nav_level_1)
                .getIcon()
                .setColorFilter(Color.parseColor(pink), PorterDuff.Mode.DST);

        //adMob
        MobileAds.initialize(this, "ca-app-pub-2982820374753667~6485409389");

        View header = navigationView.getHeaderView(0);

        AdView adView = header.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch(menuItem.getItemId()){
            case R.id.nav_current_raids:

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Frag1_CurrentPokemon()).commit();
                break;
            case R.id.nav_level_5:

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Frag2_All_Level_5s()).commit();
                break;
            case R.id.nav_level_4:

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Frag3_All_Level_4s()).commit();
                break;
            case R.id.nav_level_3:

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Frag4_All_Level_3s()).commit();
                break;
            case R.id.nav_level_2:

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Frag5_All_Level_2s()).commit();
                break;
            case R.id.nav_level_1:

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Frag6_All_Level_1s()).commit();
                break;
            case R.id.nav_map:

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Map_Fragment()).commit();
                break;
            case R.id.nav_credit:

                Toast.makeText(this, "All content & design ©\n" +
                        "Pokemon Database, 2008-2018\n" +
                        "Pokémon images & names ©\n" +
                        "Nintendo/Game Freak, 1995-2018 ", Toast.LENGTH_SHORT).show();

                break;
            case R.id.nav_disclaimer:
                Toast.makeText(this, "PokéSouth, is in no way associated with Pokémon Go © or Niantic inc.\n" +
                        "This is purely a service, that aims to help trainers, within Pokémon Go ©", Toast.LENGTH_SHORT).show();

                break;
            case R.id.nav_About:

                Toast.makeText(this, "PokéSouth is a community that is built around Pokémon Go ©\n" +
                        "and can be found at:\nhttps://discord.gg/ZHpd9pQ", Toast.LENGTH_SHORT).show();
                break;

        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed(){

        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        } else{
            super.onBackPressed();
        }
    }
}
