package app.repository.keyword

import app.domain.keyword.Keyword
import slick.jdbc.SQLiteProfile.api._

trait KeywordInterpolation { this: KeywordDao.type =>

  def readAll: DBIO[Vector[Keyword]] = sql"select * from keyword".as[Keyword]

  def insert(keyword: Keyword): DBIO[Int] = sqlu"insert into keyword values (${keyword.id}, ${keyword.name})"

  def remove(name: String): DBIO[Int] = sqlu"delete from keyword where name = $name"

}