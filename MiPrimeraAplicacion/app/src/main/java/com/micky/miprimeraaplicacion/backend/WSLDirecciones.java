package com.micky.miprimeraaplicacion.backend;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class WSLDirecciones {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("0")
    @Expose
    private Integer _0;
    @SerializedName("calle")
    @Expose
    private String calle;
    @SerializedName("1")
    @Expose
    private String _1;
    @SerializedName("numero")
    @Expose
    private Integer numero;
    @SerializedName("2")
    @Expose
    private Integer _2;

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

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String get1() {
        return _1;
    }

    public void set1(String _1) {
        this._1 = _1;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer get2() {
        return _2;
    }

    public void set2(Integer _2) {
        this._2 = _2;
    }
}
