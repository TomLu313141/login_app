package ncku.geomatics.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.AuthResult
import com.google.android.gms.tasks.OnCompleteListener
import kotlinx.android.synthetic.main.activity_hello.*

class Hello : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello)

        val bundle: Bundle? = intent.extras
        val msg = bundle!!.getString("email_id")
        val userId = intent.getStringExtra("user_id")
        val emailId = intent.getStringExtra("email_Id")
        tv.text = "User:: $msg"

        btn.setOnClickListener {

            var intent = Intent(this,password::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//        intent.putExtra("user_id",userId)
//        intent.putExtra("email_id",emailId)
            startActivity(intent)
            finish()

        }
    }


}
