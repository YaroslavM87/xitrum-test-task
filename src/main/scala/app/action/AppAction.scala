package app.action

import xitrum.{Action, FutureAction}

trait AppAction extends FutureAction {
  override def layout: String = renderViewNoLayout[AppAction]()
}
