package com.criva.pipelinerunners;

import com.criva.pipelinerunners.bigquery.function.BigQueryWrite;
import com.criva.pipelinerunners.bigquery.model.BigQueryData;
import com.criva.pipelinerunners.pipeline.function.CountWords;
import com.criva.pipelinerunners.pipeline.options.PipelineRunnersOptions;
import com.criva.pipelinerunners.pipeline.util.WordCountUtils;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.extensions.gcp.options.GcpOptions;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.values.KV;

public class App {

  public static void main(String[] args) {

    PipelineRunnersOptions options = PipelineOptionsFactory
        .fromArgs(args)
        .withValidation()
        .as(PipelineRunnersOptions.class);

    Pipeline pipeline = Pipeline.create(options);

    pipeline
        .apply(TextIO.read().from(options.getInput()))
        .apply(new CountWords())
        .apply(new BigQueryWrite<KV<String, Long>>(new BigQueryData<>(
            options.as(GcpOptions.class).getProject(),
            options.getDataset(),
            options.getTableNamePrefix() + "_hello_world_count",
            WordCountUtils.createWordCountTableFieldsMap())));

    pipeline.run().waitUntilFinish();
  }
}
