/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2019.
 */

package ch.sbb.sputnik.workshop.mumbling;

import org.apache.commons.lang3.StringUtils;

import java.util.stream.Collectors;

public class Mumbling {
  public String accum(String s) {
    final int[] i = {0};
    return s.codePoints()
        .mapToObj(c -> String.valueOf((char) c))
        .map(s1 -> s1.toUpperCase() + StringUtils.repeat(s1.toLowerCase(), i[0]++))
        .collect(Collectors.joining("-"));
  }
}
