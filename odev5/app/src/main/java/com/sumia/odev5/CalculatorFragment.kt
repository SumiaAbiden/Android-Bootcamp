package com.sumia.odev5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sumia.odev5.databinding.FragmentCalculatorBinding

class CalculatorFragment : Fragment() {

    private lateinit var binding: FragmentCalculatorBinding

    private var currentInput = "" // Ekranda gösterilecek mevcut giriş
    private var firstNumber: Double? = null
    private var operator: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCalculatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Rakam butonlarını tanımlama (0–9)
        val digitButtons = listOf(
            binding.btn0, binding.btn1, binding.btn2, binding.btn3, binding.btn4,
            binding.btn5, binding.btn6, binding.btn7, binding.btn8, binding.btn9
        )

        // Her rakam tuşuna basıldığında, ilgili rakam currentInput’a eklenir
        digitButtons.forEachIndexed { index, button ->
            button.setOnClickListener {
                currentInput += index.toString()
                updateResultDisplay()
            }
        }

        // İşlem butonları (+, -, *, /)
        listOf(
            binding.btnAdd to "+",
            binding.btnSubtract to "-",
            binding.btnMultiply to "*",
            binding.btnDivide to "/"
        ).forEach { (button, operatorSymbol) ->
            button.setOnClickListener {
                // İşlem butonuna basılmadan önce bir sayı girilmiş olmalı
                if (currentInput.isNotEmpty()) {
                    currentInput += " $operatorSymbol " // İşlem sembolünü boşluklarla ekle
                    updateResultDisplay()
                }
            }
        }

        // Eşittir butonu, işlemi hesaplar
        binding.btnEqual.setOnClickListener {
            calculateResult()
        }

        // CE butonu, tüm girişi sıfırlar
        binding.btnClear.setOnClickListener {
            clearInput()
        }
    }

    // Ekrandaki sonucu günceller, boşsa "0" gösterilir
    private fun updateResultDisplay() {
        binding.textViewResult.text = currentInput.ifEmpty { "0" }
    }

    // Mevcut işlemi değerlendirip sonucu hesaplar
    private fun calculateResult() {
        try {
            val result = evaluateSimpleExpression(currentInput)
            binding.textViewResult.text = result.toString()
            resetCalculator() // Sonuç gösterildikten sonra giriş temizlenir
        } catch (e: Exception) {
            showError("Geçersiz işlem")
        }
    }

    // Girilen basit işlemi değerlendirir (örneğin "5 + 3")
    private fun evaluateSimpleExpression(expression: String): Double {
        val parts = expression.split(" ")
        if (parts.size != 3) throw Exception("Geçersiz ifade formatı")

        val operand1 = parts[0].toDoubleOrNull() ?: throw Exception("Geçersiz sayı")
        val operand2 = parts[2].toDoubleOrNull() ?: throw Exception("Geçersiz sayı")
        val operator = parts[1]

        return when (operator) {
            "+" -> operand1 + operand2
            "-" -> operand1 - operand2
            "*" -> operand1 * operand2
            "/" -> if (operand2 != 0.0) operand1 / operand2 else throw Exception("Sıfıra bölme hatası")
            else -> throw Exception("Bilinmeyen işlem")
        }
    }

    // Hata mesajını ekranda gösterir
    private fun showError(message: String) {
        binding.textViewResult.text = message
    }

    // Girişleri sıfırlar ve ekranı günceller
    private fun clearInput() {
        currentInput = ""
        updateResultDisplay()
    }

    // Hesap makinesini yeni işlem için sıfırlar
    private fun resetCalculator() {
        currentInput = ""
        firstNumber = null
        operator = null
    }
}
