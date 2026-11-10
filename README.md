# ZeroOS

ZeroOS is a Linux-based mobile operating system project for a Xiaomi Redmi 14C-class ARM64 target. This repository is intentionally structured as a working, buildable prototype that compiles on a Linux host environment while keeping the project ready for later device-specific development.

This repository currently includes:
- a Linux console prototype
- a futuristic Android app prototype under `android/ZeroOSApp`
- a GitHub Actions workflow to build a debug APK

Build Android app prototype without a PC:
1. Open the GitHub repository.
2. Go to the Actions tab.
3. Run the workflow named `Build ZeroOS Android APK`.
4. Download the artifact `ZeroOS-debug-apk` when the workflow completes.
5. Transfer the APK to your phone and tap to install.

Important:
- This is not a real OS image and does not replace Android.
- It only runs as an Android app prototype.
- It does not boot the phone or flash anything.
- It is a visual prototype that demonstrates the ZeroOS shell and design direction.

Android project location:
- `android/ZeroOSApp/`

ZeroOS app prototype features:
- black futuristic UI
- cyan accents
- touchable app tiles
- status bar and home view
- app launcher styling

Build locally on a Linux machine:
```bash
cd android/ZeroOSApp
gradle wrapper
./gradlew :app:assembleDebug
```
