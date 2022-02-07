package ncku.geomatics.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_password.*
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.AuthResult
import com.google.android.gms.tasks.OnCompleteListener

class password : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password)

        btn_pass.setOnClickListener {

            val user = FirebaseAuth.getInstance().currentUser
            val txtNewPass = et_1.text
            val txtNewPassS = et_1.text.toString()
            val txtNewpassS2 = et_2.text.toString()

            if(txtNewPassS == txtNewpassS2){
                user!!.updatePassword(txtNewPass.toString()).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this,"successfully",Toast.LENGTH_SHORT).show()

                        var intent = Intent(this,login_interface::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(this,"failed",Toast.LENGTH_LONG).show()
                    }
                }
            }else{
                Toast.makeText(this,"Not Equal",Toast.LENGTH_LONG).show()
            }



        }

    }
}