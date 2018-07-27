package com.criva.pipelinerunners.pipeline.options;

import org.apache.beam.sdk.options.Default;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.Validation.Required;

public interface PipelineRunnersOptions extends PipelineOptions {

  @Default.String("gs://bucket-dataflow-sandbox-210515/pipeline-runners/hello-world.txt")
  String getInput();
  void setInput(String input);

  @Required
  String getDataset();
  void setDataset(String dataset);

  @Default.String("pipeline_runners")
  String getTableNamePrefix();
  void setTableNamePrefix(String tableNamePrefix);
}
