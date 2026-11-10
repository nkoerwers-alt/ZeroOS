#include <stdio.h>

#include "configs/zeroos_config.h"
#include "system/init/init.h"

void zeroos_boot_system(void) {
    printf("[%s] Initializing init process ...\n", ZEROOS_NAME);
    printf("[%s] Loading system configuration ...\n", ZEROOS_NAME);
    printf("[%s] Starting base services ...\n", ZEROOS_NAME);
}
