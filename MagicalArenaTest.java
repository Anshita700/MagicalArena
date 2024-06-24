import static org.junit.jupiter.api.Assertions.*;

import org.example.MagicalArena;
import org.example.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;
public class MagicalArenaTest {
    private Player playerA;
    private Player playerB;

    @BeforeEach
    public void setup() {
        playerA = new Player(50, 5, 10);
        playerB = new Player(100, 10, 5);
    }

    @Test
    public void testPlayerIsAlive() {
        assertTrue(playerA.isAlive());
        assertTrue(playerB.isAlive());

        playerA.setHealth(0);
        assertFalse(playerA.isAlive());
    }

    @Test
    public void testAttackDamageCalculation() {
        MagicalArena.rand = new Random(1); // Seed for reproducibility

        // First attack: playerA attacks playerB
        MagicalArena.attack(playerA, playerB);
        // Based on the Random seed 1, let's assume attacker rolls 4 (attackDamage: 40)
        // and defender rolls 5 (defenseStrength: 50)
        // No damage should be inflicted
        assertEquals(50, playerA.getHealth());
        assertEquals(100, playerB.getHealth());

        // Second attack: playerB attacks playerA
        MagicalArena.rand = new Random(2); // Different seed for different roll
        MagicalArena.attack(playerB, playerA);
        // Based on the Random seed 2, let's assume attacker rolls 5 (attackDamage: 25)
        // and defender rolls 2 (defenseStrength: 20)
        // Damage inflicted: 25 - 20 = 5
        assertEquals(45, playerA.getHealth());
        assertEquals(100, playerB.getHealth());
    }

    @Test
    public void testAttackNoDamageInflicted() {
        playerA.setAttack(1); // Minimize attack to ensure no damage
        playerB.setStrength(20); // Maximize defense to ensure no damage
        MagicalArena.rand = new Random(1); // Seed for reproducibility

        MagicalArena.attack(playerA, playerB);
        assertEquals(100, playerB.getHealth()); // No damage should be inflicted
    }

    @Test
    public void testHealthDoesNotGoBelowZero() {
        playerA.setAttack(100); // High attack value to ensure defender health drops below zero
        playerB.setStrength(1); // Low defense value to ensure maximum damage
        MagicalArena.rand = new Random(1); // Seed for reproducibility

        MagicalArena.attack(playerA, playerB);
        assertEquals(0, playerB.getHealth()); // Health should not go below zero
    }

    @Test
    public void testRollDice() {
        MagicalArena.rand = new Random(1); // Seed for reproducibility
        int roll = MagicalArena.rollDice();
        assertEquals(4, roll); // Corrected the expected value based on the seed
    }

}
