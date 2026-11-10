#include <stdio.h>
#include <unistd.h>

#include "boot/boot_config/boot_config.h"
#include "boot/boot_config/boot_screen.h"
#include "configs/zeroos_config.h"

void zeroos_render_status_bar(const char *status, unsigned int progress) {
    int i;
    int filled = 0;

    if (progress > 100U) {
        progress = 100U;
    }

    filled = (int)((progress * 20U) / 100U);

    printf("\033[36m[%s]\033[0m ", status);
    printf("[");
    for (i = 0; i < 20; ++i) {
        if (i < filled) {
            printf("#");
        } else {
            printf("-");
        }
    }
    printf("] %u%%\n", progress);
}

void zeroos_render_boot_screen(void) {
    int i;

    printf("\033[2J\033[H");
    printf("\n\n");
    printf("\033[36m");
    printf("        ███████╗██╗  ██╗███████╗ ██████╗ ███████╗██╗   ██╗\n");
    printf("        ██╔════╝██║  ██║██╔════╝██╔═══██╗██╔════╝██║   ██║\n");
    printf("        ███████╗███████║█████╗  ██║   ██║█████╗  ██║   ██║\n");
    printf("        ╚════██║██╔══██║██╔══╝  ██║   ██║██╔══╝  ╚██╗ ██╔╝\n");
    printf("        ███████║██║  ██║███████╗╚██████╔╝███████╗ ╚████╔╝ \n");
    printf("        ╚══════╝╚═╝  ╚═╝╚══════╝ ╚═════╝ ╚══════╝  ╚═══╝  \n");
    printf("\033[0m");

    printf("\033[36mZeroOS\033[0m");
    printf(" v%s\n", ZEROOS_VERSION);
    printf("   target: %s\n", ZEROOS_TARGET);
    printf("   arch: %s | kernel: %s\n", ZEROOS_ARCH, ZEROOS_KERNEL);
    printf("   accent: %s\n\n", ZEROOS_PRIMARY_COLOR);

    for (i = 0; i <= 100; i += 20) {
        zeroos_render_status_bar("boot", (unsigned int)i);
        usleep(120000);
    }

    printf("\n\n");
    printf("   %s\n", BOOT_SCREEN_SUBTITLE);
    printf("   ready for user session\n");
    printf("\n");
}
