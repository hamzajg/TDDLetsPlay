# ADR 0001 — Initial architecture

Date: 2026-11-13 (baseline recorded retroactively)
Status: accepted (describes what is built)

## Context

A TDD kata repo: three small exercises (savings, bowling, tic-tac-toe)
where the test suite defines the required behaviour.

## Decisions

1. **Tests are the specification.** Each kata grew from its test suite;
   production code contains only what examples demanded. Rationale: the
   repo's purpose is demonstrating TDD — speculative code would betray it.
2. **One kata per package.** `finances/`, `games/bowling/`,
   `games/tictactoe/` — flat, discoverable, no shared framework. Rationale:
   KISS; each kata is independently readable.
3. **Stdlib Java only in main.** `var` is the newest feature used; zero
   runtime dependencies. Rationale: kata clarity — nothing to learn but
   the domain rules.
4. **JUnit 4 + Jupiter 5 side by side.** Both on the test classpath;
   tests use whichever fits. Rationale: pragmatic — matches however each
   kata's tests were written.
5. **Gradle wrapper checked in; toolchain JDK 25.** `gradlew` is the only
   supported entry; compilation targets Java 25 via toolchain while CI's
   launcher JDK is 17. Rationale: reproducible builds + modern bytecode
   without requiring contributors to install JDK 25 manually (toolchain
   auto-resolution).
6. **Bootstrap demo included.** `finances/Bootstrap` runs a 60-year
   projection so the kata is runnable, not just testable.

## Consequences

- Adding features means writing the failing test first — enforced by
  convention.
- The JDK17-launcher/JDK25-compile split can confuse newcomers; it's
  documented here and in AGENTS.md.
- No build.gradle plugins beyond `java` — deliberately minimal.
