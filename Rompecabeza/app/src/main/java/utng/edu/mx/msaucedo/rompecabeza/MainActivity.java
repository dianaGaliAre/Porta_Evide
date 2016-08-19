package utng.edu.mx.msaucedo.rompecabeza;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private LinearLayout mainLayout;
    private ListView menuLateral;
    private Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar aBar=getSupportActionBar();
        aBar.setHomeButtonEnabled(true);
        aBar.setDisplayHomeAsUpEnabled(true);
        drawerLayout= (DrawerLayout) findViewById(R.id.drawerLayout);
        mainLayout= (LinearLayout)findViewById(R.id.mainLayout);
        menuLateral= (ListView) findViewById(R.id.menuLateral);
        String[] opciones={"Mario Bross","Arale","Payaso","Monster University","Creditos"};
        ArrayAdapter adp= new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,opciones);
        menuLateral.setAdapter(adp);
        menuLateral.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String opcSeleccionado = (String) menuLateral.getAdapter().getItem(position);
                Toast.makeText(MainActivity.this,opcSeleccionado,Toast.LENGTH_SHORT).show();

                drawerLayout.closeDrawer(menuLateral);
                if(opcSeleccionado.equals("Mario Bross")){
                    i = new Intent(MainActivity.this,MarioActivity.class);
                    startActivity(i);
                }else if(opcSeleccionado.equals("Arale")){
                    i= new Intent(MainActivity.this,AraleActivity.class);
                    startActivity(i);
                }else if(opcSeleccionado.equals("Payaso")){
                    i = new Intent(MainActivity.this,PayasoActivity.class);
                    startActivity(i);
                }else if(opcSeleccionado.equals("Monster University")){
                    i = new Intent(MainActivity.this,MonsterActivity.class);
                    startActivity(i);
                }else if(opcSeleccionado.equals("Creditos")){
                    i = new Intent(MainActivity.this,CreditosActivity.class);
                    startActivity(i);
                }
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == android.R.id.home){
            if(drawerLayout.isDrawerOpen(menuLateral)){
                drawerLayout.closeDrawer(menuLateral);
            }else{
                drawerLayout.openDrawer(menuLateral);
            }
        }
        return true;
    }
}
