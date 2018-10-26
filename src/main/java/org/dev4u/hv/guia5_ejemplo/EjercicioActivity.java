package org.dev4u.hv.guia5_ejemplo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class EjercicioActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView izq, centro, derech;
    Button btnIzq, btnCentro, btnDerech;
    Animation anim_COMBINADO;
    Boolean esIzquierda;
    Boolean esDerecha;
    Boolean esCentro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio);
        btnIzq=findViewById(R.id.btnIzq);
        btnCentro=findViewById(R.id.btnCentro);
        btnDerech=findViewById(R.id.btnDerech);
        izq=findViewById(R.id.izq);
        centro=findViewById(R.id.centro);
        derech=findViewById(R.id.derech);

        anim_COMBINADO = AnimationUtils.loadAnimation(this, R.anim.bajar_aparecer);
        anim_COMBINADO.setDuration(1000);
        anim_COMBINADO.setFillAfter(false);
        btnIzq.setOnClickListener(this);
        btnCentro.setOnClickListener(this);
        btnDerech.setOnClickListener(this);
        esIzquierda=false;
        esDerecha=false;
        esCentro=false;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnIzq:
                esIzquierda=true;
                esDerecha=false;
                esCentro=false;
                Animacion();
                break;
            case R.id.btnCentro:
                esDerecha=false;
                esIzquierda=false;
                esCentro=true;
                Animacion();
                break;
            case R.id.btnDerech:
                esIzquierda=false;
                esDerecha=true;
                esCentro=false;
                Animacion();
                break;
        }
    }

    private void Animacion(){
        if(esIzquierda){
            izq.startAnimation(anim_COMBINADO);
        }else{
            if(esDerecha){
                derech.startAnimation(anim_COMBINADO);
            }else{
                if(esCentro) {
                    centro.startAnimation(anim_COMBINADO);
                }
            }
        }
    }
}
