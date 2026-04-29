# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

**HealthKey** is a **Kotlin Multiplatform (KMP)** project using **Compose Multiplatform** for shared UI across Android and iOS. It is a health/agri platform with four user roles: **Farmer**, **Doctor**, **Consumer**, and **Athlete**.

- **Main module:** `:composeApp`
- **Root package:** `com.example.healthkey`
- **Android min SDK:** 24 | **Target/Compile SDK:** 36
- **Key versions:** Kotlin 2.3.20, Compose Multiplatform 1.10.3, AGP 8.11.2, Gradle 8.14.3

## Build Commands

```bash
# Debug APK
gradlew.bat :composeApp:assembleDebug

# Run all tests (all targets)
gradlew.bat :composeApp:allTests

# Run Android unit tests only
gradlew.bat :composeApp:testDebugUnitTest

# Run Android instrumentation tests (requires connected device/emulator)
gradlew.bat :composeApp:connectedDebugAndroidTest

# Lint
gradlew.bat :composeApp:lint

# Clean
gradlew.bat :composeApp:clean
```

On macOS/Linux use `./gradlew` instead of `gradlew.bat`.

## Architecture

### Package Layout (commonMain)

```
com.example.healthkey/
├── core/
│   ├── navigation/      # AppNavigation.kt — Voyager Navigator entry point
│   └── theme/           # Color.kt, Typography.kt, Shape.kt, Theme.kt
├── data/
│   ├── model/           # Domain models + SampleData (Models.kt, User.kt, Patient.kt, …)
│   ├── repository/      # Repository interfaces (AuthRepository, FarmerRepository, …)
│   └── NutriGuideEngine.kt
├── domain/usecase/      # UseCase<Params, Returns> marker interface + NoParams
├── presentation/
│   ├── auth/            # LoginScreen, LoginViewModel, RegisterScreen, RegisterViewModel
│   ├── farmer/          # FarmerHomeScreen/VM, Earth2Screen/VM
│   ├── doctor/          # DoctorHomeScreen/VM, PatientsScreen/VM, ChatScreen/VM
│   ├── consumer/        # ConsumerHomeScreen/VM, ProductsScreen/VM, NutriGuideScreen/VM
│   └── shared/          # ProfileScreen/VM, MedicalFileScreen/VM
└── App.kt               # Root @Composable (currently placeholder, real entry via AppNavigation)
```

> `ui/` and `viewmodel/` top-level packages are legacy scaffolding — use `presentation/` and `core/` instead.

### Navigation

Uses **Voyager** (`cafe.adriel.voyager:voyager-navigator:1.0.0`). Every screen is a `Screen` class; navigate with `navigator.push(TargetScreen())` / `navigator.pop()`. `AppNavigation()` in `core/navigation/` is the composable root, starting at `LoginScreen`.

### State Management

Each screen has a paired `ViewModel` (extends `androidx.lifecycle.ViewModel`). State is exposed as `StateFlow<UiState>` via `MutableStateFlow`. Pattern: one `data class XyzUiState` + one `XyzViewModel` per screen, both in the same file.

### Theme

Canonical theme lives in `core/theme/`:
- `Color.kt` — named brand colors (`PrimaryGreen`, `DoctorBlue`, `AthleteTeal`, tag/chat/progress colors)
- `Typography.kt` — `AppTypography` with all 15 MD3 text styles, sizing from 11–24 sp
- `Shape.kt` — `AppShapes` (extraSmall=4dp → extraLarge=24dp)
- `Theme.kt` — `HealthKeyTheme {}` wrapping `MaterialTheme` with the above three

Always wrap screens in `HealthKeyTheme`. Use `MaterialTheme.colorScheme.*` tokens rather than raw color values.

### Data / Domain

- **Models** in `data/model/`: `User`, `Patient`, `Farmer`, `Product`, `Message`, plus UI-only models in `Models.kt` (`CropCard`, `MealItem`, `ClimateData`, etc.). `SampleData` object in `Models.kt` holds hardcoded preview data.
- **Repositories** in `data/repository/`: interfaces only (e.g. `AuthRepository`). Implementations are not yet wired up.
- **Use cases** in `domain/usecase/`: implement `UseCase<Params, Returns>` where `Returns` is typically `Result<T>`.

### Platform Abstraction

`expect`/`actual` for platform-specific code:
- `commonMain`: `expect interface Platform`, `expect fun getPlatform()`
- `androidMain`: `actual class AndroidPlatform`
- `iosMain`: iOS actual implementation

### Testing

- Shared unit tests: `commonTest/kotlin/`
- Android instrumentation: `androidTest/` with Espresso
- Test framework: `kotlin.test` + JUnit 4