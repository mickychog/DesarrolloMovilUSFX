package com.micky.primerkotlin.backend

import io.reactivex.Observable

import retrofit2.Call
import retrofit2.http.GET

interface WebServiceAPI {
    @GET("personas.php")
    fun getPersonasObservable(): Observable<List<WSPersonas>>
    @GET("informaciones.php")
    fun getInformacionesObservable(): Observable<List<WSInformaciones>>
    @GET("direcciones.php")
    fun getDireccionesObservable(): Observable<List<WSDirecciones>>
    @GET("profesiones.php")
    fun getProfesionesObservable(): Observable<List<WSProfesiones>>
}