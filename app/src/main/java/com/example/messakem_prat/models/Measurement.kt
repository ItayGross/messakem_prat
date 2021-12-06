package com.example.messakem_prat.models

import java.util.*

data class Measurement(
    val id: String,
    val personName: String,
    val aggression: Int,
    val technic: Int,
    val shooting: Int,
    val totalTime: Long
) {
    companion object {
        fun doMock(): Measurement {
            return (Measurement(UUID.randomUUID().toString(), "itay", 15, 14, 12, 100))
        }

        fun getMockList(size: Int): ArrayList<Measurement> {
            val list = arrayListOf<Measurement>()
            repeat(size) {
                list.add(Measurement.doMock())
            }
            return list
        }
    }
}