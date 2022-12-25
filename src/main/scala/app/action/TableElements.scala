package app.action

import app.viewmodel.ViewModel
import app.viewmodel.ViewModel.ElementHolder
import xitrum.RequestVar
import xitrum.annotation.{GET, POST}

object RVTableElements extends RequestVar[Iterable[ElementHolder]]

@GET("")
class TableShow extends AppAction {
  def execute(): Unit = {
    val tableElements = ViewModel.getAllKeywords()
    RVTableElements.set(tableElements)
    respondView()
  }
}

@GET("add")
class TableShowAddNewElement extends AppAction {
  def execute(): Unit = {
    //    val tableElements = TableElements.findAll()
    val tableElements = ViewModel.getAllKeywords()
    RVTableElements.set(tableElements)
    respondView()
  }
}

@GET("delete")
class TableShowDeleteElement extends AppAction {
  def execute(): Unit = {
    //    val tableElements = TableElements.findAll()
    val tableElements = ViewModel.getAllKeywords()
    RVTableElements.set(tableElements)
    respondView()
  }
}

@POST("add")
class TableElementAdd extends AppAction {
  def execute(): Unit = {
    val title = param("newTableElementTitle")
    ViewModel.addNewKeyword(title)
    flash("Element added")
    redirectTo[TableShow]()
  }
}

@POST("delete")
class TableElementDelete extends AppAction {
  def execute(): Unit = {
    val title = param("tableElementToDeleteTitle")
    ViewModel.deleteKeyword(title)
    flash("Element deleted")
    redirectTo[TableShow]()
  }
}