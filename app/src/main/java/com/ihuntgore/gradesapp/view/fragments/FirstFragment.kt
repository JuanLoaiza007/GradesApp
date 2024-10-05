package com.ihuntgore.gradesapp.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ihuntgore.gradesapp.R
import com.ihuntgore.gradesapp.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navigationFragmentFirst()
    }

    private fun navigationFragmentFirst() {
        binding.btnCalcular.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentFirst_to_fragmentSecond)
        }
    }
}