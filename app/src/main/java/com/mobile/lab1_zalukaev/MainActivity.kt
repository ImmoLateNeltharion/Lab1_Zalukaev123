package com.mobile.lab1_zalukaev

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var optionsLayout: LinearLayout
    private lateinit var resultTextView: TextView
    private var totalPrice = 1000000 // Начальная цена автомобиля

    private val options = arrayOf(
        Pair("Кондиционер", 1000),
        Pair("Подогрев сидений", 1500),
        Pair("Система навигации", 2000),
        Pair("Автоматическая круиз-контроль", 3500),
        Pair("Автоматическая камера заднего вида", 1000)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        optionsLayout = findViewById(R.id.optionsLayout)
        resultTextView = findViewById(R.id.resultTextView)

        // Обновляем текст в resultTextView с начальной ценой автомобиля
        resultTextView.text = "Стоимость автомобиля: $totalPrice"

        // Создаем TextView и кнопку "Купить" для каждой опции
        for (option in options) {
            val optionView = layoutInflater.inflate(R.layout.option_layout, null) as LinearLayout
            val optionTextView = optionView.findViewById<TextView>(R.id.optionTextView)
            val priceTextView = optionView.findViewById<TextView>(R.id.priceTextView)
            val buyButton = optionView.findViewById<Button>(R.id.buyButton)

            optionTextView.text = option.first
            priceTextView.text = "Цена: ${option.second}"

            buyButton.setOnClickListener {
                // При нажатии кнопки "Купить" добавляем цену опции к общей стоимости и обновляем текст в resultTextView
                totalPrice += option.second
                resultTextView.text = "Стоимость автомобиля: $totalPrice"
            }

            optionsLayout.addView(optionView)
        }

        // Назначаем обработчик события для кнопки "Рассчитать"
        val calculateButton = findViewById<Button>(R.id.calculateButton)
        calculateButton.setOnClickListener {
            // При нажатии кнопки "Рассчитать" выводим общую стоимость автомобиля в resultTextView
            resultTextView.text = "Стоимость автомобиля: $totalPrice"
        }
    }
}
