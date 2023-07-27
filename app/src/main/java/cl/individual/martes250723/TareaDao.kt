package cl.individual.martes250723

import androidx.room.Dao
import androidx.room.Insert
import cl.individual.martes250723.Tarea

@Dao
interface TareaDao {

    @Insert
    suspend fun insertarTarea(tarea: Tarea)

    // Listo por ahora, ya que solo nos enfocaremos primero en la inserción.
}