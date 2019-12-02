/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2019.
 */

package ch.sbb.sputnik.workshop.mgmt.party.pg;

import ch.sbb.sputnik.workshop.mgmt.db.ID;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public abstract class PlayableCharacter {
  private ID id;
  private String name;
  private double pay;

  public ID getId() {
    return id;
  }

  public void setId(ID id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPay() {
    return pay;
  }

  public void setPay(double pay) {
    this.pay = pay;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;

    if (!(o instanceof PlayableCharacter)) return false;

    PlayableCharacter playableCharacter = (PlayableCharacter) o;

    return new EqualsBuilder().append(id, playableCharacter.id).isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37).append(id).toHashCode();
  }

  public abstract String attack();
}
