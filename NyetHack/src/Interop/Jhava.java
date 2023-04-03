package Interop;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Jhava {

    private int hitPoints = 52489112;
    private String greeting = "BLARGH";

    public static void main(String[] args) {
        System.out.println(HeroKt.makeProclamation());
        System.out.println("Spells:");
        SpellBook spellBook = new SpellBook();
        for (String spell : spellBook.spells) {
            System.out.println(spell);
        }
        System.out.println("Max spell count: " + SpellBook.MAX_SPELL_COUNT);
        SpellBook.getSpellbookGreeting();
    }
    @NotNull
    public String utterGreeting() {
        return greeting;
    }

    @Nullable
    public String determineFriendshipLevel() {
        return null;
    }

    public int getHitPoints() {
        return hitPoints;
    }
    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public void offerFood() {
        HeroKt.handOverFood("pizza");
    }
}
