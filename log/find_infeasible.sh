#!/bin/bash

find . -name '*.lp' -exec grep -H "infeasible" {} \;
