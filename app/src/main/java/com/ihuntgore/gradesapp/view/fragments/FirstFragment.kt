package com.ihuntgore.gradesapp.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.ihuntgore.gradesapp.R
import com.ihuntgore.gradesapp.databinding.FragmentFirstBinding
import com.ihuntgore.gradesapp.view.model.Student

class FirstFragment : Fragment() {

    // Objetos que se compartiran publicamente
    companion object {
        // Key del bundle de estudiante
        // Ventaja de esta forma: Minimiza los problemas en cambios de nombre (variable, valor) y facilita la depuracion
        const val ESTUDIANTE_BUNDLE = "estudiante_bundle"
    }

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

        initListeners()
    }

    private fun initListeners() {
        addListenerBtnCalcular()
    }

    private fun addListenerBtnCalcular(){
        binding.btnCalcular.setOnClickListener {
            val nombre = "Default"
            val nota1 = binding.etNota1.text.toString()
            val nota2 = binding.etNota2.text.toString()

            if (nota1.isEmpty() || nota2.isEmpty()) {
                Toast.makeText(requireContext(), "Debe digitar ambas notas", Toast.LENGTH_SHORT)
                    .show()
            } else {
                try {
                    val bundle = Bundle() // Se crea un bundle donde se meterá to'do lo necesario
                    val estudiante = Student(nombre, nota1.toDouble(), nota2.toDouble())

                    // Se pone un serializable en el bundle
                    bundle.putSerializable(
                        ESTUDIANTE_BUNDLE, // La key del bundle
                        estudiante // El objeto es el estudiante
                    )

                    findNavController().navigate(
                        R.id.action_fragmentFirst_to_fragmentSecond,
                        bundle // Aqui se pasa el bundle
                    )

                } catch (e: Exception) {

                    Toast.makeText(
                        requireContext(),
                        "Ha ocurrido un problema $e",
                        Toast.LENGTH_SHORT
                    ).show()

                }
            }
        }
    }
}