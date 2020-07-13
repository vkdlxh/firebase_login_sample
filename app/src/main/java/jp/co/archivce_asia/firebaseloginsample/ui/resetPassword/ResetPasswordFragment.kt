package jp.co.archivce_asia.firebaseloginsample.ui.resetPassword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import jp.co.archivce_asia.firebaseloginsample.BaseFragment
import jp.co.archivce_asia.firebaseloginsample.databinding.FragmentResetPasswordBinding
import jp.co.archivce_asia.firebaseloginsample.extension.isEmailFormat
import jp.co.archivce_asia.firebaseloginsample.extension.showSnackBar

class ResetPasswordFragment : BaseFragment<FragmentResetPasswordBinding>() {

    override fun setBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentResetPasswordBinding
            = FragmentResetPasswordBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpButtons()
    }

    private fun setUpButtons() {
        binding.backButton.setOnClickListener { parentFragmentManager.popBackStack() }
        binding.resetPasswordButton.setOnClickListener {
            checkEmailValidation(binding.emailEditText.text.toString())
        }
    }

    private fun checkEmailValidation(email: String) {
        if (email.isEmailFormat().not()) {
            showSnackBar("CHECK EMAIL FORMAT")
        } else {
            sendPasswordResetEmail(email)
        }
    }

    private fun sendPasswordResetEmail(email: String) {
        showSnackBar("SENT PASSWORD RESET EMAIL TO $email")
    }

    companion object {
        const val TAG = "RESET_PASSWORD"
    }
}