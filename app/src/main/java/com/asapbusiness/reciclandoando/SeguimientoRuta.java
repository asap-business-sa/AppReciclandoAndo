package com.asapbusiness.reciclandoando;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.BundleCompat;

import com.vishnusivadas.advanced_httpurlconnection.PutData;

import java.util.ArrayList;

public class SeguimientoRuta extends AppCompatActivity{

    TableLayout tlTabla;

    override fun onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ruta_reciclador);

        tlTabla=findViewById(R.id.tlTabla);
        trazabilidad();
    }
    fun trazabilidad(){
        PutData putData = new PutData("https://luisbustamante.tk/Consulta/Consulta.php", "POST", field, data);
        val bd=putData.writableDatabase
        val fila=bd.rawQuery(sql:"Select R.latitud,R.longitud, D.latitud, D.longitud from MapReciclador R INNER JOIN MapDonador D ON  R.id_MapReciclador = D.MapDonador where R.longitud = D.longitud",selectionArgs:null)
        fila.moveToFirst()
        do{
            val registro= LayoutInflater.from(this).inflate(R.layout.ruta_reciclador,null,false);
            val tvreciclador=registro.findviewById(View)(R.id.tvreciclador) as TextView
            val tvlongitud=registro.findviewById(View)(R.id.tvlongitud) as TextView
            val tvlatitud=registro.findviewById(View)(R.id.tvlatitud) as TextView
            val tvdonador=registro.findviewById(View)(R.id.tvdonador) as TextView
            tvreciclador.setText(fila.getString(0))
            tvlongitud.setText(fila.getString(1))
            tvlatitud.setText(fila.getString(2))
            tvdonador.setText(fila.getString(3))
            tlTabla.addView(registro);

        }while(putData.moveToNext())
    }

}
