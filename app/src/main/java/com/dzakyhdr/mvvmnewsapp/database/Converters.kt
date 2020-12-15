package com.dzakyhdr.mvvmnewsapp.database

import androidx.room.TypeConverter
import com.dzakyhdr.mvvmnewsapp.model.Source


class Converters {

    @TypeConverter
    fun fromSource(source: Source): String{
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): Source{
        return Source(name, name)
    }
}