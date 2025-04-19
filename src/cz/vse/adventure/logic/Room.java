package cz.vse.adventure.logic;

import cz.vse.adventure.logic.entities.Entity;
import cz.vse.adventure.logic.items.Item;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Trida Prostor - popisuje jednotlivé prostory (místnosti) hry
 * <p>
 * Tato třída je součástí jednoduché textové hry.
 * <p>
 * "Prostor" reprezentuje jedno místo (místnost, prostor, ..) ve scénáři hry.
 * Prostor může mít sousední prostory připojené přes východy. Pro každý východ
 * si prostor ukládá odkaz na sousedící prostor.
 *
 * @author Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova
 * @version pro školní rok 2016/2017
 */
public class Room {

    private String name;
    private String description;
    private Set<Room> exits = new HashSet<>();
    private List<Entity> entities = new ArrayList<Entity>();
    private List<Item> items = new ArrayList<Item>();


    /**
     * Vytvoření prostoru se zadaným popisem, např. "kuchyň", "hala", "trávník
     * před domem"
     *
     * @param name        nazev prostoru, jednoznačný identifikátor, jedno slovo nebo
     *                    víceslovný název bez mezer.
     * @param description Popis prostoru.
     */
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Vytvoření prostoru se zadaným popisem, např. "kuchyň", "hala", "trávník
     * před domem"
     *
     * @param name        nazev prostoru, jednoznačný identifikátor, jedno slovo nebo
     *                    víceslovný název bez mezer.
     * @param description Popis prostoru.
     * @param entities    Entity, které se budou v místnosti nacházet
     */
    public Room(String name, String description, List<Entity> entities) {
        this.name = name;
        this.description = description;
        exits = new HashSet<>();
        this.entities = entities;
    }

    /**
     * Definuje východ z prostoru (sousední/vedlejsi prostor). Vzhledem k tomu,
     * že je použit Set pro uložení východů, může být sousední prostor uveden
     * pouze jednou (tj. nelze mít dvoje dveře do stejné sousední místnosti).
     * Druhé zadání stejného prostoru tiše přepíše předchozí zadání (neobjeví se
     * žádné chybové hlášení). Lze zadat též cestu ze do sebe sama.
     *
     * @param vedlejsi prostor, který sousedi s aktualnim prostorem.
     */
    public void setExit(Room vedlejsi) {
        exits.add(vedlejsi);
    }

    public List<Entity> getEntities() {
        return this.entities;
    }

    public List<Item> getItems() {
        return items;
    }

    public Entity getEntityWithName(String name) {
        for (Entity e : entities) {
            if (e.getName().equals(name)) {
                return e;
            }
        }
        return null;
    }

    /**
     * Metoda equals pro porovnání dvou prostorů. Překrývá se metoda equals ze
     * třídy Object. Dva prostory jsou shodné, pokud mají stejný název. Tato
     * metoda je důležitá z hlediska správného fungování seznamu východů (Set).
     * <p>
     * Bližší popis metody equals je u třídy Object.
     *
     * @param o object, který se má porovnávat s aktuálním
     * @return hodnotu true, pokud má zadaný prostor stejný název, jinak false
     */


    @Override
    public boolean equals(Object o) {
        // porovnáváme zda se nejedná o dva odkazy na stejnou instanci
        if (this == o) {
            return true;
        }
        // porovnáváme jakého typu je parametr 
        if (!(o instanceof Room)) {
            return false;    // pokud parametr není typu Prostor, vrátíme false
        }
        // přetypujeme parametr na typ Prostor 
        Room druhy = (Room) o;

        //metoda equals třídy java.util.Objects porovná hodnoty obou názvů. 
        //Vrátí true pro stejné názvy a i v případě, že jsou oba názvy null,
        //jinak vrátí false.

        return (java.util.Objects.equals(this.name, druhy.name));
    }

    /**
     * metoda hashCode vraci ciselny identifikator instance, ktery se pouziva
     * pro optimalizaci ukladani v dynamickych datovych strukturach. Pri
     * prekryti metody equals je potreba prekryt i metodu hashCode. Podrobny
     * popis pravidel pro vytvareni metody hashCode je u metody hashCode ve
     * tride Object
     */
    @Override
    public int hashCode() {
        int vysledek = 3;
        int hashNazvu = java.util.Objects.hashCode(this.name);
        vysledek = 37 * vysledek + hashNazvu;
        return vysledek;
    }


    /**
     * Vrací název prostoru (byl zadán při vytváření prostoru jako parametr
     * konstruktoru)
     *
     * @return název prostoru
     */
    public String getName() {
        return name;
    }

    /**
     * Vrací "dlouhý" popis prostoru, který může vypadat následovně: Jsi v
     * mistnosti/prostoru vstupni hala budovy VSE na Jiznim meste. vychody:
     * chodba bufet ucebna
     *
     * @return Dlouhý popis prostoru
     */
    public String getLongDescription() {
        return "You are in room " + name + ":" + description + ".\n"
                + getExitsDescription();
    }

    /**
     * Vrací textový řetězec, který popisuje sousední východy, například:
     * "vychody: hala ".
     *
     * @return Popis východů - názvů sousedních prostorů
     */
    private String getExitsDescription() {
        String vracenyText = "exits:";
        for (Room sousedni : exits) {
            vracenyText += " " + sousedni.getName();
        }
        return vracenyText;
    }

    /**
     * Vrací prostor, který sousedí s aktuálním prostorem a jehož název je zadán
     * jako parametr. Pokud prostor s udaným jménem nesousedí s aktuálním
     * prostorem, vrací se hodnota null.
     *
     * @param nazevSouseda Jméno sousedního prostoru (východu)
     * @return Prostor, který se nachází za příslušným východem, nebo hodnota
     * null, pokud prostor zadaného jména není sousedem.
     */
    public Room getSiblingRoom(String nazevSouseda) {
        List<Room> hledaneProstory =
                exits.stream()
                        .filter(sousedni -> sousedni.getName().equals(nazevSouseda))
                        .collect(Collectors.toList());
        if (hledaneProstory.isEmpty()) {
            return null;
        } else {
            return hledaneProstory.get(0);
        }
    }

    /**
     * Vrací kolekci obsahující prostory, se kterými tento prostor sousedí.
     * Takto získaný seznam sousedních prostor nelze upravovat (přidávat,
     * odebírat východy) protože z hlediska správného návrhu je to plně
     * záležitostí třídy Prostor.
     *
     * @return Nemodifikovatelná kolekce prostorů (východů), se kterými tento
     * prostor sousedí.
     */
    public Collection<Room> getExits() {
        return Collections.unmodifiableCollection(exits);
    }
}
