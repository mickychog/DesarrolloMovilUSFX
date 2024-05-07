package com.micky.miprimeraaplicacion.backend;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface WebServiceAPI {
    @GET("albums")
    Call<List<WSAlbums>>getAlbums();
    @GET("users")
    Call<List<WSUsers>>getUsers();

    @GET("photos")
    Call<List<WSPhotos>>getPhotos();

    @GET("lugares")
    Call<List<WSLugares>>getLugares();

    @GET("personas")
    Call<List<WSLPersonas>>getPersonas();
    @GET("informaciones")
    Call<List<WSLInformaciones>>getInformaciones();
    @GET("direcciones")
    Call<List<WSLDirecciones>>getDirecciones();
    @GET("profesiones")
    Call<List<WSLProfesiones>>getProfesiones();
}
