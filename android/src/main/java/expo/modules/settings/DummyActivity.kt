package expo.modules.settings

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import kotlin.concurrent.schedule


class DummyActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        Timer().schedule(3000) {
            Log.i("DummyActivity", "timeout ! finish activity")
            val data = Intent()
            data.putExtra("hello", "world")
            setResult(RESULT_OK, data)
            finish()
        }

        Log.i("DummyActivity", "onCreate")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("DummyActivity", "onDestroy")
    }
}
