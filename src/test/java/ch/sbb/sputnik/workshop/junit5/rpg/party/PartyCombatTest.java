/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2019.
 */

package ch.sbb.sputnik.workshop.junit5.rpg.party;


import ch.sbb.sputnik.workshop.junit5.rpg.party.pg.PlayableCharacter;
import ch.sbb.sputnik.workshop.junit5.rpg.party.pg.Role;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class PartyCombatTest {

  @RegisterExtension PartyTestBase partyTestBase = new PartyTestBase();

  @BeforeAll
  static void beforeAll() {
    System.out.println("PartyCombatTest beforeAll");
  }

  @AfterAll
  static void afterAll() {
    System.out.println("PartyCombatTest afterAll");
  }

  @Test
  void test() {
    // a party of three rogues should attack by backstabbing three times
    Party systemUnderTest = partyTestBase.createParty();
    final ArrayList<PlayableCharacter> playableCharacters =
        new ArrayList<>(
            Arrays.asList(
                partyTestBase.createRogue("1", 0.0),
                partyTestBase.createRogue("2", 0.0),
                partyTestBase.createRogue("3", 0.0)));
    systemUnderTest.setPartyOnlyForTests(playableCharacters);
    final String attack = systemUnderTest.attack();

    assertThat(attack).isEqualTo("Backstab - Backstab - Backstab");
  }

  @Test
  void test2() {
    // a party of two rogues and a mage should attack by backstabbing two times and then fireballing
    Party systemUnderTest = partyTestBase.createParty();
    final ArrayList<PlayableCharacter> playableCharacters =
        new ArrayList<>(
            Arrays.asList(
                partyTestBase.createRogue("1", 0.0),
                partyTestBase.createRogue("2", 0.0),
                partyTestBase.createMage("3", 0.0)));
    systemUnderTest.setPartyOnlyForTests(playableCharacters);
    final String attack = systemUnderTest.attack();

    assertThat(attack).isEqualTo("Fireball - Backstab - Backstab");
  }

  @Test
  void test3() {
    // a party of two rogues, a mage and a warrior should attack by backstabbing two times and then fireballing and
    // smashing
    Party systemUnderTest = partyTestBase.createParty();
    final ArrayList<PlayableCharacter> playableCharacters =
        new ArrayList<>(
            Arrays.asList(
                partyTestBase.createRogue("1", 0.0),
                partyTestBase.createRogue("2", 0.0),
                partyTestBase.createMage("3", 0.0)));
    systemUnderTest.setPartyOnlyForTests(playableCharacters);

    systemUnderTest.hire("4", 0.0, Role.WARRIOR);

    final String attack = systemUnderTest.attack();

    assertThat(attack).isEqualTo("Fireball - Backstab - Backstab - Smash");
  }

  @Test
  void test4() {
    // a party of two rogues, a mage and a warrior should defend by dodging & rolling two times,  then casting "Magic
    // Shiled" and
    // blocking with the shield
    Party systemUnderTest = partyTestBase.createParty();
    final ArrayList<PlayableCharacter> playableCharacters =
        new ArrayList<>(
            Arrays.asList(
                partyTestBase.createRogue("1", 0.0),
                partyTestBase.createRogue("2", 0.0),
                partyTestBase.createMage("3", 0.0)));
    systemUnderTest.setPartyOnlyForTests(playableCharacters);

    systemUnderTest.hire("4", 0.0, Role.WARRIOR);

    final String result = systemUnderTest.defend();

    assertThat(result).isEqualTo("Magic Shield - Dodge & Roll - Dodge & Roll - Shield Block");
  }
}
