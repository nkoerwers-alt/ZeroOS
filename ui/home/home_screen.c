#include <stdio.h>
#include <time.h>
#include <unistd.h>

#include "configs/zeroos_config.h"
#include "ui/home/home_screen.h"

#define CYAN  "\033[38;2;0;217;255m"
#define DIM   "\033[2m"
#define BOLD  "\033[1m"
#define RESET "\033[0m"
#define BG    "\033[48;2;8;12;18m"

static void print_app(const char *icon, const char *name) {
    printf("  %-3s  %-12s", icon, name);
}

void zeroos_home_draw(void) {
    const int color = isatty(STDOUT_FILENO);
    const char *cyan = color ? CYAN : "";
    const char *dim = color ? DIM : "";
    const char *bold = color ? BOLD : "";
    const char *reset = color ? RESET : "";
    const char *background = color ? BG : "";
    time_t now = time(NULL);
    struct tm *local = localtime(&now);
    char clock_text[16] = "--:--";
    char date_text[32] = "Date unavailable";

    if (local != NULL) {
        (void)strftime(clock_text, sizeof(clock_text), "%H:%M", local);
        (void)strftime(date_text, sizeof(date_text), "%a, %b %d", local);
    }

    if (color) {
        printf("\033[2J\033[H");
    }

    printf("%s\n", background);
    printf("  %sZEROOS%s                                      %s%s%s\n", cyan, reset, bold, clock_text, reset);
    printf("  %s%s%s\n", dim, date_text, reset);
    printf("  %s+--------------------------------------------------+%s\n", cyan, reset);
    printf("  |                                                  |\n");
    printf("  |  %s%sWelcome back%s                               |\n", bold, cyan, reset);
    printf("  |  Your device. Your system.                       |\n");
    printf("  |                                                  |\n");
    printf("  |  %sAPPS%s                                            |\n", cyan, reset);
    printf("  |                                                  |\n");
    printf("  |  "); print_app("[F]", "Files"); print_app("[T]", "Terminal"); printf(" |\n");
    printf("  |  "); print_app("[C]", "Calculator"); print_app("[S]", "Settings"); printf(" |\n");
    printf("  |                                                  |\n");
    printf("  |  %sSYSTEM%s                                          |\n", cyan, reset);
    printf("  |  %-48s |\n", "Touch: not connected in host prototype");
    printf("  |  %-48s |\n", "Target: Xiaomi Redmi 14C (unverified)");
    printf("  |                                                  |\n");
    printf("  +--------------------------------------------------+\n");
    printf("  %sZeroOS %s  |  Cyan interface preview  |  Host prototype%s\n", dim, ZEROOS_VERSION, reset);

    if (color) {
        printf("%s", RESET);
    }
}
