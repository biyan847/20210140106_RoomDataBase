package com.example.roomdata.repositori

import com.example.roomdata.Data.Siswa
import com.example.roomdata.Data.SiswaDao
import kotlinx.coroutines.flow.Flow


class OfflineRepositoriSiswa (private val siswaDao: SiswaDao):RepositoriSiswa{

    override fun getAllSiswaStream(): Flow<List<Siswa>> {
        return siswaDao.getALLSiswa() }

    override fun getSiswaStream(id: Int): Flow<Siswa?> {
        return siswaDao.getSiswa(id) }

    override suspend fun insertSiswa(siswa: Siswa) {
        return siswaDao.insert(siswa) }

    override suspend fun deleteSiswa(siswa: Siswa) {
        return siswaDao.delete(siswa) }

    override suspend fun updateSiswa(siswa: Siswa) {
        return siswaDao.Update(siswa) }

}