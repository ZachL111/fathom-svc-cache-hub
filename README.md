# fathom-svc-cache-hub

`fathom-svc-cache-hub` is a Kotlin project in backend services. Its focus is to design a Kotlin verification harness for cache systems, covering graph analysis, node-edge fixtures, and failure-oriented tests.

## Reason For The Project

The project exists to keep a narrow engineering decision visible and testable. For this repo, that decision is how queue pressure and worker slack should influence a review result.

## Fathom Svc Cache Hub Review Notes

The first comparison I would make is `queue pressure` against `retry load` because it shows where the rule is most opinionated.

## What It Does

- `fixtures/domain_review.csv` adds cases for queue pressure and retry load.
- `metadata/domain-review.json` records the same cases in structured form.
- `config/review-profile.json` captures the read order and the two review questions.
- `examples/fathom-svc-cache-walkthrough.md` walks through the case spread.
- The Kotlin code includes a review path for `queue pressure` and `retry load`.
- `docs/field-notes.md` explains the strongest and weakest cases.

## How It Is Put Together

The fixture data drives the tests. The code stays thin, while `metadata/domain-review.json` and `config/review-profile.json` explain what each case is meant to protect.

The Kotlin code keeps the review rule close to the tests.

## Run It

```powershell
powershell -NoProfile -ExecutionPolicy Bypass -File scripts/verify.ps1
```

## Check It

The same command runs the local verification path. The highest-scoring domain case is `stale` at 191, which lands in `ship`. The most cautious case is `stress` at 82, which lands in `hold`.

## Boundaries

The repository is intentionally scoped to local checks. I would expand it by adding adversarial fixtures before adding features.
