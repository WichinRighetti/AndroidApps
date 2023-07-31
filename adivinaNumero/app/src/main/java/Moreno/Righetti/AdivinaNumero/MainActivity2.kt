package Moreno.Righetti.AdivinaNumero


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random
import kotlin.random.nextInt


class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val campo_numero: EditText = findViewById(R.id.campoNumero)
        val buttonAdivina: Button = findViewById(R.id.buttonAdivina)
        var intentos: Int = 0
        val tv_intentos: TextView = findViewById(R.id.textIntento)
        var num_alt: Int = Random.nextInt(100)

        buttonAdivina.setOnClickListener{

          var num_ad: Int = campo_numero.text.toString().toInt()

            if(num_ad == num_alt){
                Toast.makeText(this,"CORRECTO EL NUMERO ERA $num_alt", Toast.LENGTH_LONG).show()
            }
            if(num_ad < num_alt){
                Toast.makeText(this,"DAME UN NUMERO MAYOR", Toast.LENGTH_LONG).show()
            }
            if(num_ad > num_alt){
                Toast.makeText(this,"DAME UN NUMERO MENOR", Toast.LENGTH_LONG).show()
            }
            intentos++
            tv_intentos.text = "Llevas $intentos intentos"
        }
    }
}