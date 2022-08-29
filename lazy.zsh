#!/usr/bin/env zsh

export loop_count=${1:-3}

curl -XDELETE "http://localhost:8080/api/range"
for id in {1..$loop_count}; do
  curl -s -XPOST "http://localhost:8080/api/range?id=${id}" | jq .
done
for id in {1..$loop_count}; do
  curl -s -XPATCH "http://localhost:8080/api/range?id=${id}" | jq .
done
