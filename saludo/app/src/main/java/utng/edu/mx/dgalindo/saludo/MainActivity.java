package utng.edu.mx.dgalindo.saludo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnSaludar;
    private Button btnDespedir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSaludar=(Button)findViewById(R.id.btn_saludar);
        btnDespedir=(Button)findViewById(R.id.btn_despedir);


        btnSaludar.setOnClickListener(this);
        btnDespedir.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_saludar:
                Intent i = new Intent(this, SaludoActivity.class);
                startActivity(i);
                break;
            case R.id.btn_despedir:

                break;
        }
        
        switch (view.getId()) {
            case R.id.btn_despedir:
                Intent i = new Intent(this, SaludoActivity.class);
                startActivity(i);
                break;
            case R.id.btn_saludar:

                break;
        }

    }
}
