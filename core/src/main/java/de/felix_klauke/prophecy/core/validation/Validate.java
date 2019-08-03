/*
 * Copyright (c) 2017 Felix Klauke
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package de.felix_klauke.prophecy.core.validation;

/**
 * @author Felix Klauke (info@felix-klauke.de)
 */
public class Validate {

  /**
   * Prevent instantiation.
   */
  private Validate() {
    throw new AssertionError("Can not instantiate Validate.");
  }

  /**
   * Check if an object is null and throw an exception otherwise.
   *
   * @param object The object.
   * @param message The message.
   */
  public static void checkNotNull(Object object, String message) {
    if (object == null) {
      throw new IllegalArgumentException(message);
    }
  }

  /**
   * Check if an b is what you expect and throw an exception otherwise.
   *
   * @param b The state to check.
   * @param b1 The expected state.
   * @param message the message.
   */
  public static void checkState(boolean b, boolean b1, String message) {
    if (b != b1) {
      throw new IllegalStateException(message);
    }
  }
}
