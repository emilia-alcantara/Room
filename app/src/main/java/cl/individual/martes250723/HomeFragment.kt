package cl.individual.martes250723

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import cl.individual.martes250723.databinding.FragmentHomeBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel : TareaVM by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        initListeners()
        obtenerTarea()

        return binding.root
    }



    private fun initListeners() {
        binding.btnRealizar.setOnClickListener {
            val texto = binding.editAgregarTarea.text.toString()
            guardarTarea(texto)

        }
    }

    private fun guardarTarea(texto: String) {
        val tarea = Tarea(texto)
        viewModel.insertarTareas(tarea)

    }

    private fun obtenerTarea() {
        viewModel.obtenerTareas().observe(viewLifecycleOwner) {
            val tareaComoTexto = it.joinToString("\n") { it.nombre }
            binding.txtInfoAgregada.text = tareaComoTexto
        }
    }
}