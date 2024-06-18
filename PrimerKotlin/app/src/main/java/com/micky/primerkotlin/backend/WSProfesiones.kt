package com.micky.primerkotlin.backend

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class WSProfesiones {
    @SerializedName("id")
    @Expose
    private var id: Int? = null

    @SerializedName("0")
    @Expose
    private var _0: Int? = null

    @SerializedName("carrera")
    @Expose
    private var carrera: String? = null

    @SerializedName("1")
    @Expose
    private var _1: String? = null

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

    fun getCarrera(): String? {
        return carrera
    }

    fun setCarrera(carrera: String?) {
        this.carrera = carrera
    }

    fun get1(): String? {
        return _1
    }

    fun set1(_1: String?) {
        this._1 = _1
    }
}