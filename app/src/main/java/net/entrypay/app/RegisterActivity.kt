package net.entrypay.app
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
class RegisterActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register) // Reemplaza con el nombre del archivo XML si es diferente

        // Referencias a los elementos del formulario
        val nombreField = findViewById<EditText>(R.id.registro_nombre)
        val correoField = findViewById<EditText>(R.id.registro_correo)
        val contraseñaField = findViewById<EditText>(R.id.registro_contraseña)
        val confirmarContraseñaField = findViewById<EditText>(R.id.editTextTextPassword2)
        val registroButton = findViewById<Button>(R.id.button)

        // Validación de los campos al hacer clic en el botón de registro
        registroButton.setOnClickListener {
            val nombre = nombreField.text.toString().trim()
            val correo = correoField.text.toString().trim()
            val contraseña = contraseñaField.text.toString().trim()
            val confirmarContraseña = confirmarContraseñaField.text.toString().trim()

            // Verificar que todos los campos estén llenos
            if (nombre.isEmpty()) {
                nombreField.error = "El campo nombre no puede estar vacío"
                return@setOnClickListener
            }
            if (correo.isEmpty()) {
                correoField.error = "El campo correo no puede estar vacío"
                return@setOnClickListener
            }
            if (contraseña.isEmpty()) {
                contraseñaField.error = "El campo contraseña no puede estar vacío"
                return@setOnClickListener
            }
            if (confirmarContraseña.isEmpty()) {
                confirmarContraseñaField.error = "El campo confirmar contraseña no puede estar vacío"
                return@setOnClickListener
            }

            // Validar que las contraseñas coincidan
            if (contraseña != confirmarContraseña) {
                confirmarContraseñaField.error = "Las contraseñas no coinciden"
                return@setOnClickListener
            }

            // Si todo está correcto, mostrar un mensaje de éxito
            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()

            // Aquí puedes realizar la acción correspondiente, como guardar los datos o redirigir a otra pantalla
        }
    }
}