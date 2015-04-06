package org.nypl.simplified.books.core;

import com.io7m.jfunctional.OptionType;

public interface BooksStatusCacheType
{
  void booksStatusClearAll();

  OptionType<BookStatusType> booksStatusGet(
    BookID id);

  void booksStatusUpdate(
    BookID id,
    BookStatusType s);

  void booksStatusUpdateOwned(
    BookID id);
}