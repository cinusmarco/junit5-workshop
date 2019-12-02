/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2019.
 */

package ch.sbb.sputnik.workshop.abbreviator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Abbreviator {

  public String abbreviate(String string) {
    Pattern p = Pattern.compile("\\w");
    String[] tokens = string.split("\\w");

    char[] chars = string.substring(1, string.length() - 1).toCharArray();
    int size = 0;
    List<String> toAdd = new ArrayList<>();
    for (char c : chars) {
      ++size;
      if (!p.matcher(String.valueOf(c)).find()) {
        toAdd.add(String.valueOf(c));
      }
    }
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(string.substring(0, 1));
    for (String s : toAdd) {
      stringBuffer.append(s);
    }
    stringBuffer.append(string.substring(string.length() - 1));
    return stringBuffer.toString();
  }
}
