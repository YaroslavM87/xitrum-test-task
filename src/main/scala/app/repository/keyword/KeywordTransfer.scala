package app.repository.keyword

import app.domain.keyword.Keyword
import slick.jdbc.GetResult

trait KeywordTransfer { this: KeywordDao.type =>

  implicit val getKeywordModelResult: GetResult[Keyword] =
    GetResult(r =>
      Keyword(r.nextInt(), r.nextString())
  )

}