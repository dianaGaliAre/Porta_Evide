package equitnero.utng.edu.mx.practica;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    private ImageButton btnImagen;
    private Button btnOption1;
    private Button btnOption2;
    private Button btnOption3;
    private Button btnOption4;
    private TextView txtDesplazamiento;
    private float x1, y1;


    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnImagen = (ImageButton) findViewById(R.id.btn_imagen);
        txtDesplazamiento = (TextView) findViewById(R.id.txt_desplazamiento);

        btnOption1 = (Button) findViewById(R.id.btnOpcion1);
        btnOption2 = (Button) findViewById(R.id.btnOpcion2);
        btnOption3 = (Button) findViewById(R.id.btnOpcion3);
        btnOption4 = (Button) findViewById(R.id.btnOpcion4);
        btnImagen.setOnTouchListener(this);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        float  x2,  y2, dx, dy;
        switch (v.getId()){
            case R.id.btnOpcion1:
                txtDesplazamiento.setText("Pulsó opción 1");
                break;
            case R.id.btnOpcion2:
                txtDesplazamiento.setText("Pulsó opción 2");
                break;
            case R.id.btnOpcion3:
                txtDesplazamiento.setText("Pulsó opción 3");
                break;
            case R.id.btnOpcion4:
                txtDesplazamiento.setText("Pulsó opción 4");
                break;
            case R.id.btn_imagen:
                if (event.getAction() ==MotionEvent.ACTION_DOWN){
                    x1 = event.getX();
                    y1 = event.getY();
                }
                if(event.getAction()==MotionEvent.ACTION_UP){
                    x2 = event.getX();
                    y2 = event.getY();
                    dx = x2 - x1;
                    dy = y2 - y1;
                    if(Math.abs(dx)>Math.abs(dy)){// desplazamiento horizontal
                            if(dx>0){
                                txtDesplazamiento.setText("Desplazado  a la derecha");
                            }
                    else{ // desplazamiento vertical
                                txtDesplazamiento.setText("Desplazado a la izquierda");
                    }
                }else{
                    if (dy>0){
                        txtDesplazamiento.setText("Desplazamiento hacia abajo");
                    }else{
                        txtDesplazamiento.setText("Desplazamiento hacia abajo");
                    }
                    }
                    }
                }
        return false;
        }


    }

