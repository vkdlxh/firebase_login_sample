package jp.co.archivce_asia.firebaseloginsample.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import jp.co.archivce_asia.firebaseloginsample.BaseActivity
import jp.co.archivce_asia.firebaseloginsample.databinding.ActivityHomeBinding
import jp.co.archivce_asia.firebaseloginsample.ui.front.FrontActivity

class HomeActivity : BaseActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onBackPressed() {
        // Logout
        startActivity(FrontActivity.createInstance(this))
        finish()
    }

    companion object {
        fun createInstance(context: Context?): Intent = Intent(context, HomeActivity::class.java)
    }
}