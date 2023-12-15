package com.example.databaseapplication.personalinfodb

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

/*@Parcelize*/
@Entity(tableName="personal_info_table")
data class PersonalInfo(
    val name : String,
    val age : Int,
    val qualification: String,
    val profession: String,
    @PrimaryKey(autoGenerate = false) val id : Int? = null
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readValue(Int::class.java.classLoader) as? Int
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(age)
        parcel.writeString(qualification)
        parcel.writeString(profession)
        parcel.writeValue(id)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PersonalInfo> {
        override fun createFromParcel(parcel: Parcel): PersonalInfo {
            return PersonalInfo(parcel)
        }

        override fun newArray(size: Int): Array<PersonalInfo?> {
            return arrayOfNulls(size)
        }
    }
}
