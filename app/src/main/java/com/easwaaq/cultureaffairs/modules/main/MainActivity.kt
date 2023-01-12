package com.easwaaq.cultureaffairs.modules.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.viewinterop.AndroidViewBinding
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.easwaaq.cultureaffairs.R
import com.easwaaq.cultureaffairs.databinding.ContentMainBinding
import com.easwaaq.cultureaffairs.ui.theme.CultureAffairsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CultureAffairsTheme {
                AndroidViewBinding(ContentMainBinding::inflate)
            }
        }

        findNavController()
    }


    /**
     * See https://issuetracker.google.com/142847973
     */
    private fun findNavController(): NavController? {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as? NavHostFragment
        return navHostFragment?.navController
    }

}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    setView()
//}