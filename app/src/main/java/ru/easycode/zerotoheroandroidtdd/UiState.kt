import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import kotlinx.coroutines.*

interface UiState {
    fun apply(textView: TextView, actionButton: Button, progressBar: ProgressBar)

    data class Base(private val text: String) : UiState {
        override fun apply(textView: TextView, actionButton: Button, progressBar: ProgressBar) {
            textView.visibility = View.INVISIBLE
            actionButton.isEnabled = true
            progressBar.isVisible = false
        }
    }

    data class OnClick(private val text: String) : UiState {
        override fun apply(textView: TextView, actionButton: Button, progressBar: ProgressBar) {
            // Устанавливаем текст textView (если нужно)
            // textView.text = text

            // Делаем textView недоступным
            textView.isEnabled = true
            textView.visibility = View.VISIBLE
            progressBar.visibility = View.VISIBLE

            // Делаем actionButton сначала недоступным, а затем доступным
            actionButton.isEnabled = false

            // Используем корутину для выполнения задержки
            CoroutineScope(Dispatchers.Main).launch {
                delay(3500) // Задержка на 3.5 секунды


                // После задержки, делаем actionButton доступным и скрываем progressBar
                actionButton.isEnabled = true
                progressBar.isVisible = false
                    //progressBar.visibility  = View.GONE
            }
        }
    }
}
