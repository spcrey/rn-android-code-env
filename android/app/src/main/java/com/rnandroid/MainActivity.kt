package com.rnandroid

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.facebook.react.ReactActivity
import com.facebook.react.ReactFragment

class MainActivity : ReactActivity() {

    companion object {
        const val TAG = "MainActivity"
    }

    val btnToReactActivity: Button by lazy {
        findViewById<Button>(R.id.btn_to_main_react_activity)
    }

    val btnToReactFragment: Button by lazy {
        findViewById<Button>(R.id.btn_to_react_fragment)
    }

    val btnToComposeActivity: Button by lazy {
        findViewById<Button>(R.id.btn_to_compose_activity)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_main_activity)
        btnToReactActivity.setOnClickListener {
            Log.i(TAG, "To ReactActivity")
            val intent = Intent(this, MainReactActivity::class.java)
            startActivity(intent)
        }
        btnToReactFragment.setOnClickListener {
            Log.i(TAG, "To ReactFragment")
            val launchOptions = Bundle().apply {
                putString("data", "ReactFragment")
            }
            val reactNativeFragment = ReactFragment.Builder()
                .setComponentName("ReactFragmentComponent")
                .setLaunchOptions(launchOptions)
                .build()
            supportFragmentManager
                .beginTransaction()
                .add(R.id.react_fragment, reactNativeFragment)
                .commit()
        }
        btnToComposeActivity.setOnClickListener {
            Log.i(TAG, "To ComposeActivity")
            val intent = Intent(this, MainComposeActivity::class.java)
            startActivity(intent)
        }
    }
}
