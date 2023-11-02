#!/bin/bash

generate_trace_id(){
    START_TIME=$(date +%s)
    HEX_TIME=$(printf '%x\n' $START_TIME)
    GUID=$(dd if=/dev/random bs=12 count=1 2>/dev/null | od -An -tx1 | tr -d ' \t\n')
    TRACE_ID="1-$HEX_TIME-$GUID"
 
    echo $TRACE_ID
}
 
 
generate_segment_id(){
    n=8
    od  -vN "$n" -An -tx1 /dev/urandom | tr -d " \n" ; echo
}