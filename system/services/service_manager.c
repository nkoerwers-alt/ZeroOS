#include <stdio.h>

#include "configs/zeroos_config.h"
#include "system/services/service_manager.h"

void zeroos_init_services(void) {
    printf("[%s] Registering system services ...\n", ZEROOS_NAME);
    printf("[%s] Services ready: boot, ui, input, storage, power\n", ZEROOS_NAME);
}
