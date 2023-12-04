package com.example.roomdata.Data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


@Dao
interface SiswaDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(siswa: Siswa)
    @Update
    suspend fun Update(siswa: Siswa)
    @Delete
    suspend fun delete(siswa: Siswa)
    @Query("SELECT * from tblSiswa WHERE id = :id")
    fun getSiswa(id: Int): Flow<Siswa>
    @Query("SELECT * from tblSiswa ORDER BY nama ASC")
    fun getALLSiswa(): Flow<List<Siswa>>
}