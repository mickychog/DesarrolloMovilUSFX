package com.micky.primerkotlin.backend

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
class WSDirecciones {
    @com.google.gson.annotations.SerializedName("id")
    @com.google.gson.annotations.Expose
    private var id: Int? = null

    @com.google.gson.annotations.SerializedName("0")
    @com.google.gson.annotations.Expose
    private var _0: Int? = null

    @com.google.gson.annotations.SerializedName("calle")
    @com.google.gson.annotations.Expose
    private var calle: String? = null

    @com.google.gson.annotations.SerializedName("1")
    @com.google.gson.annotations.Expose
    private var _1: String? = null

    @com.google.gson.annotations.SerializedName("numero")
    @com.google.gson.annotations.Expose
    private var numero: Int? = null

    @com.google.gson.annotations.SerializedName("2")
    @com.google.gson.annotations.Expose
    private var _2: Int? = null

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

    fun getCalle(): String? {
        return calle
    }

    fun setCalle(calle: String?) {
        this.calle = calle
    }

    fun get1(): String? {
        return _1
    }

    fun set1(_1: String?) {
        this._1 = _1
    }

    fun getNumero(): Int? {
        return numero
    }

    fun setNumero(numero: Int?) {
        this.numero = numero
    }

    fun get2(): Int? {
        return _2
    }

    fun set2(_2: Int?) {
        this._2 = _2
    }
}