package moreno.righetti.contador

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast



class MainActivity : AppCompatActivity() {

    var cuenta = 0
    lateinit var txtCounter: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        txtCounter = findViewById(R.id.txtCounter)
        val btnMas: ImageButton = findViewById(R.id.btnAdd)
        val btnMenos: ImageButton = findViewById(R.id.btnRest)
        val btnReset: ImageButton =findViewById(R.id.btnReset)

        btnMas.setOnClickListener{
            cuenta++
            txtCounter.setText("$cuenta")
        }

        btnMenos.setOnClickListener{
            cuenta--
            txtCounter.setText("$cuenta")
            if (cuenta < 0 ){
                txtCounter.setText("0")
                cuenta = 0
            }
        }

        btnReset.setOnClickListener{
            cuenta = 0
            txtCounter.setText("$cuenta")
        }
    }

    override fun onPause() {
        super.onPause()

        val sharedPref = this?.getPreferences(Context.MODE_PRIVATE)
        val editor = sharedPref?.edit()
        editor?.putInt("contador",cuenta)
        editor?.apply()
    }

    override fun onStart() {
        super.onStart()

        val sharedPref = this?.getPreferences(Context.MODE_PRIVATE)?: return
        val contador = sharedPref.getInt("contador", 0)
        cuenta = contador
        txtCounter.setText("$contador")
    }

}