package com.d3if4202.emaildata.db

class EmailDataRepository(private val dao: EmailDataDAO) {

    val emaildatas = dao.getAllEmailDatas()

    suspend fun insert(emaildata: EmailData): Long {
        return dao.insertEmailData(emaildata)
    }

    suspend fun update(emaildata: EmailData): Int {
        return dao.updateEmailData(emaildata)
    }

    suspend fun delete(emaildata: EmailData): Int {
        return dao.deleteEmailData(emaildata)
    }

    suspend fun deleteAll(): Int {
        return dao.deleteAll()
    }
}