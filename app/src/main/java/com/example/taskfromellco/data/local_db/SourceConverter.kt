package com.example.taskfromellco.data.local_db

import androidx.room.TypeConverter
import com.example.taskfromellco.data.remote_db.Source

class SourceConverter {
    companion object {

        @TypeConverter
        @JvmStatic
        fun fromName(source: Source): String {
            return source.name
        }

        @TypeConverter
        @JvmStatic
        fun fromId(source: Source): String {
            return source.id
        }

        @TypeConverter
        @JvmStatic
        fun toName(name: String): Source {
            return Source("0", name)
        }
        @TypeConverter
        @JvmStatic
        fun toId(id: String): Source {
            return Source(id, "ANSALTA")
        }
    }
}