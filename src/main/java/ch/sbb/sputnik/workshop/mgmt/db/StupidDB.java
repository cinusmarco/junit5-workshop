/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2019.
 */

package ch.sbb.sputnik.workshop.mgmt.db;

import ch.sbb.sputnik.workshop.mgmt.party.pg.PlayableCharacter;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class StupidDB {

  ArrayList<PlayableCharacter> playableCharacters;

  public StupidDB() {
    playableCharacters = new ArrayList<>();
  }

  public ID add(PlayableCharacter playableCharacter) {
    final ID id = ID.generate();
    playableCharacter.setId(id);
    playableCharacters.add(playableCharacter);
    return id;
  }

  public void remove(ID id) {
    if (playableCharacters.removeIf(playableCharacter -> playableCharacter.getId().equals(id))) {
      throw new NoSuchElementException(String.format("No PG with ID %s in DB", id));
    }
  }

  public List<PlayableCharacter> playableCharacters() {
    return playableCharacters;
  }

  public void setPlayableCharacters(ArrayList<PlayableCharacter> playableCharacters) {
    this.playableCharacters = playableCharacters;
  }
}
