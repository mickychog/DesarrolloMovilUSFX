package com.micky.miprimeraaplicacion;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.micky.miprimeraaplicacion.backend.WSLDirecciones;
import com.micky.miprimeraaplicacion.backend.WSLInformaciones;
import com.micky.miprimeraaplicacion.backend.WSLPersonas;
import com.micky.miprimeraaplicacion.backend.WSLProfesiones;
import com.micky.miprimeraaplicacion.backend.WSLPersonas;
import com.micky.miprimeraaplicacion.backend.WSLugares;
import com.micky.miprimeraaplicacion.backend.WebServiceAPI;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WSLabActivity extends AppCompatActivity {
    private TextView textViewInfo;
    List<WSLugares> listData = new ArrayList<WSLugares>();
    List<WSLPersonas> listData1 = new ArrayList<WSLPersonas>();
    List<WSLInformaciones> listData3 = new ArrayList<WSLInformaciones>();
    List<WSLDirecciones> listData2 = new ArrayList<WSLDirecciones>();
    List<WSLProfesiones> listData4 = new ArrayList<WSLProfesiones>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_wslab);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textViewInfo = findViewById(R.id.textViewInfo);

        //getDataLugares();
        getDataPersonas();
    }

    public void getDataLugares(){
        String URL_WS = "http://192.168.0.7/webservice/primer.php/";
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_WS)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WebServiceAPI webServiceApi = retrofit.create(WebServiceAPI.class);
        final Call<List<WSLugares>> call = webServiceApi.getLugares();
        call.enqueue(new Callback<List<WSLugares>>() {
            @Override
            public void onResponse(Call<List<WSLugares>> call, Response<List<WSLugares>> response) {
                if(response.isSuccessful()){
                    listData = response.body();
                    StringBuilder userInfoBuilder = new StringBuilder();
                    //Toast.makeText(WebServicesActivity.this, listDataUsers.get(0).getAddress().getCity(), Toast.LENGTH_SHORT).show();

                    // Recorrer la lista de usuarios y construir la cadena con los detalles de cada usuario
                    for (WSLugares user : listData) {
                        userInfoBuilder.append("---------------------------------------\n");
                        userInfoBuilder.append("ID: ").append(user.getId()).append("\n");
                        userInfoBuilder.append("Nombre: ").append(user.getNombre()).append("\n");
                        userInfoBuilder.append("Descripcion: ").append(user.getDescripcion()).append("\n");
                        userInfoBuilder.append("latitud: ").append(user.getLatitud()).append("\n");
                        userInfoBuilder.append("Longitud: ").append(user.getLongitud()).append("\n");
                    }

                    // Mostrar la información en el TextView
                    textViewInfo.setText(userInfoBuilder.toString());
                }else{
                    Toast.makeText(WSLabActivity.this, "Algo paso", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<WSLugares>> call, Throwable throwable) {

                Toast.makeText(WSLabActivity.this, "REVISE EL SERVICIO WEB DE INTERNET", Toast.LENGTH_SHORT).show();

            }
        });

    }

    public void getDataPersonas(){
        final long startTime = System.currentTimeMillis();

        String URL_WS1 = "http://192.168.0.7/webservice/tablas_personas.php/";
        String URL_WS2 = "http://192.168.0.7/webservice/tablas_direcciones.php/";
        String URL_WS3 = "http://192.168.0.7/webservice/tablas_informaciones.php/";
        String URL_WS4 = "http://192.168.0.7/webservice/tablas_profesiones.php/";

        final Retrofit retrofit1 = new Retrofit.Builder()
                .baseUrl(URL_WS1)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final Retrofit retrofit2 = new Retrofit.Builder()
                .baseUrl(URL_WS2)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final Retrofit retrofit3 = new Retrofit.Builder()
                .baseUrl(URL_WS3)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final Retrofit retrofit4 = new Retrofit.Builder()
                .baseUrl(URL_WS4)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WebServiceAPI webServiceApi1 = retrofit1.create(WebServiceAPI.class);
        WebServiceAPI webServiceApi2 = retrofit2.create(WebServiceAPI.class);
        WebServiceAPI webServiceApi3 = retrofit3.create(WebServiceAPI.class);
        WebServiceAPI webServiceApi4 = retrofit4.create(WebServiceAPI.class);

        final Call<List<WSLPersonas>> call1 = webServiceApi1.getPersonas();
        final Call<List<WSLDirecciones>> call2 = webServiceApi2.getDirecciones();
        final Call<List<WSLInformaciones>> call3 = webServiceApi3.getInformaciones();
        final Call<List<WSLProfesiones>> call4 = webServiceApi4.getProfesiones();


        call1.enqueue(new Callback<List<WSLPersonas>>() {
            @Override
            public void onResponse(Call<List<WSLPersonas>> call, Response<List<WSLPersonas>> response) {
                if(response.isSuccessful()){
                    listData1 = response.body();
                    StringBuilder userInfoBuilder = new StringBuilder();
                    //Toast.makeText(WebServicesActivity.this, listDataUsers.get(0).getAddress().getCity(), Toast.LENGTH_SHORT).show();
                    userInfoBuilder.append("-------------------PERSONAS--------------------\n");

                    // Recorrer la lista de usuarios y construir la cadena con los detalles de cada usuario
                    for (WSLPersonas user : listData1) {
                        userInfoBuilder.append("---------------------------------------\n");
                        userInfoBuilder.append("ID: ").append(user.getId()).append("\n");
                        userInfoBuilder.append("Nombre: ").append(user.getNombre()).append("\n");
                        userInfoBuilder.append("Apellidos: ").append(user.getApellidos()).append("\n");
                        userInfoBuilder.append("CI: ").append(user.getCi()).append("\n");
                    }

                    // Mostrar la información en el TextView
                    textViewInfo.setText(userInfoBuilder.toString());

                    call2.enqueue(new Callback<List<WSLDirecciones>>() {
                        @Override
                        public void onResponse(Call<List<WSLDirecciones>> call, Response<List<WSLDirecciones>> response) {
                            if(response.isSuccessful()){
                                listData2 = response.body();
                                //StringBuilder userInfoBuilder = new StringBuilder();
                                //Toast.makeText(WebServicesActivity.this, listDataUsers.get(0).getAddress().getCity(), Toast.LENGTH_SHORT).show();

                                userInfoBuilder.append("-------------------DIRECCIONES-------------------\n");

                                // Recorrer la lista de usuarios y construir la cadena con los detalles de cada usuario
                                for (WSLDirecciones user : listData2) {
                                    userInfoBuilder.append("---------------------------------------\n");
                                    userInfoBuilder.append("ID: ").append(user.getId()).append("\n");
                                    userInfoBuilder.append("Calle: ").append(user.getCalle()).append("\n");
                                    userInfoBuilder.append("Numero: ").append(user.getNumero()).append("\n");
                                }

                                // Mostrar la información en el TextView
                                textViewInfo.setText(userInfoBuilder.toString());

                                call3.enqueue(new Callback<List<WSLInformaciones>>() {
                                    @Override
                                    public void onResponse(Call<List<WSLInformaciones>> call, Response<List<WSLInformaciones>> response) {
                                        if(response.isSuccessful()){

                                            listData3 = response.body();

                                            userInfoBuilder.append("-------------------INFORMACIONES--------------------\n");

                                            // Recorrer la lista de usuarios y construir la cadena con los detalles de cada usuario
                                            for (WSLInformaciones user : listData3) {
                                                userInfoBuilder.append("---------------------------------------\n");
                                                userInfoBuilder.append("ID: ").append(user.getId()).append("\n");
                                                userInfoBuilder.append("Celular: ").append(user.getCelular()).append("\n");
                                                userInfoBuilder.append("Correo: ").append(user.getCorreo()).append("\n");
                                            }

                                            // Mostrar la información en el TextView
                                            textViewInfo.setText(userInfoBuilder.toString());

                                            call4.enqueue(new Callback<List<WSLProfesiones>>() {
                                                @Override
                                                public void onResponse(Call<List<WSLProfesiones>> call, Response<List<WSLProfesiones>> response) {
                                                    if(response.isSuccessful()){

                                                        listData4 = response.body();
                                                        userInfoBuilder.append("-------------------PROFESIONES--------------------\n");

                                                        // Recorrer la lista de usuarios y construir la cadena con los detalles de cada usuario
                                                        for (WSLProfesiones user : listData4) {
                                                            userInfoBuilder.append("---------------------------------------\n");
                                                            userInfoBuilder.append("ID: ").append(user.getId()).append("\n");
                                                            userInfoBuilder.append("Carrera: ").append(user.getCarrera()).append("\n");
                                                        }

                                                        long endTime = System.currentTimeMillis();
                                                        long duration = endTime - startTime;
                                                        userInfoBuilder.append("*************************************\n");
                                                        //userInfoBuilder.append("Inicio: " + startTime + " milisegundos");
                                                        //userInfoBuilder.append("Final: " + endTime+ " milisegundos");
                                                        userInfoBuilder.append("Duración total: " + duration + " milisegundos");

                                                        // Mostrar la información en el TextView
                                                        textViewInfo.setText(userInfoBuilder.toString());

                                                    }else{
                                                        Toast.makeText(WSLabActivity.this, "Algo paso", Toast.LENGTH_SHORT).show();
                                                    }
                                                }

                                                @Override
                                                public void onFailure(Call<List<WSLProfesiones>> call, Throwable throwable) {
                                                    Toast.makeText(WSLabActivity.this, "REVISE EL SERVICIO WEB DE INTERNET", Toast.LENGTH_SHORT).show();

                                                }
                                            });
                                        }else{
                                            Toast.makeText(WSLabActivity.this, "Algo paso", Toast.LENGTH_SHORT).show();
                                        }


                                    }

                                    @Override
                                    public void onFailure(Call<List<WSLInformaciones>> call, Throwable throwable) {
                                        Toast.makeText(WSLabActivity.this, "REVISE EL SERVICIO WEB DE INTERNET", Toast.LENGTH_SHORT).show();

                                    }
                                });
                            }else{
                                Toast.makeText(WSLabActivity.this, "Algo paso", Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void onFailure(Call<List<WSLDirecciones>> call, Throwable throwable) {
                            Toast.makeText(WSLabActivity.this, "REVISE EL SERVICIO WEB DE INTERNET", Toast.LENGTH_SHORT).show();
                        }
                    });

                }else{
                    Toast.makeText(WSLabActivity.this, "Algo paso", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<WSLPersonas>> call, Throwable throwable) {

                Toast.makeText(WSLabActivity.this, "REVISE EL SERVICIO WEB DE INTERNET", Toast.LENGTH_SHORT).show();

            }
        });


    }

}