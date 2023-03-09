package expo.modules.settings

import android.util.Log
import expo.modules.kotlin.activityresult.AppContextActivityResultLauncher
import expo.modules.kotlin.modules.Module
import expo.modules.kotlin.modules.ModuleDefinition
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ExpoSettingsModule : Module() {
    override fun definition() = ModuleDefinition {
        Name("ExpoSettings")

        Function("startDummyActivity") {
            startDummyActivity()
        }

        RegisterActivityContracts {
            dummyActivityLauncher = registerForActivityResult(
                DummyContract(this@ExpoSettingsModule),
            ) { input, result ->
                Log.i(
                    "ExpoSettingsModule",
                    "dummyActivityLauncher result : $result"
                )
            }
        }
    }

    private val context
        get() = requireNotNull(appContext.reactContext)

    private lateinit var dummyActivityLauncher: AppContextActivityResultLauncher<DummyContractOptions, DummyContractResult>

    private fun startDummyActivity() {
        CoroutineScope(Dispatchers.Main).launch {
            dummyActivityLauncher.launch(DummyContractOptions(DummyParam.DUMMY_INPUT))
        }
    }
}
