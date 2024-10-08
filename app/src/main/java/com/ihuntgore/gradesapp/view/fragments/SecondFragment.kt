package com.ihuntgore.gradesapp.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.ihuntgore.gradesapp.databinding.FragmentSecondBinding
import com.ihuntgore.gradesapp.view.model.Student

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSecondBinding.inflate(inflater)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
        initListeners()
    }

    private fun initUI(){
        captureData()
    }

    private fun initListeners(){
        addListenerBtnVolver()
    }

    private fun addListenerBtnVolver(){
        binding.btnSwitchToFirstFragment.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun captureData() {

        val bundle = arguments

        // Es OBLIGATORIO comprobar que el bundle no sea null antes de empezar a usarlo
        if (bundle != null) {
            val estudiante = bundle.getSerializable(FirstFragment.ESTUDIANTE_BUNDLE) as Student

            val message = "Estudiante: ${estudiante.name}" +
                    "\nNota 1: ${estudiante.grade1}" +
                    "\nNota 2: ${estudiante.grade2}" +
                    "\nPromedio: ${estudiante.promedio}"

            binding.fragmentContent.text = message
        } else {
            Toast.makeText(requireContext(), "No hay datos disponibles", Toast.LENGTH_SHORT).show()
        }
    }
}