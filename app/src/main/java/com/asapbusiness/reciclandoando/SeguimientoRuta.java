package com.asapbusiness.reciclandoando;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.BundleCompat;

import com.vishnusivadas.advanced_httpurlconnection.PutData;

import java.util.ArrayList;

public class SeguimientoRuta extends AppCompatActivity{

    TableLayout tlTabla;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ruta_reciclador);

        tlTabla=findViewById(R.id.tlTabla);


    }
    fun trazabilidad(){

        PutData putData = new PutData("https://luisbustamante.tk/Consulta/Consulta.php", "POST", field, data);
       val bd=putData.writableDataBase
        val fila=bd.rawQuery(sql:"Select R.latitud,R.longitud, D.latitud, D.longitud from MapReciclador R INNER JOIN MapDonador D ON  R.id_MapReciclador = D.MapDonador where R.longitud = D.longitud",selectionArgs:null)
        fila.moveToFirst()
        do{
            val registro= LayoutInflater.from(context: this).inflate(R.layout.ruta_reciclador, root: null, attachToRoot:false)

        }while(putData.moveToNext())
    }

}
