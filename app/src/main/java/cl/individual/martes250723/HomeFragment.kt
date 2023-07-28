package cl.individual.martes250723

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cl.individual.martes250723.databinding.FragmentHomeBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var repo: Repositorio

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        initListeners()
        initRepo()
        obtenerTarea()

        return binding.root
    }

    private fun initRepo() {
        repo = Repositorio(TareaDatabase.getDatabase(requireContext()).getTareaDao())
    }

    private fun initListeners() {
        binding.btnRealizar.setOnClickListener {
            val texto = binding.editAgregarTarea.text.toString()
            guardarTarea(texto)

        }
    }

    private fun guardarTarea(texto: String) {
        val tarea = Tarea(texto)
        GlobalScope.launch { repo.insertTarea(tarea) }
    }

    private fun obtenerTarea() {
        repo.getTareas().observe(requireActivity()) {
            val tareaComoTexto = it.joinToString("\n") { it.nombre }
            binding.txtInfoAgregada.text = tareaComoTexto
        }
    }
}