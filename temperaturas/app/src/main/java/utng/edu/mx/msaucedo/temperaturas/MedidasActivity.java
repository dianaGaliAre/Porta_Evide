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
public class MedidasActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText txtMetros;
    private EditText txtResultado;

    private RadioButton rbtnYardas;
    private RadioButton rbtnKilometros;
    private RadioButton rbtnMillas;

    private Button btnresultado;
    private Button btnLimpiar;
    private Button btnSalir;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medidas);
        txtMetros = (EditText) findViewById(R.id.txt_metros);
        txtResultado = (EditText) findViewById(R.id.txt_resultado);

        rbtnMillas = (RadioButton) findViewById(R.id.rb_millas);
        rbtnKilometros = (RadioButton) findViewById(R.id.rb_kilometros);
        rbtnYardas = (RadioButton) findViewById(R.id.rb_yardas);

        btnresultado = (Button) findViewById(R.id.btn_resultado);
        btnLimpiar = (Button) findViewById(R.id.btn_limpiar);
        btnSalir = (Button) findViewById(R.id.btn_salir);
        btnresultado.setOnClickListener(this);
        btnLimpiar.setOnClickListener(this);
        btnSalir.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        double mtrs = 0.0;
        double kms = 0.0;
        double yd = 0.0;
        double mll = 0.0;

        switch (v.getId()) {
            case R.id.btn_resultado:
                String resultado = txtMetros.getText().toString();
                if(!(resultado.equalsIgnoreCase(""))) {
                    if(rbtnKilometros.isChecked()) {
                        mtrs = Double.parseDouble(txtMetros.getText().toString());
                        kms = Conversiones.metrosToKilometros(mtrs);
                        txtResultado.setText(""+kms+" Kilometros");
                    } else if(rbtnYardas.isChecked()) {
                        mtrs = Double.parseDouble(txtMetros.getText().toString());
                        yd= Conversiones.metrosToYardas(mtrs);
                        txtResultado.setText(""+yd+" Yardas");
                    } else if(rbtnMillas.isChecked()) {
                        mtrs = Double.parseDouble(txtMetros.getText().toString());
                        mll= Conversiones.metrosToMillas(mtrs);
                        txtResultado.setText(""+mll+" Millas");
                    }else {
                        Toast.makeText(MedidasActivity.this,
                                "Selecciona un elemento.", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(MedidasActivity.this,
                            "El campo no puede ir vacio.", Toast.LENGTH_LONG).show();
                }

                break;
            case R.id.btn_limpiar:

                txtMetros.setText("");
                txtResultado.setText("");
                rbtnKilometros.setChecked(false);
                rbtnMillas.setChecked(false);
                rbtnYardas.setChecked(false);
                break;

            case R.id.btn_salir:
                System.exit(0);
                break;
        }
    }
}
