package com.micky.miprimeraaplicacion.backend;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class WSLInformaciones {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("0")
    @Expose
    private Integer _0;
    @SerializedName("celular")
    @Expose
    private Integer celular;
    @SerializedName("1")
    @Expose
    private Integer _1;
    @SerializedName("correo")
    @Expose
    private String correo;
    @SerializedName("2")
    @Expose
    private String _2;

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

    public Integer getCelular() {
        return celular;
    }

    public void setCelular(Integer celular) {
        this.celular = celular;
    }

    public Integer get1() {
        return _1;
    }

    public void set1(Integer _1) {
        this._1 = _1;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String get2() {
        return _2;
    }

    public void set2(String _2) {
        this._2 = _2;
    }
}
