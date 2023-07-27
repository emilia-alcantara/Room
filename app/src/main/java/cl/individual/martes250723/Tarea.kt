package cl.individual.martes250723

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "tabla_tarea")
data class Tarea(val nombre: String) {
    @PrimaryKey (autoGenerate = true) var id:Long = 0
}