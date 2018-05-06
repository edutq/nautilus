package alonso.nautilus

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.speech.RecognizerIntent
import android.view.View
import java.util.*
import android.widget.SearchView
import kotlinx.android.synthetic.*
import android.widget.TextView
import android.view.ViewGroup
import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.view.LayoutInflater
import android.widget.BaseAdapter



class Rutas_inicio : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rutas_inicio)
    }

    fun getSpeechInput(view: View) {

        val intent = Intent( RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale("es", "MEX"))


        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, 10)
        }
        else {


        }

    }

    override fun onActivityResult(requestCode : Int, resultCode : Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            10 -> if (resultCode == RESULT_OK && data != null) {
                val barra = findViewById<SearchView>(R.id.barra_busqueda)
                barra.setQuery(data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)[0], false)

            }

        }




    }
}
