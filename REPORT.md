# Lab Report — CampusCardLab

**Student:** Umar  
**Student ID:** 2026001  
**Package:** kg.iuca.campuscard

---

## Exercise 1 — Horizontal alignment on a Column

The title block ("Campus Card" + name + Student ID) uses  
`horizontalAlignment = Alignment.CenterHorizontally`.

Schedule rows stay full-width and left-aligned inside their own Column.

**Result:** The three title lines are centered horizontally. The schedule list and the bottom action bar remain left-aligned / full-width as expected.

---

## Exercise 2 — SpaceBetween vs Center on a Row

Bottom action row was tested with both arrangements:

1. `Arrangement.SpaceBetween` — buttons stick to the far left and far right.
2. `Arrangement.Center` + `spacedBy(16.dp)` — buttons sit next to each other in the middle.

**Final choice:** `SpaceBetween`.  
Reason: on a phone screen it keeps the two actions clearly separated and easy to reach with different thumbs; centered buttons feel cramped for a simple two-item bar.

---

## Exercise 3 — Vertical alignment inside a schedule Row

Time text uses a larger style (`titleMedium`).  
With `verticalAlignment = Alignment.Top` the time sits higher than the course title and room.  
With `CenterVertically` everything lines up on the same baseline.

**When Top is visibly different:** only when the time text is taller (larger font / more lines). Otherwise the difference is hard to notice.

---

## Exercise 4 — Modifier.weight for flexible middle

Each schedule row gives the course title `Modifier.weight(1f)`.  
Time and room keep their natural width.  
Long titles expand and shrink between the two fixed parts without pushing the room off-screen (tested with a deliberately long fake title).

---

## Exercise 5 — Nested layout refactor

Two extracted composables:

```kotlin
@Composable
fun ProfileHeader(name: String, status: String)

@Composable
fun ScheduleRow(time: String, title: String, room: String)
```

They are called from the main `CampusCardScreen` Column. Behaviour is unchanged.

---

## Exercise 6 — Arrangement experiment write-up

When the outer Column uses `verticalArrangement = Arrangement.SpaceBetween` together with `fillMaxSize()`:

- Header stays at the very top.
- Schedule block is pushed into the middle.
- Action row is forced to the bottom of the screen.

For a short campus card this looks a bit empty in the middle on tall phones.  
`Arrangement.Top` (or the default) keeps everything compact at the top and is more natural for a profile + short list. SpaceBetween is better when you intentionally want a sticky footer.

---

## Screenshots

(Place emulator screenshots here after running the app)

1. Full screen with centered title block  
2. Bottom bar with SpaceBetween  
3. Schedule row with long course title (weight demo)  
4. Overall portrait layout
