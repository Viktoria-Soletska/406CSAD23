#!/bin/sh
set -eu
exec mvn -B clean test package
