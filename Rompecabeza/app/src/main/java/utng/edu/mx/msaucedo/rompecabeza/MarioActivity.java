package utng.edu.mx.msaucedo.rompecabeza;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by Mariana Saucedo on 20/06/2016.
 */
public class MarioActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageButton[] imagenes;
    private Puzzle p1;
    private int pieza1;
    private int pieza2;
    private ImageButton imagenTempo; //Permitira el intercambio de imagenes
    private Button btnMezclar;
    private Button btnRegresar;
    private TextView txtTiempo;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mario);

        btnMezclar = (Button) findViewById(R.id.btn_mezclar);
        btnRegresar = (Button) findViewById(R.id.btn_regresar);

        p1 = new Puzzle();
        imagenTempo = new ImageButton(this);

        imagenes = new ImageButton[16];
        imagenes[0] = (ImageButton) findViewById(R.id.btn_img1);
        imagenes[1] = (ImageButton) findViewById(R.id.btn_img2);
        imagenes[2] = (ImageButton) findViewById(R.id.btn_img3);
        imagenes[3] = (ImageButton) findViewById(R.id.btn_img4);
        imagenes[4] = (ImageButton) findViewById(R.id.btn_img5);
        imagenes[5] = (ImageButton) findViewById(R.id.btn_img6);
        imagenes[6] = (ImageButton) findViewById(R.id.btn_img7);
        imagenes[7] = (ImageButton) findViewById(R.id.btn_img8);
        imagenes[8] = (ImageButton) findViewById(R.id.btn_img9);
        imagenes[9] = (ImageButton) findViewById(R.id.btn_img10);
        imagenes[10] = (ImageButton) findViewById(R.id.btn_img11);
        imagenes[11] = (ImageButton) findViewById(R.id.btn_img12);
        imagenes[12] = (ImageButton) findViewById(R.id.btn_img13);
        imagenes[13] = (ImageButton) findViewById(R.id.btn_img14);
        imagenes[14] = (ImageButton) findViewById(R.id.btn_img15);
        imagenes[15] = (ImageButton) findViewById(R.id.btn_img16);

        for (int i = 0; i < 16; i++) {
            imagenes[i].setOnClickListener(this);
        }
        btnMezclar.setOnClickListener(this);
        btnRegresar.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_mezclar) {
            mezclarImagenes();
        }

        if(v.getId() == R.id.btn_regresar) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

        if(!p1.isBanTiro()) { //SI es el primer tiro.
            switch (v.getId()) {
                case R.id.btn_img1:
                    pieza1 = 0;
                    break;
                case R.id.btn_img2:
                    pieza1 = 1;
                    break;
                case R.id.btn_img3:
                    pieza1 = 2;
                    break;
                case R.id.btn_img4:
                    pieza1 = 3;
                    break;
                case R.id.btn_img5:
                    pieza1 = 4;
                    break;
                case R.id.btn_img6:
                    pieza1 = 5;
                    break;
                case R.id.btn_img7:
                    pieza1 = 6;
                    break;
                case R.id.btn_img8:
                    pieza1 = 7;
                    break;
                case R.id.btn_img9:
                    pieza1 = 8;
                    break;
                case R.id.btn_img10:
                    pieza1 = 9;
                    break;
                case R.id.btn_img11:
                    pieza1 = 10;
                    break;
                case R.id.btn_img12:
                    pieza1 = 11;
                    break;
                case R.id.btn_img13:
                    pieza1 = 12;
                    break;
                case R.id.btn_img14:
                    pieza1 = 13;
                    break;
                case R.id.btn_img15:
                    pieza1 = 14;
                    break;
                case R.id.btn_img16:
                    pieza1 = 15;
                    break;
            }
            p1.setTiro1(pieza1);
        } else {
            switch (v.getId()) {
                case R.id.btn_img1:
                    pieza2 = 0;
                    break;
                case R.id.btn_img2:
                    pieza2 = 1;
                    break;
                case R.id.btn_img3:
                    pieza2 = 2;
                    break;
                case R.id.btn_img4:
                    pieza2 = 3;
                    break;
                case R.id.btn_img5:
                    pieza2 = 4;
                    break;
                case R.id.btn_img6:
                    pieza2 = 5;
                    break;
                case R.id.btn_img7:
                    pieza2 = 6;
                    break;
                case R.id.btn_img8:
                    pieza2 = 7;
                    break;
                case R.id.btn_img9:
                    pieza2 = 8;
                    break;
                case R.id.btn_img10:
                    pieza2 = 9;
                    break;
                case R.id.btn_img11:
                    pieza2 = 10;
                    break;
                case R.id.btn_img12:
                    pieza2 = 11;
                    break;
                case R.id.btn_img13:
                    pieza2 = 12;
                    break;
                case R.id.btn_img14:
                    pieza2 = 13;
                    break;
                case R.id.btn_img15:
                    pieza2 = 14;
                    break;
                case R.id.btn_img16:
                    pieza2 = 15;
                    break;
            }
            p1.setTiro2(pieza2);
            intercambiarImagenes(pieza1, pieza2);

            if(p1.yaGano()) {
                Toast.makeText(getApplicationContext(), "GANASTE!!!!!!!", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private void intercambiarImagenes(int pieza1, int pieza2) {
        imagenTempo.setImageDrawable(imagenes[pieza1].getDrawable());
        imagenes[pieza1].setImageDrawable(imagenes[pieza2].getDrawable());
        imagenes[pieza2].setImageDrawable(imagenTempo.getDrawable());
    }

    private void mezclarImagenes() {
        btnMezclar.setEnabled(false);
        Random r1 = new Random();
        int y = 0;
        int x = 0;

        for (int i = 1; i < 100; i++) {
            x = r1.nextInt(16);
            y = r1.nextInt(16);

            intercambiarImagenes(x, y);
            p1.setTiro1(x);
            p1.setTiro2(y);
        }
    }
}
