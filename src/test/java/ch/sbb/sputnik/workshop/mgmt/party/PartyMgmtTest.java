/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2019.
 */

package ch.sbb.sputnik.workshop.mgmt.party;

import ch.sbb.sputnik.workshop.mgmt.db.ID;
import ch.sbb.sputnik.workshop.mgmt.party.pg.Mage;
import ch.sbb.sputnik.workshop.mgmt.party.pg.PlayableCharacter;
import ch.sbb.sputnik.workshop.mgmt.party.pg.Rogue;
import ch.sbb.sputnik.workshop.mgmt.party.pg.Role;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class PartyMgmtTest extends PartyTestBase {

  @Test
  public void testHiring() {
    Party systemUnderTest = new Party(db);
    final ID ptorId = systemUnderTest.hire("Ptor", 42.0, Role.MAGE);

    assertThat(db.playableCharacters()).hasSize(1);

    final Optional<PlayableCharacter> optionalPtor =
        db.playableCharacters().stream()
            .filter(playableCharacter -> playableCharacter.getId().equals(ptorId))
            .findAny();

    assertThat(optionalPtor.isPresent()).isTrue();
    assertThat(optionalPtor.get().getId()).isEqualTo(ptorId);
  }

  @Test
  public void testHiring2() {
    Party systemUnderTest = new Party(db);
    final Rogue kmer = createRogue("Kmer", 69.0);
    db.add(kmer);
    final ID ptorId = systemUnderTest.hire("Ptor", 42.0, Role.MAGE);

    assertThat(db.playableCharacters()).hasSize(2);

    final Optional<PlayableCharacter> optionalPtor =
        db.playableCharacters().stream()
            .filter(playableCharacter -> playableCharacter.getId().equals(ptorId))
            .findAny();

    assertThat(optionalPtor.isPresent()).isTrue();
    assertThat(optionalPtor.get().getId()).isEqualTo(ptorId);
  }

  @Test
  public void testFiring() {
    Party systemUnderTest = new Party(db);
    final Rogue kmer = createRogue("Kmer", 69.0);
    final Mage ptor = createMage("Ptor", 42.0);

    db.setPlayableCharacters(new ArrayList<>(Arrays.asList(kmer, ptor)));
    final ID ptorId = systemUnderTest.fire(kmer.getId());

    assertThat(db.playableCharacters()).hasSize(1);

    final Optional<PlayableCharacter> optionalPtor =
        db.playableCharacters().stream()
            .filter(playableCharacter -> playableCharacter.getId().equals(ptorId))
            .findAny();

    assertThat(optionalPtor.isPresent()).isFalse();
  }

  @Test
  public void testComputePay() {
    Party systemUnderTest = new Party(db);
    final Rogue kmer = createRogue("Kmer", 69.0);
    final Mage ptor = createMage("Ptor", 42.0);

    db.setPlayableCharacters(new ArrayList<>(Arrays.asList(kmer, ptor)));

    double actual = systemUnderTest.getCost();
    assertThat(actual).isEqualTo(111.0);
  }
}
