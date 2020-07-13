package co.jp.archivce_asia.firebaseloginsample.ui.signUp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.jp.archivce_asia.firebaseloginsample.BaseFragment
import co.jp.archivce_asia.firebaseloginsample.databinding.FragmentSignUpBinding
import co.jp.archivce_asia.firebaseloginsample.extension.isEmailFormat
import co.jp.archivce_asia.firebaseloginsample.extension.showSnackBar
import co.jp.archivce_asia.firebaseloginsample.ui.home.HomeActivity

class SignUpFragment : BaseFragment<FragmentSignUpBinding>() {

    override fun setBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentSignUpBinding
            = FragmentSignUpBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpButtons()
    }

    private fun setUpButtons() {
        binding.backButton.setOnClickListener { parentFragmentManager.popBackStack() }
        binding.signUpButton.setOnClickListener {
            checkSignUpValidation(
                binding.emailEditText.text.toString(),
                binding.passwordEditText.text.toString(),
                binding.nameEditText.text.toString()
            )
        }
    }

    private fun checkSignUpValidation(email: String, password: String, name: String) {
        if (email.isEmailFormat().not()) {
            showSnackBar("PLEASE CHECK EMAIL")
        } else if (password.length < MIN_PASSWORD_LENGTH) {
            showSnackBar("PLEASE CHECK PASSWORD")
        } else if (name.isEmpty()){
            showSnackBar("PLEASE CHECK NAME")
        } else {
            signUp(email, password, name)
        }
    }

    private fun signUp(email: String, password: String, name: String) {
        navigateToHome()
    }

    private fun navigateToHome() {
        startActivity(HomeActivity.createInstance(context))
        activity?.finish()
    }

    companion object {
        const val TAG = "SIGN_UP"
        private const val MIN_PASSWORD_LENGTH = 6
    }
}