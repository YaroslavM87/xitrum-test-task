package app.domain

trait Dao[T] {

  def getAll: Vector[T]

  def save(entity: T): Int

  def delete(entity: T): Int

}