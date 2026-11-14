# Architecture — TDDLetsPlay

Current-state map. Descriptive, not aspirational; see `docs/adr/` for why.

## Shape

```
TDDLetsPlay/  (Gradle, single module)
├── build.gradle     java toolchain → JDK 25; junit4 + junit-jupiter test deps
├── settings.gradle  rootProject.name = 'TDDLetsPlay'
├── gradlew(bat)     checked-in wrapper
└── src/
    ├── main/java/com/hamzajg/tddletsplay/
    │   ├── finances/    SavingsAccountYear, Bootstrap (demo main)
    │   └── games/       bowling/Game.java, tictactoe/Game.java
    └── test/java/...    SavingsAccountYearTest, BowlingGameTest, TicTacToeGameTest
```

## The katas

| Kata | Class | What it models |
|---|---|---|
| Savings | `finances/SavingsAccountYear` | compound interest: year-end balance, rollover start balance, fixed rate |
| Bowling | `games/bowling/Game` | frame scoring: spares, strikes, perfect game, input validation |
| Tic-tac-toe | `games/tictactoe/Game` | turn alternation, win/draw detection, board bounds |

## Design

- **Test-driven by construction.** Production classes contain only what
  the tests required — no speculative API. The tests ARE the spec.
- **No dependencies in main.** Only JDK + `var`; all deps are test-scoped
  (JUnit 4.13.1 + Jupiter 5.8.1).
- **Toolchain split.** Gradle itself runs on the CI's JDK 17;
  `java.toolchain.languageVersion = 25` makes compilation target a JDK 25
  (auto-resolved). Deliberate result of the fleet SDK sweep.

## Verification

CI: `sh gradlew test --no-daemon` on JDK 17 → HTML report at
`build/reports/tests/test/index.html`. Local demo:
`java -cp build/classes/java/main com.hamzajg.tddletsplay.finances.Bootstrap`.
