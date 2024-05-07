package com.micky.miprimeraaplicacion.backend;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WSLugares {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("0")
    @Expose
    private Integer _0;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("1")
    @Expose
    private String _1;
    @SerializedName("descripcion")
    @Expose
    private String descripcion;
    @SerializedName("2")
    @Expose
    private String _2;
    @SerializedName("latitud")
    @Expose
    private Double latitud;
    @SerializedName("3")
    @Expose
    private Double _3;
    @SerializedName("longitud")
    @Expose
    private Double longitud;
    @SerializedName("4")
    @Expose
    private Double _4;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer get0() {
        return _0;
    }

    public void set0(Integer _0) {
        this._0 = _0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String get1() {
        return _1;
    }

    public void set1(String _1) {
        this._1 = _1;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String get2() {
        return _2;
    }

    public void set2(String _2) {
        this._2 = _2;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double get3() {
        return _3;
    }

    public void set3(Double _3) {
        this._3 = _3;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Double get4() {
        return _4;
    }

    public void set4(Double _4) {
        this._4 = _4;
    }
}
