package jp.co.archivce_asia.firebaseloginsample.ui.signUp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.auth.FirebaseAuth
import jp.co.archivce_asia.firebaseloginsample.BaseFragment
import jp.co.archivce_asia.firebaseloginsample.databinding.FragmentSignUpBinding
import jp.co.archivce_asia.firebaseloginsample.extension.isEmailFormat
import jp.co.archivce_asia.firebaseloginsample.extension.showSnackBar
import jp.co.archivce_asia.firebaseloginsample.ui.home.HomeActivity

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
        } else if (name.isEmpty()) {
            showSnackBar("PLEASE CHECK NAME")
        } else {
            signUp(email, password, name)
        }
    }

    private fun signUp(email: String, password: String, name: String) {
        FirebaseAuth
            .getInstance()
            .createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    navigateToHome()
                } else {
                    showSnackBar(task.exception?.localizedMessage ?: "Error")
                }
            }

//        FirebaseAuth
//            .getInstance()
//            .createUserWithEmailAndPassword(email, password)
//            .addOnSuccessListener {
//                navigateToHome()
//            }.addOnFailureListener {
//                showSnackBar(it.localizedMessage ?: "Error")
//            }
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