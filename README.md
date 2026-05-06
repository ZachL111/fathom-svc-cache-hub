# fathom-svc-cache-hub

`fathom-svc-cache-hub` is a Kotlin project for Backend services. It turns design a Kotlin verification harness for cache systems, covering graph analysis, node-edge fixtures, and failure-oriented tests into a small local model with readable fixtures and a direct verification command.

## Reading Fathom Svc Cache Hub

Start with the README, then open `metadata/project.json` to check the constants behind the examples. After that, `fixtures/cases.csv` shows the compact path and `examples/extended_cases.csv` gives a wider look at the same rule.

## What It Does

- Includes extended examples for queue pressure, including `recovery` and `degraded`.
- Documents bounded workers tradeoffs in `docs/operations.md`.
- Runs locally with a single verification command and no external credentials.
- Stores project constants and verification metadata in `metadata/project.json`.
- Adds a repository audit script that checks structure before running the language verifier.

## Purpose

I use this kind of project to make a rule visible before adding more machinery around it. The important part here is not the size of the codebase. It is that the input signals, scoring rule, fixture data, and expected output can all be checked in one sitting.

## Files Worth Reading

- `src`: primary implementation
- `tests`: verification harness
- `fixtures`: compact golden scenarios
- `examples`: expanded scenario set
- `metadata`: project constants and verification metadata
- `docs`: operations and extension notes
- `scripts`: local verification and audit commands

## Design Sketch

The core is a scoring model over demand, capacity, latency, risk, and weight. That keeps job state, retry rules, and queue pressure in one explicit decision path. The threshold is 172, with risk penalty 6, latency penalty 2, and weight bonus 5. The Kotlin version keeps data classes and model logic close together for a JVM-friendly core.

## Usage

```powershell
powershell -NoProfile -ExecutionPolicy Bypass -File scripts/verify.ps1
```

This runs the language-level build or test path against the compact fixture set.

## Fixture Notes

`surge` is the first example I would inspect because it lands on the `accept` path with a score of 208. The broader file also keeps `degraded` at 21 and `recovery` at 236, which gives the model a useful low-to-high spread.

## Verification

```powershell
powershell -NoProfile -ExecutionPolicy Bypass -File scripts/audit.ps1
```

The audit command checks repository structure and README constraints before it delegates to the verifier.

## Limits

The scoring model is simple by design. More domain-specific behavior should be added through explicit adapters or extra fixture classes rather than hidden constants.

## Next Directions

- Add a short report command that prints the score breakdown for a single scenario.
- Add malformed input fixtures so the failure path is as visible as the happy path.
- Split the scoring constants into a typed configuration object and validate it before use.
- Add one more backend services fixture that focuses on a malformed or borderline input.

## Setup

Clone the repository, enter the directory, and run the verifier. No database server, cloud account, or token is required.
