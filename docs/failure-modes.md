# Failure Modes

For `fathom-svc-cache-hub`, I would look first for these mistakes:

- `queue pressure` cases moving lanes without a matching threshold change.
- `worker slack` scoring higher after drag increases.
- Duplicate fixture ids hiding a stale golden row.
- README examples drifting away from the verifier.

The local checks are intentionally strict about these cases.
