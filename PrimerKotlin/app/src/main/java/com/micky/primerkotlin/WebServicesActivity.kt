package com.micky.primerkotlin

//import java.util.function.Function;

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.gson.GsonBuilder
import com.micky.primerkotlin.backend.WSDirecciones
import com.micky.primerkotlin.backend.WSInformaciones
import com.micky.primerkotlin.backend.WSPersonas
import com.micky.primerkotlin.backend.WSProfesiones
import com.micky.primerkotlin.backend.WebServiceAPI
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class WebServicesActivity : AppCompatActivity() {
    private val textViewUserInfo: TextView? = null
    private val textViewPhotosInfo: TextView? = null

    private val imageView: ImageView? = null
    private val textViewResultado:     TextView? = null

    var buttonTiendaOnline2: Button? = null
    var listaPersonas: List<WSPersonas> = java.util.ArrayList<WSPersonas>()
    var listaProfesiones: List<WSProfesiones> = java.util.ArrayList<WSProfesiones>()
    var listaInformaciones: List<WSInformaciones> = java.util.ArrayList<WSInformaciones>()
    var listaDirecciones: List<WSDirecciones> = java.util.ArrayList<WSDirecciones>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_web_services)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        getPersonas()
    }

    fun getPersonas() {
        val URL_WS = "http://192.168.0.1/webservice/    "
        val gson = GsonBuilder().setLenient().create()

        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val retrofit2 = Retrofit.Builder()
            .baseUrl(URL_WS)
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        val webServiceApi: WebServiceAPI = retrofit2.create(WebServiceAPI::class.java)
        val requests: MutableList<Observable<*>> = ArrayList()


        requests.add(webServiceApi.getPersonasObservable())
        requests.add(webServiceApi.getProfesionesObservable())
        requests.add(webServiceApi.getInformacionesObservable())
        requests.add(webServiceApi.getDireccionesObservable())

        val obs: Disposable = Observable.zip<Any, Any>(
            requests
        ) { objects ->
            listaPersonas = objects[0] as List<WSPersonas>
            listaProfesiones = objects[1] as List<WSProfesiones>
            listaDirecciones = objects[2] as List<WSDirecciones>
            listaInformaciones = objects[3] as List<WSInformaciones>
            Any()
        }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<Any?>() {
                override fun onNext(o: Any) {
                    // Método requerido pero no necesitamos hacer nada aquí
                }

                override fun onError(e: Throwable) {
                    Log.d("Datos", "OnError ")
                }

                override fun onComplete() {
                    Log.d("Datos", "Finalizado con éxito onComplete ")

                    val persona: WSPersonas = listaPersonas.get(2)
                    val profesion: WSProfesiones = listaProfesiones.get(2)
                    val informacion: WSInformaciones = listaInformaciones.get(2)
                    val direccion: WSDirecciones = listaDirecciones.get(2)

                    val dato = StringBuilder()
                    dato.append("PERSONA: \n")
                    dato.append("ID: ").append(persona.getId()).append("\n")
                    dato.append("Nombre: ").append(persona.getNombre()).append("\n")
                    dato.append("Edad: ").append(persona.getApellidos()).append("\n")
                    dato.append("Email: ").append(persona.getCi()).append("\n")

                    dato.append("PROFESION: \n")
                    dato.append("ID: ").append(profesion.getId()).append("\n")
                    dato.append("Carrera: ").append(profesion.getCarrera()).append("\n")

                    dato.append("INFORMACION: \n")
                    dato.append("ID: ").append(informacion.getId()).append("\n")
                    dato.append("Correo: ").append(informacion.getCorreo()).append("\n")
                    dato.append("Celular: ").append(informacion.getCelular()).append("\n")
                        .append("\n\n")

                    dato.append("DIRECCION: \n")
                    dato.append("ID: ").append(direccion.getId()).append("\n")
                    dato.append("Calle: ").append(direccion.getCalle()).append("\n")
                    dato.append("Numero: ").append(direccion.getNumero()).append("\n")

                    textViewResultado?.setText(dato.toString())
                }
            })
    }


}