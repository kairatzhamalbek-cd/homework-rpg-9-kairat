package com.narxoz.rpg.artifact;

public class GoldAppraiser implements ArtifactVisitor{
    private int totalValue = 0;

    public int getTotalValue() {
        return totalValue;
    }

    @Override
    public void visit(Weapon weapon) {
        System.out.println("Appraising weapon: " + weapon.getName() + " value=" + weapon.getValue());
        totalValue += weapon.getValue();
    }

    @Override
    public void visit(Potion potion) {
        System.out.println("Appraising potion: " + potion.getName() + " value=" + potion.getValue());
        totalValue += potion.getValue();
    }

    @Override
    public void visit(Scroll scroll) {
        System.out.println("Appraising scroll: " + scroll.getName() + " value=" + scroll.getValue());
        totalValue += scroll.getValue();
    }

    @Override
    public void visit(Ring ring) {
        System.out.println("Appraising ring: " + ring.getName() + " value=" + ring.getValue());
        totalValue += ring.getValue();
    }

    @Override
    public void visit(Armor armor) {
        System.out.println("Appraising armor: " + armor.getName() + " value=" + armor.getValue());
        totalValue += armor.getValue();
    }
}
