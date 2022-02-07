package ncku.geomatics.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.AuthResult
import com.google.android.gms.tasks.OnCompleteListener
import android.view.View
import android.widget.*
import android.text.TextUtils

class login_interface : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_interface)

        var btn_submit = findViewById(R.id.btn_submit) as Button
        var et_user_name = findViewById(R.id.et_user_name) as EditText
        var et_password = findViewById(R.id.et_password) as EditText

        btn_submit.setOnClickListener {

            var email: String = et_user_name.text.toString()
            val password: String = et_password.text.toString()
            var mail = et_user_name.text.toString()


        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener { task ->
                if(task.isSuccessful){
                    val firebaseUser: FirebaseUser = task.result!!.user!!

                    Toast.makeText(this,"You are registered successfully",Toast.LENGTH_LONG).show()

                    var intent = Intent(this,Hello::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

                        intent.putExtra("user_id",firebaseUser.uid)
                        intent.putExtra("email_id",mail)
                        startActivity(intent)
                        finish()
                }else{
                    Toast.makeText(this,task.exception!!.message.toString(),Toast.LENGTH_LONG).show()
                }
        }

    }
    }




//    btn_submit.setOnClickListener {
//        val user_name = et_user_name.text;
//        val password = et_password.text;
//        Toast.makeText(this@MainActivity, user_name, Toast.LENGTH_LONG).show()
//
//        var intent = Intent(this,MainActivity2::class.java);
//        intent.putExtra("bundle",bundle);
//        startActivity(intent);
//
//        // your code to validate the user_name and password combination
//        // and verify the same
//
//    }

}