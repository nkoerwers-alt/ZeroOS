#include <stdio.h>
#include <unistd.h>

#include "boot/boot_config/boot_config.h"
#include "configs/zeroos_config.h"
#include "kernel/zeroos_types.h"
#include "system/init/init.h"
#include "system/services/service_manager.h"
#include "system/drivers/touch_driver.h"
#include "ui/home/home_screen.h"

int main(void) {
    printf("\n========================================\n");
    printf("= %s v%s =\n", ZEROOS_NAME, ZEROOS_VERSION);
    printf("= Target: %s =\n", ZEROOS_TARGET);
    printf("= Arch: %s | Kernel: %s =\n", ZEROOS_ARCH, ZEROOS_KERNEL);
    printf("========================================\n\n");

    printf("[%s] Boot splash: %s\n", BOOT_SCREEN_TITLE, BOOT_SCREEN_SUBTITLE);
    fflush(stdout);
    usleep(BOOT_DELAY_MS * 1000);

    zeroos_boot_system();
    zeroos_init_services();
    zeroos_touch_init();
    zeroos_home_draw();

    printf("\n[%s] System ready.\n", ZEROOS_NAME);
    return 0;
}
