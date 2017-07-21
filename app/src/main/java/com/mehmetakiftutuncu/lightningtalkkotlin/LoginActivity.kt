package com.mehmetakiftutuncu.lightningtalkkotlin

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.usernameView
import kotlinx.android.synthetic.main.activity_login.passwordView
import kotlinx.android.synthetic.main.activity_login.loginButton

class LoginActivity : AppCompatActivity() {
    private val dummyCredentials = listOf(User("akif","test"))

    private var authTask: UserLoginTask? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginButton.setOnClickListener {
            attemptLogin()
        }
    }

    private fun attemptLogin() {
        if (authTask != null) {
            return
        }

        usernameView.error = null
        passwordView.error = null

        val (cancel, focusView) = if (usernameView.text.isNullOrEmpty()) {
            usernameView.error = getString(R.string.error_invalid_username)
            true to usernameView
        } else if (passwordView.text.isNullOrEmpty()) {
            passwordView.error = getString(R.string.error_invalid_password)
            true to passwordView
        } else {
            false to null
        }

        if (cancel) {
            focusView?.requestFocus()
        } else {
            val user = (usernameView.text.toString() to passwordView.text.toString()).toUser()

            authTask = UserLoginTask(user)
            authTask?.execute(null)
        }
    }

    inner class UserLoginTask(private val user: User) : AsyncTask<Void, Void, Boolean>() {
        override fun doInBackground(vararg params: Void) = dummyCredentials.contains(user)

        override fun onPostExecute(success: Boolean) {
            authTask = null

            if (success) {
                startActivity(Intent(this@LoginActivity, NotesActivity::class.java))
                finish()
            } else {
                Toast.makeText(this@LoginActivity, getString(R.string.error_login_failed), Toast.LENGTH_LONG).show()
            }
        }

        override fun onCancelled() {
            authTask = null
        }
    }
}
