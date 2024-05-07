package com.micky.miprimeraaplicacion.backend;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class WSLPersonas {
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
    @SerializedName("apellidos")
    @Expose
    private String apellidos;
    @SerializedName("2")
    @Expose
    private String _2;
    @SerializedName("ci")
    @Expose
    private Integer ci;
    @SerializedName("3")
    @Expose
    private Integer _3;

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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String get2() {
        return _2;
    }

    public void set2(String _2) {
        this._2 = _2;
    }

    public Integer getCi() {
        return ci;
    }

    public void setCi(Integer ci) {
        this.ci = ci;
    }

    public Integer get3() {
        return _3;
    }

    public void set3(Integer _3) {
        this._3 = _3;
    }
}
