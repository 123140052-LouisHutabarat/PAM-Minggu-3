package org.example.project

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import minggu3pam.composeapp.generated.resources.Res
import minggu3pam.composeapp.generated.resources.luis
import org.jetbrains.compose.resources.painterResource

@Composable
fun App() {
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFFF5F5F5)
        ) {
            MyProfileApp()
        }
    }
}

@Composable
fun MyProfileApp() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        ProfileCard(
            name = "Louis Hutabarat",
            bio = "Mahasiswa Teknik Informatika NIM 123140052. Tertarik pada Mobile Dev & IoT.",
            email = "louis.123140052@student.itera.ac.id",
            phone = "+62 813-9780-3190",
            location = "Bandar Lampung, Indonesia"
        )
    }
}

@Composable
fun ProfileCard(
    name: String,
    bio: String,
    email: String,
    phone: String,
    location: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.Top
        ) {
            ProfileAvatar()

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = bio,
                    fontSize = 14.sp,
                    color = Color(0xFF616161),
                    textAlign = TextAlign.Start
                )

                Spacer(modifier = Modifier.height(12.dp))

                HorizontalDivider(color = Color(0xFFE0E0E0), thickness = 1.dp)

                Spacer(modifier = Modifier.height(12.dp))

                InfoItem(icon = Icons.Default.Email, text = email)
                InfoItem(icon = Icons.Default.Phone, text = phone)
                InfoItem(icon = Icons.Default.LocationOn, text = location)

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = { /* Aksi edit profil */ },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF673AB7))
                ) {
                    Text("Edit Profile", color = Color.White)
                }
            }
        }
    }
}


@Composable
fun ProfileAvatar(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(100.dp)
            .clip(CircleShape)
            .background(Color(0xFFEDE7F6)),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(Res.drawable.luis),
            contentDescription = "Foto Profil",
            modifier = Modifier
                .size(92.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun InfoItem(icon: ImageVector, text: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFF673AB7),
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(text = text, fontSize = 13.sp, color = Color(0xFF616161))
    }
}