package moreno.righetti.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    //0-> nada, 1 -> Suma, 2 -> Resta, 3 -> Multimplicacion, 4 -> dev
    var operacion: Int = 0
    var numero1:  Double = 0.0
    lateinit var  tv_num1: TextView
    lateinit var  tv_num2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_num1 = findViewById(R.id.tv_num1)
        tv_num2 = findViewById(R.id.tv_num2)
        val btnC: Button = findViewById(R.id.btnCancel)
        val btnEqual: Button = findViewById(R.id.btnEqual)

        btnEqual.setOnClickListener{
            var numero2: Double = tv_num2.text.toString().toDouble()
            var resp: Double = 0.0

            when(operacion){
                1 -> resp = numero1 + numero2
                2 -> resp = numero1 - numero2
                3 -> resp = numero1 * numero2
                4 -> resp = numero1 / numero2
            }
            tv_num2.setText(resp.toString())
            tv_num1.setText("")
        }

        btnC.setOnClickListener {
            tv_num1.setText("")
            tv_num2.setText("")
            numero1 = 0.0
            operacion = 0
        }
    }

    fun presionarDigito(view: View){
        //val tv_mun2: TextView = findViewById(R.id.tv_num2)
        var num2: String = tv_num2.text.toString()

        when(view.id){
            R.id.btn0 -> tv_num2.setText(num2 + "0")
            R.id.btn1 -> tv_num2.setText(num2 + "1")
            R.id.btn2 -> tv_num2.setText(num2 + "2")
            R.id.btn3 -> tv_num2.setText(num2 + "3")
            R.id.btn4 -> tv_num2.setText(num2 + "4")
            R.id.btn5 -> tv_num2.setText(num2 + "5")
            R.id.btn6 -> tv_num2.setText(num2 + "6")
            R.id.btn7 -> tv_num2.setText(num2 + "7")
            R.id.btn8 -> tv_num2.setText(num2 + "8")
            R.id.btn9 -> tv_num2.setText(num2 + "9")
            R.id.btnDot -> tv_num2.setText(num2 + ".")
        }
    }

    fun clicOps(view: View){
        numero1 = tv_num2.text.toString().toDouble()
        var num2_text: String = tv_num2.text.toString()
        tv_num2.setText("")
        when (view.id){
            R.id.btnSum ->{
                tv_num1.setText(num2_text + "+")
                operacion = 1
            }
            R.id.btnRest ->{
                tv_num1.setText(num2_text + "-")
                operacion = 2
            }
            R.id.btnMult ->{
                tv_num1.setText(num2_text + "*")
                operacion = 3
            }
            R.id.btnDiv ->{
                tv_num1.setText(num2_text + "/")
                operacion = 4
            }



        }
    }

}