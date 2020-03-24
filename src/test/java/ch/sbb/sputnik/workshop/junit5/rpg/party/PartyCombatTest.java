/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2019.
 */

package ch.sbb.sputnik.workshop.junit5.rpg.party;

import ch.sbb.sputnik.workshop.junit5.rpg.party.pg.PlayableCharacter;
import ch.sbb.sputnik.workshop.junit5.rpg.party.pg.Role;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class PartyCombatTest extends PartyTestBase {

  @Test
  public void test() {
    // a party of three rogues should attack by backstabbing three times
    Party systemUnderTest = new Party(db);
    final ArrayList<PlayableCharacter> playableCharacters =
        new ArrayList<>(Arrays.asList(createRogue("1", 0.0), createRogue("2", 0.0), createRogue("3", 0.0)));
    systemUnderTest.setPartyOnlyForTests(playableCharacters);
    final String attack = systemUnderTest.attack();

    assertThat(attack).isEqualTo("Backstab - Backstab - Backstab");
  }

  @Test
  public void test2() {
    // a party of two rogues and a mage should attack by backstabbing two times and then fireballing
    Party systemUnderTest = new Party(db);
    final ArrayList<PlayableCharacter> playableCharacters =
        new ArrayList<>(Arrays.asList(createRogue("1", 0.0), createRogue("2", 0.0), createMage("3", 0.0)));
    systemUnderTest.setPartyOnlyForTests(playableCharacters);
    final String attack = systemUnderTest.attack();

    assertThat(attack).isEqualTo("Fireball - Backstab - Backstab");
  }

  @Test
  public void test3() {
    // a party of two rogues, a mage and a warrior should attack by backstabbing two times and then fireballing and
    // smashing
    Party systemUnderTest = new Party(db);
    final ArrayList<PlayableCharacter> playableCharacters =
        new ArrayList<>(Arrays.asList(createRogue("1", 0.0), createRogue("2", 0.0), createMage("3", 0.0)));
    systemUnderTest.setPartyOnlyForTests(playableCharacters);

    systemUnderTest.hire("4", 0.0, Role.WARRIOR);

    final String attack = systemUnderTest.attack();

    assertThat(attack).isEqualTo("Fireball - Backstab - Backstab - Smash");
  }

  @Test
  public void test4() {
    // a party of two rogues, a mage and a warrior should defend by dodging & rolling two times,  then casting "Magic
    // Shiled" and
    // blocking with the shield
    Party systemUnderTest = new Party(db);
    final ArrayList<PlayableCharacter> playableCharacters =
        new ArrayList<>(Arrays.asList(createRogue("1", 0.0), createRogue("2", 0.0), createMage("3", 0.0)));
    systemUnderTest.setPartyOnlyForTests(playableCharacters);

    systemUnderTest.hire("4", 0.0, Role.WARRIOR);

    final String result = systemUnderTest.defend();

    assertThat(result).isEqualTo("Magic Shield - Dodge & Roll - Dodge & Roll - Shield Block");
  }
}
