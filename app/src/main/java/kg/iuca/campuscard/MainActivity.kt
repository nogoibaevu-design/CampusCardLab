package kg.iuca.campuscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kg.iuca.campuscard.ui.theme.CampusCardLabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CampusCardLabTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CampusCardScreen()
                }
            }
        }
    }
}

@Composable
fun CampusCardScreen() {
    // Exercise 6: try Arrangement.SpaceBetween here to push header / schedule / actions apart
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Top,
        // Exercise 1: title block is centered; schedule stays full-width below
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Title block (centered by parent horizontalAlignment)
        Text(
            text = "Campus Card",
            style = MaterialTheme.typography.headlineMedium
        )
        Text(text = "Ada Lovelace")
        Text(text = "Student ID: 2026001")

        Spacer(modifier = Modifier.height(20.dp))

        // Header: avatar + name/status
        ProfileHeader(
            name = "Ada Lovelace",
            status = "In class · Building B"
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Schedule section — left-aligned relative to the screen
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Today",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(12.dp))

            ScheduleRow(
                time = "09:00",
                title = "CS101 Intro",
                room = "Lab 3"
            )
            ScheduleRow(
                time = "11:00",
                title = "MATH210 Calculus",
                room = "A-204"
            )
            // Exercise 4: long title to demonstrate weight
            ScheduleRow(
                time = "14:00",
                title = "Soft Skills and Professional Communication Workshop",
                room = "Hall 1"
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        // Bottom action bar
        // Exercise 2: final choice = SpaceBetween
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = { /* Map */ }) {
                Text("Map")
            }
            OutlinedButton(onClick = { /* QR */ }) {
                Text("Show QR")
            }
        }
    }
}

/**
 * Exercise 5 — extracted header composable.
 */
@Composable
fun ProfileHeader(name: String, status: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // Avatar placeholder
        Box(
            modifier = Modifier
                .size(56.dp)
                .background(MaterialTheme.colorScheme.primaryContainer)
        )
        Column {
            Text(
                text = name,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = status,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

/**
 * Exercise 5 — extracted schedule row.
 * Exercise 3: verticalAlignment can be Top or CenterVertically.
 * Exercise 4: title uses weight(1f).
 */
@Composable
fun ScheduleRow(
    time: String,
    title: String,
    room: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        // Exercise 3: Top makes the larger time text sit higher;
        // CenterVertically lines everything up.
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = time,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.width(56.dp)
        )
        Text(
            text = title,
            style = MaterialTheme.typography.bodyLarge,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 8.dp)
        )
        Text(
            text = room,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CampusCardPreview() {
    CampusCardLabTheme {
        CampusCardScreen()
    }
}
