package ru.easycode.zerotoheroandroidtdd // Объявление пакета, в котором находится класс MainActivity

import android.os.Build // Импорт класса Build из пакета android.os для работы с информацией об устройстве
import androidx.appcompat.app.AppCompatActivity // Импорт класса AppCompatActivity из библиотеки AndroidX для создания активити
import android.os.Bundle // Импорт класса Bundle из пакета android.os для работы с информацией о состоянии активити
import android.widget.Button // Импорт класса Button из пакета android.widget для работы с кнопками
import android.widget.LinearLayout // Импорт класса LinearLayout из пакета android.widget для работы с вертикальными макетами
import android.widget.TextView // Импорт класса TextView из пакета android.widget для работы с текстовыми представлениями
import java.io.Serializable // Импорт интерфейса Serializable из пакета java.io для сериализации объектов

class MainActivity : AppCompatActivity() { // Объявление класса MainActivity, который является подклассом AppCompatActivity

    private lateinit var rootlayout: LinearLayout // Объявление переменной rootlayout, представляющей собой контейнер LinearLayout
    private lateinit var textView: TextView // Объявление переменной textView, представляющей собой текстовое представление
    //private var state: State = State.Initial // Объявление переменной state, представляющей текущее состояние приложения
    private lateinit var button: Button // Объявление переменной button, представляющей собой кнопку

    private val count = Count.Base (step =2)
    override fun onCreate(savedInstanceState: Bundle?) { // Переопределение метода onCreate для создания активити
        super.onCreate(savedInstanceState) // Вызов родительского метода onCreate
        setContentView(R.layout.activity_main) // Установка макета для активити из файла activity_main.xml
        textView = findViewById(R.id.countTextView) // Поиск текстового представления по его идентификатору и присвоение его переменной textView
        rootlayout = findViewById(R.id.rootLayout) // Поиск контейнера по его идентификатору и присвоение его переменной rootlayout
        button = findViewById(R.id.incrementButton) // Поиск кнопки по ее идентификатору и присвоение ее переменной button

        button.setOnClickListener { // Установка слушателя кликов на кнопку
            val result = count.increment( textView.text.toString())
            textView.text = result
            //state = State.Increment // Установка состояния приложения на "удалено"
            //state.apply(rootlayout, textView, button) // Применение изменений в соответствии с новым состоянием
        }
    }

//    override fun onRestoreInstanceState(savedInstanceState: Bundle) { // Переопределение метода onRestoreInstanceState для восстановления состояния активити
//        super.onRestoreInstanceState(savedInstanceState) // Вызов родительского метода onRestoreInstanceState
//        state = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) { // Проверка версии Android, начиная с которой поддерживается TIRAMISU
//            savedInstanceState.getSerializable(KEY, State::class.java) as State // Восстановление состояния из сохраненных данных
//        } else {
//            savedInstanceState.getSerializable(KEY) as State // Восстановление состояния из сохраненных данных
//        }
//        state.apply(rootlayout, textView, button) // Применение восстановленного состояния
//    }

//    override fun onSaveInstanceState(outState: Bundle) { // Переопределение метода onSaveInstanceState для сохранения состояния активити
//        super.onSaveInstanceState(outState) // Вызов родительского метода onSaveInstanceState
//        outState.putSerializable(KEY, state) // Сохранение состояния приложения в объекте Bundle
//    }

//    companion object { // Объявление companion object, содержащего статические члены класса
//        private const val KEY = "key" // Объявление константы KEY с именем "key"
//    }
}

//interface State : Serializable { // Объявление интерфейса State, представляющего состояние приложения
//    fun apply(rootlayout: LinearLayout, textView: TextView, button: Button) // Объявление метода apply для применения состояния
//
//    object Initial : State { // Объявление объекта Initial внутри интерфейса State
//        override fun apply(rootlayout: LinearLayout, textView: TextView, button: Button) = Unit // Начальное состояние приложения (ничего не делать)
//    }
//
//    object Increment : State { // Объявление объекта Increment внутри интерфейса State
//        override fun apply(rootlayout: LinearLayout, textView: TextView, button: Button) { // Применение состояния "инкремент"
//            val currentValue = textView.text.toString().toIntOrNull() ?: 0 // Получение текущего числового значения из текстового представления
//            val newValue = currentValue + 2 // Вычисление нового числового значения (прибавление 2)
//            textView.text = newValue.toString() // Установка нового числового значения в текстовое представление
//        }
//    }
//
//}
