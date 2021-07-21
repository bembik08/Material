package geekbrains.material.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import geekbrains.material.R
import geekbrains.material.ui.picture.ApodFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ApodFragment.newInstance())
                .commitNow()
        }
    }
}
