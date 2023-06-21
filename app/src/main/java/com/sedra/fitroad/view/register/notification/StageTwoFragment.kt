package com.sedra.fitroad.view.register.notification

import android.content.pm.PackageManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.sedra.fitroad.R
import com.sedra.fitroad.databinding.FragmentStageTwoBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StageTwoFragment : Fragment() {
    var binding: FragmentStageTwoBinding? = null
    private val NOTIFICATION_PERMISSION_CODE = 1

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            // Permission granted
            findNavController().navigate(R.id.action_stageTwoFragment_to_stageThreeFragment)
        } else {
            // Permission denied
            findNavController().navigate(R.id.action_stageTwoFragment_to_stageThreeFragment)

        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_stage_two, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            button.setOnClickListener {
                requestNotificationPermission()

            }
            include.progressBar.progress = 2
            include.textView5.text = "STEP 2 OF 7"
        }
    }
    private fun requestNotificationPermission() {
        if (ContextCompat.checkSelfPermission(
                requireActivity(),
                android.Manifest.permission.BIND_NOTIFICATION_LISTENER_SERVICE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissionLauncher.launch(android.Manifest.permission.BIND_NOTIFICATION_LISTENER_SERVICE)
        }else{
            findNavController().navigate(R.id.action_stageTwoFragment_to_stageThreeFragment)

        }
    }

}