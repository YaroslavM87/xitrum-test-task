package app.repository

import slick.jdbc.SQLiteProfile.api._

object Connection {

  lazy val url = "jdbc:sqlite:database.db"
  lazy val db = Database.forURL(url)

}