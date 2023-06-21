package com.sedra.fitroad.view.register.personaldata

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.sedra.fitroad.R
import com.sedra.fitroad.StartingViewModel
import com.sedra.fitroad.databinding.FragmentStageFourBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StageFourFragment : Fragment() {

    var binding: FragmentStageFourBinding? = null
    val viewModel: StartingViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_stage_four, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            button.setOnClickListener {
                viewModel.first_name = fName.text.toString()
                viewModel.last_name = lastName.text.toString()
                viewModel.country = country.text.toString()
                viewModel.city = city.text.toString()
                viewModel.gov = governorate.text.toString()
                viewModel.age = "22"
                findNavController().navigate(R.id.action_stageFourFragment_to_stageFiveFragment)
            }
            include.progressBar.progress = 4
            include.textView5.text = "STEP 4 OF 7"

        }
    }


}