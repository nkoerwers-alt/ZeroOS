#!/usr/bin/env bash
set -eu

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"

echo "[ZeroOS] Preparing build environment ..."

if command -v apt-get >/dev/null 2>&1; then
  SUDO=""
  if command -v sudo >/dev/null 2>&1; then
    SUDO="sudo"
  fi
  ${SUDO} apt-get update
  ${SUDO} apt-get install -y --no-install-recommends build-essential make gcc git ca-certificates
elif command -v apk >/dev/null 2>&1; then
  apk add --no-cache build-base gcc musl-dev make git
elif command -v dnf >/dev/null 2>&1; then
  dnf install -y make gcc git gcc-c++
elif command -v yum >/dev/null 2>&1; then
  yum install -y make gcc git gcc-c++
else
  echo "[ZeroOS] Unsupported package manager. Please install build-essential/make/gcc manually."
  exit 1
fi

echo "[ZeroOS] Build environment ready."
echo "[ZeroOS] Next step: ./build/build.sh"
