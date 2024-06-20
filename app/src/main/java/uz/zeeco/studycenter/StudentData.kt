package uz.zeeco.studycenter

import android.os.Parcel
import android.os.Parcelable

data class StudentData(
    val age: Int,
    val contract: String,
    val course_day: String,
    val course_level: String,
    val course_name: String,
    val gender: String,
    val group_name: String,
    val id: String,
    val login: String,
    val name: String,
    val password: String,
    val phone_1: String,
    val phone_2: String,
    val status: String,
    val surname: String
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(age)
        parcel.writeString(contract)
        parcel.writeString(course_day)
        parcel.writeString(course_level)
        parcel.writeString(course_name)
        parcel.writeString(gender)
        parcel.writeString(group_name)
        parcel.writeString(id)
        parcel.writeString(login)
        parcel.writeString(name)
        parcel.writeString(password)
        parcel.writeString(phone_1)
        parcel.writeString(phone_2)
        parcel.writeString(status)
        parcel.writeString(surname)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<StudentData> {
        override fun createFromParcel(parcel: Parcel): StudentData {
            return StudentData(parcel)
        }

        override fun newArray(size: Int): Array<StudentData?> {
            return arrayOfNulls(size)
        }
    }
}