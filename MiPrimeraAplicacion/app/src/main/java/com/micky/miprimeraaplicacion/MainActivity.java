package com.micky.miprimeraaplicacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.micky.miprimeraaplicacion.backend.WSAlbums;
import com.micky.miprimeraaplicacion.backend.WebServiceAPI;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//Libreria para inicio de app movil
public class MainActivity extends AppCompatActivity {
//hace referencia a la clase = class al padre de metodos

    Button buttonCalculadora, buttonGrafico, buttonCrud, buttonSalir,buttonAPI, buttonWservices, buttonWslab;
    List<WSAlbums> listData = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //METODO LLAMANDO ONCREATE SIN RETORNO PROTEGIDO
        super.onCreate(savedInstanceState);
        //SUPER HACE REFERENCIA AL PADRE DEL QUE SE HEREDA
        // Y LE PASAMOS EL POBJETO SAVED


        setContentView(R.layout.activity_main);
        //TODO ESTO HACE REFERENCIA A LA ACTIVIDAD EN LA CUAL SE ESTA TRABAJANDO

        buttonCalculadora=findViewById(R.id.buttonCalculadora);
        buttonGrafico=findViewById(R.id.buttonGrafico);
        buttonCrud=findViewById(R.id.buttonCrud);
        buttonSalir=findViewById(R.id.buttonSalir);
        buttonAPI=findViewById(R.id.buttonAPI);
        buttonWservices=findViewById(R.id.buttonWServices);
        buttonWslab=findViewById(R.id.buttonWSLab);

        buttonCalculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CalculadoraActivity.class);
                startActivity(intent);
            }
        });

        buttonCrud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, BaseDatosActivity.class);
                startActivity(intent);

            }
        });

        buttonGrafico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent= new Intent(MainActivity.this, GraficoActivity.class);
            startActivity(intent);
            }
        });
        buttonAPI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //getData();
                Intent intent= new Intent(MainActivity.this, WebServicesActivity.class);
                startActivity(intent);
            }
        });
        buttonWservices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //getData();
                Intent intent= new Intent(MainActivity.this, WSLocalActivity.class);
                startActivity(intent);
            }
        });

        buttonWslab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //getData();
                Intent intent= new Intent(MainActivity.this, WSLabActivity.class);
                startActivity(intent);
            }
        });

        buttonSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            finish();
            }
        });
    }

    public void getData(){
        String URL_WS = "https://jsonplaceholder.typicode.com/";
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_WS)
                .addConverterFactory(GsonConverterFactory.create())
         .build();
        WebServiceAPI webServiceApi = retrofit.create(WebServiceAPI.class);
        final Call<List<WSAlbums>> call = webServiceApi.getAlbums();
        call.enqueue(new Callback<List<WSAlbums>>() {
            @Override
            public void onResponse(Call<List<WSAlbums>> call, Response<List<WSAlbums>> response) {
                if(response.isSuccessful()){
                    listData = response.body();
                    Toast.makeText(MainActivity.this, listData.get(0).getTitle(), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Algo paso", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<WSAlbums>> call, Throwable throwable) {
                Toast.makeText(MainActivity.this, "REVISE EL SERVICIO WEB DE INTERNET", Toast.LENGTH_SHORT).show();
            }
        });
    }
}