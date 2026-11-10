CC ?= gcc
CFLAGS ?= -std=c11 -Wall -Wextra -Werror -O2 -I..
TARGET := zeroos_app
ROOT := ..

SRC := \
	$(ROOT)/kernel/main.c \
	$(ROOT)/system/init/init.c \
	$(ROOT)/system/services/service_manager.c \
	$(ROOT)/system/drivers/touch_driver.c \
	$(ROOT)/ui/home/home_screen.c

all: $(TARGET)

$(TARGET): $(SRC) $(ROOT)/configs/zeroos_config.h $(ROOT)/boot/boot_config/boot_config.h
	$(CC) $(CFLAGS) -o $@ $(SRC)

run: $(TARGET)
	./$(TARGET)

clean:
	rm -f $(TARGET)

.PHONY: all run clean
