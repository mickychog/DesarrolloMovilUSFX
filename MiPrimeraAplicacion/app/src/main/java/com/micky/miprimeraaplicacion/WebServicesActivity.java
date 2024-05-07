package com.micky.miprimeraaplicacion;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.micky.miprimeraaplicacion.backend.WSAlbums;
import com.micky.miprimeraaplicacion.backend.WSPhotos;
import com.micky.miprimeraaplicacion.backend.WSUsers;
import com.micky.miprimeraaplicacion.backend.WebServiceAPI;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WebServicesActivity extends AppCompatActivity {
    private TextView textViewUserInfo;
    private TextView textViewPhotosInfo;

    private ImageView imageView;
    List<WSAlbums> listData = new ArrayList<>();
    List<WSUsers> listDataUsers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_web_services);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textViewUserInfo = findViewById(R.id.textViewUserInfo);
        imageView = findViewById(R.id.imageView);
        // textViewPhotosInfo= findViewById(R.id.textViewPhotosInfo);
        //getData();
        getDataUsers();
        getDataphotos();
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
                    Toast.makeText(WebServicesActivity.this, listData.get(0).getTitle(), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(WebServicesActivity.this, "Algo paso", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<WSAlbums>> call, Throwable throwable) {
                Toast.makeText(WebServicesActivity.this, "REVISE EL SERVICIO WEB DE INTERNET", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getDataUsers(){
        String URL_WS = "https://jsonplaceholder.typicode.com/";
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_WS)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WebServiceAPI webServiceApi = retrofit.create(WebServiceAPI.class);
        final Call<List<WSUsers>> call = webServiceApi.getUsers();
        call.enqueue(new Callback<List<WSUsers>>() {
            @Override
            public void onResponse(Call<List<WSUsers>> call, Response<List<WSUsers>> response) {
                if(response.isSuccessful()){
                    listDataUsers = response.body();
                    StringBuilder userInfoBuilder = new StringBuilder();
                    //Toast.makeText(WebServicesActivity.this, listDataUsers.get(0).getAddress().getCity(), Toast.LENGTH_SHORT).show();

                    // Recorrer la lista de usuarios y construir la cadena con los detalles de cada usuario
                    for (WSUsers user : listDataUsers) {
                        userInfoBuilder.append("---------------------------------------\n");
                        userInfoBuilder.append("ID: ").append(user.getId()).append("\n");
                        userInfoBuilder.append("Name: ").append(user.getName()).append("\n");
                        userInfoBuilder.append("Username: ").append(user.getUsername()).append("\n");
                        userInfoBuilder.append("Email: ").append(user.getEmail()).append("\n");
                        userInfoBuilder.append("Phone: ").append(user.getPhone()).append("\n");
                        userInfoBuilder.append("Website: ").append(user.getWebsite()).append("\n");
                        userInfoBuilder.append("Address: ").append("\n");
                        userInfoBuilder.append("   Street: ").append(user.getAddress().getStreet()).append("\n");
                        userInfoBuilder.append("   Suite: ").append(user.getAddress().getSuite()).append("\n");
                        userInfoBuilder.append("   City: ").append(user.getAddress().getCity()).append("\n");
                        userInfoBuilder.append("   Zipcode: ").append(user.getAddress().getZipcode()).append("\n");
                        userInfoBuilder.append("   Geo: ").append("\n");
                        userInfoBuilder.append("       Lat: ").append(user.getAddress().getGeo().getLat()).append("\n");
                        userInfoBuilder.append("       Lng: ").append(user.getAddress().getGeo().getLng()).append("\n");
                        userInfoBuilder.append("Company: ").append("\n");
                        userInfoBuilder.append("   Name: ").append(user.getCompany().getName()).append("\n");
                        userInfoBuilder.append("   Catch Phrase: ").append(user.getCompany().getCatchPhrase()).append("\n");
                        userInfoBuilder.append("   Bs: ").append(user.getCompany().getBs()).append("\n\n");
                    }

                    // Mostrar la información en el TextView
                    textViewUserInfo.setText(userInfoBuilder.toString());
                }else{
                    Toast.makeText(WebServicesActivity.this, "Algo paso", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<WSUsers>> call, Throwable throwable) {
                Toast.makeText(WebServicesActivity.this, "REVISE EL SERVICIO WEB DE INTERNET", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getDataphotos(){
        String URL_WS = "https://jsonplaceholder.typicode.com/";
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_WS)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WebServiceAPI webServiceApi = retrofit.create(WebServiceAPI.class);
        final Call<List<WSPhotos>> call = webServiceApi.getPhotos();

        call.enqueue(new Callback<List<WSPhotos>>() {
            @Override
            public void onResponse(Call<List<WSPhotos>> call, Response<List<WSPhotos>> response) {
                if (response.isSuccessful()) {
                    List<WSPhotos> listDataPhotos = response.body();
                    if (listDataPhotos != null && !listDataPhotos.isEmpty()) {
                        WSPhotos photo = listDataPhotos.get(10); // Obtener la foto en la posición 0
                        String photoUrl = photo.getUrl(); // Obtener la URL de la foto

                        // Cargar la imagen de la URL en un ImageView usando Picasso
                        Picasso.get().load(photoUrl).into(imageView);
                        // Cambia "imageView" por el ID de tu ImageView
                    } else {
                        Toast.makeText(WebServicesActivity.this, "La lista de fotos está vacía", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(WebServicesActivity.this, "Algo pasó", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<WSPhotos>> call, Throwable throwable) {
                Toast.makeText(WebServicesActivity.this, "REVISE EL SERVICIO WEB DE INTERNET", Toast.LENGTH_SHORT).show();
            }
        });

    }
}