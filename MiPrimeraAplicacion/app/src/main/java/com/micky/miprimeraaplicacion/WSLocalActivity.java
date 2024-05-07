package com.micky.miprimeraaplicacion;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.micky.miprimeraaplicacion.backend.WSLugares;
import com.micky.miprimeraaplicacion.backend.WebServiceAPI;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WSLocalActivity extends AppCompatActivity {
    private TextView textViewInfo;
    List<WSLugares> listData = new ArrayList<WSLugares>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_wslocal);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        textViewInfo = findViewById(R.id.textViewInfo);

        getDataLugares();
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
                    Toast.makeText(WSLocalActivity.this, "Algo paso", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<WSLugares>> call, Throwable throwable) {

                Toast.makeText(WSLocalActivity.this, "REVISE EL SERVICIO WEB DE INTERNET", Toast.LENGTH_SHORT).show();

            }
        });

    }
}