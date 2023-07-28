package cl.individual.martes250723

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import cl.individual.martes250723.Tarea

@Dao
interface TareaDao {

    @Insert
    suspend fun insertarTarea(tarea: Tarea)

    @Query ("SELECT * FROM tabla_tarea ORDER BY id ASC")
    fun getTareas(): LiveData<List<Tarea>>


}