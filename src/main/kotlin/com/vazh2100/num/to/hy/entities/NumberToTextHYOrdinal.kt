package com.vazh2100.num.to.hy.entities

import com.vazh2100.num.to.hy.entities.Nums.BILLION
import com.vazh2100.num.to.hy.entities.Nums.FOUR
import com.vazh2100.num.to.hy.entities.Nums.HUNDRED
import com.vazh2100.num.to.hy.entities.Nums.TEN

internal class NumberToTextHYOrdinal : Converter {

    private val cardinal = NumberToTextHYCardinal()

    override fun convert(number: Int): String = StringBuilder().convert(number).toString()

    private fun StringBuilder.convert(number: Int): StringBuilder {
        return when {
            number <= FOUR -> append(Ordinal.ones[number])
            number <= BILLION -> {
                cardinal.convertWithBuilder(number, this).append(Ordinal.ERORD)
                if (number % HUNDRED == TEN) {
                    StringBuilder(replace(Regex("տասըերորդ"), "տասներորդ"))
                } else {
                    this
                }
            }
            else -> error("Unsupported value")
        }
    }
}
