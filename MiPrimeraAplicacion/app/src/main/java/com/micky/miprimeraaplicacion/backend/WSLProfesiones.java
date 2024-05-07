package com.micky.miprimeraaplicacion.backend;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class WSLProfesiones {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("0")
    @Expose
    private Integer _0;
    @SerializedName("carrera")
    @Expose
    private String carrera;
    @SerializedName("1")
    @Expose
    private String _1;

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

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String get1() {
        return _1;
    }

    public void set1(String _1) {
        this._1 = _1;
    }

}
