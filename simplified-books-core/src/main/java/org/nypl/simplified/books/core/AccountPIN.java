package org.nypl.simplified.books.core;

import com.io7m.jnull.NullCheck;
import com.io7m.jnull.Nullable;
import org.nypl.simplified.files.FileUtilities;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

/**
 * The type of account PINs.
 *
 * Account PINs are expected to be 4 digit numbers, but the type does not
 * (currently) enforce this fact.
 */

public final class AccountPIN implements Serializable
{
  private static final long serialVersionUID = 1L;
  private final String value;

  /**
   * Construct a PIN.
   *
   * @param in_value The raw PIN value
   */

  public AccountPIN(
    final String in_value)
  {
    this.value = NullCheck.notNull(in_value);
  }

  @Override public boolean equals(
    final @Nullable Object obj)
  {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (this.getClass() != obj.getClass()) {
      return false;
    }
    final AccountPIN other = (AccountPIN) obj;
    return this.value.equals(other.value);
  }

  @Override public int hashCode()
  {
    return this.value.hashCode();
  }

  @Override public String toString()
  {
    return this.value;
  }

  /**
   * Write the pin to the {@code f_tmp}, atomically renaming {@code f_tmp} to
   * {@code f} on success. For platform independence, {@code f_tmp} and {@code
   * f} should be in the same directory.
   *
   * @param file_pin     The resulting file
   * @param file_pin_tmp The temporary file
   *
   * @throws IOException On I/O errors
   */

  public void writeToFile(
    final File file_pin,
    final File file_pin_tmp)
    throws IOException
  {
    FileUtilities.fileWriteUTF8Atomically(file_pin, file_pin_tmp, this.value);
  }
}
