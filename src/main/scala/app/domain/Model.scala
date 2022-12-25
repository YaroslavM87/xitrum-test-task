package app.domain

import app.domain.keyword.Keyword
import app.repository.keyword.KeywordDao

import scala.collection.mutable.ArrayBuffer

object Model {

  private val keywordDao = KeywordDao

  private val keywordStorage = new ArrayBuffer[Keyword]
  private var storageActualized = false

  def addNewKeyword(keywordName: String): Unit = {
    if(storageActualized) {
      var primeIndex = 0
      for (k <- keywordStorage) if(k.id > primeIndex) primeIndex = k.id
      primeIndex += 1

      val newKeyword = Keyword(primeIndex, keywordName)
      keywordStorage += newKeyword
      keywordDao.save(newKeyword)

      println("Model: Element added")

    } else println("Model: Keyword temporary storage does not contain actual data")
  }

  def deleteKeyword(keywordName: String): Unit = {
    val option = keywordStorage.find( k => k.name == keywordName)

    if(option.nonEmpty) {
      keywordDao.delete(option.get)
      keywordStorage.remove(keywordStorage.indexOf(option.get))
      println("Model: Element deleted")

    } else println("Model: There is no such element")
  }

  def getAllKeywords(): Array[Keyword] = {
    if(!storageActualized) {
      keywordStorage ++= keywordDao.getAll
      storageActualized = true
    }
    keywordStorage.toArray
  }

}