package com.example.healthkey.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthkey.data.model.NavIcon
import com.example.healthkey.data.model.NavItem
import com.example.healthkey.ui.theme.*

@Composable
fun TagChip(
    text: String,
    bgColor: Color = TagGreenBg,
    textColor: Color = TagGreenText,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .background(bgColor, RoundedCornerShape(20.dp))
            .padding(horizontal = 10.dp, vertical = 4.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = text,
            color = textColor,
            fontSize = 11.sp,
            fontWeight = FontWeight.Medium,
        )
    }
}

@Composable
fun InfoRow(label: String, value: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = label,
            color = TextSecondary,
            style = MaterialTheme.typography.bodyMedium,
        )
        Text(
            text = value,
            color = OnSurface,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Medium,
        )
    }
    Divider(color = Divider, thickness = 0.5.dp)
}

@Composable
fun StatBox(
    value: String,
    label: String,
    headerColor: Color = PrimaryGreen,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .background(headerColor.copy(alpha = 0.25f), RoundedCornerShape(10.dp))
            .padding(horizontal = 12.dp, vertical = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = value,
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = label,
            color = Color.White.copy(alpha = 0.85f),
            fontSize = 11.sp,
            fontWeight = FontWeight.Normal,
        )
    }
}

@Composable
fun AvatarCircle(
    initials: String,
    size: Int = 52,
    bgColor: Color = Color.White.copy(alpha = 0.25f),
    textColor: Color = Color.White,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .size(size.dp)
            .background(bgColor, CircleShape),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = initials,
            color = textColor,
            fontSize = (size / 2.6).sp,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Composable
fun SectionCard(
    title: String,
    headerColor: Color = PrimaryGreen,
    content: @Composable ColumnScope.() -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(CardGreen, RoundedCornerShape(12.dp))
            .border(1.dp, CardBorder, RoundedCornerShape(12.dp)),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(headerColor, RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
                .padding(horizontal = 16.dp, vertical = 10.dp),
        ) {
            Text(title, color = Color.White, style = MaterialTheme.typography.titleLarge)
        }
        Column(modifier = Modifier.padding(16.dp), content = content)
    }
}

@Composable
fun AppBottomNav(
    items: List<NavItem>,
    selectedIndex: Int,
    activeColor: Color = PrimaryGreen,
    onSelect: (Int) -> Unit,
) {
    Surface(shadowElevation = 8.dp, color = Color.White) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .navigationBarsPadding()
                .height(64.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            items.forEachIndexed { index, item ->
                BottomNavItem(
                    item = item,
                    isSelected = selectedIndex == index,
                    activeColor = activeColor,
                    onClick = { onSelect(index) },
                )
            }
        }
    }
}

@Composable
private fun BottomNavItem(
    item: NavItem,
    isSelected: Boolean,
    activeColor: Color,
    onClick: () -> Unit,
) {
    val tint = if (isSelected) activeColor else TextSecondary
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(horizontal = 12.dp, vertical = 4.dp),
    ) {
        Icon(navIcon(item.icon), contentDescription = item.label, tint = tint, modifier = Modifier.size(22.dp))
        Text(item.label, color = tint, fontSize = 11.sp, fontWeight = FontWeight.Medium)
        Spacer(Modifier.height(2.dp))
        Box(
            Modifier
                .size(if (isSelected) 5.dp else 0.dp)
                .background(if (isSelected) activeColor else Color.Transparent, CircleShape)
        )
    }
}

@Composable
private fun navIcon(icon: NavIcon): ImageVector = when (icon) {
    NavIcon.HOME -> Icons.Default.Home
    NavIcon.CROPS -> Icons.Default.Grass
    NavIcon.MARKET -> Icons.Default.Store
    NavIcon.EARTH -> Icons.Default.Public
    NavIcon.NUTRITION -> Icons.Default.FoodBank
    NavIcon.DISCOVER -> Icons.Default.Search
    NavIcon.PROFILE_NAV -> Icons.Default.Person
}

@Composable
fun ScreenHeader(
    title: String,
    color: Color,
    onBack: (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {},
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color)
            .statusBarsPadding()
            .padding(horizontal = 4.dp, vertical = 4.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
        ) {
            if (onBack != null) {
                IconButton(onClick = onBack) {
                    Icon(Icons.Default.ArrowBack, "Back", tint = Color.White)
                }
            } else {
                Spacer(Modifier.width(8.dp))
            }
            Text(
                text = title,
                color = Color.White,
                style = MaterialTheme.typography.displaySmall,
                modifier = Modifier.weight(1f).padding(start = if (onBack == null) 8.dp else 0.dp),
            )
            actions()
        }
    }
}
