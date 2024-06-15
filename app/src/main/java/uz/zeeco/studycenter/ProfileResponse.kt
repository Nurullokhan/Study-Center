package uz.zeeco.studycenter

import android.os.Parcel
import android.os.Parcelable

data class ProfileResponse(
    val id: Int,
    val name: String,
    val surname: String,
    val age: Int,
    val gender: String,
    val phoneNumber1: String,
    val phoneNumber2: String?,
    val courseId: String,
    val level: String,
    val lessonDays: String,
    val status: String,
    val groupId: String,
    val marketing: String,
    val contract: String
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString(),
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
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(surname)
        parcel.writeInt(age)
        parcel.writeString(gender)
        parcel.writeString(phoneNumber1)
        parcel.writeString(phoneNumber2)
        parcel.writeString(courseId)
        parcel.writeString(level)
        parcel.writeString(lessonDays)
        parcel.writeString(status)
        parcel.writeString(groupId)
        parcel.writeString(marketing)
        parcel.writeString(contract)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ProfileResponse> {
        override fun createFromParcel(parcel: Parcel): ProfileResponse {
            return ProfileResponse(parcel)
        }

        override fun newArray(size: Int): Array<ProfileResponse?> {
            return arrayOfNulls(size)
        }
    }
}
