package expo.modules.settings

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import expo.modules.kotlin.activityresult.AppContextActivityResultContract
import expo.modules.kotlin.providers.AppContextProvider
import java.io.Serializable
import kotlinx.parcelize.Parcelize

@Parcelize
enum class DummyParam : Parcelable {
    DUMMY_INPUT,
}

internal class DummyContract(private val appContextProvider: AppContextProvider,) : AppContextActivityResultContract<DummyContractOptions, DummyContractResult> {
    override fun createIntent(context: Context, input: DummyContractOptions): Intent {
        val extras = Bundle()
        extras.putParcelable(
            "DummyActivitPacelable",
            input.dummyParam
        )
        val intent = Intent(appContextProvider.appContext.reactContext, DummyActivity::class.java)
        intent.putExtras(extras)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        return intent
    }

    override fun parseResult(input: DummyContractOptions, resultCode: Int, intent: Intent?): DummyContractResult =
        if (resultCode == Activity.RESULT_CANCELED) {
            DummyContractResult.Cancelled()
        } else {
            DummyContractResult.Success()
        }
}

internal data class DummyContractOptions(
    val dummyParam: DummyParam
) : Serializable

internal sealed class DummyContractResult private constructor() {
    class Cancelled : DummyContractResult()
    class Success : DummyContractResult()
}
