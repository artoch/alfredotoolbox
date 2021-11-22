package com.tochapps.alfredotoolbox.ui.views

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.get
import com.tochapps.alfredotoolbox.R
import com.tochapps.alfredotoolbox.databinding.ActivityMainBinding
import com.tochapps.alfredotoolbox.ui.dialog.ExitDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val exitDialog:ExitDialogFragment by lazy {
        ExitDialogFragment()
    }

    private val navController by lazy {
        findNavController(R.id.nav_host_fragment_content_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onBackPressed() {
        if (isBasedFragment()){
            if (!exitDialog.isVisible)
                exitDialog.show(supportFragmentManager, "ExitDialog")
        }else {
            super.onBackPressed()
        }
    }

    private fun isBasedFragment(): Boolean {
        return with(navController) {
            currentDestination == graph[R.id.SecondFragment]
        }
    }

}