package com.vazh2100.num.to.hy

import com.vazh2100.num.to.hy.entities.NumberToTextHYCardinal
import com.vazh2100.num.to.hy.entities.NumberToTextHYOrdinal

class NumToHy(ordinal: Boolean = false) {

    private val converter = if (!ordinal) NumberToTextHYCardinal() else NumberToTextHYOrdinal()
    fun convert(number: Int) = converter.convert(number)
}
