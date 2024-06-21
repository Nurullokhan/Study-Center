package uz.zeeco.studycenter.home

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.messaging.FirebaseMessaging
import uz.zeeco.studycenter.atttendance.AttendanceFragment
import uz.zeeco.studycenter.R
import uz.zeeco.studycenter.databinding.ActivityMainBinding
import uz.zeeco.studycenter.profile.ProfileFragment

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    lateinit var storedVerificationId: String
    lateinit var resendToken: PhoneAuthProvider.ForceResendingToken
    private lateinit var callbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        auth = FirebaseAuth.getInstance()
        requestPermission()


//        Reference
        binding.navView.setOnItemSelectedListener {
            when (it) {
                R.id.navigation_home -> replaceFragment(HomeFragment())
                R.id.navigation_attendance -> replaceFragment(AttendanceFragment())
                R.id.navigation_profile -> replaceFragment(ProfileFragment())
            }




        }
    }
    private fun replaceFragment(fragment: Fragment){
        val fragmentManager=supportFragmentManager
        val fragmentTransaction=fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer,fragment)
        fragmentTransaction.commit()
    }


    private fun requestPermission() {
        // This is only necessary for API level >= 33 (TIRAMISU)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.POST_NOTIFICATIONS
                ) ==
                PackageManager.PERMISSION_GRANTED
            ) {
                // FCM SDK (and your app) can post notifications.
            } else if (shouldShowRequestPermissionRationale(android.Manifest.permission.POST_NOTIFICATIONS)) {
                // TODO: display an educational UI explaining to the user the features that will be enabled
                //       by them granting the POST_NOTIFICATION permission. This UI should provide the user
                //       "OK" and "No thanks" buttons. If the user selects "OK," directly request the permission.
                //       If the user selects "No thanks," allow the user to continue without notifications.
            } else {
                // Directly ask for the permission
                requestPermissionLauncher.launch(android.Manifest.permission.POST_NOTIFICATIONS)
            }
        }
    }


    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission(),
    ) { isGranted: Boolean ->
        if (isGranted) {
            FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
                if (!task.isSuccessful) {
                    Log.w(
                        ContentValues.TAG,
                        "Fetching FCM registration token failed",
                        task.exception
                    )
                    return@OnCompleteListener
                }

                // Get new FCM registration token
                val token = task.result
                Log.w("FirebaseLogs", " Fetching FCM registration token:$token")
                // Log and toast

            })
            /*    <androidx.constraintlayout.widget.ConstraintLayout
        android:id="@+id/informations_layout"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginStart="28dp"
        android:layout_marginEnd="28dp"
        android:background="@drawable/information_style"
        android:gravity="center"
        android:elevation="8dp"
        android:orientation="vertical"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toBottomOf="@id/name_layout"
        app:layout_constraintBottom_toBottomOf="parent"


        >


        <TextView
            android:id="@+id/age_layout"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:layout_marginStart="10dp"
            android:layout_marginTop="10dp"
            android:gravity="start"
            android:text="@string/age"
            android:textColor="@color/detail"
            android:textSize="20sp"

            app:layout_constraintBottom_toTopOf="@id/view_1"
            app:layout_constraintLeft_toLeftOf="parent"
            app:layout_constraintTop_toTopOf="parent" />

        <TextView
            android:id="@+id/age"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:layout_marginEnd="10dp"
            android:gravity="center"
            android:text="@string/_20"
            android:textColor="@color/category_color"
            android:textSize="18sp"
            app:layout_constraintBottom_toBottomOf="@id/age_layout"
            app:layout_constraintRight_toRightOf="parent"
            app:layout_constraintTop_toTopOf="@id/age_layout" />

        <View
            android:id="@+id/view_1"
            android:layout_width="match_parent"
            android:layout_height="0.8dp"
            android:background="@color/view_color"
            android:layout_margin="5dp"
            app:layout_constraintBottom_toTopOf="@id/gender_layout"
            app:layout_constraintTop_toBottomOf="@id/age_layout" />

        <View
            android:id="@+id/view_2"
            android:layout_width="match_parent"
            android:layout_height="0.8dp"
            android:layout_margin="5dp"
            android:background="@color/view_color"
            app:layout_constraintBottom_toTopOf="@id/phone_1_layout"
            app:layout_constraintTop_toBottomOf="@id/gender_layout" />

        <View
            android:id="@+id/view_3"
            android:layout_width="match_parent"
            android:layout_height="0.8dp"
            android:layout_margin="5dp"
            android:background="@color/view_color"
            app:layout_constraintBottom_toTopOf="@id/phone_2_layout"
            app:layout_constraintTop_toBottomOf="@id/phone_1_layout" />

        <View
            android:id="@+id/view_4"
            android:layout_margin="5dp"
            android:layout_width="match_parent"
            android:layout_height="0.8dp"
            android:background="@color/view_color"
            app:layout_constraintBottom_toTopOf="@id/course_layout"
            app:layout_constraintTop_toBottomOf="@id/phone_2_layout" />

        <View
            android:id="@+id/view_5"
            android:layout_margin="5dp"
            android:layout_width="match_parent"
            android:layout_height="0.8dp"
            android:background="@color/view_color"
            app:layout_constraintBottom_toTopOf="@id/level_layout"
            app:layout_constraintTop_toBottomOf="@id/course_layout" />

        <View
            android:layout_margin="10dp"
            android:id="@+id/view_6"
            android:layout_width="match_parent"
            android:layout_height="0.8dp"
            android:background="@color/view_color"
            app:layout_constraintBottom_toTopOf="@id/course_day_layout"
            app:layout_constraintTop_toBottomOf="@id/level_layout" />

        <View
            android:layout_margin="15dp"
            android:id="@+id/view_7"
            android:layout_width="match_parent"
            android:layout_height="0.8dp"
            android:background="@color/view_color"
            app:layout_constraintBottom_toTopOf="@id/status_layout"
            app:layout_constraintTop_toBottomOf="@id/course_day_layout" />

        <View
            android:id="@+id/view_8"
            android:layout_margin="5dp"
            android:layout_width="match_parent"
            android:layout_height="0.8dp"
            android:background="@color/view_color"
            app:layout_constraintBottom_toTopOf="@id/group_layout"
            app:layout_constraintTop_toBottomOf="@id/status_layout" />

        <View
            android:id="@+id/view_9"
            android:layout_margin="5dp"
            android:layout_width="match_parent"
            android:layout_height="0.8dp"
            android:background="@color/view_color"
            app:layout_constraintBottom_toTopOf="@id/id_layout"
            app:layout_constraintTop_toBottomOf="@id/group_layout" />

        <View
            android:id="@+id/view_10"
            android:layout_margin="5dp"
            android:layout_width="match_parent"
            android:layout_height="0.8dp"
            android:background="@color/view_color"
            app:layout_constraintBottom_toTopOf="@id/contract_layout"
            app:layout_constraintTop_toBottomOf="@id/id_layout" />
        <View
            android:id="@+id/view_11"
            android:layout_margin="5dp"
            android:layout_width="match_parent"
            android:layout_height="0.8dp"
            android:background="@color/view_color"
            app:layout_constraintBottom_toTopOf="@id/login_layout"
            app:layout_constraintTop_toBottomOf="@id/contract_layout" />
        <View
            android:id="@+id/view_12"
            android:layout_margin="5dp"
            android:layout_width="match_parent"
            android:layout_height="0.8dp"
            android:background="@color/view_color"
            app:layout_constraintBottom_toTopOf="@id/password_layout"
            app:layout_constraintTop_toBottomOf="@id/login_layout" />

        <TextView
            android:id="@+id/gender_layout"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:layout_marginStart="10dp"
            android:text="@string/gender"
            android:textColor="@color/detail"
            android:textSize="20sp"
            android:textStyle="normal"
            app:layout_constraintBottom_toTopOf="@id/view_2"
            app:layout_constraintLeft_toLeftOf="parent"

            app:layout_constraintTop_toBottomOf="@id/view_1" />

        <TextView
            android:id="@+id/gender"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:layout_marginEnd="10dp"
            android:gravity="center"
            android:text="@string/male"
            android:textColor="@color/category_color"
            android:textSize="18sp"
            app:layout_constraintBottom_toBottomOf="@id/gender_layout"
            app:layout_constraintRight_toRightOf="parent"
            app:layout_constraintTop_toTopOf="@id/gender_layout" />


        <TextView
            android:id="@+id/phone_1_layout"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:layout_marginStart="10dp"
            android:text="@string/phone_1"
            android:textColor="@color/detail"
            android:textSize="20sp"

            app:layout_constraintBottom_toTopOf="@id/view_3"
            app:layout_constraintLeft_toLeftOf="parent"
            app:layout_constraintTop_toBottomOf="@id/view_2" />

        <TextView
            android:id="@+id/phone_1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:layout_marginEnd="10dp"
            android:gravity="center"
            android:text="@string/_998907804240"
            android:textColor="@color/category_color"
            android:textSize="18sp"
            app:layout_constraintBottom_toBottomOf="@id/phone_1_layout"
            app:layout_constraintRight_toRightOf="parent"
            app:layout_constraintTop_toTopOf="@id/phone_1_layout" />


        <TextView
            android:id="@+id/phone_2_layout"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:layout_marginStart="10dp"
            android:text="@string/phone_2"
            android:textColor="@color/detail"
            android:textSize="20sp"

            app:layout_constraintBottom_toTopOf="@id/view_4"
            app:layout_constraintLeft_toLeftOf="parent"
            app:layout_constraintTop_toBottomOf="@id/view_3" />

        <TextView
            android:id="@+id/phone_2"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:layout_marginEnd="10dp"
            android:gravity="center"

            android:text="@string/_998910446710"
            android:textColor="@color/category_color"
            android:textSize="18sp"
            app:layout_constraintBottom_toBottomOf="@id/phone_2_layout"
            app:layout_constraintRight_toRightOf="parent"
            app:layout_constraintTop_toTopOf="@id/phone_2_layout" />


        <TextView
            android:id="@+id/course_layout"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:layout_marginStart="10dp"
            android:text="@string/course_name"
            android:textColor="@color/detail"
            android:textSize="20sp"

            app:layout_constraintBottom_toTopOf="@id/view_5"
            app:layout_constraintLeft_toLeftOf="parent"
            app:layout_constraintTop_toBottomOf="@id/view_4" />

        <TextView
            android:id="@+id/course_name"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:layout_marginEnd="10dp"
            android:gravity="center"
            android:text="Chemistry"
            android:textColor="@color/category_color"
            android:textSize="18sp"
            app:layout_constraintBottom_toBottomOf="@id/course_layout"
            app:layout_constraintRight_toRightOf="parent"
            app:layout_constraintTop_toTopOf="@id/course_layout" />


        <TextView
            android:id="@+id/level_layout"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:layout_marginStart="10dp"
            android:text="@string/course_level"
            android:textColor="@color/detail"
            android:textSize="20sp"

            app:layout_constraintBottom_toTopOf="@id/view_6"
            app:layout_constraintLeft_toLeftOf="parent"
            app:layout_constraintTop_toBottomOf="@id/view_5" />

        <TextView
            android:id="@+id/course_level"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:layout_marginEnd="10dp"
            android:gravity="center"
            android:text="@string/beginner"
            android:textColor="@color/category_color"
            android:textSize="18sp"
            app:layout_constraintBottom_toBottomOf="@id/level_layout"
            app:layout_constraintRight_toRightOf="parent"
            app:layout_constraintTop_toTopOf="@id/level_layout" />


        <TextView
            android:id="@+id/course_day_layout"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:layout_marginStart="10dp"
            android:text="@string/course_days"
            android:textColor="@color/detail"
            android:textSize="20sp"

            app:layout_constraintBottom_toTopOf="@id/view_7"
            app:layout_constraintLeft_toLeftOf="parent"
            app:layout_constraintTop_toBottomOf="@id/view_6" />

        <TextView
            android:id="@+id/course_day"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:layout_marginEnd="10dp"
            android:gravity="center"
            android:text="@string/dush_chor_juma"
            android:textColor="@color/category_color"
            android:textSize="18sp"
            app:layout_constraintBottom_toBottomOf="@id/course_day_layout"
            app:layout_constraintRight_toRightOf="parent"
            app:layout_constraintTop_toTopOf="@id/course_day_layout" />


        <TextView
            android:id="@+id/status_layout"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:layout_marginStart="10dp"
            android:text="@string/status"
            android:textColor="@color/detail"
            android:textSize="20sp"

            app:layout_constraintBottom_toTopOf="@id/view_8"
            app:layout_constraintLeft_toLeftOf="parent"
            app:layout_constraintTop_toBottomOf="@id/view_7" />

        <TextView
            android:id="@+id/status"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:layout_marginEnd="10dp"
            android:gravity="center"
            android:text="@string/o_qishni_boshladi"
            android:textColor="@color/category_color"
            android:textSize="18sp"
            app:layout_constraintBottom_toBottomOf="@id/status_layout"
            app:layout_constraintRight_toRightOf="parent"
            app:layout_constraintTop_toTopOf="@id/status_layout" />


        <TextView
            android:id="@+id/group_layout"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:layout_marginStart="10dp"
            android:text="@string/group_name"
            android:textColor="@color/detail"
            android:textSize="20sp"

            app:layout_constraintBottom_toTopOf="@id/view_9"
            app:layout_constraintLeft_toLeftOf="parent"
            app:layout_constraintTop_toBottomOf="@id/view_8" />

        <TextView
            android:id="@+id/group_name"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:layout_marginEnd="10dp"
            android:gravity="center"
            android:text="Chemistry #"
            android:textColor="@color/category_color"
            android:textSize="18sp"
            app:layout_constraintBottom_toBottomOf="@id/group_layout"
            app:layout_constraintRight_toRightOf="parent"
            app:layout_constraintTop_toTopOf="@id/group_layout" />


        <TextView
            android:id="@+id/id_layout"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:layout_marginStart="10dp"
            android:text="@string/id"
            android:textColor="@color/detail"
            android:textSize="20sp"
            app:layout_constraintBottom_toTopOf="@id/view_10"
            app:layout_constraintLeft_toLeftOf="parent"
            app:layout_constraintTop_toBottomOf="@id/view_9" />

        <TextView
            android:id="@+id/id"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:layout_marginEnd="10dp"
            android:gravity="center"
            android:text="@string/_123"
            android:textColor="@color/category_color"
            android:textSize="18sp"
            app:layout_constraintBottom_toBottomOf="@id/id_layout"
            app:layout_constraintRight_toRightOf="parent"
            app:layout_constraintTop_toTopOf="@id/id_layout" />


        <TextView
            android:id="@+id/contract_layout"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:layout_marginStart="10dp"
            android:layout_marginBottom="10dp"
            android:text="@string/contract"
            android:textColor="@color/detail"
            android:textSize="20sp"
            app:layout_constraintBottom_toTopOf="@id/view_11"
            app:layout_constraintLeft_toLeftOf="parent"
            app:layout_constraintTop_toBottomOf="@id/view_10" />

        <TextView
            android:id="@+id/contract"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:layout_marginEnd="10dp"
            android:gravity="center"
            android:text="@string/tuzilgan"
            android:textColor="@color/category_color"
            android:textSize="18sp"
            app:layout_constraintBottom_toBottomOf="@id/contract_layout"
            app:layout_constraintRight_toRightOf="parent"
            app:layout_constraintTop_toTopOf="@id/contract_layout" />
        <TextView
            android:layout_gravity="center"
            android:layout_marginStart="10dp"
            android:layout_marginBottom="10dp"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:textColor="@color/detail"
            android:textSize="22sp"
            android:text="@string/login"
            android:id="@+id/login_layout"
            app:layout_constraintTop_toBottomOf="@id/view_11"
            app:layout_constraintLeft_toLeftOf="parent"
            />
        <TextView
            android:id="@+id/login"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:layout_marginEnd="10dp"
            android:gravity="center"
            android:text="@string/husanovdostonbek2007"
            android:textColor="@color/category_color"
            android:textSize="18sp"
            app:layout_constraintBottom_toBottomOf="@id/login_layout"
            app:layout_constraintRight_toRightOf="parent"
            app:layout_constraintTop_toTopOf="@id/login_layout" />

        <TextView
            android:layout_gravity="center"
            android:layout_marginStart="10dp"
            android:layout_marginBottom="10dp"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:textColor="@color/detail"
            android:textSize="22sp"
            android:text="@string/password"
            android:id="@+id/password_layout"
            app:layout_constraintTop_toBottomOf="@id/view_12"
            app:layout_constraintLeft_toLeftOf="parent"
            app:layout_constraintBottom_toBottomOf="parent"
            />
        <TextView
            android:id="@+id/password"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:layout_marginEnd="10dp"
            android:gravity="center"
            android:text="@string/dostonbek123456"
            android:textColor="@color/category_color"
            android:textSize="18sp"
            app:layout_constraintBottom_toBottomOf="@id/password_layout"
            app:layout_constraintRight_toRightOf="parent"
            app:layout_constraintTop_toTopOf="@id/password_layout" />
    </androidx.constraintlayout.widget.ConstraintLayout>*/
        }
    }
}