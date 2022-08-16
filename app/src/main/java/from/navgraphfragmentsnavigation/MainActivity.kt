package from.navgraphfragmentsnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupActionBarWithNavController

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val manager = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment

        navController = manager.navController

        val buttonOne = findViewById<Button>(R.id.button_one)
        val buttonSecond = findViewById<Button>(R.id.button_second)

        buttonOne.setOnClickListener(View.OnClickListener {
            view -> manager.findNavController().navigate(R.id.oneFragment)
        })

        buttonSecond.setOnClickListener(View.OnClickListener {
                view -> manager.findNavController().navigate(R.id.secondFragment)
        })

        // This make bottom function work
        // TODO this is not working
        setupActionBarWithNavController(navController)
    }

    /** Fragments are on created stack and when you click back you getting back one by one
     * same order as you clicked buttons, this override prevents that
     */
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}