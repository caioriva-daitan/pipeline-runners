#!/usr/bin/env bash

export GOOGLE_APPLICATION_CREDENTIALS="${HOME}/repos/dataflow-sandbox-fe006f43ab0d.json"

mvn exec:java \
  -Dexec.mainClass=com.criva.pipelinerunners.App \
  -Dexec.cleanupDaemonThreads=false \
  -Dexec.args="--appName=pipeline-runners \
               --jobName=pipeline-runners-job \
               --runner=DataflowRunner \
               --project=dataflow-sandbox-210515 \
               --tempLocation=gs://bucket-dataflow-sandbox-210515/pipeline-runners/temp \
               --dataset=dataflow_sandbox"