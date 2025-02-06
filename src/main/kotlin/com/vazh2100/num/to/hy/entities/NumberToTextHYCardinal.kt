package com.vazh2100.num.to.hy.entities

import com.vazh2100.num.to.hy.entities.Cardinal.ones
import com.vazh2100.num.to.hy.entities.Cardinal.tens
import com.vazh2100.num.to.hy.entities.Nums.BILLION
import com.vazh2100.num.to.hy.entities.Nums.HUNDRED
import com.vazh2100.num.to.hy.entities.Nums.MILLION
import com.vazh2100.num.to.hy.entities.Nums.TEN
import com.vazh2100.num.to.hy.entities.Nums.THOUSAND

internal class NumberToTextHYCardinal : Converter {

    override fun convert(number: Int): String = StringBuilder().convert(number).toString()

    internal fun convertWithBuilder(number: Int, builder: StringBuilder): StringBuilder = builder.convert(number)

    private fun StringBuilder.convert(number: Int): StringBuilder {
        return when {
            number <= TEN -> append(ones[number])
            number < HUNDRED -> append(tens[number / TEN]).processOdd(number % TEN, withSpace = false)
            number < THOUSAND -> processPre(number / HUNDRED).append(Word.HUNDRED).processOdd(number % HUNDRED)
            number < MILLION -> processPre(number / THOUSAND).append(Word.THOUSAND).processOdd(number % THOUSAND)
            number < BILLION -> processPre(number / MILLION).append(Word.MILLION).processOdd(number % MILLION)
            else -> error("Unsupported value")
        }
    }

    private fun StringBuilder.processPre(odd: Int): StringBuilder {
        if (odd == 1) return this
        return convert(odd).append(" ")
    }

    private fun StringBuilder.processOdd(odd: Int, withSpace: Boolean = true): StringBuilder {
        if (odd == 0) return this
        if (withSpace) append(" ")
        return convert(odd)
    }
}
