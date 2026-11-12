# TDDLetsPlay

Three small test-driven katas in Java, each grown from its test suite:

| Kata | Source | Tests | What it covers |
|---|---|---|---|
| Savings account | [`finances/SavingsAccountYear`](src/main/java/com/hamzajg/tddletsplay/finances/SavingsAccountYear.java) | [`SavingsAccountYearTest`](src/test/java/com/hamzajg/tddletsplay/finances/SavingsAccountYearTest.java) | Compound interest across years: ending balance, next year's starting balance, a stable interest rate |
| Bowling | [`games/bowling/Game`](src/main/java/com/hamzajg/tddletsplay/games/bowling/Game.java) | [`BowlingGameTest`](src/test/java/com/hamzajg/tddletsplay/games/bowling/BowlingGameTest.java) | The classic bowling scorer: gutter game, all ones, one spare, one strike, a perfect 300, and rejecting a roll outside 0–10 or a 22nd roll |
| Tic-tac-toe | [`games/tictactoe/Game`](src/main/java/com/hamzajg/tddletsplay/games/tictactoe/Game.java) | [`TicTacToeGameTest`](src/test/java/com/hamzajg/tddletsplay/games/tictactoe/TicTacToeGameTest.java) | Turn taking, move application, detecting a winning row, finishing on a full board as a draw, and rejecting a move outside the board |

The point of the repository is the tests: every rule is pinned by an example,
and the production classes contain only what those examples required.

## Requirements

- JDK 17 (the code uses `var`)
- No Gradle install needed — the wrapper is checked in (Gradle 8.2)

## Run the tests

```bash
sh gradlew test
```

The HTML report is written to `build/reports/tests/test/index.html`.

## Run the savings demo

`Bootstrap` deposits $10,000 and prints the starting balance for each of the
next 60 years. It uses the no-argument constructor, so the interest rate is 0
and the balance stays at $10,000; construct `SavingsAccountYear(10_000, 10)`
instead to see it compound:

```bash
sh gradlew classes
java -cp build/classes/java/main com.hamzajg.tddletsplay.finances.Bootstrap
```

## Layout

```
src/main/java/com/hamzajg/tddletsplay/
  finances/    SavingsAccountYear, Bootstrap
  games/bowling/     Game
  games/tictactoe/   Game
src/test/java/...    one test class per kata
```

## Continuous integration

[`.github/workflows/ci.yml`](.github/workflows/ci.yml) runs `gradlew test` on
JDK 17 for every push and pull request to `master`.

## License

See [LICENSE](LICENSE).
