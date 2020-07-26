package jp.co.archivce_asia.firebaseloginsample.ui.front

import android.content.Context
import android.content.Intent
import android.os.Bundle
import jp.co.archivce_asia.firebaseloginsample.BaseActivity
import jp.co.archivce_asia.firebaseloginsample.R
import jp.co.archivce_asia.firebaseloginsample.databinding.ActivityFrontBinding
import jp.co.archivce_asia.firebaseloginsample.ui.login.LoginFragment

class
FrontActivity : BaseActivity() {

    private lateinit var binding: ActivityFrontBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFrontBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            navigateToLogin()
        }
    }

    private fun navigateToLogin() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, LoginFragment(), LoginFragment.TAG)
            .commit()
    }

    companion object {
        fun createInstance(context: Context?): Intent = Intent(context, FrontActivity::class.java)
    }
}
