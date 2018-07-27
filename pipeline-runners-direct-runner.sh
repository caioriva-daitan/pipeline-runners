#!/usr/bin/env bash

export GOOGLE_APPLICATION_CREDENTIALS="${HOME}/repos/dataflow-sandbox-fe006f43ab0d.json"

java -cp target/pipeline-runners-1.0-SNAPSHOT.jar com.criva.pipelinerunners.App \
 --appName=pipeline-runners \
 --project=dataflow-sandbox-210515 \
 --tempLocation=gs://bucket-dataflow-sandbox-210515/pipeline-runners/temp \
 --dataset=dataflow_sandbox