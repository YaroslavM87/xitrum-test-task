package app.repository.keyword

import app.domain.Dao
import app.domain.keyword.Keyword
import app.repository.Connection
import scala.concurrent.duration.Duration
import scala.concurrent.Await

object KeywordDao extends App with KeywordInterpolation with KeywordTransfer with Dao[Keyword] {

  override def getAll: Vector[Keyword] = {
    Await.result(Connection.db.run(readAll), Duration.Inf)
  }

  override def save(entity: Keyword): Int = {
    Await.result(Connection.db.run(insert(entity)), Duration.Inf)
  }

  override def delete(entity: Keyword): Int = {
    Await.result(Connection.db.run(remove(entity.name)), Duration.Inf)
  }

  def printAll(): Unit = {
    for (keyword <- getAll)
      println("* " + keyword.id + "\t" + keyword.name)
  }

}