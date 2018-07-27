package com.criva.pipelinerunners.bigquery.function;

import com.criva.pipelinerunners.bigquery.model.BigQueryField;
import com.google.api.services.bigquery.model.TableRow;
import org.apache.beam.sdk.transforms.DoFn;

import java.util.Map;

public class BigQueryCreateRow<T> extends DoFn<T, TableRow> {

  private Map<String, BigQueryField<T>> fields;

  public BigQueryCreateRow(Map<String, BigQueryField<T>> fields) {

    this.fields = fields;
  }

  @ProcessElement
  public void processElement(ProcessContext context) {

    TableRow row = new TableRow();

    fields.entrySet().stream().forEach(
        entry -> {

          String key = entry.getKey();
          row.set(key, entry.getValue().getFieldFunction().apply(context));
        }
    );

    context.output(row);
  }
}
