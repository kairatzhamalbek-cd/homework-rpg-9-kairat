package com.narxoz.rpg.artifact;

public class EnchantmentScanner implements ArtifactVisitor{
    @Override
    public void visit(Weapon weapon) {
        System.out.println("Weapon " + weapon.getName() + " has attack bonus: +" + weapon.getAttackBonus());
    }

    @Override
    public void visit(Potion potion) {
        System.out.println("Potion " + potion.getName() + " heals: +" + potion.getHealing() + " HP");
    }

    @Override
    public void visit(Scroll scroll) {
        System.out.println("Scroll " + scroll.getName() + " contains spell: " + scroll.getSpellName());
    }

    @Override
    public void visit(Ring ring) {
        System.out.println("Ring " + ring.getName() + " grants magic bonus: " + ring.getMagicBonus());    }

    @Override
    public void visit(Armor armor) {
        System.out.println("Armor " + armor.getName() + " gives defense: +" + armor.getDefenseBonus());
    }
}
