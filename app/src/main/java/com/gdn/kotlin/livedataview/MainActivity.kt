package com.gdn.kotlin.livedataview

import android.arch.lifecycle.Observer
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.gdn.kotlin.livedataview.databinding.ActivityMainBinding
import android.arch.lifecycle.ViewModelProviders
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var view: ActivityMainBinding
//    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        view = DataBindingUtil.setContentView(this, R.layout.activity_main)

//        get the viewModel
        val userViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)

        // Create the observer which updates the UI.
//        val nameObserver = Observer<String> { newName ->
//            // Update the UI, in this case, a TextView.
//            activityMainBinding.tvTwo.text = newName
//        }
        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
//        userViewModel.fullName.observe(this, nameObserver)

        userViewModel.getUsers().observe(this, Observer<List<UserModel>> { users ->
            Log.d("coba", "masukharusnya")
            view.tvFirst.text = users?.first()?.firstName
            Toast.makeText(this, "okeoke", Toast.LENGTH_SHORT).show()
        })
    }
}
