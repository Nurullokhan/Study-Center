package uz.zeeco.studycenter

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import uz.zeeco.studycenter.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_profile)
        binding=ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.profile_main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }

}
/*<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/profile_main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"

    tools:context=".ProfileActivity">

    <LinearLayout
        android:id="@+id/main_liner"
        android:layout_width="match_parent"
        android:layout_height="180dp"
        android:background="@drawable/profile_style"
        android:backgroundTint="#2199F8"
        android:gravity="center"
        android:orientation="vertical"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent">

        <FrameLayout
            android:layout_width="80dp"
            android:layout_height="80dp"
            android:background="@drawable/logo_style"
            android:backgroundTint="@color/material_dynamic_neutral95"

            >

            <ImageView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:contentDescription="@string/todo"
                android:padding="14dp"
                android:src="@drawable/user" />

        </FrameLayout>

        <LinearLayout
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:layout_marginTop="6dp"
            android:orientation="horizontal">


            <TextView
                android:id="@+id/name"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_margin="4dp"
                android:text="@string/nurulloxon"
                android:textColor="@color/white"
                android:textSize="24sp"
                android:textStyle="bold" />

            <TextView
                android:id="@+id/surname"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_margin="4dp"
                android:text="@string/kenjaxo_jayev"
                android:textColor="@color/white"
                android:textSize="24sp"
                android:textStyle="bold" />

        </LinearLayout>
    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_margin="10dp"
        android:gravity="center"
        android:orientation="vertical"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toBottomOf="@id/main_liner"

        >

        <LinearLayout
            android:layout_width="350dp"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:orientation="horizontal"
            android:background="@drawable/information_style"
            android:elevation="10dp"

            android:layout_margin="6dp"
            tools:ignore="UselessParent">

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"

                android:gravity="start"
                android:layout_marginTop="4dp"
                android:layout_marginBottom="4dp"
                android:layout_marginStart="8dp"
                android:layout_gravity="center"
                android:text="@string/age"

                android:textColor="#2199F8"
                android:textSize="24sp"
                android:textStyle="bold" />

            <TextView
                android:id="@+id/age"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_gravity="center"
                android:layout_margin="4dp"
                android:gravity="center"
                android:text="@string/_20"
                android:textColor="@color/category_color"
                android:textSize="24sp" />

        </LinearLayout>

        <LinearLayout
            android:layout_width="350dp"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:orientation="horizontal"
            android:elevation="10dp"
            android:layout_margin="6dp"
            android:background="@drawable/information_style"
            tools:ignore="UselessParent">

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_gravity="center"

                android:layout_marginTop="4dp"
                android:layout_marginBottom="4dp"
                android:layout_marginStart="8dp"
                android:text="@string/gender"
                android:textColor="#2199F8"
                android:textSize="24sp"
                android:textStyle="bold" />

            <TextView
                android:id="@+id/gender"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_gravity="center"
                android:layout_margin="4dp"
                android:gravity="center"
                android:text="@string/male"
                android:textColor="@color/category_color"
                android:textSize="24sp" />

        </LinearLayout>

        <LinearLayout
            android:layout_width="350dp"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:orientation="horizontal"
            android:elevation="10dp"
            android:layout_margin="6dp"
            android:background="@drawable/information_style"
            tools:ignore="UselessParent">

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_gravity="center"

                android:layout_marginTop="4dp"
                android:layout_marginBottom="4dp"
                android:layout_marginStart="8dp"
                android:text="@string/phone_1"
                android:textColor="#2199F8"
                android:textSize="24sp"
                android:textStyle="bold" />

            <TextView
                android:id="@+id/phone_1"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_gravity="center"
                android:layout_margin="4dp"
                android:gravity="center"
                android:text="@string/_998907804240"
                android:textColor="@color/category_color"
                android:textSize="24sp" />

        </LinearLayout>

        <LinearLayout
            android:layout_width="350dp"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:orientation="horizontal"
            android:elevation="10dp"
            android:layout_margin="6dp"
            android:background="@drawable/information_style"
            tools:ignore="UselessParent">

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_gravity="center"

                android:layout_marginTop="4dp"
                android:layout_marginBottom="4dp"
                android:layout_marginStart="8dp"
                android:text="@string/phone_2"
                android:textColor="#2199F8"
                android:textSize="24sp"
                android:textStyle="bold" />

            <TextView
                android:id="@+id/phone_2"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_gravity="center"
                android:layout_margin="4dp"
                android:gravity="center"
                android:text="@string/_998910446710"
                android:textColor="@color/category_color"
                android:textSize="24sp" />

        </LinearLayout>

        <LinearLayout
            android:layout_width="350dp"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:orientation="horizontal"
            android:elevation="10dp"
            android:layout_margin="6dp"
            android:background="@drawable/information_style"
            tools:ignore="UselessParent">

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_gravity="center"

                android:layout_marginTop="4dp"
                android:layout_marginBottom="4dp"
                android:layout_marginStart="8dp"
                android:text="@string/course_id"
                android:textColor="#2199F8"
                android:textSize="24sp"
                android:textStyle="bold" />

            <TextView
                android:id="@+id/course_id"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_gravity="center"
                android:layout_margin="4dp"
                android:gravity="center"
                android:text="@string/_123"
                android:textColor="@color/category_color"
                android:textSize="24sp" />

        </LinearLayout>

        <LinearLayout
            android:layout_width="350dp"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:orientation="horizontal"
            android:elevation="10dp"
            android:layout_margin="6dp"
            android:background="@drawable/information_style"
            tools:ignore="UselessParent">

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_gravity="center"

                android:layout_marginTop="4dp"
                android:layout_marginBottom="4dp"
                android:layout_marginStart="8dp"
                android:text="@string/course_level"
                android:textColor="#2199F8"
                android:textSize="24sp"
                android:textStyle="bold" />

            <TextView
                android:id="@+id/course_level"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_gravity="center"
                android:layout_margin="4dp"
                android:gravity="center"
                android:text="@string/beginner"
                android:textColor="@color/category_color"
                android:textSize="24sp" />

        </LinearLayout>

        <LinearLayout
            android:layout_width="350dp"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:orientation="horizontal"
            android:elevation="10dp"
            android:layout_margin="6dp"
            android:background="@drawable/information_style"
            tools:ignore="UselessParent">

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_gravity="center"

                android:layout_marginTop="4dp"
                android:layout_marginBottom="4dp"
                android:layout_marginStart="8dp"
                android:text="@string/course_days"
                android:textColor="#2199F8"
                android:textSize="24sp"
                android:textStyle="bold" />

            <TextView
                android:id="@+id/course_day"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_gravity="center"
                android:layout_margin="4dp"
                android:gravity="center"
                android:text="@string/dush_chor_juma"
                android:textColor="@color/category_color"
                android:textSize="24sp" />

        </LinearLayout>

        <LinearLayout
            android:layout_width="350dp"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:orientation="horizontal"
            android:elevation="10dp"
            android:layout_margin="6dp"
            android:background="@drawable/information_style"
            tools:ignore="UselessParent">

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_gravity="center"

                android:layout_marginTop="4dp"
                android:layout_marginBottom="4dp"
                android:layout_marginStart="8dp"
                android:text="@string/status"
                android:textColor="#2199F8"
                android:textSize="24sp"
                android:textStyle="bold" />

            <TextView
                android:id="@+id/status"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_gravity="center"
                android:layout_margin="4dp"
                android:gravity="center"
                android:text="@string/o_qishni_boshladi"
                android:textColor="@color/category_color"
                android:textSize="24sp" />

        </LinearLayout>

        <LinearLayout
            android:layout_width="350dp"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:orientation="horizontal"
            android:elevation="10dp"
            android:layout_margin="6dp"
            android:background="@drawable/information_style"
            tools:ignore="UselessParent">

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_gravity="center"

                android:layout_marginTop="4dp"
                android:layout_marginBottom="4dp"
                android:layout_marginStart="8dp"
                android:text="@string/group_id"
                android:textColor="#2199F8"
                android:textSize="24sp"
                android:textStyle="bold" />

            <TextView
                android:id="@+id/group_id"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_gravity="center"
                android:layout_margin="4dp"
                android:gravity="center"
                android:text="@string/_321"
                android:textColor="@color/category_color"
                android:textSize="24sp" />

        </LinearLayout>

        <LinearLayout
            android:layout_width="350dp"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:elevation="10dp"
            android:layout_margin="6dp"
            android:background="@drawable/information_style"
            android:orientation="horizontal"
            tools:ignore="UselessParent">

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_gravity="center"

                android:layout_marginTop="4dp"
                android:layout_marginBottom="4dp"
                android:layout_marginStart="8dp"
                android:text="@string/marketing"
                android:textColor="#2199F8"
                android:textSize="24sp"
                android:textStyle="bold" />

            <TextView
                android:id="@+id/marketing"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_gravity="center"
                android:layout_margin="4dp"
                android:gravity="center"
                android:text="@string/tanishlar"
                android:textColor="@color/category_color"
                android:textSize="24sp" />

        </LinearLayout>

        <LinearLayout
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="start"
            android:orientation="horizontal"
            tools:ignore="UselessParent">

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_gravity="center"
                android:layout_margin="4dp"
                android:text="@string/contract"
                android:textColor="#2199F8"
                android:textSize="24sp"
                android:textStyle="bold" />

            <TextView
                android:id="@+id/contract"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_gravity="center"
                android:layout_margin="4dp"
                android:gravity="center"
                android:text="@string/tuzilgan"
                android:textColor="@color/category_color"
                android:textSize="24sp" />

        </LinearLayout>


    </LinearLayout>


</androidx.constraintlayout.widget.ConstraintLayout>*/
