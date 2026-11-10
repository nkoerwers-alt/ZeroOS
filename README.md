# ZeroOS

ZeroOS is a Linux-based mobile operating system project for a Xiaomi Redmi 14C-class ARM64 target. This repository is intentionally structured as a working, buildable prototype that compiles on a Linux host environment while keeping the project ready for later device-specific development.

This repository is currently at milestone 0.1.0:
- boot environment skeleton
- Linux-hosted build system
- init system stub
- service manager stub
- touch driver stub
- home UI prototype
- app placeholders

Important:
- This is not a flashed Android/bootloader image.
- It does not assume Redmi 14C hardware compatibility.
- The goal of this step is to make the project compile cleanly and remain testable before any device-level boot work.

Directory map:
- `boot/boot_config/` - boot configuration and theme values
- `kernel/` - core kernel and system entry logic
- `system/init/` - init process
- `system/services/` - service manager and system services
- `system/drivers/` - device drivers (touch, display, etc.)
- `ui/home/` - home screen UI prototype
- `ui/lockscreen/` - lock screen UI placeholder
- `ui/settings/` - settings UI placeholder
- `ui/notifications/` - notification UI placeholder
- `apps/files/` - file manager app placeholder
- `apps/terminal/` - terminal app placeholder
- `apps/calculator/` - calculator app placeholder
- `build/` - build scripts and generated binary
- `configs/` - configuration headers

Build on Linux:

1. Prepare the environment
   ```bash
   chmod +x build/setup_env.sh
   ./build/setup_env.sh
   ```

2. Build the prototype
   ```bash
   ./build/build.sh
   ```

3. Run the compiled prototype
   ```bash
   ./build/zeroos_app
   ```

This prototype prints a minimal ZeroOS boot sequence and launches the home screen stub.

Hardware note:
- Redmi 14C support is a future milestone.
- Do not flash this binary to hardware.
- All device-level validation must happen only after driver and boot testing on a safe development target.
