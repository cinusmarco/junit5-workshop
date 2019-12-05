/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2019.
 */

package ch.sbb.sputnik.workshop.abbreviator;

public class Abbreviator {

  public String abbreviate(String string) {

    String[] tokens = string.split("\\W");
    StringBuilder stringBuilder = new StringBuilder();

    int currentPointer = 0;

    for (String token : tokens) {
      if (token.length() < 4) {
        stringBuilder.append(token);
      } else {
        int size = token.length() - 2;

        stringBuilder.append(token, 0, 1);
        stringBuilder.append(size);
        stringBuilder.append(token.substring(token.length() - 1));
      }
      currentPointer = currentPointer + token.length();
      if (string.length() > currentPointer) {
        stringBuilder.append(string.charAt(currentPointer));
      }
      ++currentPointer;
    }
    return stringBuilder.toString();
  }
}
