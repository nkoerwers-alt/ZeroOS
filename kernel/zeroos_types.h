#ifndef ZEROOS_TYPES_H
#define ZEROOS_TYPES_H

#include <stdint.h>

typedef enum {
    ZEROOS_STATUS_OK = 0,
    ZEROOS_STATUS_ERROR = 1
} zeroos_status_t;

typedef struct {
    char name[32];
    int enabled;
} zeroos_service_t;

#endif
