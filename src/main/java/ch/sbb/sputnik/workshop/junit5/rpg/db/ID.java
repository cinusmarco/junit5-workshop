/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2019.
 */

package ch.sbb.sputnik.workshop.junit5.rpg.db;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.UUID;

public class ID {
  private final UUID uuid;

  public ID(UUID uuid) {
    this.uuid = uuid;
  }

  static ID generate() {
    return new ID(UUID.randomUUID());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;

    if (!(o instanceof ID)) return false;

    ID id = (ID) o;

    return new EqualsBuilder().append(uuid, id.uuid).isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37).append(uuid).toHashCode();
  }

  @Override
  public String toString() {
    return uuid.toString();
  }
}
