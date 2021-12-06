package com.example.messakem_prat.models

import java.util.*
import kotlin.collections.ArrayList

data class Squad(
    val id: String,
    val unitName: String,
    val squadName: String,
    val measurementDate: String,
    val measurements: List<Measurement>? = null
) {

    companion object {
        fun getMock(): Squad {
            return Squad(UUID.randomUUID().toString(), "228", "a", "11/06/21")
        }

        fun getMockList(size: Int): ArrayList<Squad> {
            val list = arrayListOf<Squad>()
            repeat(size) {
                list.add(getMock())
            }
            return list
        }

        fun getSquad(unit: String, squad: String): ArrayList<Squad> {
            val list = arrayListOf<Squad>()
            list.add(Squad(UUID.randomUUID().toString(), unit, squad, "11/06"))
            return list
        }
    }
}