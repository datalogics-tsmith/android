package org.nypl.simplified.books.core;

/**
 * The main interface to carry out operations relating to accounts.
 */

public interface AccountsControllerType
{
  /**
   * @return {@code true} if the user is currently logged into an account.
   */

  boolean accountIsLoggedIn();

  /**
   * Get login details delivering them to the given listener immediately.
   *
   * @param listener The listener
   */

  void accountGetCachedLoginDetails(
    AccountGetCachedCredentialsListenerType listener);

  /**
   * Start loading books, delivering results to the given {@code listener}.
   *
   * @param listener The listener
   */

  void accountLoadBooks(
    AccountDataLoadListenerType listener);

  /**
   * Log in, delivering results to the given {@code listener}.
   *
   * @param credentials The account credentials
   * @param listener    The listener
   */

  void accountLogin(
    AccountCredentials credentials,
    AccountLoginListenerType listener);

  /**
   * Log out, delivering results to the given {@code listener}.
   *
   * @param listener The listener
   */

  void accountLogout(
    AccountLogoutListenerType listener);

  /**
   * Sync books, delivering results to the given {@code listener}.
   *
   * @param listener The listener
   */

  void accountSync(
    AccountSyncListenerType listener);

  /**
   * Activate the device with the currently logged in account (if you are logged in).
   */
  void accountActivateDevice();
}
