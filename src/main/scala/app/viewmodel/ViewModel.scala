package app.viewmodel

import app.domain.Model
import app.domain.keyword.Keyword

import scala.collection.mutable.ArrayBuffer

object ViewModel {

  case class ElementHolder(value: String, isSubheader: Boolean)

  private val model = Model

  def addNewKeyword(keywordName: String): Unit = {
    model.addNewKeyword(keywordName)
  }

  def deleteKeyword(keywordName: String): Unit = {
    model.deleteKeyword(keywordName)
  }

  def getAllKeywords(): Iterable[ElementHolder] = {
    convertKeywordToElementHolder(model.getAllKeywords())
  }

  def convertKeywordToElementHolder(from: Array[Keyword]): Array[ElementHolder] = {
    val result = new ArrayBuffer[ElementHolder]

    if(from.length == 0) return result.toArray

    val sorted = from.sortWith(
      _.name.substring(0, 1).toUpperCase() < _.name.substring(0, 1).toUpperCase()
    )

    var letter = sorted.apply(0).name.substring(0, 1).toUpperCase
    result += ElementHolder(value = letter, isSubheader = true)

    for (k <- sorted) {
      val nextLetter = k.name.substring(0, 1).toUpperCase
      if (letter >= nextLetter) {
        result += ElementHolder(value = k.name, isSubheader = false)
      }
      else {
        letter = nextLetter
        result += ElementHolder(value = letter, isSubheader = true)
        result += ElementHolder(value = k.name, isSubheader = false)
      }

    }
    result.toArray
  }

}