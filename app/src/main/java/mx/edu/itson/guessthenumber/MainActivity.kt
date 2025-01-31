package mx.edu.itson.guessthenumber

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var numeroAdivinar = (0..100).random()
        val numeroIngresado = findViewById<TextView>(R.id.textoNumero)
        val surrender = findViewById<Button>(R.id.btnSurrender)
        val guess = findViewById<Button>(R.id.btnGuess)
        val jugarDeNuevo = findViewById<Button>(R.id.btnPlayAgain)
        val textoGanar = findViewById<TextView>(R.id.textSuccesful)
        val textoPista = findViewById<TextView>(R.id.textHint)


        guess.setOnClickListener {
            val intIngresado = numeroIngresado.text.toString().toInt()
            if (intIngresado == numeroAdivinar) {
                textoGanar.text = "Felicidades, adivinaste el número"
            }
            else if (intIngresado < numeroAdivinar) {
                textoPista.text = "El número a adivinar es mayor"
            }
            else {
                textoPista.text = "El número a adivinar es menor"
            }

        }

        jugarDeNuevo.setOnClickListener {
            textoGanar.text = ""
            numeroIngresado.text = ""
            textoPista.text = ""
            numeroAdivinar = (0..100).random()
        }

        surrender.setOnClickListener {
            textoGanar.text = "El número a adivinar era: $numeroAdivinar"+ "\n" + "PERDEDOR!"
            numeroIngresado.text = ""
            textoPista.text = ""
            numeroAdivinar = (0..100).random()
        }
    }
}