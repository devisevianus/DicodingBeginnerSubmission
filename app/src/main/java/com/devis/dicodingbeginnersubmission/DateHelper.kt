package com.devis.dicodingbeginnersubmission

import android.annotation.SuppressLint
import com.devis.dicodingbeginnersubmission.DateHelper.DATE_DD_MM_YYYY
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by devis on 2019-11-16
 */
 
object DateHelper {
    const val DATE_DD_MM_YYYY = "dd/MM/YYYY"
}

@SuppressLint("SimpleDateFormat")
fun String.convertToDate(): Date? {
    val sdf = SimpleDateFormat(DATE_DD_MM_YYYY)
    return sdf.parse(this)
}

fun Date.getAge(): Int? {
    val dob = Calendar.getInstance()
    val today = Calendar.getInstance()

    dob.time = this
    val year = dob.get(Calendar.YEAR)
    val month = dob.get(Calendar.MONTH) + 1
    val day = dob.get(Calendar.DAY_OF_MONTH)

    dob.set(year, month, day)
    val age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR)

    return age
}