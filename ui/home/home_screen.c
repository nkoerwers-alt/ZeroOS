#include <stdio.h>

#include "boot/boot_config/boot_config.h"
#include "configs/zeroos_config.h"
#include "ui/home/home_screen.h"

void zeroos_home_draw(void) {
    printf("[%s] Rendering ZeroUI home screen ...\n", ZEROOS_NAME);
    printf("[%s] Accent color: %s\n", ZEROOS_NAME, ZEROOS_PRIMARY_COLOR);
    printf("[%s] Home UI: ready\n", ZEROOS_NAME);
    printf("   _________________________________\n");
    printf("  |  [Files]  [Terminal]  [Calc]   |\n");
    printf("  |  [Settings] [Notif]  [Power]  |\n");
    printf("  |_______________________________|\n");
}
