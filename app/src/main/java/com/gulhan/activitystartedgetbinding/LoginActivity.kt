package com.gulhan.activitystartedgetbinding


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.inflate
import androidx.databinding.DataBindingUtil
import com.gulhan.activitystartedgetbinding.databinding.ActivityGetStartedBinding
import com.gulhan.activitystartedgetbinding.databinding.ActivityGetStartedBinding.inflate
import com.gulhan.activitystartedgetbinding.databinding.ActivityLoginBinding
import com.gulhan.activitystartedgetbinding.databinding.ActivityLoginBinding.inflate

class LoginActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityLoginBinding
    private lateinit var myIntent: Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        myIntent = Intent(this,SignUpActivity::class.java)
        //binding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        binding.loginbutton.setOnClickListener {
            startActivity(myIntent)
        }
    }
}