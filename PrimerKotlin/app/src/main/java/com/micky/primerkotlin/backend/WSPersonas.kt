package com.micky.primerkotlin.backend

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class WSPersonas {
    @SerializedName("id")
    @Expose
    private var id: Int? = null

    @SerializedName("0")
    @Expose
    private var _0: Int? = null

    @SerializedName("nombre")
    @Expose
    private var nombre: String? = null

    @SerializedName("1")
    @Expose
    private var _1: String? = null

    @SerializedName("apellidos")
    @Expose
    private var apellidos: String? = null

    @SerializedName("2")
    @Expose
    private var _2: String? = null

    @SerializedName("ci")
    @Expose
    private var ci: Int? = null

    @SerializedName("3")
    @Expose
    private var _3: Int? = null

    fun getId(): Int? {
        return id
    }

    fun setId(id: Int?) {
        this.id = id
    }

    fun get0(): Int? {
        return _0
    }

    fun set0(_0: Int?) {
        this._0 = _0
    }

    fun getNombre(): String? {
        return nombre
    }

    fun setNombre(nombre: String?) {
        this.nombre = nombre
    }

    fun get1(): String? {
        return _1
    }

    fun set1(_1: String?) {
        this._1 = _1
    }

    fun getApellidos(): String? {
        return apellidos
    }

    fun setApellidos(apellidos: String?) {
        this.apellidos = apellidos
    }

    fun get2(): String? {
        return _2
    }

    fun set2(_2: String?) {
        this._2 = _2
    }

    fun getCi(): Int? {
        return ci
    }

    fun setCi(ci: Int?) {
        this.ci = ci
    }

    fun get3(): Int? {
        return _3
    }

    fun set3(_3: Int?) {
        this._3 = _3
    }
}