package com.micky.primerkotlin.backend

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class WSInformaciones {
    @SerializedName("id")
    @Expose
    private var id: Int? = null

    @SerializedName("0")
    @Expose
    private var _0: Int? = null

    @SerializedName("celular")
    @Expose
    private var celular: Int? = null

    @SerializedName("1")
    @Expose
    private var _1: Int? = null

    @SerializedName("correo")
    @Expose
    private var correo: String? = null

    @SerializedName("2")
    @Expose
    private var _2: String? = null

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

    fun getCelular(): Int? {
        return celular
    }

    fun setCelular(celular: Int?) {
        this.celular = celular
    }

    fun get1(): Int? {
        return _1
    }

    fun set1(_1: Int?) {
        this._1 = _1
    }

    fun getCorreo(): String? {
        return correo
    }

    fun setCorreo(correo: String?) {
        this.correo = correo
    }

    fun get2(): String? {
        return _2
    }

    fun set2(_2: String?) {
        this._2 = _2
    }
}