package expo.modules.settings

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity


class DummyActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        Log.i("DummyActivity", "onCreate")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("DummyActivity", "onDestroy")
    }
}
