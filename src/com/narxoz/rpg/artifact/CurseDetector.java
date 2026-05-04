package com.narxoz.rpg.artifact;

public class CurseDetector implements ArtifactVisitor {

    private int cursedCount = 0;

    public int getCursedCount() {
        return cursedCount;
    }

    @Override
    public void visit(Weapon weapon) {
        if (weapon.getValue() < 50) {
            System.out.println("⚠ Cursed weapon detected: " + weapon.getName());
            cursedCount++;
        }
    }

    @Override
    public void visit(Potion potion) {
        if (potion.getHealing() < 10) {
            System.out.println("⚠ Suspicious potion: " + potion.getName());
            cursedCount++;
        }
    }

    @Override
    public void visit(Scroll scroll) {
        if (scroll.getSpellName().toLowerCase().contains("dark")) {
            System.out.println("⚠ Dark magic scroll: " + scroll.getName());
            cursedCount++;
        }
    }

    @Override
    public void visit(Ring ring) {
        if (ring.getMagicBonus() < 0) {
            System.out.println("⚠ Cursed ring: " + ring.getName());
            cursedCount++;
        }
    }

    @Override
    public void visit(Armor armor) {
        if (armor.getDefenseBonus() < 5) {
            System.out.println("⚠ Weak (possibly cursed) armor: " + armor.getName());
            cursedCount++;
        }
    }
}
