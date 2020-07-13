package jp.co.archivce_asia.firebaseloginsample.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import jp.co.archivce_asia.firebaseloginsample.BaseFragment
import jp.co.archivce_asia.firebaseloginsample.R
import jp.co.archivce_asia.firebaseloginsample.databinding.FragmentLoginBinding
import jp.co.archivce_asia.firebaseloginsample.extension.isEmailFormat
import jp.co.archivce_asia.firebaseloginsample.extension.showSnackBar
import jp.co.archivce_asia.firebaseloginsample.ui.home.HomeActivity
import jp.co.archivce_asia.firebaseloginsample.ui.resetPassword.ResetPasswordFragment
import jp.co.archivce_asia.firebaseloginsample.ui.signUp.SignUpFragment

class LoginFragment: BaseFragment<FragmentLoginBinding>() {

    override fun setBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentLoginBinding
            = FragmentLoginBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpButtons()
    }

    private fun setUpButtons() {
        binding.loginButton.setOnClickListener {
            checkLoginValidation(
                binding.emailEditText.text.toString(),
                binding.passwordEditText.text.toString()
            )
        }
        binding.signUpButton.setOnClickListener { navigateToSignUp() }
        binding.resetPasswordButton.setOnClickListener { navigateToResetPassword() }
    }

    private fun checkLoginValidation(email: String, password: String) {
        if (email.isEmailFormat().not()) {
            showSnackBar("PLEASE CHECK EMAIL")
        } else if (password.length < MIN_PASSWORD_LENGTH) {
            showSnackBar("PLEASE CHECK PASSWORD")
        } else {
            login(email, password)
        }
    }

    private fun login(email: String, password: String) {
        navigateToHome()
    }

    private fun navigateToHome() {
        startActivity(HomeActivity.createInstance(context))
        activity?.finish()
    }

    private fun navigateToSignUp() {
        parentFragmentManager.beginTransaction()
            .addToBackStack(SignUpFragment.TAG)
            .replace(R.id.container, SignUpFragment(), SignUpFragment.TAG)
            .commit()
    }

    private fun navigateToResetPassword() {
        parentFragmentManager.beginTransaction()
            .addToBackStack(ResetPasswordFragment.TAG)
            .replace(R.id.container, ResetPasswordFragment(), ResetPasswordFragment.TAG)
            .commit()
    }

    companion object {
        const val TAG = "LOGIN"
        private const val MIN_PASSWORD_LENGTH = 6
    }
}