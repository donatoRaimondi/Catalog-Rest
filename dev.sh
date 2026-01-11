#!/usr/bin/env bash
set -e

echo "Starting backend..."
cd catalog-web
mvn -q spring-boot:run &
BACK_PID=$!

cd ../catalog-ui
echo "Starting frontend..."
npx ng serve --proxy-config proxy.conf.json &
FRONT_PID=$!

echo "Backend PID: $BACK_PID"
echo "Frontend PID: $FRONT_PID"
echo "Press Ctrl+C to stop everything."

trap "echo 'Stopping...'; kill $BACK_PID $FRONT_PID" INT
wait
