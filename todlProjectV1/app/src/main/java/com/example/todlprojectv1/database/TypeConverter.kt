package com.example.todlprojectv1.database

import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.room.TypeConverter


class Converters {

        @TypeConverter
        fun fromRadioGroup(rad: RadioGroup): String {
            return rad.toString()
        }



    }



