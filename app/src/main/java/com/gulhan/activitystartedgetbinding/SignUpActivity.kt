package com.gulhan.activitystartedgetbinding


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.gulhan.activitystartedgetbinding.databinding.ActivityLoginBinding
import com.gulhan.activitystartedgetbinding.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding


    private lateinit var myIntent: Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        myIntent = Intent(this, GetStartedActivity::class.java)
        // binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
        binding.signupbutton.setOnClickListener {
            startActivity(myIntent)
        }
    }
}

