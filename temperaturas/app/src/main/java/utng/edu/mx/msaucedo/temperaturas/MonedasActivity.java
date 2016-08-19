package utng.edu.mx.msaucedo.temperaturas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * Created by Mariana Saucedo on 20/06/2016.
 */
public class MonedasActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText txtPesos;
    private EditText txtResultado;

    private RadioButton rbtnDolares;
    private RadioButton rbtnEuros;
    private RadioButton rbtnYenes;

    private Button btnresultado;
    private Button btnLimpiar;
    private Button btnSalir;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monedas);
        txtPesos = (EditText) findViewById(R.id.txt_pesos);
        txtResultado = (EditText) findViewById(R.id.txt_resultado);

        rbtnDolares = (RadioButton) findViewById(R.id.rb_dolares);
        rbtnEuros = (RadioButton) findViewById(R.id.rb_euros);
        rbtnYenes = (RadioButton) findViewById(R.id.rb_yenes);

        btnresultado = (Button) findViewById(R.id.btn_resultado);
        btnLimpiar = (Button) findViewById(R.id.btn_limpiar);
        btnSalir = (Button) findViewById(R.id.btn_salir);
        btnresultado.setOnClickListener(this);
        btnLimpiar.setOnClickListener(this);
        btnSalir.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        double dl = 0.0;
        double eu = 0.0;
        double yn = 0.0;
        double mx = 0.0;

        switch (v.getId()) {
            case R.id.btn_resultado:
                String resultado = txtPesos.getText().toString();
                if(!(resultado.equalsIgnoreCase(""))) {
                    if(rbtnDolares.isChecked()) {
                        mx = Double.parseDouble(txtPesos.getText().toString());
                        dl = Conversiones.pesosToDolares(mx);

                        txtResultado.setText(""+dl+ " Dolares");
                    } else if(rbtnEuros.isChecked()) {
                        mx = Double.parseDouble(txtPesos.getText().toString());
                        eu = Conversiones.pesosToEuros(mx);
                        txtResultado.setText(""+eu+ " Euros");
                    } else if(rbtnYenes.isChecked()) {
                        mx = Double.parseDouble(txtPesos.getText().toString());
                        yn = Conversiones.pesosToYenes(mx);
                        txtResultado.setText(""+yn+ " Yenes");
                    } else {
                        Toast.makeText(MonedasActivity.this,
                                "Selecciona un elemento.", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(MonedasActivity.this,
                            "El campo no puede ir vacio.", Toast.LENGTH_LONG).show();
                }

                break;
            case R.id.btn_limpiar:

                txtPesos.setText("");
                txtResultado.setText("");
                rbtnDolares.setChecked(false);
                rbtnYenes.setChecked(false);
                rbtnEuros.setChecked(false);

                break;

            case R.id.btn_salir:
                System.exit(0);
                break;
        }
    }
}
