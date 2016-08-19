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
public class TemperaturasActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText txtGradosCelsius;
    private EditText txtResultado;

    private RadioButton rbtnFahrenheit;
    private RadioButton rbtnKelvin;
    private RadioButton rbtnRankin;

    private Button btnresultado;
    private Button btnLimpiar;
    private Button btnSalir;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperaturas);
        txtGradosCelsius = (EditText) findViewById(R.id.txt_grados_celsius);
        txtResultado = (EditText) findViewById(R.id.txt_resultado);

        rbtnFahrenheit = (RadioButton) findViewById(R.id.rb_fahrenheit);
        rbtnKelvin = (RadioButton) findViewById(R.id.rb_kelvin);
        rbtnRankin = (RadioButton) findViewById(R.id.rb_rankin);

        btnresultado = (Button) findViewById(R.id.btn_resultado);
        btnLimpiar = (Button) findViewById(R.id.btn_limpiar);
        btnSalir = (Button) findViewById(R.id.btn_salir);
        btnresultado.setOnClickListener(this);
        btnLimpiar.setOnClickListener(this);
        btnSalir.setOnClickListener(this);

    }

    public void onClick(View v) {
        double gc = 0.0;
        double gf = 0.0;
        double gk = 0.0;
        double gr = 0.0;

        switch (v.getId()) {
            case R.id.btn_resultado:
                String resultado = txtGradosCelsius.getText().toString();
                if(!(resultado.equalsIgnoreCase(""))) {
                    if(rbtnFahrenheit.isChecked()) {
                        gc = Double.parseDouble(txtGradosCelsius.getText().toString());
                        gf = Conversiones.gradosCTogradosF(gc);

                        txtResultado.setText(""+gf+ " Farenheit");
                    } else if(rbtnKelvin.isChecked()) {
                        gc = Double.parseDouble(txtGradosCelsius.getText().toString());
                        gk = Conversiones.gradosCTogradosK(gc);

                        txtResultado.setText(""+gk+ " Kelvin");

                    } else if(rbtnRankin.isChecked()) {
                        gc = Double.parseDouble(txtGradosCelsius.getText().toString());
                        gr = Conversiones.gradosCTogradosR(gc);

                        txtResultado.setText(""+gr+ " Rankin ");
                    } else {
                        Toast.makeText(TemperaturasActivity.this,
                                "Selecciona un elemento.", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(TemperaturasActivity.this,
                            "El campo no puede ir vacio.", Toast.LENGTH_LONG).show();
                }

                break;
            case R.id.btn_limpiar:

                txtGradosCelsius.setText("");
                txtResultado.setText("");
                rbtnFahrenheit.setChecked(false);
                rbtnKelvin.setChecked(false);
                rbtnRankin.setChecked(false);

                break;

            case R.id.btn_salir:
                System.exit(0);
                break;
        }
    }
}

