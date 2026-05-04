package com.narxoz.rpg.vault;
import com.narxoz.rpg.artifact.*;
import com.narxoz.rpg.combatant.Hero;
import java.util.List;
import com.narxoz.rpg.combatant.HeroMemento;
import com.narxoz.rpg.memento.Caretaker;



public class ChronomancerEngine {


    public VaultRunResult runVault(List<Hero> party) {
        System.out.println("=== Entering Chronomancer's Vault ===");

        int totalArtifacts = 0;
        int mementosCreated = 0;
        int restored = 0;

        for (Hero hero : party) {

            System.out.println("\nHero enters: " + hero);

            Inventory inventory = hero.getInventory();

            GoldAppraiser goldVisitor = new GoldAppraiser();
            EnchantmentScanner enchantVisitor = new EnchantmentScanner();
            CurseDetector curseVisitor = new CurseDetector();

            System.out.println("\n-- Appraising artifacts --");
            inventory.accept(goldVisitor);
            inventory.accept(enchantVisitor);
            inventory.accept(curseVisitor);

            totalArtifacts += inventory.size();

            Caretaker caretaker = new Caretaker();
            HeroMemento snapshot = hero.createMemento();
            caretaker.save(snapshot);
            mementosCreated++;

            System.out.println("\nSnapshot saved!");

            System.out.println("\n⚔ Trap activated! Hero takes damage...");
            hero.takeDamage(30);
            hero.spendGold(20);

            System.out.println("After trap: " + hero);

            HeroMemento restoredState = caretaker.undo();
            if (restoredState != null) {
                hero.restoreFromMemento(restoredState);
                restored++;
                System.out.println("⏪ Time rewind! Hero restored: " + hero);
            }
        }

        System.out.println("\n=== Vault run complete ===");

        return new VaultRunResult(totalArtifacts, mementosCreated, restored);
    }
}
