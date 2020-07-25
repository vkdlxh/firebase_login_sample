package jp.co.archivce_asia.firebaseloginsample.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import jp.co.archivce_asia.firebaseloginsample.databinding.ActivitySplashBinding
import jp.co.archivce_asia.firebaseloginsample.extension.showSnackBar
import jp.co.archivce_asia.firebaseloginsample.ui.front.FrontActivity
import jp.co.archivce_asia.firebaseloginsample.ui.home.HomeActivity


class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val homeActivity = Intent(this, HomeActivity::class.java)
        val frontActivity = Intent(this, FrontActivity::class.java)

        // 로그인 중이면 -> 바로 Home Activity, 로그인 중 아니면 -> Front Activity
        val user = FirebaseAuth.getInstance().currentUser
        if (user != null) {
            startActivity(homeActivity)
            finish()
        } else {
            startActivity(frontActivity)
            finish()
        }
    }
}