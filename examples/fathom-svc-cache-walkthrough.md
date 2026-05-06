# Fathom Svc Cache Hub Walkthrough

I use this file as a small checklist before changing the Kotlin implementation.

| Case | Focus | Score | Lane |
| --- | --- | ---: | --- |
| baseline | queue pressure | 170 | ship |
| stress | retry load | 82 | hold |
| edge | worker slack | 159 | ship |
| recovery | session drift | 146 | ship |
| stale | queue pressure | 191 | ship |

Start with `stale` and `stress`. They create the widest contrast in this repository's fixture set, which makes them better review anchors than the middle cases.

`stale` is the optimistic case; use it to make sure the scoring path still rewards strong signal.
