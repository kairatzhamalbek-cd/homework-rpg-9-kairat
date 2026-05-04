package com.narxoz.rpg;
import com.narxoz.rpg.artifact.*;
import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.vault.ChronomancerEngine;
import com.narxoz.rpg.vault.VaultRunResult;

import java.util.List;


public class Main {

    public static void main(String[] args) {
        System.out.println("=== Homework 9 Demo: Visitor + Memento ===");

        Inventory inventory1 = new Inventory();
        inventory1.addArtifact(new Weapon("Sword", 100, 5, 10));
        inventory1.addArtifact(new Potion("Healing Potion", 50, 1, 20));
        inventory1.addArtifact(new Scroll("Fire Scroll", 70, 1, "Fireball"));
        inventory1.addArtifact(new Ring("Magic Ring", 120, 1, 5));
        inventory1.addArtifact(new Armor("Steel Armor", 150, 10, 15));

        Inventory inventory2 = new Inventory();
        inventory2.addArtifact(new Weapon("Dagger", 30, 2, 5));
        inventory2.addArtifact(new Potion("Weak Potion", 10, 1, 5));
        inventory2.addArtifact(new Scroll("Dark Scroll", 40, 1, "dark curse"));
        inventory2.addArtifact(new Ring("Cursed Ring", 20, 1, -3));
        inventory2.addArtifact(new Armor("Old Armor", 25, 8, 3));

        Hero hero1 = new Hero("Arthas", 100, 50, 15, 10, 100, inventory1);
        Hero hero2 = new Hero("Jaina", 80, 100, 10, 5, 200, inventory2);

        List<Hero> party = List.of(hero1, hero2);

        ChronomancerEngine engine = new ChronomancerEngine();
        VaultRunResult result = engine.runVault(party);

        System.out.println("\nFinal Result:");
        System.out.println(result);
    }
}
