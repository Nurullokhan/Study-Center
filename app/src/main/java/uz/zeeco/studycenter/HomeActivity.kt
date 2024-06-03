package uz.zeeco.studycenter

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import uz.zeeco.studycenter.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityHomeBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.home_main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // requestPermission()
        auth = FirebaseAuth.getInstance()
        val currentUser = auth.currentUser

//        Reference


        if (currentUser == null) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        binding.idLogout.setOnClickListener {
            auth.signOut()
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

    }

    /*  fun requestPermission() {
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
                      Log.w(TAG, "Fetching FCM registration token failed", task.exception)
                      return@OnCompleteListener
                  }

                  // Get new FCM registration token
                  val token = task.result
                  Log.w("FirebaseLogs", " Fetching FCM registration token:$token")
                  // Log and toast

              })
              }
          }*/
}