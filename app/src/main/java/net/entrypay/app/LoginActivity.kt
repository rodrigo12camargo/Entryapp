package net.entrypay.app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
//Falta el diseño del toast
import android.widget.Toast
import androidx.activity.ComponentActivity

class LoginActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Referencias a los campos y botón
        val emailField = findViewById<EditText>(R.id.correo_login)
        val passwordField = findViewById<EditText>(R.id.password_login)
        val loginButton = findViewById<Button>(R.id.button_login)

        loginButton.setOnClickListener {
            val email = emailField.text.toString().trim()
            val password = passwordField.text.toString().trim()

            // Validar que los campos no estén vacíos

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Validar credenciales
            if (email == "correo@correo.com" && password == "123") {
                // Redirigir al MainActivity con Jetpack Compose
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish() // Finalizar LoginActivity
            } else {
                Toast.makeText(this, "Correo o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
