package jp.co.archivce_asia.firebaseloginsample.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import jp.co.archivce_asia.firebaseloginsample.BaseActivity
import jp.co.archivce_asia.firebaseloginsample.databinding.ActivityHomeBinding
import jp.co.archivce_asia.firebaseloginsample.ui.front.FrontActivity
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : BaseActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val auth by lazy { FirebaseAuth.getInstance() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = FirebaseFirestore.getInstance()

        val fireBaseLoginSample = hashMapOf(
            "textUserEmail" to "2222@111.com",
            "textUserName" to "jeon"
        )

        // 데이터 추가
        db.collection("fireBaseLoginSample")
            .add(fireBaseLoginSample)
            .addOnSuccessListener {
                binding.textUserEmail.text.toString()
                binding.textUserName.text.toString()
            }
            .addOnFailureListener {

            }

        // 데이터 읽기
        db.collection("fireBaseLoginSample")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {

                }
            }
            .addOnFailureListener {

            }

    }

    override fun onBackPressed() {
        // TODO: Logout
        auth.signOut()
        navigateToFront()
    }

    private fun navigateToFront() {
        startActivity(FrontActivity.createInstance(this))
        finish()
    }

    companion object {
        fun createInstance(context: Context?): Intent = Intent(context, HomeActivity::class.java)
    }
}