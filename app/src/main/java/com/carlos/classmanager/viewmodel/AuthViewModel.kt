//package com.carlos.classmanager.viewmodel
//
//import android.app.Activity
//import android.content.Context
//import android.content.Intent
//import android.content.SharedPreferences
//import android.widget.Toast
//import androidx.activity.result.contract.ActivityResultContracts
//import androidx.core.content.ContextCompat.startActivity
//import androidx.lifecycle.ViewModel
//import com.carlos.classmanager.R
//import com.carlos.classmanager.ui.Home
//import com.google.android.gms.auth.api.signin.GoogleSignIn
//import com.google.android.gms.auth.api.signin.GoogleSignInAccount
//import com.google.android.gms.auth.api.signin.GoogleSignInClient
//import com.google.android.gms.auth.api.signin.GoogleSignInOptions
//import com.google.android.gms.tasks.Task
//import com.google.firebase.auth.FirebaseAuth
//import com.google.firebase.auth.GoogleAuthProvider
//
//
//class AuthViewModel(): ViewModel() {
//
//    private lateinit var googleSignInClient: GoogleSignInClient
//    private lateinit var auth: FirebaseAuth
//
//    init {
//        googleSignIn()
//        authAllReadyOn()
//    }
//
//    private fun googleSignIn() {
//        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//            .requestIdToken(getString(R.string.web_client_id))
//            .requestEmail()
//            .build()
//
//        googleSignInClient = GoogleSignIn.getClient(context, gso)
//    }
//
//    fun signInGoogle() {
//        val signIntent = googleSignInClient.signInIntent
//        launcher.launch(signIntent)
//    }
//
//    private val launcher =
//        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
//            if (result.resultCode == Activity.RESULT_OK) {
//                val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
//                handlerResult(task)
//            }
//
//
//        }
//
//    private fun handlerResult(task: Task<GoogleSignInAccount>) {
//        if (task.isSuccessful) {
//            val account: GoogleSignInAccount? = task.result
//            if (account != null) {
//                updateUI(account)
//
//            }
//        } else {
//            Toast.makeText(context, task.exception.toString(), Toast.LENGTH_SHORT).show()
//        }
//    }
//
//    private fun updateUI(account: GoogleSignInAccount) {
//        val credential = GoogleAuthProvider.getCredential(account.idToken, null)
//        auth.signInWithCredential(credential).addOnCompleteListener {
//            if (it.isSuccessful) {
//                val intent = Intent(context, Home::class.java)
//                val name = account.displayName
//                val email = account.email
//                val photoUrl = account.photoUrl
//
//                val sharedPreferences: SharedPreferences = getSharedPreferences("sharedAccountInfo", Context.MODE_PRIVATE)
//                val editor = sharedPreferences.edit()
//                editor.apply {
//                    putString("NameInfo", name)
//                    putString("photoUrl", photoUrl.toString())
//                    putString("EmailInfo", email)
//                }.apply()
//
//                startActivity(intent)
//            } else {
//                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
//
//    private fun authAllReadyOn() {
//        if (auth.currentUser != null) {
//            val intent = Intent(context, Home::class.java)
//
//            startActivity(intent)
//
//        }
//    }
//}