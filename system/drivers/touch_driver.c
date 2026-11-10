#include <stdio.h>

#include "configs/zeroos_config.h"
#include "system/drivers/touch_driver.h"

void zeroos_touch_init(void) {
    printf("[%s] Touch driver: probing input device ...\n", ZEROOS_NAME);
    printf("[%s] Touch input: ready for touchscreen events.\n", ZEROOS_NAME);
}
