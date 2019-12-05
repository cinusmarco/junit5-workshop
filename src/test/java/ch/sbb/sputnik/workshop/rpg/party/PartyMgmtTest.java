/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2019.
 */

package ch.sbb.sputnik.workshop.rpg.party;

import ch.sbb.sputnik.workshop.rpg.db.ID;
import ch.sbb.sputnik.workshop.rpg.party.pg.Mage;
import ch.sbb.sputnik.workshop.rpg.party.pg.PlayableCharacter;
import ch.sbb.sputnik.workshop.rpg.party.pg.Rogue;
import ch.sbb.sputnik.workshop.rpg.party.pg.Role;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class PartyMgmtTest {

  @RegisterExtension PartyTestBase partyTestBase = new PartyTestBase();

  @Test
  void testHiring() {
    Party systemUnderTest = partyTestBase.createParty();
    final ID ptorId = systemUnderTest.hire("Ptor", 42.0, Role.MAGE);

    assertThat(partyTestBase.playableCharacters()).hasSize(1);

    final Optional<PlayableCharacter> optionalPtor =
        partyTestBase.playableCharacters().stream()
            .filter(playableCharacter -> playableCharacter.getId().equals(ptorId))
            .findAny();

    assertThat(optionalPtor.isPresent()).isTrue();
    assertThat(optionalPtor.get().getId()).isEqualTo(ptorId);
  }

  @Test
  void testHiring2() {
    Party systemUnderTest = partyTestBase.createParty();
    final Rogue kmer = partyTestBase.createRogue("Kmer", 69.0);
    partyTestBase.setPlayableCharacters(new ArrayList<>(Arrays.asList(kmer)));
    final ID ptorId = systemUnderTest.hire("Ptor", 42.0, Role.MAGE);

    assertThat(partyTestBase.playableCharacters()).hasSize(2);

    final Optional<PlayableCharacter> optionalPtor =
        partyTestBase.playableCharacters().stream()
            .filter(playableCharacter -> playableCharacter.getId().equals(ptorId))
            .findAny();

    assertThat(optionalPtor.isPresent()).isTrue();
    assertThat(optionalPtor.get().getId()).isEqualTo(ptorId);
  }

  @Test
  void testFiring() {
    Party systemUnderTest = partyTestBase.createParty();
    final Rogue kmer = partyTestBase.createRogue("Kmer", 69.0);
    final Mage ptor = partyTestBase.createMage("Ptor", 42.0);

    partyTestBase.setPlayableCharacters(new ArrayList<>(Arrays.asList(kmer, ptor)));
    final ID ptorId = systemUnderTest.fire(kmer.getId());

    assertThat(partyTestBase.playableCharacters()).hasSize(1);

    final Optional<PlayableCharacter> optionalPtor =
        partyTestBase.playableCharacters().stream()
            .filter(playableCharacter -> playableCharacter.getId().equals(ptorId))
            .findAny();

    assertThat(optionalPtor.isPresent()).isFalse();
  }

  @Test
  void testComputePay() {
    Party systemUnderTest = partyTestBase.createParty();
    final Rogue kmer = partyTestBase.createRogue("Kmer", 69.0);
    final Mage ptor = partyTestBase.createMage("Ptor", 42.0);

    partyTestBase.setPlayableCharacters(new ArrayList<>(Arrays.asList(kmer, ptor)));

    double actual = systemUnderTest.getCost();
    assertThat(actual).isEqualTo(111.0);
  }
}
