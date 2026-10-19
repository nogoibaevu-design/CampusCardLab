# CampusCardLab

Jetpack Compose lab: campus profile card + today's schedule.

**Course:** Introduction to Android with Jetpack Compose  
**Package:** `kg.iuca.campuscard`  
**Min SDK:** 24

## How to open

1. Clone the repo or download ZIP.
2. Open the project root in Android Studio (Ladybug / Koala or newer).
3. Wait for Gradle sync.
4. Create/start an AVD (API 34 recommended).
5. Run the app (green triangle).

## What is implemented

- Profile header (avatar placeholder + name + status) using `Row` + nested `Column`
- "Today" section with three schedule slots
- Each slot is a `Row` (time | course title with `weight(1f)` | room)
- Bottom action bar with two buttons (`Map` / `Show QR`)
- Extracted composables: `ProfileHeader`, `ScheduleRow`
- All graded exercises (see `REPORT.md`)

## Project structure

```
app/src/main/java/kg/iuca/campuscard/MainActivity.kt   # all UI
app/src/main/res/                                      # themes, strings
REPORT.md                                              # answers for Exercises 1-6
```

No networking, no database, no navigation graph — only nested Row/Column as required.
