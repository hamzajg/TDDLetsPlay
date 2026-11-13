# AGENTS.md — TDDLetsPlay

Guidance for AI agents (and humans) working in this repository.

## Project

Three small test-driven katas in Java, each grown from its test suite —
the tests are the point; production classes contain only what the examples
required. Learning repo.
Stack: Java (Gradle wrapper checked in), JUnit 4 + JUnit 5 (Jupiter).

## Commands

Verified 2026-11-13 against CI (`.github/workflows/ci.yml`) and README.

| Task | Command |
|---|---|
| Test | `sh gradlew test --no-daemon` (CI: JDK 17) |
| Compile classes | `sh gradlew classes` |
| Savings demo | `java -cp build/classes/java/main com.hamzajg.tddletsplay.finances.Bootstrap` |
| Test report | `build/reports/tests/test/index.html` |

Requires: JDK to run Gradle (CI uses 17). **Compilation toolchain is
JDK 25** (`build.gradle` → `java.toolchain.languageVersion = 25`) — Gradle
resolves/downloads it; local runs may auto-provision.

## Architecture

```
src/main/java/com/hamzajg/tddletsplay/
  finances/SavingsAccountYear.java   compound interest across years
  finances/Bootstrap.java            demo main (60-year projection)
  games/bowling/Game.java            classic bowling scorer
  games/tictactoe/Game.java          turn taking, win/draw detection
src/test/java/...                    one test class per kata
build.gradle                         java toolchain 25, junit deps
settings.gradle                      rootProject.name only
```

The three katas:

| Kata | Rules pinned by tests |
|---|---|
| Savings account | ending balance, next-year start, stable rate; ctor arg = interest rate (default ctor → 0%) |
| Bowling | gutter game, all ones, spare, strike, perfect 300, reject roll outside 0–10 or a 22nd roll |
| Tic-tac-toe | turns, move application, winning row, full-board draw, reject off-board move |

## Conventions

- **Tests first, code minimal.** Every rule is pinned by an example; add
  behaviour only when a test demands it. Don't gold-plate the katas.
- Plain Java, `var` used — no frameworks, no Spring, no DI.
- One kata per package (`finances/`, `games/bowling/`, `games/tictactoe/`).
- Mixed JUnit: `junit:junit:4.13.1` + `junit-jupiter:5.8.1` both on the
  test classpath — match whichever the neighbouring test uses.

## Landmines

- **Default branch is `master`, not `main`.**
- Toolchain mismatch is deliberate: Gradle runs on JDK 17 (CI) but compiles
  with a JDK 25 toolchain — don't "fix" either number without understanding
  the auto-provisioning.
- `Bootstrap` uses the no-arg ctor → interest rate 0 → flat $10,000; use
  `new SavingsAccountYear(10_000, 10)` to see compounding.
- Wrapper is checked in (`gradlew`) — use `sh gradlew`, not a system
  `gradle`.

## Agent rules

- Branch from `master`; name branches `feat/*`, `fix/*`, `chore/*`, `docs/*`.
- Docs-only changes still go through a PR; never commit to `master` directly.
- Verify before claiming: `sh gradlew test --no-daemon` and report the
  real result.
- Keep changes minimal and consistent with surrounding code. No drive-by
  refactors.
- New kata behaviour needs a test first — that's the repo's whole point.
- Update AGENTS.md / docs/ARCHITECTURE.md when adding a kata or changing
  the toolchain.
