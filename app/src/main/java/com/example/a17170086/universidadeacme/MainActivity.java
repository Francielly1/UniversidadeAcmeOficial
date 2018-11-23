package com.example.a17170086.universidadeacme;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.a17170086.universidadeacme.fragments.AgendaFragment;
import com.example.a17170086.universidadeacme.fragments.BoletimFragment;
import com.example.a17170086.universidadeacme.fragments.CarteirinhaDigitalFragment;
import com.example.a17170086.universidadeacme.fragments.EventoFragment;
import com.example.a17170086.universidadeacme.fragments.FeadbackFragment;
import com.example.a17170086.universidadeacme.fragments.FinanceiroFragment;
import com.example.a17170086.universidadeacme.fragments.NoticiaFragment;
import com.example.a17170086.universidadeacme.view.MainFragmentContract;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, MainFragmentContract {

    //fragment manager
    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fm = getSupportFragmentManager();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //chamar tela home
        /*LoginFragment loginFragment = new LoginFragment();
        loginFragment.configDependencias(this);

        abrirFragment(loginFragment);*/

        EventoFragment eventoFragment = new EventoFragment();
        eventoFragment.configDependencias(this);

        abrirFragment(eventoFragment);
    }


    @Override
    public void abrirFragment(Fragment tela){

        FragmentTransaction fragmentTransaction = fm.beginTransaction();

        fragmentTransaction.replace(R.id.frame_layout,tela);

        fragmentTransaction.addToBackStack(null).commit();
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_eventos) {
            // Handle the camera action
            //chamar tela home
            EventoFragment evento = new EventoFragment();
            evento.configDependencias(this);
            abrirFragment(evento);

        } else if (id == R.id.nav_noticias) {
            NoticiaFragment noticiaFragment = new NoticiaFragment();
            noticiaFragment.configDependencias(this);
            abrirFragment(noticiaFragment);

        } else if (id == R.id.nav_agenda) {
            AgendaFragment agendaFragment = new AgendaFragment();
            agendaFragment.configDependencias(this);
            abrirFragment(agendaFragment);

        } else if (id == R.id.nav_boletim) {

            abrirFragment(new BoletimFragment());

        } else if (id == R.id.nav_financeiro) {

            abrirFragment(new FinanceiroFragment());

        } else if (id == R.id.nav_qrcode) {
            abrirFragment(new CarteirinhaDigitalFragment());

        } else if (id == R.id.nav_share) {
            abrirFragment(new FeadbackFragment());
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
