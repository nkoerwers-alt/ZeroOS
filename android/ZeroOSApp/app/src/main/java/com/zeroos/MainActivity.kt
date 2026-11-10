package com.zeroos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

private val ZeroCyan = Color(0xFF00D9FF)
private val ZeroBlack = Color(0xFF050A12)
private val ZeroDark = Color(0xFF0A1118)
private val ZeroPanel = Color(0xFF101B26)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme(
                colorScheme = MaterialTheme.colorScheme.copy(
                    primary = ZeroCyan,
                    surface = ZeroBlack,
                    background = ZeroBlack,
                    onPrimary = Color.White,
                    onBackground = Color.White,
                    onSurface = Color.White,
                ),
                typography = MaterialTheme.typography,
                shapes = MaterialTheme.shapes,
            ) {
                Surface(modifier = Modifier.fillMaxSize(), color = ZeroBlack) {
                    ZeroOSHomeScreen()
                }
            }
        }
    }
}

@Composable
fun ZeroOSHomeScreen() {
    var selectedApp by remember { mutableStateOf("Home") }
    val timeText = remember { SimpleDateFormat("HH:mm", Locale.getDefault()) }
    val dateText = remember { SimpleDateFormat("EEE, MMM d", Locale.getDefault()) }
    val currentTime = timeText.format(Date())
    val currentDate = dateText.format(Date())

    val alpha by animateFloatAsState(
        targetValue = if (selectedApp == "Home") 1f else 0.7f,
        animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing),
        label = "homeAlpha"
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(ZeroBlack, ZeroDark, ZeroBlack)
                )
            )
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    selectedApp = "Home"
                })
            }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 18.dp, vertical = 22.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "ZEROOS",
                    color = ZeroCyan,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                )
                Text(
                    text = currentTime,
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                )
            }

            Text(
                text = currentDate,
                color = Color(0xFFB8EAF7),
                fontSize = 12.sp,
                modifier = Modifier.padding(top = 6.dp)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(230.dp)
                    .clip(RoundedCornerShape(28.dp))
                    .background(ZeroPanel.copy(alpha = 0.82f))
                    .shadow(16.dp, RoundedCornerShape(28.dp))
                    .padding(18.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Welcome back",
                        color = ZeroCyan,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Your device. Your system.",
                        color = Color.White.copy(alpha = 0.8f),
                        fontSize = 14.sp,
                    )
                    Spacer(modifier = Modifier.height(22.dp))
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(14.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        AppTile(title = "Files", accent = "F", selected = selectedApp == "Files") {
                            selectedApp = "Files"
                        }
                        AppTile(title = "Calc", accent = "C", selected = selectedApp == "Calc") {
                            selectedApp = "Calc"
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(14.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        AppTile(title = "Terminal", accent = "T", selected = selectedApp == "Terminal") {
                            selectedApp = "Terminal"
                        }
                        AppTile(title = "Settings", accent = "S", selected = selectedApp == "Settings") {
                            selectedApp = "Settings"
                        }
                    }
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(22.dp))
                    .background(ZeroPanel.copy(alpha = 0.78f))
                    .padding(16.dp)
            ) {
                Text(
                    text = "System",
                    color = ZeroCyan,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Touch ready: active",
                    color = Color.White.copy(alpha = 0.9f),
                    fontSize = 12.sp,
                )
                Text(
                    text = "Target: Xiaomi Redmi 14C (unverified)",
                    color = Color.White.copy(alpha = 0.75f),
                    fontSize = 12.sp,
                )
                Text(
                    text = "Theme: Cyan / Black / Futuristic",
                    color = Color.White.copy(alpha = 0.75f),
                    fontSize = 12.sp,
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(18.dp))
                    .background(ZeroCyan.copy(alpha = 0.16f))
                    .padding(horizontal = 14.dp, vertical = 10.dp)
            ) {
                Text(
                    text = "ZeroOS 0.1.0 • Home • ${selectedApp}",
                    color = ZeroCyan,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                )
            }
        }
    }
}

@Composable
fun AppTile(
    title: String,
    accent: String,
    selected: Boolean,
    onClick: () -> Unit,
) {
    val bg = if (selected) ZeroCyan.copy(alpha = 0.18f) else ZeroDark.copy(alpha = 0.8f)
    val pulse = if (selected) 1f else 0.9f
    val animatedScale by animateFloatAsState(
        targetValue = if (selected) 1.06f else 1f,
        animationSpec = tween(durationMillis = 200, easing = FastOutSlowInEasing),
        label = "tileScale"
    )

    Box(
        modifier = Modifier
            .size(102.dp, 78.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(bg)
            .clickable { onClick() }
            .shadow(if (selected) 10.dp else 4.dp, RoundedCornerShape(20.dp))
            .padding(10.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Box(
                modifier = Modifier
                    .size(30.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(ZeroCyan.copy(alpha = 0.25f)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = accent,
                    color = ZeroCyan,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = title,
                color = Color.White,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
            )
        }
    }
}
