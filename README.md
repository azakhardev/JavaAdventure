# Facility X – Textová adventura

Jednoduchá hra s textovým rozhraním vytvořená v jazyce Java. Hráč se probouzí v podzemním výzkumném komplexu **Facility
X**, kde je jeho cílem **najít cestu ven**. Při postupu se setkává s překážkami (např. zavalené chodby, zamčené dveře,
přerostlé rostliny), které je nutné překonat pomocí správných předmětů. Hra probíhá ve stylu klasických adventur, kdy
hráč prozkoumává místnosti, sbírá předměty, používá je a interaguje s objekty v prostředí.

### Autor:

**Zacharčenk Artem**  
student Vysoké školy ekonomické v Praze  
Fakulta informatiky a statistiky  
**Obor:** Aplikovaná informatika

### Verze:

**1.0**

## Poznámky k projektu

- Hra neobsahuje NPC – příběh je vyprávěn skrze prostředí a popisy objektů.
- Hlavní důraz je kladen na kombinaci předmětů s objekty ve světě (`CommandUse`) a správný management inventáře (
  `CommandInventory`, `CommandDrop`).
- Objekty v místnostech jsou reprezentovány třídami `Prop` a `Obstacle`, které dědí ze společné abstraktní třídy
  `Entity`.
- Předměty jsou reprezentovány pomocí třídy `Item`, konkrétní speciální předměty jako `Flashlight` pak dědí z ní.
- Herní příkazy jsou zpracovány v balíčku `logic.commands`, kde každá třída implementuje rozhraní `ICommand`.

Change
