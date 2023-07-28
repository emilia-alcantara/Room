package cl.individual.martes250723

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TareaVM(app: Application) : AndroidViewModel(app) {
    private val repositorio: Repositorio

    init {
        repositorio = Repositorio(TareaDatabase.getDatabase(app).getTareaDao())
    }

    fun obtenerTareas(): LiveData<List<Tarea>> {
        return repositorio.getTareas()
    }

    fun insertarTareas(tarea: Tarea) = viewModelScope.launch {
        repositorio.insertTarea(tarea)
    }
}