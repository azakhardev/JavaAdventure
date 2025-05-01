# GUIDEBOOK.md

## 🕹️ O hře

Tato textová adventura vás zavede do opuštěného komplexu, kde musíte přežít, hledat předměty a rozplétat tajemství,
která se skrývají v temnotě. Svět je plný zamčených dveří, porouchaných mechanismů, a stop zanechaných předchozími
obyvateli.

Vaším cílem je dostat se z komplexu — a možná cestou zjistit, co se zde vlastně stalo.

---

## 🎯 Cíl hry

Hráč se probouzí v neznámém prostředí a nemá žádné vybavení. Musí prozkoumávat okolí, sbírat a používat předměty, číst
poznámky a dokumenty a řešit "hádanky", které odemykají další části herního světa.

---

## 💬 Příkazy

Hra se ovládá pomocí textových příkazů zadávaných do konzole.

Základní dostupné příkazy:

| Příkaz                   | Popis                                                   |
|--------------------------|---------------------------------------------------------|
| `look_around`            | Popíše aktuální místnost a její obsah.                  |
| `inventory`              | Vypíše seznam předmětů v inventáři.                     |
| `go [místnost]`          | Přesune hráče do jiné místnosti (např. `go kitchen`).   |
| `pick [předmět]`         | Vezme předmět z místnosti (např. `pick fuse`).          |
| `drop [předmět]`         | Položí předmět z inventáře do místnosti.                |
| `use [předmět] [objekt]` | Pokusí se použít předmět na nějaký objekt v místnosti.  |
| `interact [objekt]`      | Hráč se pokusí nějak interagovat s objekty v místnosti. |
| `help`                   | Zobrazí nápovědu k příkazům.                            |
| `combine [item] [item]`  | Pokusí se zkombinovat dva itemy.                        |
| `description [objekt?]`  | Popíše aktuální místnost nebo objekt v místnosti.       |
| `inspect [item]`         | Popíše předmět z inventáře hráče.                       |
| `end`                    | Ukončí hru.                                             |

---

## 📦 Předměty

Předměty ve hře mají různé objemy a funkce. Některé lze použít na konkrétních místech, jiné slouží jako klíče k hádankám
nebo dokumenty s nápovědou.

Např.:

- **fuse** – obnova elektřiny
- **key** – odemykání zamčených objektů
- **journal_page1** – obsahuje část hesla

---

## 🧠 Hádanky

Ve hře se objevují logické překážky, např. zničené dveře, zamčené skříně, nebo potřeba obnovit elektrické připojení.
Řešení těchto situací závisí na:

- správné kombinaci předmětů
- čtení dokumentů, které obsahují části přístupového kódu (např. z `Password.password`)
- postupu ve správném pořadí

---

## 🛠️ Doporučení pro hraní

- Důkladně čtěte texty, které hra vypisuje.
- Pečlivě spravujte inventář – některé předměty mají vyšší objem.
- Před použitím předmětu se nejprve rozhlédněte pomocí `look_around`.
- Všímejte si čísel v poznámkách – mohou být součástí hesla.
- Používejte `help`, pokud si nevíte rady s ovládáním.

---
